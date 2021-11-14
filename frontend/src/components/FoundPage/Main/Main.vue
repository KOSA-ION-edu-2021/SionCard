<template>
    <!-- main page video 출력 -->
    <v-container class="pa-0 ma-0" fluid>
        <Player 
            height="100%"
            width="100%"
        />
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

<style lang="scss" scoped>
</style>