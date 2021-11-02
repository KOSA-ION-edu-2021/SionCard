<template>
  <v-container>
    <!-- 카드 이미지와 정보 출력 -->
    <CardInforHeader />
    <!-- 나머지 부분들 출력    -->
    <CardInforBody />
  </v-container>
</template>

<script>
import CardInforHeader from "./CardInforHeader.vue";
import CardInforBody from "../Card/CardInforBody.vue";

export default {
  name: "CardInfor",
  components: {
    CardInforHeader,
    CardInforBody,
  },
};
</script>

<style>
</style>