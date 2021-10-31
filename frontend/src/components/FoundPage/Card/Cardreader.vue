<template>
<v-container>
<v-card tile flat style="margin-left: 30px">
      <v-row class="align-center justify-center" >
        <v-col cols="2" md="2" />
        <v-col cols="4" class="pa-0 d-none d-md-block justify-center">
            <img :src="require(`@/assets/cardimg/${card0.img}.png`)" style="width:290px; height:180px">
        </v-col>

<v-col cols="10" md="6" class="pa-0">
<v-card
        class="d-flex mt-16"
        tile flat
        height="300"
    >
        <div class="d-flex flex-column">
            
            <div class="text-h4">
                <pre>{{card0.name}}</pre>
            </div>
            
            <div class="text-body-3" style="margin-top:10px">
                <pre>{{card0.title}}</pre>
            </div>  
           
            <div class="text-body-2">
                <v-list-item>
                <v-list-item-icon>
                    <v-icon v-text="card0.icon1" />
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-content v-text="card0.benefit1" />
                </v-list-item-content>
                </v-list-item>
            </div>

            <div class="text-body-2">
                <!-- <pre>{{card0.benefit2}}</pre> -->
                 <v-list-item>
                <v-list-item-icon>
                    <v-icon v-text="card0.icon2" />
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-content v-text="card0.benefit2" />
                </v-list-item-content>
                </v-list-item>
            </div>

            <div class="text-body-2">
                <!-- <pre>{{card0.benefit3}}</pre> -->
                 <v-list-item>
                <v-list-item-icon>
                    <v-icon v-text="card0.icon3" />
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-content v-text="card0.benefit3" />
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
export default {
    data:()=>({
        card0:{
            name : "요기요 카드",
            title : "맛있는 생활의 필수 혜택 카드",
            benefit1 : "요기요 할인 최대 2만원 할인",
            benefit2 : "요기요 캐시백 추가 5천원 캐시백",
            benefit3 : "홈Life 서비스 최대 2만5천원 할인",
            img : "yogiyo",
            icon1:  'mdi-food-turkey',
            icon2:  'mdi-cash-register',
            icon3:  'mdi-cast-variant'
        },
    }),
}
</script>

<style>

</style>