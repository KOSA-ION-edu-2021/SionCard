<template>
  <v-row justify="">
    <v-dialog
      v-model="dialog"
      transition="dialog-bottom-transition"
      width="600px"
      ><!-- fullscreen 추가하면 모달창 화면 전체 -->
      <template v-slot:activator="{ on, attrs }">
        <v-col class="" cols="auto" v-bind="attrs" v-on="on">
          <v-btn color="grey darken-3" dark v-bind="attrs" v-on="on" text>
            <b> 비밀번호 찾기 </b>
          </v-btn>
        </v-col>
      </template>

      <!-- 모달 페이지 -->
      <v-card>
        <!-- 최상단 bar -->
        <v-toolbar color="grey darken-3">
          <v-toolbar-title class="white--text">PW 찾기</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn icon dark @click="dialog = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </v-toolbar>

        <!-- 정보 입력란 (이름 / 이메일)  -->
        <v-list three-line subheader v-if="!result">
          
            <v-list-item>
              <v-col cols=""><b>이름</b></v-col>
                <v-col cols="10" dense>
                  <v-text-field
                    label="이름을 입력해 주세요."
                    v-model="user_nm"
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
              <v-col cols=""><b>ID</b></v-col>
                <v-col cols="10" dense>
                  <v-text-field
                    label="ID를 입력해 주세요."
                    v-model="user_id"
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
              <v-row class="justify-right">
                <v-col cols="8"></v-col>
                <v-col cols="1" dense algin-self="center">
                  <v-btn @click="submit" color="grey lighten-2"> 비밀번호 찾기 </v-btn>
                </v-col>
              </v-row>
            </v-list-item>
          
        </v-list>

        <v-card tile flat v-else>
          <v-list-item>
            <!-- <v-list-item-content width="100px" class="ma-1"> -->
            <v-col cols=""><b>비밀번호</b></v-col>
            <!-- </v-list-item-content> -->

            <!-- <v-row justify="start"> -->
            <v-col cols="10" dense>
              {{this.result}}
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
  name: "Find_PW",
  data: () => ({
    dialog: false,
    user_nm: "",
    user_email: "",
    user_id: "",
    result:""
  }),
  props: {},
  methods: {
    submit(){
      axios.post(this.$store.state.apihost + '/api/find_pw',{
        name : this.user_nm,
        email : this.user_email,
        member_id : this.user_id
      })
      .then(res=>{
        console.log(res.data);
        this.result=res.data;
      })
      .catch(err=>{
        console.log(err);
      })
      
    }},
};
</script>

<style>
</style>