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
          
          <!-- 카드 이미지 슬라이드 -->
          <v-row>
            <v-col align-self="center">
              <v-carousel
                height="300"
                hide-delimiters
                hide-delimiter-background
                class="mt-10 mb-10"
                max-width="800px"
                >
                <v-carousel-item v-for="(card) in cardInfo" :key="card.id" class="align-center">
                  
                    <v-row justify="center">
                        <v-col cols="6" align-self="center">
                            <v-img
                            contain
                            aspect-ratio="2"
                            :src=card.img />
                        </v-col>
                    </v-row>
                  
                </v-carousel-item>
              </v-carousel>
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
export default {
  name: "mycard",
  data: () => ({
    cardInfo
  }),
  components: {
      
  },
  mounted() {
    this.loginCheck_myCard()
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
  },
};
</script>

<style>
</style>