<template>
  <v-app-bar app dark height="100px">
    <!-- SION Card logo image -->
    <router-link to="/">
      <v-img
        max-height="48px"
        max-width="60px"
        contain
        src="@/assets/logo_transparent.png"
      />
    </router-link>
    <router-link to="/" tag="button">
    <v-app-bar-title>
      SionCard
    </v-app-bar-title>
    </router-link>
    
    <v-spacer></v-spacer>

    <!-- My menu -->
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          plain
          v-bind="attrs"
          v-on="on"
        >
          My
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in myitems" :key="index">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <!-- Card menu -->
    <v-menu  offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          plain
          v-bind="attrs"
          v-on="on"
        >
          Card 
        </v-btn>
      </template>
      <v-list>
        <v-list-item >
          <v-list-item-title>
            <router-link  to="/cardinfor" class="text-decoration-none">
              카드 안내
            </router-link>
            </v-list-item-title>
        </v-list-item>
        <v-list-item>
          <router-link  to="/cardrecommend" class="text-decoration-none">
          <v-list-item-title>
            
              카드 추천
            
            </v-list-item-title>
            </router-link>
        </v-list-item>
      </v-list>
    </v-menu>

    <router-link
      to="/card_main"
      tag="div"
    >
      <v-btn
        plain
      > 
      card_main
      </v-btn>
    </router-link>
    <!-- Log In -->
    <router-link
      to="/login"
      tag="div"
    >
      <v-btn
        plain
      > 
      Log In
      </v-btn>
    </router-link>
    <!-- Sign In -->
    <!-- <v-btn> Sign In </v-btn> -->

    <v-app-bar-nav-icon @click.stop="changeDraw"></v-app-bar-nav-icon>
  </v-app-bar>
</template>

<script>
export default {
  name: "Bar",
  components: {},
  data: () => ({
    myitems: [
      { title: "내 정보" },
      { title: "내 카드 정보" },
      { title: "이용 금액" },
      { title: "~~~~~" },
    ],
    carditems: [
      { title: "카드 안내" },
      { title: "카드 추천" },
      { title: "카드 신청" },
      { title: "~~~~~" },
    ],
    cardlink: [
      {link: "/cardrecommend"},
    ],
    auth:null
  }),
  props:{
    changeDraw:Function,
  },
  methods:{
  },
  mounted(){
    
    this.$cookies.set("test","test");
    this.$session.set("testsession","testsession");
  }
};
</script>

<style>

</style>