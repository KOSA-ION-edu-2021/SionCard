<template>
  <v-container>
      <v-row>
      <v-col cols="1"></v-col>
      <v-col cols="10">

          <v-sheet class="mt-5 mb-10 text-h3 font-weight-bold">
              카드 신청
          </v-sheet>  

            <v-stepper v-model="e1" class="mb-5" >
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
                <v-stepper-items class="grey lighten-4" >

                    <!-- 1단계 : 카드 선택 -->
                    <v-stepper-content step="1" >
                        
                        <v-row class="mb-12" >
                            <v-col cols="3" v-for="(card,i) in cardInfo" :key="i">
                                <v-hover v-slot="{ hover }">
                                    <v-img
                                    class="ma-5"
                                    :src=card.img
                                    contain
                                    aspect-ratio="2"
                                    @click="cardpick(i)"
                                    >
                                        <v-expand-transition>
                                                <v-img
                                                v-if="hover"
                                                :src=card.img
                                                contain
                                                />
                                        </v-expand-transition>
                                    </v-img>
                                </v-hover>
                                <!-- </v-card>  -->   
                            </v-col>
                        </v-row>
                        
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
                                :src=wantedcard
                                contain
                                aspect-ratio="4"
                                />
                                <v-row class="mt-10 mb-10 text-h5 font-weight-bold" >
                                    <v-col align-self="center" class="ml-5">
                                        해외 결제 기능
                                    </v-col>
                                    <v-col align-self="center">
                                        <v-btn @click="color1" :color=bgcolor1 
                                        outlined min-width="100" large 
                                        class="font-weight-bold">master</v-btn>
                                    </v-col>
                                    <v-col align-self="center">
                                        <v-btn @click="color2" :color=bgcolor2 
                                        outlined min-width="100" large 
                                        class="font-weight-bold">국내 전용</v-btn>
                                    </v-col>
                                </v-row>
                                <v-row class="mt-10 mb-10 text-h5 font-weight-bold" >
                                    <v-col align-self="center" class="ml-5">
                                        후불교통 기능
                                    </v-col>
                                    <v-col align-self="center">
                                        <v-btn @click="color3" :color=bgcolor3 
                                        outlined min-width="100" large 
                                        class="font-weight-bold">신청</v-btn>
                                    </v-col>
                                    <v-col align-self="center">
                                        <v-btn @click="color4" :color=bgcolor4 
                                        outlined min-width="100" large 
                                        class="font-weight-bold">신청안함</v-btn>
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
        wantedcardID:0,
        wantedcard:'',
        bgcolor1:'blue',
        bgcolor2:'',
        bgcolor3:'blue',
        bgcolor4:'',
        mastercard: true,
        traficcard: true,
    }),
    mounted() {
        this.loginCheck_cardApply()    
    },
    methods: {
    loginCheck_cardApply(){
      if(this.$store.state.auth == null){
        this.$router.push('login')
        alert('로그인을 해야 접속 가능합니다!');
      }
      else{
        this.$router.push('cardapply')
      }
    },
        cardpick(num){
            this.wantedcard=this.cardInfo[num].img
        },
        color1(){
            this.bgcolor1 = 'blue'
            this.bgcolor2 = ''
            this.mastercard = true
        },
        color2(){
            this.bgcolor1 = ''
            this.bgcolor2 = 'blue'
            this.mastercard = false
        },
        color3(){
            this.bgcolor3 = 'blue'
            this.bgcolor4 = ''
            this.traficcard = true
        },
        color4(){
            this.bgcolor3 = ''
            this.bgcolor4 = 'blue'
            this.traficcard = false
        },
    },
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