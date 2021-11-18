<template>
  <v-container>
    <v-row>
      <v-col>
        <v-sheet class="grey lighten-4 text-h4 font-weight-bold">
          본인 인증
        </v-sheet>
      </v-col>
    </v-row>

    <v-row class="mb-0 text-h6 font-weight-regular">
      <v-col>
        <table style="height: 60px">
          <tr>
            <th style="width: 144px">인증 방법</th>
            <td style="">
              <v-radio-group row mandatory>
                <v-radio
                  label="이메일"
                  value="email"
                  color="black"
                  aira-checked
                  @click="emailCheck"
                ></v-radio>
                <v-radio
                  label="SI-ON Card"
                  value="card"
                  color="black"
                  @click="cardCheck"
                ></v-radio>
              </v-radio-group>
              <!-- {{radioValues}} -->
            </td>
          </tr>
        </table>
      </v-col>
    </v-row>

    <!-- 인증 정보 입력 -->

    <!-- 이메일 인증 정보 -->
    <!-- <v-row class="mt-10" v-if="radioValues == 'email'">
      <v-col class="text-h4 font-weight-bold"> 인증 정보 입력 </v-col>
    </v-row> -->

    <v-row class="text-h6 font-weight-regular mb-3" v-if="radioValues == 'email'">
      <v-col cols="">
        <table>
          <tr>
            <th>ID</th>
            <td>
              <v-text-field
                style="width: 30%"
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
                style="width: 30%"
                label="EMAIL"
                required
                dense
                hide-details="auto"
                outlined
              ></v-text-field>
            </td>
          </tr>
          <tr>
            <th>현재 비밀번호</th>
            <td>
              <v-text-field
                style="width: 30%"
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

    <!-- SI-ON Card 인증 정보 -->
    <!-- <v-row class="mt-10" v-if="radioValues == 'card'">
      <v-col class="text-h4 font-weight-bold"> 인증 정보 입력 </v-col>
    </v-row> -->

    <v-row class="text-h6 font-weight-regular mb-3" v-if="radioValues == 'card'">
      <v-col cols="">
        <table>
          <tr>
            <th>ID</th>
            <td>
              <v-text-field
                style="width: 30%"
                label="ID"
                required
                dense
                hide-details="auto"
                outlined
              ></v-text-field>
            </td>
          </tr>
          <tr>
            <th>카드 번호</th>
            <td>
              <v-text-field
                style="width: 30%"
                label="CARD NUMBER"
                required
                dense
                hide-details="auto"
                outlined
              ></v-text-field>
            </td>
          </tr>
          <tr>
            <th>카드 비밀번호</th>
            <td>
              <v-text-field
                style="width: 30%"
                label="CARD PW"
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
</template>

<script>
export default {
    name: "webpw_1step",
    data: () => ({
      radioValues: 'email',
    }),
    methods:{
      emailCheck(){
        this.radioValues = 'email'
      },
      cardCheck(){
        this.radioValues = 'card'
      }

    }

};
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