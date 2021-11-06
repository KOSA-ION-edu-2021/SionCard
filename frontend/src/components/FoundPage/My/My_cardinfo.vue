<template class="">
  <v-container class="mt-10 mb-10">
      <!-- 상단 : 대표계좌 이용내역 -->
      <v-card elevation="10" class="pt-10 pb-10">
      <v-row justify="space-around" class="">
          <!-- 좌측 -->
          <v-col cols="4" class="">
              <!-- 좌측 상단 -->
              <v-row justify="space-between" class="text-h6">
                    <v-col cols="auto" class="font-weight-bold">
                    대표 계좌
                    </v-col>
                    <v-col cols="auto" >
                        신한은행 : 11038****190
                    </v-col>
              </v-row>              
              <v-row><v-divider></v-divider></v-row>
              <!-- 좌측 중간 -->
              <v-row justify="space-between" class="text-h5">
                    <v-col cols="auto" class="text-subtitle-1 font-weight-bold" >
                    출금 가능 금액
                    </v-col>
                    <v-col cols="auto" >
                        <b>0</b> 원
                    </v-col>
              </v-row>

              <!-- 우측 하단 버튼 -->
              <v-row justify="center" class="align-end">
                  <v-col cols="auto" >
                      <v-btn elevation="2">상세 내역</v-btn>
                  </v-col>
              </v-row>

          </v-col>

          <!-- 우측 -->
           <v-col cols="4" class="">
              <!-- 우측 상단 -->
              <v-row justify="" class="text-h5">
                    <v-col cols="12" class="font-weight-bold mb-n5">
                    받은 혜택
                    </v-col>
                    <v-col cols="" class="text-subtitle-2">
                        21.10.04 ~ 21.11.04 기준
                    </v-col>
              </v-row>              
              <v-row><v-divider></v-divider></v-row>
              <!-- 우측 중간 -->
              <v-row justify="space-between" class="text-h5">
                    <v-col cols="auto" class="text-subtitle-1 font-weight-bold" >
                    할인
                    </v-col>
                    <v-col cols="auto" >
                        <b>0</b> 
                    </v-col>
              </v-row>
              <v-row justify="space-between" class="text-h5">
                    <v-col cols="auto" class="text-subtitle-1 font-weight-bold" >
                    적립
                    </v-col>
                    <v-col cols="auto" >
                        <b>0</b> 
                    </v-col>
              </v-row>
              <v-row justify="space-between" class="text-h5">
                    <v-col cols="auto" class="text-subtitle-1 font-weight-bold" >
                    포인트
                    </v-col>
                    <v-col cols="auto" >
                        <b>0</b> 
                    </v-col>
              </v-row>
              <v-row justify="space-between" class="text-h5">
                    <v-col cols="auto" class="text-subtitle-1 font-weight-bold" >
                    마일리지
                    </v-col>
                    <v-col cols="auto" >
                        <b>0</b> 
                    </v-col>
              </v-row>

              <!-- 우측 하단 버튼 -->
              <v-row justify="center">
                  <v-col cols="auto">
                      <v-btn elevation="2">상세 내역</v-btn>
                  </v-col>
              </v-row>

          </v-col>
      </v-row>
  </v-card>

  <!-- 상단 끝 -->

  <!-- 하단 : 최근 거래 내역 -->
  <v-row 
    class="grey lighten-3 mt-10">
      <!-- 제목 -->
     <v-col class="pa-10">
            <v-row class="text-h5 font-weight-bold">
                <v-col cols="">
                    최근 이용 내역
                </v-col>
            </v-row>

            <v-row><v-divider></v-divider></v-row>

            <!-- 거래 내역 -->
            <v-row v-for="num in 3" :key="num">
                <v-col cols="3">
                    2021.10.6
                </v-col>
                <v-col cols="6">
                    카카오페이FBS출금
                </v-col>
                <v-col cols="3">
                    50,000원
                </v-col>
            </v-row>
     </v-col>
  </v-row>
  <!-- 하단 끝 -->

  </v-container>
</template>

<script>
export default {
    name: "Mycardinfo",
}
</script>

<style>

</style>