<template>
  <v-container class="pa-3 mt-10">
    <!-- 상단 글귀 -->
    <div class="card-rec-top">
      <v-container>
        <v-row justify="start">
          <v-col cols="auto" class=""> <h2>카드 추천</h2> </v-col>
        </v-row>
        
        <!-- 다시 선택 버튼 -->
        <v-row justify="end">
            
            <!-- 모달 -->
            <v-col cols="auto" class="yellow " dense>
                <Card_Modal/>
            </v-col>

          
        </v-row>

      </v-container>
    </div>
    <!-- <Cardmodal /> -->

    <!-- 카드 이미지 출력 -->
    <v-container class="mt-10">
      <v-row justify="space-around">
        <v-col class="mt-10" v-for="count in 11" :key="count" cols="4">
          <v-card class="pa-3 mt-5 text-center" dense outlined>
            <v-img
              aspect-ratio="2"
              contain
              src="https://www.shinhancard.com/pconts/images/contents/card/plate/cdCreditBOACOHs.png"
            />
            <v-row class="mt-3">
              <v-col cols="12">
                <strong>{{ title }}</strong>
              </v-col>
              <v-col colls="12">
                생활비 혜택을 가득 담은 서민금융지원카드
              </v-col>
            </v-row>
            <v-btn class="mt-3" color="" elevation=""> 상세 페이지</v-btn>
          </v-card>
        </v-col>
        <!--         <v-col cols="12">
          <v-card class="pa-3"> Cols 12 123 {{title}} </v-card>
        </v-col> -->
      </v-row>
    </v-container>
  </v-container>
</template>

<script>
import Card_Modal from './Card_Modal.vue';

export default {
  components: { Card_Modal },
  data: () => ({
    card: [{ title: "신한카드" }],
    title: "시온카드",
    dialog: false,
    notifications: false,
    sound: true,
    widgets: false,
    items: [
      {
        title: "Click Me",
      },
      {
        title: "Click Me",
      },
      {
        title: "Click Me",
      },
      {
        title: "Click Me 2",
      },
    ],
    select: [
      { text: "State 1" },
      { text: "State 2" },
      { text: "State 3" },
      { text: "State 4" },
      { text: "State 5" },
      { text: "State 6" },
      { text: "State 7" },
    ],
  }),
};
</script>

<style>
.card-rec-top {
  border-bottom: rgb(214, 209, 209) 2px solid;
  padding-bottom: 10px;
}
v-card {
  text-align: center;
}
</style>