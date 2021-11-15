<template>
  <v-row justify="center">
    <v-col cols="1"></v-col>
    <v-col cols="10">
      
      <v-sheet class="mt-5 mb-5 text-h3 grey lighten-2"> 카드 정보 관리 </v-sheet>

      <v-row justify="center">
        <v-col align-self="center">
          <table>
            <tr>
              <th>고객명</th>
              <th>ID</th>
              <th>Password</th>
              <th>이메일</th>
              <th>주소</th>
              <th>번호</th>
              <th></th>
            </tr>
            <tr
            v-for="(member, i) in memberInfo" :key="i">
              <td> {{member.name}}</td>
              <td> {{member.member_id}}</td>
              <td> **** </td>
              <td> {{member.email}}</td>
              <td> {{member.address}}</td>
              <td> {{member.phone}}</td>
              <td><v-btn>변경</v-btn></td>
            </tr>
          </table>
        </v-col>
      </v-row>
    </v-col>
    <v-col cols="1"></v-col>
  </v-row>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    memberInfo: null,
  }),
  mounted() {
    this.getmemberInfo();
    this.checkAdmin()
  },
  methods: {
    getmemberInfo() {
      axios
        .get(this.$store.state.apihost + "/api/member_info")
        .then((res) => {
          console.log(res.data);
          this.memberInfo = res.data;
        })
        .catch((err) => {
          console.log(err);
        })},
    
    checkAdmin(){
            if(this.$store.state.auth.id !== 119){
              this.$router.push('/')
              alert('관리자만 접속 가능합니다!');
            }
            else{
              this.$router.push('/admin/user')
            }
        },
  },
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
  text-align: center;
}
th {
  background: rgb(62, 62, 63);
  color: white;
  height: 60px;
  font-weight: 400;
}

table {
  width: 90%;
  font-size: 18px;
}
td{
  height: 150px;
}

</style>