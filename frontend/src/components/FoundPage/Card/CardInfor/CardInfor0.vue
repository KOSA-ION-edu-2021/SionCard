<template>
  <v-container>
    <!-- 카드 이미지와 대표 정보 출력 -->
    <CardInforHead0 :num="id" />
    <!-- 나머지 부분들 출력    -->
    <CardInforBody0 :num="id" />
  </v-container>
</template>

<script>
import CardInforHead0 from "./CardInforHead0.vue";
import CardInforBody0 from "./CardInforBody0.vue";
import cardInfo from "@/assets/carddetail.js"


export default {
  name: "CardInfor",
  cardInfo : cardInfo,
  components: {
    CardInforHead0,
    CardInforBody0,
  },
  data:()=>({
 
    }),
    props :{
      id : Number
    }
};
</script>

<style>
</style>