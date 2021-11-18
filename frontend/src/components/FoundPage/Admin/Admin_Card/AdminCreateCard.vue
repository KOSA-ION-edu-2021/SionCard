<template>
  <v-dialog v-model="dialog" persistent max-width="600px">
    <v-card>
      <v-card-title>
        <span class="text-h5">User Profile</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12" sm="12" md="12">
              <v-file-input
                v-model="card.img"
                :rules="rules"
                accept="image/png, image/jpeg, image/bmp, image/gif"
                placeholder="사진을 선택해 주세요"
                prepend-icon="mdi-camera"
                label="카드사진을 올려주세요"
              ></v-file-input>
            </v-col>
            <v-col cols="12" sm="12" md="12">
              <v-text-field
                v-model="card.title"
                label="카드명을 입력해 주세요"
                hint="카드명"
              ></v-text-field>
            </v-col>
            <v-col cols="12" sm="12" md="12">
              <v-textarea
                v-model="card.content"
                label="카드설명을 입력해 주세요"
                solo
                required
              ></v-textarea>
            </v-col>

            <v-col cols="12" sm="12" md="12">
              <v-list-item-title><b>카드 종류</b></v-list-item-title>
            
              <v-radio-group v-model="card.cardType" row gravity="center">
                <v-radio label="신용카드" value="credit"> </v-radio>
                <v-radio label="체크카드" value="check"> </v-radio>
              </v-radio-group>
           
              <v-list-item-title><b>카드 유형</b></v-list-item-title>

              <v-radio-group v-model="card.cardCheck" row class="ma-">
                <v-radio label="Point" value=true> </v-radio>
                <v-radio label="Mileage" value=false> </v-radio>
              </v-radio-group>

              <v-list-item-title><b>카드 혜택</b></v-list-item-title>

              <v-radio-group v-model="card.benefitContent" row>
                <v-radio label="즉시 할인" value="sale"> </v-radio>
                <v-radio label="Point / Mileage 적립" value="save"> </v-radio>
              </v-radio-group>

              <v-list-item-title><b>해외 결제 기능</b></v-list-item-title>

              <v-radio-group v-model="card.mastercard" row>
                <v-radio label="MASTER" value=true> </v-radio>
                <v-radio label="국내 전용" value=false> </v-radio>
              </v-radio-group>

              <v-list-item-title><b>후불 교통 기능</b></v-list-item-title>

              <v-radio-group v-model="card.traficcard" row>
                
                <v-radio label="신청" value=true> </v-radio>
                <v-radio label="신청안함" value=false> </v-radio>
              </v-radio-group>
            </v-col>
          </v-row>
        </v-container>
        <small>*indicates required field</small>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="setDialog(false)">
          Close
        </v-btn>
        <v-btn
          color="blue darken-1"
          text
          @click="
            submit();
            setDialog(false);
          "
        >
          Save
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import axios from "axios";
export default {
  props: {
    dialog: Boolean,
    setDialog: Function,
  },
  data: () => ({
    card: {
      img: null,
      title: "",
      content: "",
      cardType: "",
      cardCheck: "",
      benefitContent: "",
      mastercard: "",
      traficcard: "",
    },
    rules: [
      (value) => !value || value.size < 30000000 || "30MB 이하로 올려주세요",
    ],
  }),
  methods: {
    submit() {
      const formData = new FormData();
      for (const key in this.card) {
        formData.append(key, this.card[key]);
      }
      formData.append('cardCredit', !this.card.cardCheck);


      axios
        .post(this.$store.state.apihost + "/admin/create_card", formData, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("JSESSIONID")}`,
          },
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>