<template>
  <v-container>
      <v-row>
      <v-col cols="1"></v-col>
      <v-col cols="10">
            <v-stepper v-model="e1">
                <!-- 상단 -->
                <v-stepper-header class="grey lighten-2">
                    <v-stepper-step
                    :complete="e1 > 1"
                    step="1"
                    color="black"
                    >
                        카드 선택
                    </v-stepper-step>

                    <v-divider></v-divider>

                    <v-stepper-step
                        :complete="e1 > 2"
                        step="2"
                        color="black"
                    >
                        서비스 선택
                    </v-stepper-step>

                    <v-divider></v-divider>

                    <v-stepper-step
                        :complete="e1 > 3"
                        step="3"
                        color="black"
                    >
                        개인 정보 인증
                    </v-stepper-step>

                    <v-divider></v-divider>

                    <v-stepper-step step="4" color="black">
                        신청 완료
                    </v-stepper-step>
                </v-stepper-header>

                <!-- 정보 입력 틀 -->
                <v-stepper-items class="grey lighten-4">

                    <!-- 1단계 : 카드 선택 -->
                    <v-stepper-content step="1">
                        <v-hover v-slot="{ hover }">
                        <v-row class="mb-12">
                            <v-col cols="3"
                            v-for="(card,i) in cardInfo" :key="i"
                            >
                              <v-card dense outlined
                                :elevation="hover ? 10 : 1"
                                :class="{ 'on-hover': hover }"
                                >
                                <v-img
                                :src=card.img
                                contain
                                aspect-ratio="2"
                                ></v-img>
                                    <v-expand-transition>
                                        <v-container
                                        v-if="hover"
                                        class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal text-h2 white--text"
                                        :class="{ 'show-img': hover }"
                                        >
                                          <!-- <v-card
                                          :class="{ 'show-img': hover }"
                                          > -->
                                            <v-img
                                            :src=card.img
                                            contain
                                            aspect-ratio="2"
                                            />
                                          <!-- </v-card>   -->
                                            
                                        </v-container>
                                    </v-expand-transition>
                                         
                                
                                </v-card>    
                            </v-col>
                        </v-row>
                        </v-hover>
                        <v-btn
                        color="grey lighten-2"
                        @click="e1 = 2"
                        >
                        Continue
                        </v-btn>

                        <v-btn text >
                        Cancel
                        </v-btn>
                    </v-stepper-content>

                    <!-- 2단계 : 서비스 선택 -->
                    <v-stepper-content step="2">
                        <v-container
                        class="mb-12"
                        color="grey lighten-1"
                        >

                                <v-img
                                :src=cardInfo[0].img
                                contain
                                aspect-ratio="4"
                                />
                                <v-row class="mt-10 mb-10">
                                    <v-col>
                                        해외 결제 기능
                                    </v-col>
                                    <v-col>
                                        <v-btn>master</v-btn>
                                    </v-col>
                                    <v-col>
                                        <v-btn>master</v-btn>
                                    </v-col>
                                </v-row>
                                <v-row class="mt-10 mb-10">
                                    <v-col>
                                        후불교통 기능
                                    </v-col>
                                    <v-col>
                                        <v-btn>신청</v-btn>
                                    </v-col>
                                    <v-col>
                                        <v-btn>신청안함</v-btn>
                                    </v-col>
                                </v-row>

                        </v-container>

                        <v-btn
                        color="grey lighten-2"
                        @click="e1 = 3"
                        >
                        Continue
                        </v-btn>

                        <v-btn text
                        @click="e1 = 1">
                        Cancel
                        </v-btn>
                    </v-stepper-content>

                    <!-- 3단계 : 개인 정보 인증 -->
                    <v-stepper-content step="3">
                        <v-container
                        class="mb-12"
                        color="grey lighten-1"
                        >
                            <v-row class="mt-5">
                                <v-col class="text-h4 font-weight-bold">
                                    본인 인증
                                </v-col>
                                </v-row>

                                <v-row class="text-h6 font-weight-regular">
                                    <v-col cols="">
                                        <table>
                                            <tr>
                                                <th>ID</th>
                                                <td>
                                                <v-text-field
                                                    style="width: 50%"
                                                    label="ID"
                                                    required
                                                    dense
                                                    hide-details="auto"
                                                    outlined
                                                ></v-text-field>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>이메일</th>
                                                <td>
                                                <v-text-field
                                                    style="width: 50%"
                                                    label="E-MAIL"
                                                    required
                                                    dense
                                                    hide-details="auto"
                                                    outlined
                                                ></v-text-field>
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <th>비밀번호</th>
                                                <td>
                                                <v-text-field
                                                    style="width: 50%"
                                                    label="PW"
                                                    required
                                                    dense
                                                    hide-details="auto"
                                                    outlined
                                                ></v-text-field>
                                                </td>
                                            </tr>
                                        </table>

                                    </v-col> 
                                </v-row>
                        </v-container>

                        <v-btn
                        color="grey lighten-2"
                        @click="e1 = 4"
                        >
                        Continue
                        </v-btn>

                        <v-btn text
                        @click="e1 = 2"
                        >
                        Cancel
                        </v-btn>
                    </v-stepper-content>

                    <!-- 4단계 : 개인 정보 인증 -->
                    <v-stepper-content step="4">
                        <v-container
                        class="mb-12"
                        color="grey lighten-1"
                        >
                        <v-row justify="center">
                            <v-col align-self="center" class="text-center"> 
                                <v-sheet class="text-h3 font-weight-bold">
                                    신청이 완료되었습니다.
                                </v-sheet>
                            </v-col>
                        </v-row>
                        </v-container>

                        <v-btn
                        color="grey lighten-2"
                        @click="e1 = 1"
                        >
                        Continue
                        </v-btn>

                        <v-btn text
                        @click="e1 = 3"
                        >
                        Cancel
                        </v-btn>
                    </v-stepper-content>
                </v-stepper-items>
            </v-stepper>
      </v-col>
      <v-col cols="1"></v-col>
  </v-row>
  </v-container>
</template>

<script>
import cardInfo from '@/assets/cardInfo.js'
export default {
    data: ()=>({
        cardInfo,
        e1: 1,
    }),
}
</script>

<style>

</style>

<style scoped>
table,
td,
tr {
  border: 1px solid rgb(196, 201, 209);
  border-collapse: collapse;
  border-left: none;
  border-right: none;
  border-top-color: black;
  height: 60px;
}
th {
  background: rgb(62, 62, 63);
  color: white;
  width: 144px;
  font-weight: 400;
  height: 60px;
}
table {
  width: 90%;
  font-size: 18px;
}
td{
  padding-left: 40px;
}
</style>