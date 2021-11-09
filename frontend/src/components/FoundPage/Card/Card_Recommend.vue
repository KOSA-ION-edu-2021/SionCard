<template>
  <v-container class="pa-3 mt-10">
    <!-- 상단 글귀 -->
    <div class="card-rec-top">
      <v-container>
        <v-row justify="start">
          <v-col cols="auto" class=""> <h2>카드 추천</h2> </v-col>
        </v-row>
        <!-- 다시 선택 버튼 -->
        <v-row justify="end">
            <!-- 모달 -->
            <v-col cols="auto" class="yellow " dense>
                <Card_Modal 
                @changeCheck1="changeCheck1"
                @changeCheck2="changeCheck2"
                @changeCheck3="changeCheck3"
                />
            </v-col>
        </v-row>
      </v-container>
    </div>

    <!-- 카드 이미지 출력 -->
    <v-container class="mt-10">
      <v-row justify="space-around">
          <v-col class="mt-10" v-for="(card, index) in typeFilter(check1, check2, check3)" :key="index" cols="4" > 
          <!-- <v-col class="mt-10" v-for="card in cardInfo" :key="card" cols="4" v-show="card_check(card,check1,check2,check3)">  -->
          <v-card class="pa-3 mt-5 text-center" dense outlined>
            <v-img
              aspect-ratio="2"
              contain
              :src=card.img
            />
            <v-row class="mt-3">
              <v-col cols="12">
                <strong>{{ card.title }}</strong>
              </v-col>
              <v-col colls="12">
                {{ card.content }}
              </v-col>
            </v-row>
             <router-link style="text-decoration: none;"
                              :to="{
                                name: 'card',
                                params: { id: card.id-1 },
                              }"
                            >
            <v-btn class="mt-3" color="" elevation="" to=""> 상세 페이지</v-btn>
             </router-link>
          </v-card>
        </v-col>
        <!--         <v-col cols="12">
          <v-card class="pa-3"> Cols 12 123 {{title}} </v-card>
        </v-col> -->
      </v-row>
    </v-container>
  </v-container>
</template>

<script>
import Card_Modal from './Card_Modal.vue';
import cardInfo from '@/assets/cardInfo.js'

export default {
  components: { Card_Modal },
  data: () => ({
    /* V-SHOW / V-IF */
    cardInfo: cardInfo,
    check1: new RegExp('.+'),
    check2: new RegExp('.+'),
    check3: new RegExp('.+'),
  }),
  methods: {
    card_check(card,a,b,c){
          return !!a.exec(card.card_type) && !!b.exec(card.benefit_type) && !!c.exec(card.benefit_content) ;
      },
      typeBy: function(type) {
        return this.cardInfo.filter(function(card) {
          return card.card_type === type })
      },
      typeFilter: function(a, b, c){
        return this.cardInfo.filter(function(card) {
          return !!a.exec(card.card_type) && !!b.exec(card.benefit_type) && !!c.exec(card.benefit_content) })
      },
      changeCheck1(modal_data){
        this.check1 = modal_data;
      },
      changeCheck2(modal_data){
        this.check2 = modal_data;
      },
      changeCheck3(modal_data){
        this.check3 = modal_data;
      },
  }
};
</script>

<style>
.card-rec-top {
  border-bottom: rgb(214, 209, 209) 2px solid;
  padding-bottom: 10px;
}
</style>