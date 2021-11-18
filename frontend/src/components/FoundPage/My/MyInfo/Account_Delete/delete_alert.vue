<template>
  <v-row >
    <v-dialog
      v-model="dialog"
      transition="dialog-bottom-transition"
      width="35%"
      ><!-- fullscreen 추가하면 모달창 화면 전체 -->
      <template v-slot:activator="{ on, attrs }">
        
        <v-col cols="auto" v-bind="attrs" v-on="on">
          <v-btn elevation="2">
              회원 탈퇴
          </v-btn>
        </v-col>
      </template>

      <!-- 모달 페이지 -->
      <v-card>
        <v-toolbar dark color="grey darken-3">
          <v-toolbar-title class="text--black ml-1">SI-ON Card 웹 계정 삭제</v-toolbar-title>
          <v-spacer></v-spacer>

        </v-toolbar>

        <v-list class="text-center">
          <v-list-item class="text-center">
            <v-list-item-content class="text-center text-h4">      
                <v-row>
                    <v-col >
                        웹 계정을 삭제하시겠습니까?
                    </v-col>
                </v-row>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-content>      
                <v-row justify="center">
                    <v-col cols="auto">
                        <v-btn large outlined @click="deleteId(); dialog=false"> 예 </v-btn>
                    </v-col>
                    <v-col cols="auto">
                        <v-btn large outlined @click="dialog=false"> 아니오 </v-btn>
                    </v-col>
                </v-row>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import axios from 'axios'
export default {
    name: "delete_alert",
    data:()=> ({
        dialog: false,
    }),
    props:{
        id:String,
        pw:String,
        email:String
    },
    methods:{
      deleteId(){
        axios.delete(this.$store.state.apihost + "/member/members", {
          headers:{
            Authorization : `Bearer ${sessionStorage.getItem('JSESSIONID')}`,
            Id : this.id,
            Password : this.pw,
            Email : this.email
          }
        })
        .then(res=>{
          console.log(res.data);
        })
        .catch(err=>{
          console.log(err);
        })
      }
    }
}
</script>

<style>

</style>