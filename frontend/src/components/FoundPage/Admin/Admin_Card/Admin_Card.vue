<template>
  <v-row justify="center" v-if="!!this.$store.getters.getAuth">
    <v-col cols="1"></v-col>
    <v-col cols="10">
      
      <v-sheet class="mt-5 mb-5 text-h3 grey lighten-2"> 카드 정보 관리 </v-sheet>
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
              <th class="mr-1">카드명</th>
              <th class="mr-1">이미지</th>
              <th class="mr-1">설명</th>
              <th class="mr-1">종류</th>
              <th class="mr-1">유형</th>
              <th class="mr-1">혜택</th>
              <th> 기능 </th>
            </tr>
            <tr
            v-for="(card, i) in cardInfo" :key="i">
              <td class="px-2"> {{card.title}}</td>
              <td class="px-2"> <v-img :src=card.img contain aspect-ratio=3 /></td>
              <td class="px-2"> {{card.content}}</td>
              <td class="px-2"> {{card.card_type}}</td>
              <td class="px-2"> {{card.benefit_type}}</td>
              <td class="px-2"> {{card.benefit_content}}</td>
              <td>
                <v-btn class="mx-2 my-1" small color="primary">편집</v-btn>
                <v-btn class="mx-2 my-1" small color="error">삭제</v-btn>
              </td>
            </tr>
          </table>
        </v-col>
      </v-row>
    </v-col>
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
    this.$store.commit('updateAuth',this.checkAdmin);
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
    setDialog(bool){
      this.dialog=bool
    },
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