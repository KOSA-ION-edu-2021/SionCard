<template>
  <v-container>
    <v-row>
      <v-col cols="1"></v-col>
      <v-col cols="10">
        <v-container class="">
      
        <!-- 신상 카드 이미지 슬라이드 -->
        <v-carousel
          cycle
          height="200"
          hide-delimiters
          hide-delimiter-background
          class="mt-10 mb-10"
          width="1000px"
        >

          <!-- 이미지 -->
          <v-carousel-item class="mt-5 mb-5"
            v-for="(card, i) in cardInfo" :key="i">
            <v-card  class="grey lighten-3">
              <v-row justify="center" align="center">
                  <v-col cols="4">
                      <v-card-title class="text-subtitle-1 font-weight-bold">
                          {{card.title}}
                      </v-card-title>
                      <p class="ml-4">{{ card.content }}</p>
                  </v-col>
                  <v-col cols="6">
                    <router-link
                                  :to="{
                                    name: 'card',
                                    params: { id: card.id-1 },
                                  }"
                                >
                      <v-img
                      contain
                      aspect-ratio="3"
                      :src=card.img />
                      </router-link>
                  </v-col>
              </v-row>
            </v-card>
          </v-carousel-item>
        </v-carousel>

        <!-- 카드 추천 링크 -->
        <v-card class="mt-5 mb-5 grey lighten-3"> 
          <v-container>
            <v-row justify="space-around">
              <v-col cols="5" align-self="center">
                <v-col>
                  <b>찾아 드림</b>
                </v-col>
                <v-col>
                  사이온카드가 당신에게 딱 맞는 <br />
                  카드를 찾아드림
                </v-col>
                <v-col>
                  <router-link class="text-decoration-none"  to="/cardrecommend">
                    <v-btn >
                      <v-card-title>바로가기</v-card-title>
                    </v-btn>
                  </router-link>
                </v-col>
              </v-col>
              <v-col cols="5" align-self="center">
                <v-img
                  class="ma-0"
                  contain
                  aspect-ratio="2"
                  src="https://www.shinhancard.com/pconts/images/dx/banner/2021/210113_card_bigb.png"
                />
              </v-col>
            </v-row>
          </v-container>
        </v-card>

        <!-- 신용카드 -->
        <v-row class="mt-5 mb-5">
          <v-row class="mt-7">
            <v-col class="mr-3" cols="auto">
              <b>SI-ON 신용카드</b>
            </v-col>
            <v-divider vertical />
            <v-col class="ml-3"> 사이온에서만 느끼는 효율적인 신용카드 </v-col>
          </v-row>
          <v-row>
              <v-col
                v-for="card in cardInfo"
                :key="card.id"
                cols="3"
                v-show="card.card_credit"
              >
                <router-link style="text-decoration: none;"
                                      :to="{
                                        name: 'card',
                                        params: { id: card.id-1 },
                                      }"
                                    >
                  <v-card flat class="grey lighten-2">
                    <v-img :src="card.img" />
                    <v-sheet class="text-subtitle-2 font-weight-bold mt-5 mt-5 grey lighten-2">
                      {{ card.title }}
                    </v-sheet>
                    <v-sheet class="text-caption mt-5 mt-5 grey lighten-2">
                      {{ card.content }}
                    </v-sheet>
                  </v-card>
                </router-link>
              </v-col>
          </v-row>
        </v-row>

        <!-- 체크카드 -->
        <v-row class="mt-5 mb-10">
          <v-row class="mt-7">
            <v-col class="mr-3" cols="auto">
              <b>SI-ON 체크카드</b>
            </v-col>
            <v-divider vertical />
            <v-col class="ml-3"> 사이온만의 짜릿한 체크카드 </v-col>
          </v-row>
          <v-row>
            <v-col
              v-for="card in cardInfo"
              :key="card.id"
              cols="3"
              v-show="card.card_check"
            >
            <router-link style="text-decoration: none;"
                                  :to="{
                                    name: 'card',
                                    params: { id: card.id-1 },
                                  }"
                                >
              <v-card flat class="grey lighten-2">
                <v-img contain :src="card.img" />
                <v-sheet class="text-subtitle-2 font-weight-bold mt-5 mt-5 grey lighten-2">
                      {{ card.title }}
                    </v-sheet>
                    <v-sheet class="text-caption mt-5 mt-5 grey lighten-2">
                      {{ card.content }}
                    </v-sheet>
              </v-card>
            </router-link>
            </v-col>
          </v-row>
        </v-row>
        </v-container>
      </v-col>
      <v-col cols="1"></v-col>
    </v-row>
  </v-container>
</template>

<script>
/* import cardInfo from "@/assets/cardInfo.js"; */
import axios from 'axios'

export default {
  data: () => ({
    cardInfo : null,
  }),
  mounted() {
    this.getcardInfo()
  },
  methods:{
    getcardInfo(){
      axios.get(this.$store.state.apihost+'/api/card_info')
      .then((res)=>{
        console.log(res.data);
        this.cardInfo = res.data 
      })
      .catch((err)=>{
        console.log(err);
      })

    }
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
.font{
  /* font-family: 'Noto Sans KR', sans-serif; */
}
</style>