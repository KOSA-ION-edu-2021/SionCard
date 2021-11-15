<template>
    <v-system-bar app class="grey darkness-5">
        <v-spacer/>
        <div v-if="this.$store.state.auth==null" class="mr-16">
            <router-link to="/login" class="white--text text-caption mr-2" tag="button">로그인</router-link>
            <span class="mr-2 ml-2 white--text">|</span>
            <router-link to="/signin" class="white--text text-caption ml-2 mr-16" tag="button">회원가입</router-link>
        </div>
        <div v-else class="mr-16">
            <button class="white--text text-caption mr-2">{{this.$store.state.auth.name}} 접속</button>
            <!-- <span class="mr-2 ml-2 white--text">|</span> -->
            <button @click="logout" class="white--text text-caption ml-2 mr-16" tag="button">로그아웃</button>
        </div>
        <v-app-bar-nav-icon @click="changeDraw"></v-app-bar-nav-icon>
    </v-system-bar>
</template>

<script>

export default {
    methods:{
        logout(){
            sessionStorage.removeItem('JSESSIONID');
            this.$router.go() //새로고침
        },
    },
    props:{
        drawer:Boolean,
        changeDraw:Function,
    },
}
</script>