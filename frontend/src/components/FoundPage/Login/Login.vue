<template>
  <v-card tile flat ><!-- style="margin-top: 166px" -->
    <v-container >
      <v-row class="ma-auto pa-auto">
        <v-col cols="1" md="" />
        <v-col cols="3" class="pa-0 d-none d-md-block">
          <LoginDeco />
        </v-col>
        <v-col cols="10" md="6" class="pa-0">
          <LoginForm />
        </v-col>
        <v-col cols="1" />
      </v-row>
      <v-file-input
        :rules="rules"
        multiple
        v-model="file"
        accept="image/png, image/jpeg, image/bmp, image/gif"
        placeholder="사진을 선택해 주세요"
        prepend-icon="mdi-camera"
        label="카드 사진을 올려주세요"
      />
      <v-btn
        color="primary"
        @click="send"
      >
        보내기
      </v-btn>
    </v-container>
  </v-card>
</template>

<script>
import LoginForm from "./LoginForm.vue";
import LoginDeco from "./LoginDeco.vue";
import axios from 'axios';

export default {
  components: {
    LoginForm,
    LoginDeco,
  },
  data: () => ({
      rules: [
        v => v || '파일이 존재하지 않습니다.',
        v => v.map(res=>res.size).reduce((p,n)=>p+n) < 30000000 || '전체용량이 30MB보다 작은 파일을 올려주세요!',
      ],
      file:null
  }),
  methods:{
    printFile(){
      console.log(this.file);
    },
    send(){
      this.printFile();
      axios.post(this.$store.state.apihost+"/admin/file_up",{
        name:"test",
        files:this.file,
      })
      .then(res=>{
        console.log(res);
      })
      .catch(err=>{
        console.log(err);
      })
    }
  },
  updated(){
    this.printFile();
  }
};
</script>
