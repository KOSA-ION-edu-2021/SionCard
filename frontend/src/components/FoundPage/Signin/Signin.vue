<template>
    <v-container v-if="!this.$store.getters.getAuth">
      <v-row>
        <v-col cols="1"></v-col>
        <v-col cols="10">
          
          <!-- 최상단 글귀 -->
          <v-row justify="center" class="">
            <v-col class="mb-10 mt-10" cols="auto">
              <v-card flat tile class="grey lighten-2">
                <h1>회원가입</h1>
              </v-card>
            </v-col>
          </v-row>

          <h3>정보입력 및 약관동의</h3>
          <!-- 회원가입 틀 -->
          <table>
            <tr>
              <th>성명</th>
              <td>
                <v-text-field
                  style="width: 100%"
                  v-model="user_nm"
                  label="이름을 입력해 주세요."
                  :rules="user_nm_rule"
                  required
                  dense
                  hide-details="auto"
                  outlined
                ></v-text-field>
              </td>
            </tr>
            <tr>
              <th>아이디</th>
              <td>
                <!-- <v-card class="d-flex" width="40%" flat tile> -->
                  <v-text-field
                      style="width: 100%"
                      v-model="user_id"
                      label="아이디를 입력해 주세요."
                      @blur="id_check"
                      :error="error_message"
                      :error-messages="error_message"
                      :success="success_message"
                      :success-messages="success_message"
                      required
                      dense
                      outlined
                      hide-details="auto"
                    ></v-text-field>
                  <!-- <v-btn class="ml-3" color="secondary">중복 확인</v-btn> -->
                <!-- </v-card> -->
              </td>
            </tr>
            <tr>
              <th>비밀번호</th>
              <td>
                <v-text-field
                        style="width: 100%"
                        v-model="user_pw"
                        type="password"
                        label="비밀번호를 입력해 주세요."
                        :rules="user_pw_rule"
                        required
                        dense
                        hide-details="auto"
                        outlined
                      ></v-text-field>
              </td>
              <td>  
                <!------------ 비민번호 설정 기준 버튼 / 모달창--------------- -->
                      <v-dialog v-model="dialog1" width="30%">
                        <template v-slot:activator="{ on, attrs }">
                          <v-btn
                            class="ml-3"
                            color="secondary"
                            v-bind="attrs"
                            v-on="on"
                          >
                            비밀번호 설정 기준
                          </v-btn>
                        </template>
                        <v-card>
                          <v-card-title>
                            <span class="text-h5">비밀번호 설정 기준</span>
                          </v-card-title>
                          <v-card-text>
                            <ul>
                              <li>
                                영문 대문자, 영문 소문자, 숫자, 특수문자(~ ! @ # $ % ^
                                & * _ + ?) 중 3종 이상을 조합. 단, 특수문자 필수 포함
                              </li>
                            </ul>
                          </v-card-text>
                          <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="primary" text @click="dialog1 = false">
                              확인
                            </v-btn>
                          </v-card-actions>
                        </v-card>
                      </v-dialog>
              </td>
            </tr>
            <!-- =================여기까지 비밀번호 설정 기준 ============ -->

            <tr>
              <th>비밀번호 확인</th>
              <td>
                <v-text-field
                  style="width: 100%; text-align: center"
                  v-model="user_pw_chk"
                  type="password"
                  label="비밀번호를 입력해 주세요."
                  :rules="user_pw_rule2"
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
                  style="width: 100%"
                  v-model="user_email"
                  type="email"
                  label="이메일주소를 입력해주세요."
                  :rules="user_email_rule"
                  required
                  dense
                  hide-details="auto"
                  outlined
                ></v-text-field>
              </td>
            </tr>
            <!-- ===============회원가입 필수동의===================== -->
            <tr class="agreebox">
              <th>회원가입<br> 필수동의</th>
              <td colspan="2">
                <v-checkbox
                  v-model="checkbox"
                  name="checkbox"
                  :label="`SION카드 온라인회원 가입 전체동의`"
                  @click="checkbox1 = checkbox; checkbox2 = checkbox"
                ></v-checkbox>

                <!-- 온라인 이용약관 -->
                <v-card class="d-flex grey lighten-2" width="100%" flat tile>
                  <v-checkbox
                  class="grey lighten-2"
                    v-model="checkbox1"
                    :label="`온라인 이용약관 (필수)`"
                    @click="checkbox=(checkbox1 && checkbox2);"
                  ></v-checkbox>
                  <!-- ==================온라인 이용약관 버튼 / 모달창============= -->
                  <v-dialog v-model="dialog2" width="600px">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        class="ma-3"
                        color="secondary"
                        v-bind="attrs"
                        v-on="on"
                      >
                        상세보기
                      </v-btn>
                    </template>
                    <v-card class="grey lighten-2">
                      <v-card-title>
                        <span class="text-h5">SION카드 온라인회원 약관</span>
                      </v-card-title>
                      <v-card-text>
                        <Agree1 />
                      </v-card-text>
                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="primary" text @click="checkbox1 = true; checkbox=(checkbox1 && checkbox2); dialog2 = false">
                          Agree
                        </v-btn>
                        <v-btn color="primary" text @click="dialog2 = false">
                          Disagree
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                
                  <!-- ============================여기까지=========================== -->
                  <v-checkbox
                    v-model="checkbox2"
                    :label="`개인정보 수집 및 이용 (필수)`"
                    @click="checkbox=(checkbox1 && checkbox2);"
                  ></v-checkbox>
                  <!-- ====================개인정보 수집 및 이용 버튼/모달창========== -->
                  <v-dialog v-model="dialog3" width="600px">
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn
                        class="ma-3"
                        color="secondary"
                        v-bind="attrs"
                        v-on="on"
                      >
                        상세보기
                      </v-btn>
                    </template>
                    <v-card class="grey lighten-2">
                      <v-card-title>
                        <span class="text-h5">개인정보 수집 및 이용</span>
                      </v-card-title>
                      <v-card-text>
                        <Agree2 />
                      </v-card-text>
                      <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="primary" text @click="checkbox2 = true; checkbox=(checkbox1 && checkbox2); dialog3 = false">
                          Agree
                        </v-btn>
                        <v-btn color="primary" text @click="dialog3 = false">
                          Disagree
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </v-dialog>
                  <!-- =====================여기까지================================ -->
                </v-card>
              </td>
            </tr>
          </table>
          <v-row justify="center">
            <v-col class="ma-5" cols="auto">
              <v-btn
                @click="submit"
                method="post"
                x-large
                class="ml-auto; mb-16"
                color="secondary"
                dense
              >
                가입 완료
              </v-btn>
            </v-col>
          </v-row>
        </v-col>
        <v-col cols="1"></v-col>
      </v-row>
        
    </v-container>
