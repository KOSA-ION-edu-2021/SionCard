<template>
  <v-container>
      <v-row >
        <v-col cols="1"/>
        <v-col cols="10" class="text-h3 font-weight-bold">  

          <v-sheet class="mt-5 grey lighten-2">
            고객 정보 관리
          </v-sheet>  

          <v-card class="mt-10">
            <v-tabs
              color="black"
              left
            >
              <v-tab class=""><div class="tab">기본 정보 변경</div></v-tab>
              <v-tab>웹 비밀번호 변경</v-tab>
              <v-tab>웹 회원 탈퇴</v-tab>

              <!-- 기본 정보 변경 -->
              <v-tab-item>
                <v-container fluid>
                  <v-row>
                    <v-col class="grey lighten-3"> 
                      <myinfo_account />
                    </v-col>
                  </v-row>
                </v-container>
              </v-tab-item>

              <!-- 비밀번호 변경 -->
              <v-tab-item>
                <v-container fluid>
                  <v-row>
                    <v-col class="grey lighten-3"> 
                      <myinfo_webpw/>
                    </v-col>
                  </v-row>
                </v-container>
              </v-tab-item>
              
              <!-- 회원 탈퇴 -->
              <v-tab-item>
                <v-container fluid>
                  <v-row>
                    <v-col class="grey lighten-3"> 
                      <myinfo_delete/>
                    </v-col>
                  </v-row>
                </v-container>
              </v-tab-item>
              
            </v-tabs>
          </v-card>

        </v-col>
        <v-col cols="1"></v-col>
      </v-row>
 
  </v-container>
</template>

<script>
import myinfo_account from './MyInfo_account.vue'
import myinfo_webpw from './MyInfo_webpw.vue'
import myinfo_delete from './MyInfo_delete.vue'
/* import axios from 'axios' */

export default {
  name: "myinfo",
  data:() =>({
    /* memberInfo : null, */
  }),
  components:{
      myinfo_account,
      myinfo_webpw,
      myinfo_delete
  },
  mounted() {
    // this.loginCheck_myInfo()
    this.$store.commit('updateAuth',this.loginCheck_myMain)
  },
  methods: {
    loginCheck_myInfo(){
      if(this.$store.state.auth == null){
        this.$router.push('login')
        alert('로그인을 해야 접속 가능합니다!');
      }
      else{
        this.$router.push('myinfo')
      }
    },
  },
}
</script>

<style>
.tab:focus-within{
  font-weight: bold;
}
</style>