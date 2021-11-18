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
              <webpw_1step />
            </v-col>
          </v-row>

          <v-btn 
          color="grey lighten-2" 
          @click="e1 = 2"
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
import webpw_1step from "./webpw_1step.vue";
import webpw_2step from "./webpw_2step.vue";
import webpw_3step from "./webpw_3step.vue";

export default {
  name: "myinfo_webpw",
  data: () => ({
    e1: 1,
  }),
  components: {
    webpw_1step,
    webpw_2step,
    webpw_3step,
  },
  methods: {
   
  },
};
</script>

<style>
</style>
