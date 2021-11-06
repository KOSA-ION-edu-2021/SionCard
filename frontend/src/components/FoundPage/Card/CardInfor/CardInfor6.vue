<template>
  <v-container>
    <!-- 카드 이미지와 대표 정보 출력 -->
    <CardInforHead0 :num="a" />
    <!-- 나머지 부분들 출력    -->
    <CardInforBody0 :num="a" />
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
        a:5,
    }),
};
</script>

<style>
</style>