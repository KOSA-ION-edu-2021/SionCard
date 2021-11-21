<template>
  <v-conatainer v-if="!!this.$store.getters.getAuth">
    <Myuserinfo/>
    <v-row>
      <v-col cols="1"></v-col>
      <v-col cpls="10">
          <!-- 상단 고객 정보 요약 란 -->
          
          
          <!-- 중단 카드계좌 정보 요약 란 -->
          <Mycardinfo/>

          <!-- 하단 최근 거래 내역 -->
          <!-- <Graph/> -->
      </v-col>
      <v-col cols="1"></v-col>
    </v-row>
        
  </v-conatainer>
</template>

<script>

import Myuserinfo from './My_userinfo.vue'
import Mycardinfo from './My_cardinfo.vue'
//import Graph from './My_graph.vue'

export default {
  data: () =>({
  }),
  components:{
      Myuserinfo,
      Mycardinfo,
      //Graph,
  },
  mounted(){
    this.$store.commit('updateAuth',this.loginCheck_myMain)
  },
  methods: {
    loginCheck_myMain(){
        if(this.$store.state.auth === null){
          this.$router.push('login')
          alert('로그인을 해야 접속 가능합니다!');
        }
      }
  },
}
</script>

<style>

</style>