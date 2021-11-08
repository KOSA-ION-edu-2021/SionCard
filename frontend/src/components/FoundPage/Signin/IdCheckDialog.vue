<template>
  <v-dialog
      v-model="dialog"
      persistent
      max-width="290"
    >
      <v-card>
        <v-card-title class="text-h5">
          중복확인
        </v-card-title>

        <v-card-text>
          {{text}}
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>

          <v-btn
            color="primary"
            text
            v-if="!has_id"
            @click="close(true)"
          >
            확인
          </v-btn>

          <v-btn
            color="error"
            text
            @click="close(false)"
          >
            취소
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
import axios from "axios";

export default {
    props:{
        dialog:Boolean,
        close:Function,
        id:String,
    },
    data:()=>({
      text:"이미 아이디가 존재합니다.",
      has_id:true,
    }),
    updated(){
      if(this.dialog){
        axios.get(this.$store.state.apihost+"/api/id_check",{
          hearders:{id: this.id}
        })
        .then(res=>{
          res.data
        })
        .catch(err=>{
          console.log(err);
        })
      }else{
        //다일얼 로그가 꺼질때 무조건 아이디 없다고 뜨게 하기 위해서
        this.text="이미 아이디가 존재합니다.";
        this.has_id=true;
      }
    }
}
</script>