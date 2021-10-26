<template>
  <v-app-bar app dark height="100px">
    <!-- SION Card logo image -->

    <v-img
      max-height="48px"
      max-width="60px"
      contain
      src="../../../images/logo_transparent.png"
    />
    <v-nav-bar-title>
      Sion Card
    </v-nav-bar-title>

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
    <v-menu offset-y>
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
        <v-list-item v-for="(item, index) in carditems" :key="index">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <!-- Log In -->
    <v-btn
      plain
    > 
    Log In
    </v-btn>
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
  }),
  props:{
    changeDraw:Function,
  }
};
</script>

<style>
</style>