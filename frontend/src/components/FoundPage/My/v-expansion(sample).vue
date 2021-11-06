<template>
      <v-row class="mt-n6">
        <v-col cols="1"></v-col>
        <v-col cols="10">
          <v-divider></v-divider>
          <v-expansion-panels tile flat >
            <v-expansion-panel>
              <!-- 패널 제목 : 계정 정보 -->
              <v-expansion-panel-header>
                회원 정보
              </v-expansion-panel-header>
              
              <!-- 패널 내용 : ID / PW / E-mail -->
              <v-expansion-panel-content class="grey lighten-3 pa-10">
                <!-- 1열 -->
                <v-row justify="center" class="pl-4 pr-4">
                  <!-- <v-col cols="1"/> -->
                  <v-col cols="4" align-self="center" class="text-center font-weight-bold">
                    이름
                  </v-col>
                  <v-col cols="4" align-self="center">
                    <v-text-field 
                      value="heewoong96"
                      row="auto"
                      >
                    </v-text-field>
                  </v-col>
                  <v-col cols="4" align-self="center">
                    <v-btn>
                      변경
                    </v-btn>
                  </v-col>
                </v-row>
                <!-- 2열 -->
                <v-row justify="center" class="pl-4 pr-4">
                  <!-- <v-col cols="1"/> -->
                  <v-col cols="4" align-self="center" class="text-center font-weight-bold">
                    생년월일
                  </v-col>
                  <v-col cols="4" align-self="center">
                    <v-text-field 
                      type="password"
                      value="heewoong96"
                      row="auto"
                      >
                    </v-text-field>
                  </v-col>
                  <v-col cols="4" align-self="center">
                    <v-btn>
                      변경
                    </v-btn>
                  </v-col>
                </v-row>
                <!-- 3열 -->
                <v-row justify="center" class="pl-4 pr-4">
                  <!-- <v-col cols="1"/> -->
                  <v-col cols="4" align-self="center" class="text-center font-weight-bold">
                    주소
                  </v-col>
                  <v-col cols="4" align-self="center">
                    <v-text-field 
                      value="03470@naver.com"
                      row="auto"
                      >
                    </v-text-field>
                  </v-col>
                  <v-col cols="4" align-self="center">
                    <v-btn>
                      변경
                    </v-btn>
                  </v-col>
                </v-row>
              </v-expansion-panel-content>
            </v-expansion-panel>
          </v-expansion-panels>
          <v-divider></v-divider>
          
        </v-col>
        <v-col cols="1"></v-col>
      </v-row>
</template>