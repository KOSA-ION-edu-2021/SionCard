<template>
  <v-container>
    <v-row>
      <v-col>
        <v-sheet class="grey lighten-4 text-h4 font-weight-bold">
          새 비밀번호 입력
        </v-sheet>
      </v-col>
    </v-row>
    
    
    <v-row class="text-h6 font-weight-regular mb-3">
      <v-col cols="">
        <table>
          <tr>
            <th>새 비밀번호</th>
            <td>
              <v-text-field
                style="width: 30%"
                label="PW"
                v-model="newpw"
                type="password"
                :rules="user_pw_rule"
                required
                dense
                hide-details="auto"
                outlined
              ></v-text-field>
            </td>
          </tr>
          <tr>
            <th>비밀번호 확인</th>
            <td>
              <v-text-field
                v-model="checkpw"
                style="width: 30%"
                label="PW Check"
                type="password"
                :rules="user_pw_rule2"
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
    name: "webpw_2step",
    data: () => ({
      newpw:"",
      checkpw:"",
      user_pw_rule: [
        (v) => console.log(v),
        (v) => 
          !!v || "패스워드는 필수 입력사항입니다.",
        (v) =>
          !(v && v.length >= 30) || "패스워드는 30자 이상 입력할 수 없습니다.",
      ],
      user_pw_rule2: [
        (v) =>
          !!v || "패스워드는 필수 입력사항입니다.",
        (v) =>
          !(v && v.length >= 30) || "패스워드는 30자 이상 입력할 수 없습니다.",
        (v) => v === this.newpwd || "패스워드가 일치하지 않습니다.",
      ],


    }),
    updated() {
      this.emitnewPW()
    },
    methods:{
      emitnewPW(){
        this.$emit('getnewPW',this.newpw)
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