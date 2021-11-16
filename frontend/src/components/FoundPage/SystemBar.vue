<template>
    <v-system-bar app class="grey darkness-5">
        <v-spacer/>
        <div v-if="this.$store.state.auth==null" class="mr-16">
            <router-link to="/login" class="white--text text-caption mr-2" tag="button">로그인</router-link>
            <span class="mr-2 ml-2 white--text">|</span>
            <router-link to="/signin" class="white--text text-caption ml-2 mr-16" tag="button">회원가입</router-link>
        </div>
        <div v-else class="mr-16">
            <router-link to="/my_main" ><button class="white--text text-caption mr-2">{{this.$store.state.auth.name}}</button></router-link>
            <button disabled  class="white--text text-caption mr-2"> 님 반갑습니다. </button>
            <!-- <span class="mr-2 ml-2 white--text">|</span> -->
            <button class="white--text text-caption mr-2"> {{`${loginTime.getMinutes()}:${loginTime.getSeconds()}`}`}</button>
            <button @click="logout" class="white--text text-caption ml-2 mr-16" tag="button">로그아웃</button>
        </div>
    </v-system-bar>
</template>

<script>

export default {
    methods:{
        logout(){
            sessionStorage.removeItem('JSESSIONID');
            this.$router.go() //새로고침
        },
        setExpire(){
            if(!this.$store.state.auth) return;
            console.log(1);
            this.preTime = new Date();
        }
        
    },
    data:()=>({
        preTime : new Date(),
    }),
    mounted(){
        setInterval(this.setExpire,1000);
    },
    computed:{
        loginTime: function(){ 
            return this.$store.state.expire-this.preTime;
        },
    }
    


}
</script>