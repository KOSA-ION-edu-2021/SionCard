<template>
    <v-system-bar app class="grey darkness-5">
        <v-spacer/>
        <div v-if="this.$store.state.auth==null">
            <router-link to="/login" class="white--text text-caption mr-2" tag="button">로그인 |</router-link>
            <router-link to="/signin" class="white--text text-caption mr-2" tag="button">회원가입</router-link>
        </div>
        <div v-else>
            <button class="white--text text-caption mr-2">{{this.$store.state.auth.id}}</button>
            <div  class="white--text text-caption mr-2"> 님 반갑습니다. </div>
            <router-link to="/logout" class="white--text text-caption mr-2" tag="button">로그아웃</router-link>
        </div>
    </v-system-bar>
</template>

<script>

export default {

}
</script>