<template>
  <div>
  <v-card class="overflow-hidden">
    <v-app-bar dark height="100px" >
      <!-- SION Card logo image -->
      <a href="http://localhost:8080/">
        <img class="logo_image" src="../../../images/logo_transparent.png">
      </a>

      <div> Sion Card </div>

      <v-spacer></v-spacer>
      
      <!-- My menu -->
      <div class="text-center">
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn class="menu-item" color="primary" dark v-bind="attrs" v-on="on">
              My
            </v-btn>
          </template>
          <v-list>
            <v-list-item v-for="(item, index) in myitems" :key="index">
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </div>

      <v-spacer></v-spacer>

      <!-- Card menu -->
      <div class="text-center">
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn class="menu-item" color="primary" dark v-bind="attrs" v-on="on">
              Card
            </v-btn>
          </template>
          <v-list>
            <v-list-item v-for="(item, index) in carditems" :key="index">
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </div>

      <v-spacer></v-spacer>
      <!-- Log In -->
      <v-btn>
        Log In
      </v-btn>
      <!-- Sign In -->
      <v-btn>
        Sign In
      </v-btn>

    </v-app-bar>
  </v-card> 
  </div>
</template>

<script>



export default {
   name : "Bar",
   components: {

   },
   data: () => ({
      myitems: [
        { title: '내 정보' },
        { title: '내 카드 정보' },
        { title: '이용 금액' },
        { title: '~~~~~' },
      ],
      carditems: [
        { title: '카드 안내' },
        { title: '카드 추천' },
        { title: '카드 신청' },
        { title: '~~~~~' },
      ],
    }),
}
</script>

<style>
.logo_image{
  width: 60px;
  height: 48px;
  padding: 0px;
}
.menu-item{
  color: #FFF;
  padding: 10px 20px;
  position: relative;
  text-align: center;
  border-bottom: 3px solid transparent;
  transition: 0.4s;
}

.menu-item.active,
.menu-item:hover{
  background-color: #444;
  border-bottom-color: #FF5858;
}

</style>