</template>

<script>
import Agree1 from "./Agree1.vue";
import Agree2 from "./Agree2.vue";
import axios from "axios";

export default {
  name: "Signin",
  data() {
    return {
      user_id: "",
      has_id:false,
      error_message:false,
      success_message:false,
      user_id_rule: [
        (v) => !!v || "아이디는 필수 입력사항입니다.",
        (v) =>
          /^[a-zA-Z0-9]*$/.test(v) || "아이디는 영문+숫자만 입력 가능합니다.",
        (v) =>
          !(v && v.length >= 15) || "아이디는 15자 이상 입력할 수 없습니다.",
      ],
      user_nm: "",
      user_nm_rule: [
        (v) => !!v || "이름은 필수 입력사항입니다.",
        (v) => !(v && v.length >= 30) || "이름은 30자 이상 입력할 수 없습니다.",
        (v) =>
          !/[~!@#$%^&*()_+|<>?:{}]/.test(v) ||
          "이름에는 특수문자를 사용할 수 없습니다.",
      ],
      user_pw: "",
      user_pw_rule: [
        (v) =>
          this.state === "ins"
            ? !!v || "패스워드는 필수 입력사항입니다."
            : true,
        (v) =>
          !(v && v.length >= 30) || "패스워드는 30자 이상 입력할 수 없습니다.",
      ],
      user_pw_chk: "",
      user_pw_rule2: [
        (v) =>
          this.state === "ins"
            ? !!v || "패스워드는 필수 입력사항입니다."
            : true,
        (v) =>
          !(v && v.length >= 30) || "패스워드는 30자 이상 입력할 수 없습니다.",
        (v) => v === this.user_pw || "패스워드가 일치하지 않습니다.",
      ],
      user_email:"",
      user_email_chk: "",
      user_email_rule: [
        (v) => /.+@.+\..+/.test(v) || "이메일 형식으로 입력해주세요.",
      ],
      checkbox: false,
      checkbox1: false,
      checkbox2: false,
      dialog1: false,
      dialog2: false,
      dialog3: false,
      온라인이용상세: false,
      개인정보상세: false,
      formHasErrors: false,
    };
  },
  methods: {
    submit(){
      for(let rule of this.user_nm_rule){
        if(typeof rule(this.user_nm)=='string'){
          alert("올바른 이름을 입력해 주세요.")
          return;
        }
      }
      for(let rule of this.user_id_rule){
        if(typeof rule(this.user_id)=='string'){
          alert("올바른 아이디를 입력해 주세요.")
          return;
        }
      }


      axios.get(this.$store.state.apihost+"/api/id_check?id="+this.user_id)
        .then(res=>{
          if(res.data){
            this.has_id=true;
            this.error_message=false
            this.success_message="사용 가능한 아이디 입니다."
            return;
          }else{
            this.has_id=false;
            this.error_message="이미 존재하는 아이디 입니다."
            this.success_message=false
            return;
          }
        })
        .catch(err=>{
          this.has_id=false;
          this.error_message="다시 시도해주세요."
          console.log(err);
          return;
        })
      for(let rule of this.user_pw_rule){
        if(typeof rule(this.user_pw)=='string'){
          alert("올바른 암호를 입력해 주세요.")
          return;
        }
      }
      for(let rule of this.user_pw_rule2){
        if(typeof rule(this.user_pw_chk)=='string'){
          alert("올바른 암호를 입력해 주세요.")
          return;
        }
      }
      for(let rule of this.user_email_rule){
        if(typeof rule(this.user_email)=='string'){
          alert("올바른 이메일을 입력해 주세요.")
          return;
        }
      }
      if(!this.dialog2 || !this.dalog2){
        alert("개인정보동의를 전부 체크해 주세요.");
        return;
      }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////입력값 확인.
      axios.post(this.$store.state.apihost+"/api/signup",{
        name:this.user_nm,
        member_id:this.user_id,
        password:this.user_pw,
        email:this.user_email,
      })
      .then(()=>{
        alert("사이온카드 회원이 된것을 환영합니다!");
        this.$router.push('/login');
      })
      .catch(err=>{
        console.log("통신에 실패하였습니다. 다시 시도해주세요"+err);
      })
    },
    id_check(){
        for(let rule of this.user_id_rule){
          if(typeof rule(this.user_id)=='string'){
            this.has_id=false;
            this.error_message=rule(this.user_id);
            this.success_message=false
            return;
          }
        }
        axios.get(this.$store.state.apihost+"/api/id_check?id="+this.user_id)
        .then(res=>{
          if(res.data){
            this.has_id=true;
            this.error_message=false
            this.success_message="사용 가능한 아이디 입니다."
          }else{
            this.has_id=false;
            this.error_message="이미 존재하는 아이디 입니다."
            this.success_message=false
          }
        })
        .catch(err=>{
          this.has_id=false;
          this.error_message="다시 시도해주세요."
          console.log(err);
        })
    },
    
    loginCheck_myLogin(){
      this.$store.getters.getAuth && this.$router.go(-1)
    },
  }, 
  mounted(){
    this.$store.commit('updateAuth',this.loginCheck_myLogin)
  },
  computed: {
    form () {
      return {
        user_nm: this.user_nm,
        user_id:this.user_id,
        user_pw:this.user_pw,
        user_pw_chk:this.user_pw_chk,
        user_email:this.user_email
      }
    },
  },
  components: {
    Agree1,
    Agree2,
  },
};
</script>

<style scoped>

.agreebox {
  height: 100px;
}

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
td:nth-child(3){
  border-top-color:  rgb(196, 201, 209);
}
tr:last-child td{
  border-top-color:  rgb(196, 201, 209);
}
</style>