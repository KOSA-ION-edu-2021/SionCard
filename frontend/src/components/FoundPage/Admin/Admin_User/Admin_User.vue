<template>
  <v-row justify="center" v-if="!!this.$store.getters.getAuth">
    <v-col cols="1"></v-col>
    <v-col cols="10">
      
      <v-sheet class="mt-5 mb-5 text-h3 grey lighten-2"> 고객 정보 관리 </v-sheet>

      <v-row justify="center">
        <v-col align-self="center">
          <table>
            <tr>
              <th style="padding-left:20px; padding-right:20px">고객명</th>
              <th style="padding-left:20px; padding-right:20px">ID</th>
              <th style="padding-left:20px; padding-right:20px">Password</th>
              <th style="padding-left:20px; padding-right:20px">이메일</th>
              <th style="padding-left:20px; padding-right:20px">주소</th>
              <th style="padding-left:20px; padding-right:20px">번호</th>
            </tr>
            <tr
            v-for="(member, i) in memberInfo" :key="i">
              <td> {{member.name}}</td>
              <td> {{member.member_id}}</td>
              <td> **** </td>
              <td> {{member.email}}</td>
              <td> {{member.address}}</td>
              <td> {{member.phone}}</td>
              <!-- <td><v-btn>변경</v-btn></td> -->
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
    this.$store.commit('updateAuth',this.checkAdmin);
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
      if(this.$store.getters.getAuth === null || this.$store.state.auth.member_id !== 'admin'){
          this.$router.push('/')
          alert('관리자만 접속 가능합니다!');
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
  /* border-top-color: rgb(180, 169, 169); */
  text-align: center;
}
th {
  background: rgb(62, 62, 63);
  color: white;
  height: 60px;
  font-weight: 400;
}

table {
  width: 100%;
  font-size: 18px;
  display: block;
}
td{
  height: 150px;
}

</style>