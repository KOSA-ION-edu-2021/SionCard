<template>
  <div id='app'>
    
    
    <!-- <Navbar /> -->
      <header>
        
        <div data-app>
          <Bar />
        </div>
        
      </header>

     

      <!-- main page video 출력 -->
      <template>
        <v-app>
          <v-main class="main">
              <div class="d-flex align-center mx-auto video1" :style="{ width:'960px' }">
                <Player />
              </div>
            <v-parallax src="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg"></v-parallax>
          </v-main>
        </v-app>    
      </template>
      
  </div>
</template>

<script>
import Bar from './components/Bar.vue'
import Player from './components/Player.vue'

  export default {
    name : 'app',
  components: { 
    Bar,
    Player 

    },
    data: () => ({
     
    }),
  }
</script>

<style>
.main{
  background-color: black;
}

</style>
