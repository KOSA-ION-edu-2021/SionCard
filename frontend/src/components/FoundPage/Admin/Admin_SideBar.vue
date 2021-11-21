<template>
    <v-navigation-drawer
      v-model="drawer"
      absolute
      left
      app
    >
      <v-list
        nav
        dense
      >
          <v-row justify="center">
              <!-- 사용자 이미지(아이콘) -->
              <v-col cols="auto" align-self="center">
                  <svg style="width:50px; height:50px; display:flex" viewBox="0 0 24 24">
                      <path fill="currentColor" d="M12,19.2C9.5,19.2 7.29,17.92 6,16C6.03,14 10,12.9 12,12.9C14,12.9 17.97,14 18,16C16.71,17.92 14.5,19.2 12,19.2M12,5A3,3 0 0,1 15,8A3,3 0 0,1 12,11A3,3 0 0,1 9,8A3,3 0 0,1 12,5M12,2A10,10 0 0,0 2,12A10,10 0 0,0 12,22A10,10 0 0,0 22,12C22,6.47 17.5,2 12,2Z" />
                  </svg>    
              </v-col>
          </v-row>
          <v-row justify="center">    
              <!-- 사용자 이름 -->
              <v-col cols="auto" align-self="center" > 
                 {{this.$store.state.auth.name}}
              </v-col>
          </v-row>

      <!-- <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon> -->

        <v-list-item-group
          active-class="grey lighten-3 text--accent-4"
          class="mt-5"
        >
          
          <router-link to="/admin">
          <v-list-item>
            <v-list-item-title class="ml-5 text-subtitle-1">
              <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                  <path fill="currentColor" d="M10,20V14H14V20H19V12H22L12,3L2,12H5V20H10Z" />
              </svg>
              </v-list-item-title>
          </v-list-item>  
          </router-link>
          

          <router-link to="/admin/user">
          <v-list-item>
            <v-list-item-title class="ml-5 text-subtitle-1"> 고객 관리</v-list-item-title>
          </v-list-item>
          </router-link>

          <router-link to="/admin/card">
            <v-list-item>
              <v-list-item-title class="ml-5 text-subtitle-1">카드 관리 </v-list-item-title>
            </v-list-item>
          </router-link>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
    props:{
        drawer:Boolean
    }
}
</script>

<style>
</style>

<style scoped>
a{
  text-decoration: none;
}
</style>