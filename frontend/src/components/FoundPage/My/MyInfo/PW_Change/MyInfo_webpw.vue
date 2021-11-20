<template>
  <v-container>
    <!-- 상단 타이틀 -->
    <v-stepper v-model="e1">
      <v-stepper-header class="text-subtitle-1 grey lighten-2">
        <v-stepper-step :complete="e1 > 1" step="1" color="black">
          인증 정보 입력
        </v-stepper-step>

        <v-divider></v-divider>

        <v-stepper-step :complete="e1 > 2" step="2" color="black">
          비밀번호 변경
        </v-stepper-step>

        <v-divider></v-divider>

        <v-stepper-step step="3" color="black"> 비밀번호 변경 완료 </v-stepper-step>
      </v-stepper-header>

      <!-- 단계별 내용 -->

      <!-- 1단계 : 본인 인증 -->
      <v-stepper-items class="grey lighten-4">
        <v-stepper-content step="1">
          <v-row>
            <v-col>
              <webpw_1step @getPW="getPW" />
            </v-col>
          </v-row>

          <v-btn 
          color="grey lighten-2" 
          @click="CheckPassword"
          > 
          Continue 
          </v-btn>

          <v-btn 
          text
          >
           Cancel 
          </v-btn>
        </v-stepper-content>

        <!-- 2단계 : 비밀번호 변경 -->
        <v-stepper-content step="2">
          <v-row>
            <v-col>
              <webpw_2step />
            </v-col>
          </v-row>

          <v-btn color="grey lighten-1" @click="e1 = 3"> Continue </v-btn>

          <v-btn text @click="e1 = 1"> Cancel </v-btn>
        </v-stepper-content>

        <!-- 3단계 : 비밀번호 변경 완료 -->
        <v-stepper-content step="3">
          <v-row>
            <v-col>
              <webpw_3step />
            </v-col>
          </v-row>

          <v-btn color="grey lighten-1"> Continue </v-btn>

          <v-btn text @click="e1 = 2"> Cancel </v-btn>
        </v-stepper-content>
      </v-stepper-items>
    </v-stepper>
  </v-container>
</template>

<script>
import axios from 'axios';
import webpw_1step from "./webpw_1step.vue";
import webpw_2step from "./webpw_2step.vue";
import webpw_3step from "./webpw_3step.vue";

export default {
  name: "myinfo_webpw",
  data: () => ({
    e1: 1,
    pw:"",
  }),
  components: {
    webpw_1step,
    webpw_2step,
    webpw_3step,
  },
  updated() {
    console.log('updated')
  },
  methods: {
    getPW(val){
      this.pw = val
      //console.log('pw 변경값:', this.pw)
    },
    CheckPassword() {
       axios.post(this.$store.state.apihost + '/member/checkemailpassword',{},{
                headers:{
                        Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`,
                        pw : this.pw,
                    },
            })
            .then((res)=>{
              console.log(this.pw)
              console.log(res)
                if(res.data === true){
                    alert('본인 인증 되었습니다!');
                    this.el = 2;
                }else{
                    alert('본인 인증 실패하였습니다!')
                }
            })
            .catch(err=>{
                console.log(err);
                alert('시스템 문제가 발생하였습니다.')
            })
        },
  },
};
</script>

<style>
</style>
