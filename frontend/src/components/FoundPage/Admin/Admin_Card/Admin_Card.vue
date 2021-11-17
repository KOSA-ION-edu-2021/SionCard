<template>
  <v-row justify="center">
    <v-col cols="1"></v-col>
    <v-col cols="10">
      
      <v-sheet class="mt-5 mb-5 text-h3 grey lighten-2"> 고객 정보 관리 </v-sheet>
      <v-row>
        <v-col class="d-flex justify-end" cols="11">
          <v-btn @click="dialog=true">
            카드 추가하기
          </v-btn>
          <AdminCreateCard :dialog="dialog" :setDialog="setDialog"/>
        </v-col>
        <v-col cols="1"></v-col>
      </v-row>
      <v-row justify="center">
        <v-col align-self="center">
          <table>
            <tr>
              <th>카드명</th>
              <th>이미지</th>
              <th>카드 설명</th>
              <th>카드 종류</th>
              <th>카드 유형</th>
              <th>카드 혜택</th>
              <th></th>
            </tr>
            <tr
            v-for="(card, i) in cardInfo" :key="i">
              <td> {{card.title}}</td>
              <td> <v-img :src=card.img contain aspect-ratio="1"/></td>
              <td> {{card.content}}</td>
              <td> {{card.card_type}}</td>
              <td> {{card.benefit_type}}</td>
              <td> {{card.benefit_content}}</td>
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
import AdminCreateCard from './AdminCreateCard'
export default {
  data: () => ({
    cardInfo: null,
    dialog:false,
  }),
  components:{
    AdminCreateCard
  },
  mounted() {
    this.getcardInfo();
    this.checkAdmin()
  },
  methods: {
    getcardInfo() {
      axios
        .get(this.$store.state.apihost + "/api/card_info")
        .then((res) => {
          console.log(res.data);
          this.cardInfo = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    checkAdmin(){
            if(this.$store.state.auth.member_id !== 'admin'){
              this.$router.push('/')
              alert('관리자만 접속 가능합니다!');
            }
            else{
              this.$router.push('/admin/card')
            }
        },
    setDialog(bool){
      this.dialog=bool
    }
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
th:first-child{
  width: 250px;
}
th:nth-child(2){
  width: 300px;
}
table {
  width: 90%;
  font-size: 18px;
}
td{
  height: 150px;
}
td:nth-child(2){
  width: 250px;
}
</style>