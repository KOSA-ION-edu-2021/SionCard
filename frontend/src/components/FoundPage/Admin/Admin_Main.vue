<template>
  <v-app>
    <!-- <v-system-bar app></v-system-bar> -->
    
    <SideBar :drawer="drawer" v-if="!!this.$store.getters.getAuth"></SideBar>
    <SystemBar :drawer="drawer" :changeDraw="changeDraw" v-if="!!this.$store.getters.getAuth"></SystemBar>
    
    <v-main class="align-center grey lighten-2">
        <router-view/>
    </v-main>

    
  </v-app>
</template>

<script>
import SideBar from './Admin_SideBar.vue';
import SystemBar from './Admin_SystemBar.vue';


export default {
    components:{
        SideBar,
        SystemBar,
    },
    data:()=>({
        drawer: true,
    }),
    methods:{
        changeDraw(){
            this.drawer=!this.drawer;
        },

    },
};
</script>

<style>
.v-navigation-drawer--absolute{
  position: fixed;
}
</style>