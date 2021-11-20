<template>
  <v-row justify="center" v-if="!!this.$store.getters.getAuth">
      <v-col cols="1"></v-col>
      <v-col cols="10" align-self="center" class="text-center text-h3">
          관리자 페이지 입니다


          <v-container>
            <pie-chart :color="['green','black']" :data=cardInfo />
          </v-container>
      </v-col>
      <v-col cols="1"></v-col>
  </v-row>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      cardInfo: [],
    }
  },
  methods:{
    checkAdmin(){
      if(this.$store.getters.getAuth === null || this.$store.state.auth.member_id !== 'admin'){
          this.$router.push('/')
          alert('관리자만 접속 가능합니다!');
      }
    },
    loadGraph(){
      axios.get(this.$store.state.apihost+'/admin/kind_of_card',
      {
        headers:{
                  Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`
                },
      })
      .then((res)=>{
        console.log(res.data[0]);
        this.cardInfo=Object.entries(res.data[0])
       
                          console.log(this.cardInfo)
      })
      .catch((err)=>{
        console.log(err);
      })
    }
  },
  mounted(){
    this.$store.commit('updateAuth',this.checkAdmin);
    this.loadGraph();
  }
}
</script>