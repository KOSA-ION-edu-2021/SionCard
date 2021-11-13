<template>
  <v-row justify="">
    <v-dialog
      v-model="dialog"
      transition="dialog-bottom-transition"
      max-width="600px"
      ><!-- fullscreen 추가하면 모달창 화면 전체 -->
      <template v-slot:activator="{ on, attrs }">
        <v-col class="" cols="auto" v-bind="attrs" v-on="on">
          <v-btn color="grey darken-3" dark v-bind="attrs" v-on="on" text>
            <b> 아이디 찾기 </b>
          </v-btn>
        </v-col>
      </template>

      <!-- 모달 페이지 -->
      <v-card>
        <!-- 최상단 bar -->
        <v-toolbar dark color="primary">
          <v-toolbar-title class="">ID 찾기</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn icon dark @click="dialog = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </v-toolbar>

        <!-- 정보 입력란 (이름 / 이메일)  -->
        <v-list three-line subheader v-if="!user_id">
            <v-list-item>
              <!-- <v-list-item-content width="100px" class="ma-1"> -->
              <v-col cols=""><b>이름</b></v-col>
              <!-- </v-list-item-content> -->

              <!-- <v-row justify="start"> -->
              <v-col cols="10" dense>
                <v-text-field
                  label="이름을 입력해 주세요."
                  v-model="user_nm"
                  :rules="user_nm_rule"
                  dense
                  outlined
                  hide-details="auto"
                >
                </v-text-field>
              </v-col>
              <!-- </v-row> -->
            </v-list-item>
            <v-divider></v-divider>

            <v-list-item>
              <!-- <v-list-item-content width="100px" class="ma-1"> -->
              <v-col cols=""><b>이메일</b></v-col>
              <!-- </v-list-item-content> -->

              <!-- <v-row justify="start"> -->
              <v-col cols="10" dense>
                <v-text-field
                  label="이메일을 입력해 주세요."
                  v-model="user_email"
                  :rules="user_email_rule"
                  dense
                  outlined
                  hide-details="auto"
                >
                </v-text-field>
              </v-col>
              <!-- </v-row> -->
            </v-list-item>
          
          <v-divider></v-divider>

            <v-list-item class="justify-center">
              <v-row class="justify-center">
                <v-col cols="8"></v-col>
                <v-col cols="2" dense algin-self="center" justify="center">
                  <v-btn click="submit" color="primary"> 아이디 찾기 </v-btn>
                </v-col>
              </v-row>
            </v-list-item>
        </v-list>

        <v-card tile flat v-else>
          
          <v-list-item>
            <!-- <v-list-item-content width="100px" class="ma-1"> -->
            <v-col cols=""><b>아이디는 </b></v-col>
            <!-- </v-list-item-content> -->

            <!-- <v-row justify="start"> -->
            <v-col cols="10" dense>
              {{this.user_id}} 입니다.
            </v-col>
            <!-- </v-row> -->
          </v-list-item>

        </v-card>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import axios from 'axios'
export default {
  name: "Find_ID",
  data: () => ({
    dialog: false,
    user_nm: "",  
    user_nm_rule: [
      (v) => !!v || "이름은 필수 입력사항입니다.",
      (v) => !(v && v.length >= 30) || "이름은 30자 이상 입력할 수 없습니다.",
      (v) =>
        !/[~!@#$%^&*()_+|<>?:{}]/.test(v) ||
        "이름에는 특수문자를 사용할 수 없습니다.",
    ],
    user_email: "",
    user_email_rule: [
        (v) => /.+@.+\..+/.test(v) || "이메일 형식으로 입력해주세요.",
    ],
    user_id: "",
  }),
  props: {},
  methods: {
    submit(){
      axios.post(this.$store.state.apihost + '/member/find_id',{
        name : this.user_nm,
        email : this.user_email
      })
      .then(res=>{
        console.log(res);
        this.user_id=res.data.id;
      })
      .catch(err=>{
        console.log(err);
      })
      
    }
  },
};
</script>

<style>
</style>