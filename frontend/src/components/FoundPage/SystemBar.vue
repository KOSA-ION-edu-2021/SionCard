<template>
    <v-system-bar app class="grey darkness-5">
        <v-spacer/>
        <div v-if="auth==null">
            <router-link to="/login" class="white--text text-caption mr-2" tag="button">로그인 |</router-link>
            <router-link to="/signin" class="white--text text-caption mr-2" tag="button">회원가입</router-link>
        </div>
        <div v-else>

        </div>
    </v-system-bar>
</template>

<script>
import axios from "axios";

export default {
    data:()=>({
        auth:null
    }),
    methods:{
        get_auth(){
            axios.get("http://si-on.net/member/get_auth",
            {"Authorization":"Bearer "+this.$session.get('JSESSIONID')})
            .then(res=>{
                this.auth=res.data;
            })
            .catch(err=>{
                console.log("로그인이 되어 있지 않습니다.");
                console.log(err);
                this.auth=null;
            })
        }
    },
    mounted(){

    },

}
</script>