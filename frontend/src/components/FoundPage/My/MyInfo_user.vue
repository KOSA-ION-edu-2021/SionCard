<template>
    <v-container>
        <v-row class="mt-5">
          <v-col class="text-h4 font-weight-bold">
            본인 인증
          </v-col>
        </v-row>
        <v-row class="mb-0 text-h6 font-weight-regular">
            <v-col>
                <table style="height: 60px; ">
                    <tr>
                        <th style="width:144px">인증 방법</th>
                        <td style=""> 
                          <v-radio-group
                                v-model="row"
                                row
                                mandatory
                              >
                                <v-radio
                                  label="이메일"
                                  v-model="radioValues"
                                  value="email"
                                  color="black"
                                  aira-checked
                                ></v-radio>
                                <v-radio
                                  label="SI-ON Card"
                                  v-model="radioValues"
                                  value="card"
                                  color="black"
                                ></v-radio>
                            </v-radio-group>
                            {{radioValues}}
                        </td>
                    </tr>
                </table>
            </v-col>
        </v-row>
        
        <v-row class="mt-10">
          <v-col class="text-h4 font-weight-bold">
            인증 정보 입력
          </v-col>
        </v-row>

        <v-row class="text-h6 font-weight-regular">
            <v-col cols="">
                <table>
                    <tr>
                        <th>ID</th>
                        <td>
                          <v-text-field
                            style="width: 30%"
                            label="ID"
                            required
                            dense
                            hide-details="auto"
                            outlined
                          ></v-text-field>
                        </td>
                    </tr>
                    <tr>
                        <th>카드 번호</th>
                        <td>
                            03470@naver.com
                        </td>
                    </tr>
                    <tr>
                        <th>카드 비밀번호</th>
                        <td>
                            010-9699-9378
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                          <v-row justify="center">
                            <v-col>
                              <v-btn>다음</v-btn>
                            </v-col>
                          </v-row>
                        </td>
                    </tr>
                </table>

            </v-col> 
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: "myinfo_card",
    data: () => ({
      radioValues: '',
    }),
}
</script>

<style>
  th{
        width: 144px;
        height: 60px;
        font-weight: 400;
        font-size: 20px;
    }
    td{
        padding-left: 40px;
    }
    tr{
      height: 60px;
    }
</style>