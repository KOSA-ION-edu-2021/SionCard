<template>
      <v-container>
        <v-row justify="center" class="">
          <v-col class="mb-10 mt-10" cols="auto">
            <v-card flat tile>
              <h1>회원가입</h1>
            </v-card>
          </v-col>
        </v-row>

        <h3>정보입력 및 약관동의</h3>

        <table>
          <tr>
            <th>성명</th>
            <td>
              <v-text-field
                style="width: 30%"
                class="ml-10"
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
              <v-card class="d-flex" width="45%" flat tile>
                <v-text-field
                  class="ml-10"
                  style="width: 30%"
                  v-model="user_id"
                  label="아이디를 입력해 주세요."
                  :rules="user_id_rule"
                  required
                  dense
                  outlined
                  hide-details="auto"
                ></v-text-field>
                <v-btn class="ml-3" color="secondary">중복 확인</v-btn>
              </v-card>
            </td>
          </tr>
          <tr>
            <th>비밀번호</th>
            <td>
              <v-card class="d-flex" width="52%" flat tile>
                <v-text-field
                  style="width: 30%"
                  class="ml-10"
                  v-model="user_pw"
                  type="password"
                  label="비밀번호를 입력해 주세요."
                  :rules="user_pw_rule"
                  required
                  dense
                  hide-details="auto"
                  outlined
                ></v-text-field>

                <!------------ 비민번호 설정 기준 버튼 / 모달창--------------- -->
                <v-dialog v-model="dialog1" width="400px">
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
              </v-card>
            </td>
          </tr>
          <!-- =================여기까지 비밀번호 설정 기준 ============ -->

          <tr>
            <th>비밀번호 확인</th>
            <td>
              <v-text-field
                style="width: 30%; text-align: center"
                class="ml-10"
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
                style="width: 40%"
                class="ml-10"
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
            <th>회원가입 필수동의</th>
            <td>
              <v-checkbox
                class="ml-9"
                v-model="checkbox0"
                name="checkbox"
                :label="`SION카드 온라인회원 가입 전체동의`"
                @click="checkbox1 = true; checkbox2 = true"
              ></v-checkbox>

              <v-card class="d-flex" width="100%" flat tile>
                <v-checkbox
                  class="ml-9"
                  v-model="checkbox1"
                  :label="`온라인 이용약관 (필수)`"
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
                  <v-card>
                    <v-card-title>
                      <span class="text-h5">SION카드 온라인회원 약관</span>
                    </v-card-title>
                    <v-card-text>
                      <Agree1 />
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="primary" text @click="checkbox1 = true; dialog2 = false">
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
                  <v-card>
                    <v-card-title>
                      <span class="text-h5">개인정보 수집 및 이용</span>
                    </v-card-title>
                    <v-card-text>
                      <Agree2 />
                    </v-card-text>
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="primary" text @click="checkbox2 = true; dialog3 = false">
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
              to="/signincpl"
              method="post"
              x-large
              class="ml-auto; mb-16"
              color="secondary"
              dense
            >
              다음
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
</template>

                                    <script>
import Agree1 from "./Agree1.vue";
import Agree2 from "./Agree2.vue";

export default {
  name: "Signin",
  data() {
    return {
      user_id: "",
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
      user_email_chk: "",
      user_email_rule: [
        (v) => /.+@.+\..+/.test(v) || "이메일 형식으로 입력해주세요.",
      ],
      checkbox: [],
      checkbox1: false,
      checkbox2: false,
      dialog1: false,
      dialog2: false,
      dialog3: false,
      온라인이용상세: false,
      개인정보상세: false,
    };
  },
  methods: {
  },
  components: {
    Agree1,
    Agree2,
  },
};
</script>

<style>
.agreebox {
  height: 100px;
}

table,
td,
tr {
  border: 1px solid rgb(196, 201, 209);
  border-collapse: collapse;
  border-left: none;
  border-right: none;
  border-top-color: black;
}
th {
  background: rgb(62, 62, 63);
  color: white;
}
table {
  width: 100%;
  height: 500px;
}
</style>