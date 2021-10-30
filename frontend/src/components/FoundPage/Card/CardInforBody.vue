<template>
<div>
  <div class="text-center">
            <v-btn
            rounded
            color="primary"
            dark
            >
                온라인 신청
            </v-btn>
        </div>
        
        <v-row justify="center" style="margin-top:50px">
            <v-col cols="1" />
            <v-col cols="10">
            
            <v-expansion-panels tile flat accordion>
            <v-expansion-panel>
                <v-expansion-panel-header>연회비</v-expansion-panel-header>
                <v-expansion-panel-content>
                    <v-data-table
                    :headers="headers"
                    :items="brands"
                    hide-default-footer
                    ></v-data-table>
                </v-expansion-panel-content>
            </v-expansion-panel>
            <v-expansion-panel>
                <v-expansion-panel-header>유의사항</v-expansion-panel-header>
                <v-expansion-panel-content>
                
                <li>가족카드 발급 불가</li>
                <li>후불교통 가능</li>
                   
                </v-expansion-panel-content>
            </v-expansion-panel>
            </v-expansion-panels>
            </v-col>
            <v-col cols="1" />
        </v-row>

        
        </div>
</template>

<script>
export default {
    data () {
      return {
        headers: [
          {
            text: '브랜드',
            align: 'start',
            sortable: false,
            value: 'name',
          },
          { text: '옵션', value: 'option' },
          { text: '기본', value: 'basic' },
          { text: '서비스', value: 'service' },
          { text: '총연회비', value: 'tprice' },
        ],
        brands: [
          {
            name: '국내',
            option: '일반',
            basic: '7천원',
            service: '1만7천원',
            tprice: '2만4천원',
          },
          {
            name: 'BC',
            option: '일반',
            basic: '7천원',
            service: '2만원',
            tprice: '2만7천원',
          },
        ],
      }
    },
  }
</script>

<style>

</style>