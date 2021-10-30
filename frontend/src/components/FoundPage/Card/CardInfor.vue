<template>
  <v-container>
    <v-card tile flat style="margin-left: 30px">
      <v-row class="ma-auto pa-auto">
        <v-col cols="1" md="2" />
        <v-col cols="4" class="pa-0 d-none d-md-block" style="margin-top: 40px">
          <CardImg />
        </v-col>
        <v-col cols="10" md="6" class="pa-0">
          <CardReader />
        </v-col>
      </v-row>
    </v-card>

    <CardInforBody />
  </v-container>
</template>

<script>
import CardReader from "../Card/Cardreader.vue";
import CardImg from "../Card/Cardimg.vue";
import CardInforBody from "../Card/CardInforBody.vue";

export default {
  name: "CardInfor",
  components: {
    CardReader,
    CardImg,
    CardInforBody,
  },
};
</script>

<style>
</style>