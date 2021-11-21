<template>
  <v-row justify="center" v-if="!!this.$store.getters.getAuth">
    <v-col cols="1"></v-col>
    <v-col cols="10">
      
      <v-sheet class="mt-10 text-h3 grey lighten-2"> 카드 정보 관리 </v-sheet>
      <v-row justify="end">
        <v-col cols="auto" class="mr-5">
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
              <td class="px-2"> <v-text-field flat single-line width="150px" v-model="cardInfo[i].title"></v-text-field></td>
              <td class="px-2"> <v-img :src=card.img contain aspect-ratio="" max-width="200px" /></td>
              <td class="px-2"> <v-btn @click="dialog2.idx=i;dialog2.text=card.content;dialog2.isOpen=true">내용</v-btn></td>
              <td class="px-2"> <v-select v-model="card.card_type" :items="['check','credit']"/> </td>
              <td class="px-2"> <v-select v-model="card.benefit_type" :items="['point','mileage']"/></td>
              <td class="px-2"> <v-select v-model="card.benefit_content" :items="['stack','discount']"/></td>
              <td>
                <v-btn @click="editCard(i)" class="mx-2 my-1 white--text" small color="grey darken-2" flat>저장</v-btn>
                <v-btn @click="deleteCard(i)" class="mx-2 my-1" small color="error" flat>삭제</v-btn>
              </td>
            </tr>
          </table>

          <v-dialog v-model="dialog2.isOpen">
            <v-card class="ma-0" flat tile>
              <v-row class="ma-2">
                <v-col cols="12">
                  <v-textarea solo v-model="dialog2.text"></v-textarea>
                </v-col>
                <v-col class="d-flex justify-end" cols="12">
                  <v-btn class="mx-2" @click="cardInfo[dialog2.idx].content=dialog2.text;dialog2.isOpen=false" color="primary">저장</v-btn>
                  <v-btn @click="dialog2.isOpen=false" color="error">닫기</v-btn>
                </v-col>
              </v-row>
            </v-card>
          </v-dialog>
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
    dialog2: {
      idx : 0,
      isOpen : false,
      text :"",
    },
  }),
  components:{
    AdminCreateCard
  },
  mounted() {
    this.getcardInfo();
    this.$store.commit('updateAuth',this.checkAdmin);
  },
  methods: {
    editCard(idx){
      axios
        .put(`${this.$store.state.apihost}/admin/card/${this.cardInfo[idx].id}`,this.cardInfo[idx],{
          headers:{
            Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
          }
        })
        .then(res=>{
          alert("수정에 "+ res.data?"성공하였습니다.":"실패하였습니다.");
          this.$router.go();
        })
        .catch(err=>{
          console.log(err);
        })
    },
    deleteCard(idx){
      axios
        .delete(`${this.$store.state.apihost}/admin/card/${this.cardInfo[idx].id}`,{
          headers:{
            Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
          }
        })
        .then(res=>{
          alert("삭제에 "+ res.data?"성공하였습니다.":"실패하였습니다.");
          this.$router.go();
        })
        .catch(err=>{
          console.log(err);
        })
    },
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

table {
  width: 90%;
  font-size: 18px;
}
td{
  height: 150px;
}

</style>