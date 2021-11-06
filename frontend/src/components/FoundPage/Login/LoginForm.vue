<template>
    <v-card
        class="   ma-auto" 
        width="330"
        height="300" 
        tile flat> <!-- d-flex -->
        <v-container class="mt-7">
            <div class="text-h5">
                SionCard 로그인
            </div>
            <v-text-field
                class="ma-0 mt-2"
                label="아이디를 입력해 주세요."
                dense
                outlined
                hide-details="auto"
            ></v-text-field>
            <v-text-field
                class="ma-0 mt-2"
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
                <router-link class="mr-auto" to="/signin" tag="button">
                    <v-btn
                        class="px-1"
                        text
                        color="primary"
                    >
                        회원가입
                    </v-btn>
                </router-link>
                <v-btn
                    class="ml-auto"
                    color="primary"
                    dense
                >
                    로그인
                </v-btn>

            </v-card>
            <!-- <v-card
                class="d-flex align-center mt-16"
                width="100%"
                flat tile
            > -->
                <!-- <v-spacer/> -->
<!--                 <router-link class="ma-auto mr-1" to="/find_id" tag="button"> 아이디 찾기</router-link>
                <router-link class="ma-auto" to="/find_password" tag="button">| 비밀번호 찾기 </router-link> -->
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
        </v-container>
    </v-card>
</template>

<script>
import Find_ID from "./Findid.vue";
import Find_PW from "./Findpassword.vue";

export default {
    components: {
        Find_ID,
        Find_PW,
    }
}
</script>