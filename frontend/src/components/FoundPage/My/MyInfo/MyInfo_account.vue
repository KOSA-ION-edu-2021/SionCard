<template >
    <v-container>
        <v-row class="mb-0 text-h6 font-weight-regular">
            <v-col>
                <table style="height: 60px; ">
                    <tr>
                        <th style="width:144px">고객명</th>
                        <td style=""> 윤지훈</td>
                    </tr>
                </table>
            </v-col>
        </v-row>

        <v-row class="text-h6 font-weight-regular">
            <v-col cols="">
                <table>
                    <tr>
                        <th>ID</th>
                        <td>
                            heewoong96
                        </td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>
                            03470@naver.com
                        </td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td>
                            -
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화</th>
                        <td>
                            010-9699-9378
                        </td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            서울특별시 강서구 마곡중앙1로 71 마곡힐스테이트 13단지 1307동 604호
                        </td>
                    </tr>
                </table>

            </v-col> 
        </v-row>
    </v-container>
</template>

<script>
export default {
    name:"myinfo_account",
    data:()=>({
        open: false,
        
    }),
    methods: {
        changeopen : function(){
           this.open = true
           
        }
    },
}
</script>

<style>
    th{
        width: 144px;
        font-weight: 400;
        font-size: 20px;
    }
    td{
        padding-left: 40px;
    }
</style>