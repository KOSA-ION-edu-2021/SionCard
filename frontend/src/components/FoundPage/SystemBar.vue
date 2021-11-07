<template>
    <v-system-bar app class="grey darkness-5">
        <v-spacer/>
        <div v-if="this.$store.state.auth==null">
            <router-link to="/login" class="white--text text-caption mr-2" tag="button">로그인 |</router-link>
            <router-link to="/signin" class="white--text text-caption mr-2" tag="button">회원가입</router-link>
        </div>
        <div v-else>
            <button class="white--text text-caption mr-2">{{this.$store.state.auth.name}}</button>
            <button disabled  class="white--text text-caption mr-2"> 님 반갑습니다. </button>
            <button @click="logout" class="white--text text-caption mr-2" tag="button">로그아웃</button>
        </div>
    </v-system-bar>
</template>

<script>

export default {
    methods:{
        logout(){
            sessionStorage.removeItem('JSESSIONID');
            this.$router.go() //새로고침
        }
    }
}
</script>