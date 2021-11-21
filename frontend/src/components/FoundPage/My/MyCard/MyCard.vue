<template>
  <v-container> 
      <v-row>
        <v-col cols="1"></v-col>
        <v-col cols="10">
          <!-- 상단 -->
          <v-row class="mt-5">
            <v-col class="text-h4 font-weight-bold">
              내 카드 관리
            </v-col>
          </v-row>
          
          <!-- 자기 카드 표시 -->
          <v-row>
            <v-col align-self="center">
                    <v-row justify="center">
                        <v-col cols="12" align-self="center"
                        v-for="(card,k) in getinfo" :key="k"
                        > 
                          <ul>
                           <li>
                            유효기간 : {{getinfo[k].cardEdate}}
                            카드번호 : {{getinfo[k].cardNum}}
                            카드명 : {{getinfo[k].cardTitle}}
                           </li>
                          </ul>
                        </v-col>
                        <v-col v-if="getinfo.length===0">
                          <li>가지고 있는 카드가 없습니다.</li>
                        </v-col>
                    </v-row>
            </v-col>
          </v-row>
          <!-- 상단 끝 -->

          <!-- 중간 -->


        </v-col>
        <v-col cols="1"></v-col>
      </v-row> 
    </v-container>
</template>

<script>
import cardInfo from '@/assets/cardInfo.js'
import axios from "axios";
export default {
  name: "mycard",
  data: () => ({
    cardInfo,
    getinfo:[],
    // headers 
  }),
  components: {
      
  },
  mounted() {
    this.$store.commit('updateAuth',this.loginCheck_myCard);
    this.GetCard();
    //this.loginCheck_myCard()
  },
  methods: {
    loginCheck_myCard(){
      if(this.$store.state.auth == null){
        this.$router.push('login')
        alert('로그인을 해야 접속 가능합니다!');
      }
      else{
        this.$router.push('mycard')
      }
    },
    GetCard(){
      axios.get(this.$store.state.apihost + "/member/get_card",{
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("JSESSIONID")}`,
          },
        })
        .then((res) => {
            this.getinfo = res.data
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