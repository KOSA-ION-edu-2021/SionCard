<template>
  <v-app>
    <!-- <v-system-bar app></v-system-bar> -->
    <Bar :changeDraw="changeDraw"/>
    <SideBar :drawer="drawer"></SideBar>
    
    <v-main class="align-center">
        <router-view/>
    </v-main>

    <Footer/>
  </v-app>
</template>

<script>
import Bar from './Bar.vue';
import SideBar from './SideBar.vue';
import Footer from './Footer.vue';

export default {
    components:{
        Bar,
        SideBar,
        Footer
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