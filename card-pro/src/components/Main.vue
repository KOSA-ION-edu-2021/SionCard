<!-- main page video 출력 -->
<template>
  <v-app>
    <v-main class="main">
      <div
        class="d-flex align-center mx-auto video1"
        :style="{ width: '960px' }"
      >
        <Player />
      </div>
      <v-parallax
        src="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg"
      ></v-parallax>
    </v-main>
  </v-app>
</template>

<script>
import Player from './Player.vue'
export default {

    components:{
        Player
    }
};
</script>

<style>
</style>