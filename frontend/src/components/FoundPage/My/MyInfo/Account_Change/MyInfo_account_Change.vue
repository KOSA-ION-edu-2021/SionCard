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
          <!-- <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title><b>ID</b></v-list-item-title>
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
          <v-divider></v-divider> -->

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
                        <v-list-item-action class="ma-0">
                          <v-text-field
                            style="width: 30%"
                            label="EMAIL"
                            v-model="email"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </v-list-item-action>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            <v-spacer />
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                          <v-btn
                          color="grey lighten-2" 
                          @click="changeemail()"
                          >
                            변경
                          </v-btn>
                        </v-list-item-action> 
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-spacer />
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
                        <v-list-item-action class="ma-0">
                          <v-text-field
                            style="width: 30%"
                            label="0000-00-00"
                            v-model="birth"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </v-list-item-action> 
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-spacer />
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                          <v-btn
                          color="grey lighten-2" 
                          @click="changebirth()"
                          >
                            변경
                          </v-btn>
                        </v-list-item-action> 
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-spacer />
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
                        <v-list-item-action class="ma-0">
                          <v-text-field
                            style="width: 30%"
                            label="010-0000-0000"
                            v-model="phone"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </v-list-item-action>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            <v-spacer />
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                          <v-btn
                          color="grey lighten-2" 
                          @click="changephone()"
                          >
                            변경
                          </v-btn>
                        </v-list-item-action> 
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-spacer />
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
                        <v-list-item-action class="ma-0">
                          <v-text-field
                            style="width: 30%"
                            label="주소"
                            v-model="address"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </v-list-item-action>
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            <v-spacer />
              <v-col cols="auto" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                          <v-btn
                          color="grey lighten-2" 
                          @click="changeaddress()"
                          >
                            변경
                          </v-btn>
                        </v-list-item-action> 
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-spacer />
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <!-- 완료 버튼 -->
          <v-list-item>
            <v-row justify="end">
              <v-col cols="auto" dense align-self="center">
                <v-list-item-content>
                  <v-btn @click="reload"> 기본 정보 변경 </v-btn>
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
import axios from "axios";
export default {
    name: 'Account_Change',
    data:()=>({
        dialog: false,
        email : "",
        phone : "",
        birth : "",
        address : "",
    }),
    methods: {
        // 이메일 변경 함수
        changeemail(){
            let param = {
                email : this.email,
            }            
            axios.put(this.$store.state.apihost + "/member/member_info/email/"+this.$store.state.auth.member_id, param,{
                headers:{
                        Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
                    },
            })
            .then(res => {
                alert('이메일 변경이 완료되었습니다')
                console.log(res);
            })
            .catch((err)=>{
                alert('변경에 실패하였습니다. 다시 시도해주세요')
                console.log(err);
            })
        },
        // 주소 변경 함수
         changeaddress(){
            let param = {
                address : this.address,
            }            
            axios.put(this.$store.state.apihost + "/member/member_info/address/"+this.$store.state.auth.member_id, param,{
                headers:{
                        Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
                    },
            })
            .then(res => {
                alert('주소 변경이 완료되었습니다')
                console.log(res);
            })
            .catch((err)=>{
                alert('변경에 실패하였습니다. 다시 시도해주세요')
                console.log(err);
            })
        },
        // 생일 변경 함수
        changebirth(){
            let param = {
                birth : this.birth,
            }            
            axios.put(this.$store.state.apihost + "/member/member_info/birth/"+this.$store.state.auth.member_id, param,{
                headers:{
                        Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
                    },
            })
            .then(res => {
                alert('생년월일 변경이 완료되었습니다')
                console.log(res);

            })
            .catch((err)=>{
                alert('변경에 실패하였습니다. 다시 시도해주세요')
                console.log(err);
            })
        },
        // 전화번호 변경 함수
        changephone(){
            let param = {
                phone : this.phone,
            }            
            axios.put(this.$store.state.apihost + "/member/member_info/phone/"+this.$store.state.auth.member_id, param,{
                headers:{
                        Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
                    },
            })
            .then(res => {
                alert('전화번호 변경이 완료되었습니다')
                console.log(res);

            })
            .catch((err)=>{
                alert('변경에 실패하였습니다. 다시 시도해주세요')
                console.log(err);
            })
        },
        //기본정보 변경 후 새로고침 버튼
        reload(){
          this.$router.go()
        }
    },
}
</script>

<style>

</style>