<template>
  <v-row >
    <v-dialog
      v-model="dialog"
      transition="dialog-bottom-transition"
      width="30%"
      ><!-- fullscreen 추가하면 모달창 화면 전체 -->
      <template v-slot:activator="{ on, attrs }">
        
        <v-col class="yello" cols="auto" v-bind="attrs" v-on="on">
          <v-btn elevation="2">
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
            <v-list-item-content class="text-center">
              <v-list-item-title class="text-font-weight">
                ID
              </v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense align-self="center">
                <v-list-item-content>
                  <v-list-item-title  >
                      
                      <v-text-field
                        label="ID"
                        required
                        dense
                        hide-details="auto"
                        outlined
                      ></v-text-field>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 이메일 변경  -->
          <v-list-item>
            <v-list-item-content class="text-center">
              <v-list-item-title class="text-font-weight">
                이메일
              </v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense align-self="center">
                <v-list-item-content>
                  <v-list-item-title  >
                      
                      <v-text-field
                        label="EMAIL"
                        required
                        dense
                        hide-details="auto"
                        outlined
                      ></v-text-field>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 생일 변경  -->
          <v-list-item>
            <v-list-item-content class="text-center">
              <v-list-item-title class="text-font-weight">
                생년월일
              </v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense align-self="center">
                <v-list-item-content>
                  <v-list-item-title  >
                      
                      <v-text-field
                        label="BIRTHDAY"
                        required
                        dense
                        hide-details="auto"
                        outlined
                      ></v-text-field>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>
          
          <!-- 전화번호 변경  -->
          <v-list-item>
            <v-list-item-content class="text-center">
              <v-list-item-title class="text-font-weight">
                전화번호
              </v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense align-self="center">
                <v-list-item-content>
                  <v-list-item-title  >
                      
                      <v-text-field
                        label="PHONE-NUMBER"
                        required
                        dense
                        hide-details="auto"
                        outlined
                      ></v-text-field>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 주소 변경  -->
          <v-list-item>
            <v-list-item-content class="text-center">
              <v-list-item-title class="text-font-weight">
                주소
              </v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="auto" dense align-self="center">
                <v-list-item-content>
                  <v-list-item-title  >
                      
                      <v-text-field
                        label="ADDRESS"
                        required
                        dense
                        hide-details="auto"
                        outlined
                      ></v-text-field>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 완료 버튼 -->
          <v-list-item>
            <v-row justify="end">
              <v-col cols="auto" dense align-self="center">
                <v-list-item-content>
                  <v-btn> 기본 정보 변경 </v-btn>
                </v-list-item-content>
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