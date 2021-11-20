<template>
    <!-- main page video 출력 -->
    <v-container class="pa-0 ma-0" fluid>
        <v-img>
            <Player 
            height="100%"
            width="100%"
        />
        </v-img>
    
        <!-- 세션 2 -->
        <!-- <v-container class="main-section-2 text-center text-h3">
            <v-row justify="center" min-height="600px" class="ma-auto">
                <v-col align-self="center" cols="auto" class="pa-10">
                    빠르고 편리한 카드 생활<br>
                    SI-ON Card와 함께 트랜디한 금융생활을 느껴보세요
                </v-col>
            </v-row>
        </v-container> -->

        <!-- 세션 3 -->
        <!-- <v-container class="main-section-2 text-center text-h3">
            <v-row justify="center" min-height="600px" class="ma-auto">
                <v-col align-self="center" cols="auto" class="pa-10">
                    카드사 기능 설명 란 (아직 미완)
                </v-col>
            </v-row>
        </v-container> -->
    </v-container>
</template>

<script>
import Player from "./Player.vue"


export default {
    components:{
        Player,
    }
}
</script>

<style>
</style>

<style scoped>
.main-section-2{
    /* height: 600px; */
    font-size: 32px;
}
</style>