<template>
    <v-system-bar app class="grey darkness-5">
        <v-spacer/>
        <div v-if="this.$store.state.auth==null" class="mr-16">
            <router-link to="/admin/login" class="white--text text-caption mr-2" tag="button">로그인</router-link>
            <!-- <span class="mr-2 ml-2 white--text">|</span>
            <router-link to="/signin" class="white--text text-caption ml-2 mr-16" tag="button">회원가입</router-link> -->
        </div>
        <div v-else class="mr-16">
            <button class="white--text text-caption mr-2">{{this.$store.state.auth.name}} 접속</button>
            <!-- <span class="mr-2 ml-2 white--text">|</span> -->
            <button @click="refreshJwt" class="white--text text-caption mr-2"> {{`${minutes}:${seconds}`}}</button>
            <button @click="logout" class="white--text text-caption ml-2 mr-16" tag="button">로그아웃</button>
        </div>
        <v-app-bar-nav-icon @click="changeDraw(true)"></v-app-bar-nav-icon>
    </v-system-bar>
</template>

<script>
import axios from 'axios'

export default {
    methods:{
        logout(){
            sessionStorage.removeItem('JSESSIONID');
            this.$router.go() //새로고침
            //this.$router.push('')
        },
        setExpire(){
            if(!this.$store.state.auth) return;
            this.preTime = new Date();
        },
        refreshJwt(){
            axios.get(this.$store.state.apihost+"/member/refresh_jwt",{
                headers:{
                    Authorization:`Bearer ${sessionStorage.getItem("JSESSIONID")}`,
                }
            })
            .then(res=>{
                sessionStorage.setItem("JSESSIONID",res.data.jwt);
                this.$store.commit('updateAuth');
            })
            .catch(err=>{
                console.log(err);
            })
        }
    },
    data:()=>({
        preTime : new Date(),
    }),
    mounted(){
        setInterval(this.setExpire,1000);
    },
    props:{
        drawer:Boolean,
        changeDraw:Function,
    },
    computed:{
        minutes: function(){ 
            return Number.parseInt((this.$store.state.auth.expire-this.preTime)/1000/60);
        },
        seconds: function(){
            const num = Number.parseInt((this.$store.state.auth.expire-this.preTime)/1000%60);
            if(this.minutes==0 && num<=0){
                clearInterval(this.timer);
                sessionStorage.removeItem('JSESSIONID');
                this.$store.commit('updateAuth');
                return null;
            }
            const result="0"+num;
            return result.substring(result.length-2,result.length);
        }
    }
}
</script>