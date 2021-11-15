<template>
    <v-row justify="center" class="ma-auto grey lighten-3">
        
        <v-col cols="auto">
          <v-row justify="center">
              <!-- 사용자 이미지(아이콘) -->
              <v-col cols="auto" align-self="center">
                  <svg style="width:100px;height:100px" viewBox="0 0 24 24">
                      <path fill="currentColor" d="M12,19.2C9.5,19.2 7.29,17.92 6,16C6.03,14 10,12.9 12,12.9C14,12.9 17.97,14 18,16C16.71,17.92 14.5,19.2 12,19.2M12,5A3,3 0 0,1 15,8A3,3 0 0,1 12,11A3,3 0 0,1 9,8A3,3 0 0,1 12,5M12,2A10,10 0 0,0 2,12A10,10 0 0,0 12,22A10,10 0 0,0 22,12C22,6.47 17.5,2 12,2Z" />
                  </svg>    
              </v-col>
              
              <!-- 사용자 이름 -->
              <v-col cols="auto" align-self="center" > 
                <v-sheet class="text-h5 font-weight-black text--grey grey lighten-3">
                  {{this.$store.state.auth.name}}님
                </v-sheet>
              </v-col>
          </v-row>
        </v-col>

        

        <v-col cols="1"></v-col>

        <!-- 링크 아이콘 -->
        <v-col cols="auto">
          
          <!-- 내 정보  -->
          <!-- <router-link class="text-decoration-none" to="/myinfo"> -->
          <v-list-item to="/myinfo">
            <v-row >
                    <!-- 아이콘 -->
                    <v-col cols="auto"><v-icon x-large role="img">{{ icons.mdiAccount }}</v-icon> </v-col>
                    <v-col cols="auto" align-self="center">내 정보 관리</v-col>    
            </v-row>
          </v-list-item> 
          <!-- </router-link> -->
          
          
          <!-- 내 카드 정보 -->
          <v-list-item to="/mycard">
          <!-- <router-link class="text-decoration-none" to="/myinfo"> -->
            <v-row>
                <!-- 내 정보 -->
                <!-- 아이콘 -->
                <v-col cols="auto">
                <svg style="width:40px;height:40px" viewBox="0 0 24 24">
                    <path fill="currentColor" d="M20,8H4V6H20M20,18H4V12H20M20,4H4C2.89,4 2,4.89 2,6V18A2,2 0 0,0 4,20H20A2,2 0 0,0 22,18V6C22,4.89 21.1,4 20,4M7,22H9V24H7V22M11,22H13V24H11V22M15,22H17V24H15V22Z" />
                </svg>
                </v-col>
                <v-col cols="auto" align-self="center">
                내 카드 관리
                </v-col>

            </v-row>
          <!-- </router-link> -->
          </v-list-item>

        </v-col>
    </v-row>
</template>

<script>
import {mdiAccount,} from '@mdi/js'
export default {
    name: "Myuserinfo",
    data:()=>({
        icons: {
        mdiAccount,
        },
    }),
    mounted() {
        this.$store.commit('updateAuth',this.loginCheck_myMain)
  },
}
</script>

<style scoped>

</style>