<template>
    <v-system-bar app class="grey darkness-5">
        <v-spacer/>
        <div v-if="this.$store.auth==null">
            <router-link to="/login" class="white--text text-caption mr-2" tag="button">로그인 |</router-link>
            <router-link to="/signin" class="white--text text-caption mr-2" tag="button">회원가입</router-link>
        </div>
        <div v-else>

        </div>
    </v-system-bar>
</template>

<script>

export default {

}
</script>