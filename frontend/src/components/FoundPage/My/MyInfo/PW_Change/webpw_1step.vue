<template>
  <v-container>
    <v-row>
      <v-col>
        <v-sheet class="grey lighten-4 text-h4 font-weight-bold">
          본인 인증
        </v-sheet>
      </v-col>
    </v-row>

    

    <!-- 인증 정보 입력 -->

    <!-- 이메일 인증 정보 -->
    <!-- <v-row class="mt-10" v-if="radioValues == 'email'">
      <v-col class="text-h4 font-weight-bold"> 인증 정보 입력 </v-col>
    </v-row> -->

    <v-row class="text-h6 font-weight-regular mb-3">
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
                v-model="email"
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
                v-model="pw"
                required
                dense
                hide-details="auto"
                outlined
                type="password"
                @blur="CheckEmailPassword"
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

    
  </v-container>
</template>

<script>
export default {
    name: "webpw_1step",
    data: () => ({
      //radioValues: 'email',
      email : "",
      pw : "",
    }),
    methods:{
      /* emailCheck(){
        this.radioValues = 'email'
      },
      cardCheck(){
        this.radioValues = 'card'
      } */

    },
    props:[
      'CheckEmailPassword'
    ]
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