<template>
<v-container>
<v-card tile flat style="margin-left: 30px">
      <v-row class="align-center justify-center" >
        <v-col cols="2" md="1" />
        <v-col cols="4" class="pa-0 d-md-block justify-center">
            <v-img
            :src="(`${cardInfo[a].img}`)"
            ></v-img>
        </v-col>
<v-col cols="1" />    
<v-col cols="6" md="6" class="pa-0; mb-5">
<v-card
        class="d-flex mt-16"
        tile flat
        height="300"
    >
        <div class="d-flex flex-column">
            
            <div class="text-h4 mx-5">
                <!-- <pre>{{card0.name}} 카드</pre> -->
                <pre>{{cardInfo[a].title}}</pre>
            </div>
            
            <div class="text-h6 mx-8" style="margin-top:10px">
                <pre>{{cardInfo[a].content}}</pre>
            </div>  
           
            <div class="text-body-2">
                <v-list-item v-for="(header_icon, i) in cardInfo[a].header_icon" :key="i">
                <!-- <v-list-item> -->
                <v-list-item-icon>
                    <v-icon v-text="header_icon" />
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-content v-text="cardInfo[a].benefit[i]" />
                </v-list-item-content>
                </v-list-item>
            </div>

            <!-- <div class="text-body-2" v-if="cardInfo[a].header_icon2">
                 <v-list-item>
                <v-list-item-icon>
                    <v-icon v-text="cardInfo[a].header_icon2" />
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-content v-text="cardInfo[a].benefit2" />
                </v-list-item-content>
                </v-list-item>
            </div>

            <div class="text-body-2" v-if="cardInfo[a].header_icon3">
                 <v-list-item>
                <v-list-item-icon>
                    <v-icon v-text="cardInfo[a].header_icon3" />
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-content v-text="cardInfo[a].benefit3" />
                </v-list-item-content>
                </v-list-item>
            </div> -->

        </div>
    </v-card>
    </v-col>
      </v-row>
    </v-card>
</v-container>

</template>

<script>
import cardInfo from '@/assets/card.js'

export default {
    
    data:()=>({
        cardInfo : cardInfo,
        a:0,
        // card0:{
        //     name : "요기요",
        //     title : "맛있는 생활의 필수 혜택 카드",
        //     benefit1 : "요기요 할인 최대 2만원 할인",
        //     benefit2 : "요기요 캐시백 추가 5천원 캐시백",
        //     benefit3 : "홈Life 서비스 최대 2만5천원 할인",
        //     img : "yogiyo",
        //     icon1:  'mdi-food-turkey',
        //     icon2:  'mdi-cash-register',
        //     icon3:  'mdi-cast-variant'
        // },
    }),
    // methods:{
    //      cardFilter: function(a){
    //         return this.cardInfo.filter(function(card) {
    //          return !!a.exec(card.id)})
    //   },
    // },
}
</script>

<style>

</style>