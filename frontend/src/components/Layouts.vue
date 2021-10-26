<template>
  <v-app>
    <!-- <v-system-bar app></v-system-bar> -->
    <Bar :changeDraw="changeDraw"/>
    <SideBar :drawer="drawer"></SideBar>
    
    <v-main>
        <router-view/>
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
            if(this.drawer) this.drawer=!this.drawer
            this.drawer=!this.drawer
        }
    },
};
</script>

<style>
</style>