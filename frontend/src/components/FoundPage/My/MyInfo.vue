<template>
  <v-container>
      <v-row >
        <v-col cols="1"/>
        <v-col cols="10" class="text-h3 font-weight-bold">  

          <v-sheet class="mt-5">
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

              <!-- 웹 계정 정보 -->
              <v-tab-item>
                <v-container fluid>
                  <v-row>
                    <v-col class="grey lighten-5"> 
                      <myinfo_account/>
                    </v-col>
                  </v-row>
                </v-container>
              </v-tab-item>

              <!-- 개인 정보 -->
              <v-tab-item>
                <v-container fluid>
                  <v-row>
                    <v-col class="grey lighten-3"> 
                      <myinfo_card/>
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
import myinfo_card from './MyInfo_user.vue'

export default {
  name: "myinfo",
  data:() =>({
    
  }),
  components:{
      myinfo_account,
      myinfo_card
  },
  
}
</script>

<style>
.tab:focus-within{
  font-weight: bold;
}
</style>