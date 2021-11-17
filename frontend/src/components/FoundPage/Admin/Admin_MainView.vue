<template>
  <v-row justify="center" v-if="!!this.$store.getters.getAuth">
      <v-col cols="1"></v-col>
      <v-col cols="10" align-self="center" class="text-center text-h3">
          관라지 페이지 입니다
      </v-col>
      <v-col cols="1"></v-col>
  </v-row>
</template>

<script>
export default {
  methods:{
    checkAdmin(){
      if(this.$store.getters.getAuth === null || this.$store.state.auth.member_id !== 'admin'){
          this.$router.push('/')
          alert('관리자만 접속 가능합니다!');
      }
    },
  },
  mounted(){
    this.$store.commit('updateAuth',this.checkAdmin);
  }
}
</script>