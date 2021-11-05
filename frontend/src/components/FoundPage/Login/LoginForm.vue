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
// import axios from "axios";
export default {
    data:()=>({
        id:"",
        pw:""
    }),
    methods:{
        submit(){
            fetch('http://localhost:8080/api/login',{
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    id: this.id,
                    password: this.pw,
                }),
            })
            .then(res=>res.json())
            .then(data=>{
                console.log(data);
                this.$store.commit("setJwt",data.jwt);
                this.$router.push('/');
            })
            .catch(err=>{
                console.log(err);
                alert('로그인에 실패하였습니다.');
            })
        },
    }
}
</script>