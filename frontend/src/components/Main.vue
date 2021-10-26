<template>
    <!-- main page video 출력 -->
    <v-container class="pa-0 ma-0" fluid>
        <Player 
            height="auto"
            width="100%"
            :src="require('@/assets/main-bg-crad.mp4')"
        />
        <v-parallax src="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg"></v-parallax>
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

<style lang="scss" scoped >
$parallax-padding:100 100rem;

</style>