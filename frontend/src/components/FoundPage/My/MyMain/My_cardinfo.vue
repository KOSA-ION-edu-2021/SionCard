<template class="">
  <!-- <v-container class="mt-10 mb-10" v-if="!!this.$store.getters.getAuth"> -->
    <v-container class="mt-10 mb-10">
    <v-row>
      <v-col cols="1"></v-col>
      <v-col cols="10">
        <v-card elevation="10" class="pt-10 pb-10">
          <v-row justify="space-around" class="">
            <!-- 좌측 -->
            <v-col cols="4" class="">
              <!-- 좌측 상단 -->
              <v-row justify="space-between" class="text-h6">
                <v-col cols="auto" class="font-weight-bold"> 대표 카드 </v-col>

                <v-col cols="auto" class="text-subtitle-2"
                v-if="getinfo.length>0"
                >
                    <v-img 
                    :src="getinfo[0].img">
                    </v-img>
                </v-col>
                <v-col cols="12" class="text-h6"
                  v-else>
                     가지고 있는 카드가 없습니다.
                </v-col>
              </v-row>
              <v-row><v-divider></v-divider></v-row>
              <!-- 좌측 중간 -->
              <v-row justify="space-between" class="text-h5">
                <v-col cols="auto" class="text-subtitle-1 font-weight-bold">
                  총 사용 금액
                </v-col>
                <v-col cols="auto"> {{usesum[0].sum_price || 0 }} </v-col>
              </v-row>
              <!-- 좌측 하단 버튼 -->
              <v-row justify="center">
                <v-col cols="auto">
                  <v-btn elevation="2">상세 내역</v-btn>
                </v-col>
              </v-row>
            </v-col>

            <!-- 우측 -->
            <v-col cols="4" class="">
              <!-- 우측 상단 -->
              <v-row justify="" class="text-h5">
                                <v-col cols="12" class="font-weight-bold mb-n5">
                                받은 혜택
                                </v-col>
                                <v-col cols="" class="text-subtitle-2">
                                    <Calendar @date="date" />
                                </v-col>
                        </v-row>  
              <v-row><v-divider></v-divider></v-row>
              <!-- 우측 중간 -->
              <v-row justify="space-between" class="text-h5">
                <v-col cols="auto" class="text-subtitle-1 font-weight-bold">
                  할인
                </v-col>
                <v-col cols="auto" class="text-h6">
                  {{usesum[0].sum_discount}}
                </v-col>
              </v-row>
              <v-row justify="space-between" class="text-h5">
                <v-col cols="auto" class="text-subtitle-1 font-weight-bold">
                  적립
                </v-col>
                <v-col cols="auto" class="text-h6">
                  {{usesum[0].sum_stack}}
                </v-col>
              </v-row>
              <v-row justify="space-between" class="text-h5">
                <v-col cols="auto" class="text-subtitle-1 font-weight-bold">
                  포인트
                </v-col>
                <v-col cols="auto" class="text-h6">
                  {{usesum[0].sum_point}}
                </v-col>
              </v-row>
              <v-row justify="space-between" class="text-h5">
                <v-col cols="auto" class="text-subtitle-1 font-weight-bold">
                  마일리지
                </v-col>
                <v-col cols="auto" class="text-h6">
                  {{usesum[0].sum_mileage}}
                </v-col>
              </v-row>

                        <!-- 우측 하단 버튼 -->
                        <!-- <v-row justify="center">
                            <v-col cols="auto">
                                <v-btn elevation="2">상세 내역</v-btn>
                            </v-col>
                        </v-row> -->
            </v-col>
          </v-row>
        </v-card>

        <!-- 상단 끝 -->

        <!-- 하단 : 최근 거래 내역 -->
        <v-row class="grey lighten-3 mt-10">
          <!-- 제목 -->
          <v-col class="pa-10">
            <v-row class="text-h5 font-weight-bold">
              <v-col cols=""> 최근 이용 내역 </v-col>
            </v-row>

            <v-row><v-divider></v-divider></v-row>

            <!-- 거래 내역 -->
            <v-row v-for="(card, num) in cards" :key="num">
              <v-col cols="3">
                {{ card.use_date }}
              </v-col>
              <v-col cols="6">
                {{ card.use_location }}
              </v-col>
              <v-col cols="3"> {{ card.use_price }} </v-col>
            </v-row>

          </v-col>
        </v-row>
        <!-- 하단 끝 -->
      </v-col>
      <v-col cols="1"></v-col>
    </v-row>
    <!-- 상단 : 대표계좌 이용내역 -->
  </v-container>
</template>

<script>
import Calendar from "./My_cardinfo_calendar.vue";
import axios from "axios";

export default {
  name: "Mycardinfo",
  data: () => ({
    cardinfo:[],
    getinfo:[],
    cardinfonum:"",
    getinfonum:"",
    cards: [
      {
        use_date: "카드 이용 내역이 없습니다.",
      },
    ],
    usesum: [
      {
        sum_price : 0,
        sum_stack : 0,
        sum_mileage : 0,
        sum_discount : 0,
        sum_point : 0,
      },
    ],
  }),
  components: {
    Calendar,
  },
  mounted() {
    this.$store.commit("updateAuth", this.loginCheck_myMain);
    this.carduse();
    this.sumUse(); 
    this.GetCard();
    this.CardInfo();
  },
  computed(){
    
  },
  methods: {
    carduse() {
      axios
        .get(this.$store.state.apihost + "/member/get_use_card", {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("JSESSIONID")}`,
          },
        })
        .then((res) => {
          if (res.data.length != 0) {
            this.cards = res.data.map((res) => {
              res.use_price += "원";
              return res;
            });
            console.log(this.cards);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    sumUse(){
      axios.get(this.$store.state.apihost + "/member/sum_use",{
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("JSESSIONID")}`,
          },
        })
        .then((res) => {
            if(res.data.length>0){ 
              this.usesum = res.data.map(res=>{
                  res.sum_price+="원";
                  res.sum_stack+="원 적립";
                  res.sum_point+="포인트";
                  res.sum_discount+="원 할인";
                  res.sum_mileage+="마일리지";
                  return res;
              });
            }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    CardInfo(){
      axios.get(this.$store.state.apihost + "/api/card_info")
        .then((res) => {
             this.cardinfo = res.data.map((res) => {
              res.id += "";
              return res;
            });
            })
        .catch((err) => {
          console.log(err);
        });
    },
    GetCard(){
      axios.get(this.$store.state.apihost + "/member/get_card",{
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("JSESSIONID")}`,
          },
        })
        .then((res) => {
            this.getinfo = res.data;
        })
        .catch((err) => {
          this.num = 0;
          console.log(err);
        });
    },
  },
};
</script>

<style>
</style>