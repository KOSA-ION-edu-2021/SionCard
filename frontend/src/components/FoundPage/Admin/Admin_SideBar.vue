<template>
    <v-navigation-drawer
      v-model="drawer"
      absolute
      left
      temporary
    >
      <v-list
        nav
        dense
      >
          <v-row justify="center">
              <!-- 사용자 이미지(아이콘) -->
              <v-col cols="auto" align-self="center">
                  <svg style="width:50px;height:50px" viewBox="0 0 24 24">
                      <path fill="currentColor" d="M12,19.2C9.5,19.2 7.29,17.92 6,16C6.03,14 10,12.9 12,12.9C14,12.9 17.97,14 18,16C16.71,17.92 14.5,19.2 12,19.2M12,5A3,3 0 0,1 15,8A3,3 0 0,1 12,11A3,3 0 0,1 9,8A3,3 0 0,1 12,5M12,2A10,10 0 0,0 2,12A10,10 0 0,0 12,22A10,10 0 0,0 22,12C22,6.47 17.5,2 12,2Z" />
                  </svg>    
              </v-col>
              
              <!-- 사용자 이름 -->
              <v-col cols="auto" align-self="center" > 
                 <!-- {{this.$store.state.auth.name}}</button> 님 -->
              </v-col>
          </v-row>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-list-item-group
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item>
            <v-list-item-title> <v-btn to="/admin/user" text> 고객 관리</v-btn> </v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title> <v-btn to="/admin/card" text> 카드 관리</v-btn> </v-list-item-title>
          </v-list-item>
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