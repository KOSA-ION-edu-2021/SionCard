<template>
  <v-container>
    <!-- 카드 이미지와 정보 출력 -->
    <CardReader />
    <!-- 나머지 부분들 출력    -->
    <CardInforBody />
  </v-container>
</template>

<script>
import CardReader from "../Card/Cardreader.vue";

import CardInforBody from "../Card/CardInforBody.vue";

export default {
  name: "CardInfor",
  components: {
    CardReader,
    CardInforBody,
  },
};
</script>

<style>
</style>