<template>
<v-container class="grey lighten-2" color="grey lighten-2">
<v-card tile flat style="margin-left: 30px" class="grey lighten-2">
      <v-row class="align-center justify-center" >
        <v-col cols="2" md="1" />
        <v-col cols="4" class="pa-0 d-md-block justify-center">
            <v-img  
            v-if="(num == 0) || (num == 1) || (num == 2)"
            :src="(`${cardInfo[num].img}`)"
            style="transform:rotate(90deg); width: 350px"
            ></v-img>

            <v-img
            v-if="(num == 3) || (num == 4) || (num == 5) || (num == 6)"
            :src="(`${cardInfo[num].img}`)"
            ></v-img>
        </v-col>
<v-col cols="1" />    
<v-col cols="6" md="6" class="pa-0; mb-5">
<v-card
        class="d-flex mt-16 grey lighten-2"
        tile flat
        height="300"
    >
        <div class="d-flex flex-column">
            
            <div class="text-h4 mx-5">
                <v-pre>{{cardInfo[num].title}}</v-pre>
            </div>
            
            <div class="text-h6 mx-8" style="margin-top:10px">
                <v-pre>{{cardInfo[num].content}}</v-pre>
            </div>  
           
            <div class="text-body-2">
                <v-list-item v-for="(header_icon, i) in cardInfo[num].header_icon" :key="i">
                <!-- <v-list-item> -->
                <v-list-item-icon>
                    <v-icon v-text="header_icon" />
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-content v-text="cardInfo[num].benefit[i]" />
                </v-list-item-content>
                </v-list-item>
            </div>
        </div>
    </v-card>
    </v-col>
      </v-row>
    </v-card>
</v-container>

</template>

<script>

import cardInfo from '@/assets/carddetail.js'
export default {
  data:() => ({
      cardInfo : cardInfo,
    }),
    props: {
    num : Number,
  },
//   mounted: {
//       num : this.num
//   }
}
</script>

<style>

</style>