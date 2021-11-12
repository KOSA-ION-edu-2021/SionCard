<template>
  
      <v-app-bar app dark height="80px" class="pr-16">
      <!-- SION Card logo image -->
      <router-link to="/" class="ml-16">
        <v-img
          class="ml-16"
          max-height="48px"
          max-width="60px"
          contain
          src="@/assets/logo_transparent.png"
        />
      </router-link>
      <router-link to="/" tag="button">
      <v-col cols="auto" class="text-h5">
        SionCard
      </v-col>
      </router-link>
      
      <v-spacer></v-spacer>

      <!-- My menu -->
      <v-menu offset-y open-on-hover>
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            plain
            v-bind="attrs"
            v-on="on"
            @click="loginCheck_myMain"
          >
            My
          </v-btn>
        </template>
        <v-list>
          <v-list-item class="" @click="loginCheck_myInfo">
            <v-list-item-title >
                <!-- <router-link class="text-decoration-none" to="/myinfo"> -->
                  내 정보
                <!-- </router-link> -->
              </v-list-item-title>
          </v-list-item>
          <v-list-item class="" @click="loginCheck_myCard">
            <v-list-item-title>
                <!-- <router-link class="text-decoration-none" to="/mycard"> -->
                  내 카드
                <!-- </router-link> -->
              </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

      <!-- Card menu -->
      <v-menu  offset-y open-on-hover >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            plain
            v-bind="attrs"
            v-on="on"
            to="/card_main"
            class="mr-16"
            
          >
            Card 
          </v-btn>
        </template>
        <v-list >
          <v-list-item class="" to="/cardrecommend">
            <!-- <router-link  to="/cardrecommend" class="text-decoration-none"> -->
            <v-list-item-title >
                카드 추천
              </v-list-item-title>
              <!-- </router-link> -->
          </v-list-item>
          <v-list-item @click="loginCheck_cardApply">
            <v-list-item-title>
              <!-- <router-link  to="/cardinfor" class="text-decoration-none"> -->
                카드 신청
              <!-- </router-link> -->
              </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>    

      

    </v-app-bar>
    
</template>

<script>
export default {
  name: "Bar",
  components: {},
  data: () => ({
    myitems: [
      { title: "내 정보" },
      { title: "내 카드 정보" },
      { title: "이용 금액" },
      { title: "~~~~~" },
    ],
    carditems: [
      { title: "카드 안내" },
      { title: "카드 추천" },
      { title: "카드 신청" },
      { title: "~~~~~" },
    ],
    cardlink: [
      {link: "/cardrecommend"},
    ],
    auth:null
  }),
  mounted() {
    this.loginCheck_myMain()
    /* this.loginCheck_myInfo()
    this.loginCheck_myCard() */
  },
  methods: {
    loginCheck_myMain(){
      if(this.$store.state.auth == null){
        this.$router.push('login')
        alert('로그인을 해야 접속 가능합니다!');
      }
      else{
        this.$router.push('my_main')
      }
    },
    loginCheck_myInfo(){
      if(this.$store.state.auth == null){
        this.$router.push('login')
        alert('로그인을 해야 접속 가능합니다!');
      }
      else{
        this.$router.push('myinfo')
      }
    },
    loginCheck_myCard(){
      if(this.$store.state.auth == null){
        this.$router.push('login')
        alert('로그인을 해야 접속 가능합니다!');
      }
      else{
        this.$router.push('mycard')
      }
    },
    loginCheck_cardApply(){
      if(this.$store.state.auth == null){
        this.$router.push('login')
        alert('로그인을 해야 접속 가능합니다!');
      }
      else{
        this.$router.push('cardapply')
      }
    },
  },
};
</script>

<style>

</style>