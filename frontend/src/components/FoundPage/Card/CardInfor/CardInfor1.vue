<template>
  <v-container>
    <!-- 카드 이미지와 대표 정보 출력 -->
    <CardInforHead0 :num="a" />
    <!-- 나머지 부분들 출력    -->
    <CardInforBody1 :num="a" />
  </v-container>
</template>

<script>
import CardInforHead0 from "./CardInforHead0.vue";
import CardInforBody1 from "./CardInforBody1.vue";
import cardInfo from "@/assets/carddetail.js"

export default {
  name: "CardInfor",
  cardInfo : cardInfo,
  components: {
    CardInforHead0,
    CardInforBody1,
  },
  data:()=>({
        a:0,
    }),
};
</script>

<style>
</style>