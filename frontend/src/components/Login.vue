<template>
  <v-container height="100%" class="pa-0 pt-10 red">
    <v-row class="ma-auto pa-auto">
        <v-col cols="5" class="pa-0 blue">
            내용
        </v-col>
        <v-col cols="7" class="pa-0 blue">
            <v-card class="ma-auto d-flex flex-column" width="330" height="300" tile flat>
                <div class="pt-16">
                    
                    <v-text-field
                        class="justify-start ma-0"
                        label="아이디를 입력해 주세요."
                        dense
                        outlined
                    ></v-text-field>
                    <v-text-field
                        class="justify-start ma-0"
                        label="비밀번호를 입력해 주세요."
                        dense
                        hint="잘못 입력하셨습니다."
                        
                        outlined
                    ></v-text-field>
                </div>
            </v-card>
        </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {};
</script>

<style>
</style>