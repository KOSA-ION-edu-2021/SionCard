<template>
  <swiper class="swiper" :options="swiperOption">
    <swiper-slide v-for="card in cardInfo" :key="card" class="mr-2">
      <v-card flat class="grey lighten-2">
        <v-img :src="card.img" contain min-width="20%" />
        <v-sheet
          class="text-subtitle-2 font-weight-bold mt-5 mt-5 grey lighten-2"
        >
          {{ card.title }}
        </v-sheet>
        <v-sheet class="text-caption mt-5 mt-5 grey lighten-2">
          {{ card.content }}
        </v-sheet>
      </v-card>
    </swiper-slide>

    <!-- <div class="swiper-pagination" slot="pagination"></div>  -->
    <div class="swiper-button-prev" slot="button-prev"></div>
    <div class="swiper-button-next" slot="button-next"></div>
  </swiper>
</template> 

<script>
import cardInfo from "@/assets/cardInfo.js";

import { Swiper, SwiperSlide } from "vue-awesome-swiper";
import "swiper/css/swiper.css";
export default {
  name: "swiper-example-loop",
  title: "Loop mode / Infinite loop",
  components: { Swiper, SwiperSlide },
  data() {
    return {
      cardInfo,
      swiperOption: {
        slidesPerView: 4,
        /* spaceBetween: 30,  */
        loop: true,
        /* pagination: {
          el: ".swiper-pagination",
          clickable: true,
          hiddenClass: "swiper-pagination-hidden",
          dynamicBullets: true,
        }, */
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        /* effect: "fade",
        fadeEffect: {
          crossFade: true,
        }, */
      },
    };
  },
};
</script>

<style>
.swiper {
  height: 300px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.swiper-wrapper {
  width: 700px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  font-weight: bold;
}
</style>