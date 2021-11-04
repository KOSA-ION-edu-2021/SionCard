<template>
  <div id='app'>
    
    
    <!-- <Navbar /> -->
      <header>
        
        <div data-app>
          <Bar />
        </div>
        
      </header>
    <!-- Sizes your content based upon application components -->
      <v-main>

        <!-- Provides the application the proper gutter -->
        <v-container fluid>
          <!-- If using vue-router -->
          <router-view></router-view>
        </v-container>
      </v-main>

      
  </div>
</template>

<script>
import Bar from './components/Bar.vue'

  export default {
    name : 'app',
  components: { 
      Bar,
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
