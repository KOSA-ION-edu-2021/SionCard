<template>
  <v-conatainer>
    <Myuserinfo/>
    <v-row>
      <v-col cols="1"></v-col>
      <v-col cpls="10">
          <!-- 상단 고객 정보 요약 란 -->
          
          
          <!-- 중단 카드계좌 정보 요약 란 -->
          <Mycardinfo/>

          <!-- 하단 최근 거래 내역 -->
      </v-col>
      <v-col cols="1"></v-col>
    </v-row>
        
  </v-conatainer>
</template>

<script>

import Myuserinfo from './My_userinfo.vue'
import Mycardinfo from './My_cardinfo.vue'

export default {
  data: () =>({
    
    
  }),
  components:{
      Myuserinfo,
      Mycardinfo,
    },
  mounted() {
    this.loginCheck_myMain()
  },
  methods: {
    loginCheck_myMain(){
            if(this.$store.state.auth == null){
              this.$router.push('login')
              alert('로그인을 해야 접속 가능합니다!');
            }
            else{
              this.$router.push('my_main')
            }
          }
  },
}
</script>

<style>

</style>