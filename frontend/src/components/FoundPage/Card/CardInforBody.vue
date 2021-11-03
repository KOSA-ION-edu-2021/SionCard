<template>
  <v-container>
    <!-- 온라인 신청 버튼 -->
    <v-row justify="center">
    <v-card tile flat>
      <v-btn rounded color="primary"> 온라인 신청 </v-btn>
    </v-card>
    </v-row>

    <!-- 연회비 and 유의사항 목록 -->
    <v-row justify="center">
      <v-col cols="6">
        <v-expansion-panels tile flat accordion>
          <v-expansion-panel>
            <v-expansion-panel-header @click="cardFilter" class="font-weight-black">연회비</v-expansion-panel-header>
            <v-expansion-panel-content>
              <v-data-table
                :headers="headers"
                :items="brands"
                hide-default-footer
              >
              </v-data-table>
            </v-expansion-panel-content>
          </v-expansion-panel>
          <v-expansion-panel v-if="cardInfo[a].bank">
            <v-expansion-panel-header class="font-weight-black">결제은행</v-expansion-panel-header>
            <v-expansion-panel-content>
              <ul>
              <!-- <ul class="text-body-2" v-for="(bank, r) in cardInfo[a].bank" :key="r" style=" margin-top:10px">
                {{ bank }} -->
              <ul class="text-body-2" v-text="cardInfo[a].bank">
              </ul>
              </ul>
            </v-expansion-panel-content>
          </v-expansion-panel>
          <v-expansion-panel>
            <v-expansion-panel-header class="font-weight-black">유의사항</v-expansion-panel-header>
            <v-expansion-panel-content>
              <ul>
              <li class="text-body-2" v-for="(notice, r) in cardInfo[a].notice" :key="r" style=" margin-top:10px">
                {{ notice }}
              </li>
              </ul>
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels>
      </v-col>
    </v-row>


    <!-- 한눈에 보기 -->
    <v-row justify="center">혜택 한눈에 보기</v-row>
    <v-row justify="center">
    <v-col cols="6">
    <v-card tile flat>
      <v-list flat>
        <v-list-item-group
          v-model="model"
          color="indigo"
        >
          <v-list-item v-for="(one_icon, i) in cardInfo[a].one_icon" :key="i">
            <v-list-item-icon>
              <v-icon v-text="one_icon"></v-icon>
            </v-list-item-icon>

            <v-list-item-content style="margin-left:50px">
              <v-list-item-title v-text="cardInfo[a].benefit[i]"></v-list-item-title>
              <!-- v-for="(one_icon, i) in cardInfo[a].one_icon" :key="i"  -->
              <ul v-if="i===0" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list1, k) in cardInfo[a].one_list1" :key="k"
                      :v-if="cardInfo[a].one_list1[k]" 
                      v-text="one_list1"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul1, k) in cardInfo[a].one_ul1" :key="k"
                    :v-if="cardInfo[a].one_ul1[k]" 
                    v-text="cardInfo[a].one_ul1[k]" 
                    style="margin-top:5px"
                    ></ul>
              </ul>
              <ul v-if="i===1" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list2, k) in cardInfo[a].one_list2" :key="k"
                      :v-if="cardInfo[a].one_list2[k]" 
                      v-text="one_list2"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul2, k) in cardInfo[a].one_ul2" :key="k"
                    :v-if="cardInfo[a].one_ul2[k]" 
                    v-text="cardInfo[a].one_ul2[k]" 
                    style="margin-top:5px"
                    ></ul>
              </ul>
              <ul v-if="i===2" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list3, k) in cardInfo[a].one_list3" :key="k"
                      :v-if="cardInfo[a].one_list3[k]" 
                      v-text="one_list3"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul3, k) in cardInfo[a].one_ul3" :key="k"
                    :v-if="cardInfo[a].one_ul3[k]" 
                    v-text="cardInfo[a].one_ul3[k]" 
                    style="margin-top:5px"
                    ></ul>
              </ul>
              <ul v-if="i===3" style="font-size:x-small; margin-top:10px">
                  <li v-for="(one_list4, k) in cardInfo[a].one_list4" :key="k"
                      :v-if="cardInfo[a].one_list4[k]" 
                      v-text="one_list4"
                      style="margin-top:5px"
                    ></li>
                  <ul v-for="(one_ul4, k) in cardInfo[a].one_ul4" :key="k"
                    :v-if="cardInfo[a].one_ul4[k]" 
                    v-text="cardInfo[a].one_ul4[k]" 
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
    <v-card tile flat style="font-size:xx-small; margin-top:50px; margin-bottom:50px">
      <p class="mb-2">회사명 : 시온 카드</p>
      <p class="mb-2">상품명 : {{cardInfo[a].title}} </p>
      <p class="mb-2">카드 출시 일자 : {{cardInfo[a].date}}</p>
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
      a:6,
      model: 1,
      headers: [  // 연회비 분류 기준 data
        {
          text: "브랜드",
          align: "start",
          sortable: false,
          value: "card_Brand",
        },
        { text: "옵션", sortable: false,value: "card_option" },
        { text: "기본", sortable: false,value: "card_basic" },
        { text: "서비스", value: "card_service" },
        { text: "총연회비", value: "card_tprice" },
      ],
      brands: [ // 연회비 정보 data
        {
          card_Brand: cardInfo[6].card_Brand[0],
          card_option: cardInfo[6].card_option[0],
          card_basic: cardInfo[6].card_basic[0],
          card_service: cardInfo[6].card_service[0],
          card_tprice: cardInfo[6].card_tprice[0],
        },
        {
          card_Brand: cardInfo[6].card_Brand[1],
          card_option: cardInfo[6].card_option[1],
          card_basic: cardInfo[6].card_basic[1],
          card_service: cardInfo[6].card_service[1],
          card_tprice: cardInfo[6].card_tprice[1],
        },
      ],
      // notice: [ "가족카드 발급 불가" , "후불교통 가능"],
      cardname: { name: "요기요" },
      // items: [  // 한눈에 보기 data
      //   {
      //     icon: 'mdi-silverware-variant ',
      //     text1: '요기요 할인',
      //     text2: '요기요 20% 할인',
      //     text2_1: '- 1회 이용시 건당 최대 2천원 할인[월 2만원까지 할인]',
          
      //   },
      //   {
      //     icon: 'mdi-cash-refund',
      //     text1: '요기요 캐시백',
      //     text2: '요기요 추가 10% 캐시백',
      //     text2_1: '- OTT 서비스 동시 이용 시 추가 캐시백 제공'
      //   },
      //   {
      //     icon: 'mdi-home-assistant',
      //     text1: '홈Life 서비스 할인',
      //     text2: 'OTT 15% 할인',  
      //     text2_1: '- 넷플릭스, 유튜브프리미엄, 왓챠프리엄',
      //     text3: '온라인 쇼핑몰 건당 2천원 할인',
      //     text3_1: '- 쿠팡,G마켓,11번가,롯데ON,SSG.COM,마켓컬리,오아시스마켓',
      //     text4: '홈카페 10% 할인',
      //     text4_1: '- 스타벅스 사이렌오더, 와인앤모어'
      //   },
      //   {
      //     icon: 'mdi-account-alert',
      //     text1: '공통 유의사항',
      //     text2: '공통 유의사항 안내',
          
      //   },
      // ],
    }),
     methods:{
         cardFilter: function(a){
            return this.cardInfo.filter(function(card) {
             return !!a.exec(card.id)})
      },
    },
};
</script>

<style>
</style>