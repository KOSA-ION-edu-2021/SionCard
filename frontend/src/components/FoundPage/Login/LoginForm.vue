<template>
    <v-card
        class="   ma-auto" 
        width="330"
        height="300" 
        tile flat> <!-- d-flex -->
        <v-container class="align-center pt-5">
            <div class="text-h5">
                SionCard 로그인
            </div>
            <form @submit.prevent="submit">
                <v-text-field
                    class="ma-0 mt-2"
                    label="아이디를 입력해 주세요."
                    v-model="id"
                    dense
                    outlined
                    hide-details="auto"
                ></v-text-field>
                <v-text-field
                    class="ma-0 mt-2"
                    v-model="pw"
                    type="password"
                    label="비밀번호를 입력해 주세요."
                    dense
                    hint="잘못 입력하셨습니다."
                    hide-details="auto"
                    outlined
                ></v-text-field>
                <v-card
                    class="d-flex align-end mt-2"
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
                <v-card
                    class="d-flex align-center mt-16"
                    width="100%"
                    flat tile
                >
                    <v-spacer/>
                    <router-link class="ma-auto mr-1" to="/find_id" tag="button"> 아이디 찾기</router-link>
                    <router-link class="ma-auto" to="/find_password" tag="button">| 비밀번호 찾기 </router-link>
                    <v-spacer/>
                </v-card>
            </form>
        </v-container>
    </v-card>
</template>

<script>
import axios from "axios";
export default {
    data:()=>({
        id:"",
        pw:""
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
                console.log(res);
                this.$store.commit("setJwt",res.data.jwt);
                this.$router.push(this.go_page||'/' ); //go_page에 값이 없으면 루트페이지로 간다.
            })
            .catch(err=>{
                console.log(err);
                alert('로그인에 실패하였습니다.');
            })
        },
    }
}
</script>