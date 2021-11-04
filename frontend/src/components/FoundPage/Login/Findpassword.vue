<template>
  <v-row justify="">
    <v-dialog
      v-model="dialog"
      transition="dialog-bottom-transition"
      max-width="600px"
      ><!-- fullscreen 추가하면 모달창 화면 전체 -->
      <template v-slot:activator="{ on, attrs }">
        <v-col class="" cols="auto" v-bind="attrs" v-on="on">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            <b> 비밀번호 찾기 </b>
          </v-btn>
        </v-col>
      </template>

      <!-- 모달 페이지 -->
      <v-card>
        <!-- 최상단 bar -->
        <v-toolbar dark color="primary">
          <v-toolbar-title class="">PW 찾기</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-btn icon dark @click="dialog = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </v-toolbar>

        <!-- 정보 입력란 (이름 / 이메일)  -->
        <v-list three-line subheader>
          
            <v-list-item>
              <v-col cols=""><b>이름</b></v-col>
                <v-col cols="10" dense>
                  <v-text-field
                    label="이름을 입력해 주세요."
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
                <v-col cols="10" dense algin-self="center" justify="center">
                  <v-btn> 비밀번호 찾기 </v-btn>
                </v-col>
              </v-row>
            </v-list-item>
          
        </v-list>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  name: "Find_PW",
  data: () => ({
    dialog: false,
  }),
  props: {},
  methods: {},
};
</script>

<style>
</style>