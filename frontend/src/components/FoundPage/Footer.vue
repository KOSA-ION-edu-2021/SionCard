<template>
  <v-footer color="grey darken-4" padless>
    <v-row justify="center" no-gutters>
      <v-col cols="1"></v-col>
        <v-col cols="2" class="darken-3 py-4 text-center white--text">
          <a href="https://www.i-on.net/index.html" style=text-decoration:none; class="white--text">
          고객센터 5120-0305
          </a>
        </v-col>

        
        <v-col cols="2" class="darken-3 py-4 text-center white--text">
          <router-link to="/cardapply" style=text-decoration:none; class="white--text">
          카드신청 5120-0305
          </router-link>
        </v-col>
        

        <v-col cols="2" class="darken-3 py-4 text-center white--text">
          <a href="https://si-on.slack.com" style=text-decoration:none; class="white--text">
          카드분실신고 5120-0305
          </a>
        </v-col>


      
      <v-col justify="center" class="darken-3 py-4 text-center white--text" cols = "4">
        <a href="https://heewoong96.atlassian.net/jira/software/projects/VM4/boards/1/roadmap" style=text-decoration:none; 
        class="white--text">
        SION TEAM - 이윤건 유현수 윤지훈 장원혁
        </a>
      </v-col> 
      <v-col cols="4"></v-col>
      
      <v-col color="" class="grey darken-3 py-4 text-center white--text" cols="12">
        {{ new Date().getFullYear() }} — <strong>SION-TEAM</strong>
      </v-col>
    </v-row>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    links: ["Home", "About Us", "Team", "Services", "Blog", "Contact Us"],
  }),
};
</script>

<style>
</style>