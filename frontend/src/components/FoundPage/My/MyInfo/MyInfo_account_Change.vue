<template>
  <v-row >
    <v-dialog
      v-model="dialog"
      transition="dialog-bottom-transition"
      max-width="600px"
      ><!-- fullscreen 추가하면 모달창 화면 전체 -->
      <template v-slot:activator="{ on, attrs }">
        
        <v-col class="yello" cols="auto" v-bind="attrs" v-on="on">
          <v-btn
            depressed
            elevation="12"
            outlined
            >
                기본 정보 변경
            </v-btn>
        </v-col>
      </template>

      <!-- 모달 페이지 -->
      <v-card>
        <!-- 최상단 bar -->
        <v-toolbar dark color="grey darken-3">
          <v-toolbar-title class="text--black ml-1">기본 정보 변경</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-toolbar-items>
            <v-btn icon dark @click="dialog = false">
                <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-toolbar-items>
        </v-toolbar>

        <!-- ID 변경  -->
        <v-list three-line subheader>
          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title><b>ID</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense >
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        </v-list-item-action>
                    아직
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        </v-list-item-action>
                    미완성이지롱
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 이메일 -->
          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title ><b>이메일</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        </v-list-item-action>
                    기대돼?
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 생년월일 -->
          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title ><b>생년월일</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        </v-list-item-action>
                    비밀이야
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>
          
          <!-- 휴대전화 -->
          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title ><b>휴대전화</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        </v-list-item-action>
                    ㅋㅋ
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 주소 -->
          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title ><b>주소</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        </v-list-item-action>
                    살려줘 ㅠ
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

        </v-list>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
    name: 'Account_Change',
    data:()=>({
        dialog: false,
    }),
    methods: {
        
    },
}
</script>

<style>

</style>