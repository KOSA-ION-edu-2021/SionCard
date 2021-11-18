<template>
  <v-container>
    <!-- 온라인 신청 버튼 -->
    <v-row justify="center">
    <v-card tile flat class="grey lighten-2">
      <router-link to="/cardapply">
      <v-btn rounded color="primary"> 온라인 신청 </v-btn>
      </router-link>
    </v-card>
    </v-row>

    <!-- 연회비 and 유의사항 목록 -->
    <v-row justify="center">
      <v-col cols="6">

        <!-- 연회비 -->
        <v-expansion-panels tile flat accordion>
          <v-expansion-panel class="grey lighten-2">
            <v-expansion-panel-header class="font-weight-black">연회비</v-expansion-panel-header>
            <v-expansion-panel-content>
              <v-data-table
                :headers="headers"
                :items="cardInfo[num].brands"
                hide-default-footer
                class="grey lighten-2"
              >
              </v-data-table>
            </v-expansion-panel-content>
          </v-expansion-panel>

          <!-- 결제 은행 -->
          <v-expansion-panel class="grey lighten-2" v-if="cardInfo[num].bank">
            <v-expansion-panel-header class="font-weight-black">결제은행</v-expansion-panel-header>
            <v-expansion-panel-content>
              <!-- <ul> -->
              <!-- <ul class="text-body-2" v-for="(bank, r) in cardInfo[a].bank" :key="r" style=" margin-top:10px">
                {{ bank }} -->
              <!-- <ul class="text-body-2"  
              v-for="(bank, r) in bank" :key="r"
              v-text="bank"> -->
              <span class="text-body-2"  
              v-for="(bank, r) in cardInfo[num].bank" :key="r"
              >
              <ul>
              <li style="float:left; margin-left:30px">{{ bank }}</li>
              </ul>
              </span>

              <!-- </ul> -->
            </v-expansion-panel-content>
          </v-expansion-panel>

          <!-- 유의 사항 -->
          <v-expansion-panel class="grey lighten-2">
            <v-expansion-panel-header class="font-weight-black">유의사항</v-expansion-panel-header>
            <v-expansion-panel-content>
              <ul>
              <li class="text-body-2" v-for="(notice, r) in cardInfo[num].notice" :key="r" style="margin-top:10px">
                {{ notice }}
              </li>
              </ul>
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-col>
    </v-row>


    <!-- 한눈에 보기 -->
     <v-row
    align="center"
    justify="space-around"
    >
      <v-btn text>
        혜택 한눈에 보기
      </v-btn>
    </v-row>
    <v-row justify="center">
    <v-col cols="6">
    <v-card tile flat class="grey lighten-2">
      <v-list flat class="grey lighten-2">
        <v-list-item-group
          v-model="model"
          color="indigo"
        >
          <v-list-item v-for="(one_icon, i) in cardInfo[num].one_icon" :key="i">
            <v-list-item-icon>
              <v-icon v-text="one_icon"></v-icon>
            </v-list-item-icon>

            <v-list-item-content style="margin-left:50px">
              <v-list-item-title v-text="cardInfo[num].benefit[i]"></v-list-item-title>
              <!-- v-for="(one_icon, i) in cardInfo[a].one_icon" :key="i"  -->
              <ul v-if="i===0" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list1, k) in cardInfo[num].one_list1" :key="k"
                      :v-if="cardInfo[num].one_list1[k]" 
                      v-text="one_list1"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul1, k) in cardInfo[num].one_ul1" :key="k"
                    :v-if="cardInfo[num].one_ul1[k]" 
                    v-text="cardInfo[num].one_ul1[k]" 
                    style="margin-top:5px"
                    ></ul>
              </ul>
              <ul v-if="i===1" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list2, k) in cardInfo[num].one_list2" :key="k"
                      :v-if="cardInfo[num].one_list2[k]" 
                      v-text="one_list2"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul2, k) in cardInfo[num].one_ul2" :key="k"
                    :v-if="cardInfo[num].one_ul2[k]" 
                    v-text="cardInfo[num].one_ul2[k]" 
                    style="margin-top:5px"
                    ></ul>
              </ul>
              <ul v-if="i===2" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list3, k) in cardInfo[num].one_list3" :key="k"
                      :v-if="cardInfo[num].one_list3[k]" 
                      v-text="one_list3"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul3, k) in cardInfo[num].one_ul3" :key="k"
                    :v-if="cardInfo[num].one_ul3[k]" 
                    v-text="cardInfo[num].one_ul3[k]" 
                    style="margin-top:5px"
                    ></ul>
              </ul>
              <ul v-if="i===3" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list4, k) in cardInfo[num].one_list4" :key="k"
                      :v-if="cardInfo[num].one_list4[k]" 
                      v-text="one_list4"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul4, k) in cardInfo[num].one_ul4" :key="k"
                    :v-if="cardInfo[num].one_ul4[k]" 
                    v-text="cardInfo[num].one_ul4[k]" 
                    style="margin-top:5px"
                    ></ul>
              </ul>
            </v-list-item-content>
          </v-list-item>    
         
        </v-list-item-group>
      </v-list>
    </v-card>
    </v-col>
    </v-row>

    <!-- 카드 안내 사항 -->
    <v-row justify="center">
    <v-card tile flat style="font-size:xx-small; margin-top:50px; margin-bottom:50px" class="grey lighten-2">
      <p class="mb-2">회사명 : 사이온 카드</p>
      <!-- <p class="mb-2">상품명 : {{cardInfo[a].title}} </p>
      <p class="mb-2">카드 출시 일자 : {{cardInfo[a].date}}</p> -->
      <p class="mb-2">상품명 : {{cardInfo[num].title}} </p>
      <p class="mb-2">카드 출시 일자 : {{cardInfo[num].date}}</p>
      <p class="mb-1">
      <p class="mb-1">계약 체결 전, 카드 상품별 연회비, 이용조건 등 상세사항은 금융상품설명서와 약관을 확인하시기 바랍니다.</p>
      <p class="mb-1">금융소비자는 금융소비자보호법 제19조 제1항에 따라 해당 금융상품 또는 서비스에 대하여 설명 받을 권리가 있습니다.</p>
      <p class="mb-1">연체이자율은 '회원별, 이용상품별 약정금리+최대 연 3%, 법정 최고금리(연 20%)이내'에서 적용됩니다.</p>
      <p class="mb-1">단, 연체 발생 시점에 약정금리가 없는 경우 아래와 같이 적용함</p>
      <p class="mb-1">일시불 거래 연체 시: 거래 발생 시점의 최소기간(2개월) 유이자 할부 금리</p>
      <p class="mb-1">무이자 할부 거래 연체 시: 거래 발생 시점의 동일한 할부 계약기간의 유이자 할부 금리</p>
      <p class="mb-1">그 외의 경우: 약정금리는 상법상 상사법정이율과 상호금융 가계자금대출금리*중 높은 금리적용</p>
      <p class="mb-1">*한국은행에서 매월 발표하는 가장 최근의 비은행 금융기관 가중평균대출금리(신규대출 기준)</p>
      <p class="mb-1">신용카드 발급이 부적정한 경우(개인신용평점 낮음, 연체(단기 포함) 사유 발생 등), 카드발급이 제한될 수 있습니다.</p>
      <p class="mb-1">카드 이용대금과 이에 수반되는 모든 수수료는 고객님께서 지정하신 결제일에 상환하여야 합니다.</p>
      <p class="mb-1">상환능력에 비해 신용카드 사용액이 과도할 경우, 귀하의 개인신용평점이 하락할 수 있습니다.</p>
      <p class="mb-1">개인신용평점 하락 시 금융거래와 관련된 불이익이 발생할 수 있습니다.</p>
      <p class="mb-1">일정기간 신용카드 이용대금을 연체할 경우, 결제일이 도래하지 않은 모든 신용카드 이용대금을 변제할 의무가 발생할 수 있습니다.</p>
      
    </v-card>
    </v-row>
  </v-container>
</template>

<script>
import cardInfo from '@/assets/carddetail.js'
export default {
  data:() => ({
      
      cardInfo : cardInfo,
      
      model: 1,
      headers: [  // 연회비 분류 기준 data
        {
          text: "브랜드",
          align: "start",
          sortable: false,
          value: "card_brand",
        },
        { text: "옵션", sortable: false,value: "card_option" },
        { text: "기본", sortable: false,value: "card_basic" },
        { text: "서비스", value: "card_service" },
        { text: "총연회비", value: "card_tprice" },
      ],
    }),
    props: {
    num : String,
  },
};
</script>

<style>
</style>