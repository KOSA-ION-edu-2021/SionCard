<template>
  <v-app>
    <v-system-bar app></v-system-bar>
    <Bar :changeDraw="changeDraw"/>
    <SideBar app :drawer="drawer"></SideBar>
    <v-main app>
      <v-container> HelloWorld </v-container>
    </v-main>
    <v-footer app/>
  </v-app>
</template>

<script>
import Bar from './Bar.vue';
import SideBar from './SideBar.vue';

export default {
    components:{
        Bar,
        SideBar
    },
    data:()=>({
        drawer: false,

    }),
    methods:{
        changeDraw(){
            this.drawer=!this.drawer
        }
    },
};
</script>

<style>
</style>