<template>
    <v-card
        class="grey lighten-2 ma-auto" 
        width="330"
        height="300" 
        tile flat> <!-- d-flex -->
        <v-container class="mt-7">
            <div class="text-h5">
                SionCard 로그인
            </div>
            <form @submit.prevent="submit">
                <v-text-field
                    class="ma-0 mt-2"
                    label="아이디를 입력해 주세요."
                    v-model="id"
                    :rules="id_rule"
                    dense
                    outlined
                    hide-details="auto"
                ></v-text-field>
                <v-text-field
                    class="ma-0 mt-2"
                    v-model="pw"
                    type="password"
                    label="비밀번호를 입력해 주세요."
                    :rules="pw_rule"
                    required
                    dense
                    hide-details="auto"
                    outlined
                ></v-text-field>
                <v-card
                    class="d-flex align-end mt-2 grey lighten-2"
                    width="100%"
                    flat
                    tile
                >   
                    <v-btn
                        class="px-1"
                        text
                        color="primary"
                        to="/signin"
                    >
                        회원가입
                    </v-btn>
                    <v-btn
                        class="ml-auto"
                        color="primary"
                        type="submit"
                        dense
                    >
                        로그인
                    </v-btn>

            </v-card>
            
            <v-row class="mt-7 justify-center">
                <v-col cols="auto">
                    <Find_ID/>
                </v-col>
                <v-col cols="auto">
                    <Find_PW/>    
                </v-col>
            </v-row>
                
                
                <!-- <v-spacer/> -->
            <!-- </v-card> -->
            </form>
        </v-container>
    </v-card>
</template>

<script>
import Find_ID from "./Findid.vue";
import Find_PW from "./Findpassword.vue";
import axios from "axios";

export default {
    components: {
        Find_ID,
        Find_PW,
    },
    data:()=>({
        id:"",
        id_rule: [
            (v) => !!v || "아이디는 필수 입력사항입니다.",
            (v) =>
            /^[a-zA-Z0-9]*$/.test(v) || "아이디는 영문+숫자만 입력 가능합니다.",
            (v) =>
            !(v && v.length >= 15) || "아이디는 15자 이상 입력할 수 없습니다.",
        ],
        pw:"",
        pw_rule: [
            (v) => !!v || "패스워드는 필수 입력사항입니다.",
            (v) => !(v && v.length >= 30) || "패스워드는 30자 이상 입력할 수 없습니다.",
        ],
    }),
    props:{
        go_page:String,
    },
    methods:{
        submit(){
            axios.post(this.$store.state.apihost+'/api/login',{
                id: this.id,
                password: this.pw,
            })
            .then(res=>{
                this.$store.commit("setJwt",res.data.jwt);
                this.$store.state.expire = new Date(res.data.expire);
                this.$router.push(this.go_page||'/' ); //go_page에 값이 없으면 루트페이지로 간다.
            })
            .catch(err=>{
                console.log(err);
                alert('로그인에 실패하였습니다.');
            })
        },
    },
    updated(){
        if(!this.dialog) this.result="";
    }
}
</script>