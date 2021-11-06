<template>
  <v-conatainer>
      <!-- 상단 고객 정보 요약 란 -->
      <Myuserinfo/>
      
      <!-- 중단 카드계좌 정보 요약 란 -->
      <Mycardinfo/>

      <!-- 하단 최근 거래 내역 -->
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
    }
}
</script>

<style>

</style>