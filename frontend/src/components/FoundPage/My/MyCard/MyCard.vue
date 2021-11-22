<template>
  <v-container>
    <v-row>
      <v-col cols="1"></v-col>
      <v-col cols="10">
        <!-- 상단 -->
        <v-row class="mt-5">
          <v-col class="text-h4 font-weight-bold"> 내 카드 관리 </v-col>
        </v-row>

        <v-carousel
          hide-delimiters
          hide-delimiter-background
          class="mt-10 mb-10"
          v-if="getinfo.length>0"
        >
          <!-- 이미지 -->
          <v-carousel-item
            class=" mb-5"
            v-for="(card, k) in getinfo"
            :key="k"
          >
            <v-card
              class="grey lighten-2 d-flex ma-auto align-center"
              flat
              tile
              height="100%"
            >
              <v-row>
                <v-col cols="12">
                  <v-img contain aspect-ratio="3" :src="card.img"> </v-img>
                </v-col>
                <v-col cols="12">
                  <ol class="text-h5 ml-5 mt-5">
                    <li>유효기간 : {{ card.cardEdate }}</li>
                    <li>카드번호 : {{ card.cardNum }}</li>
                    <li>카드명 : {{ card.cardTitle }}</li>
                  </ol>
                </v-col>
              </v-row>
            </v-card>
          </v-carousel-item>
        </v-carousel>
        <v-container v-else justify="center">

          <v-sheet class="grey lighten-2 ma-10 text-h3 text-center">보유 중인 카드가 없습니다.</v-sheet>

          <v-row justify="center" class="pa-5">
            <v-col cols="auto">
              <v-btn to="/cardapply" color="black" x-large class="white--text" elevation="">카드 신청</v-btn>
            </v-col>
          </v-row>

        </v-container>
      </v-col>
      <v-col cols="1"></v-col>
    </v-row>
  </v-container>
</template>

<script>
import cardInfo from "@/assets/cardInfo.js";
import axios from "axios";
export default {
  name: "mycard",
  data: () => ({
    cardInfo,
    getinfo: [],
    // headers
  }),
  components: {},
  mounted() {
    this.$store.commit("updateAuth", this.loginCheck_myCard);
    this.GetCard();
    //this.loginCheck_myCard()
  },
  methods: {
    loginCheck_myCard() {
      if (this.$store.state.auth == null) {
        this.$router.push("login");
        alert("로그인을 해야 접속 가능합니다!");
      }
    },
    GetCard() {
      axios
        .get(this.$store.state.apihost + "/member/get_card", {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("JSESSIONID")}`,
          },
        })
        .then((res) => {
          this.getinfo = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style>

</style>