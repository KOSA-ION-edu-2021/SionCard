<template>
  <v-row justify="end">
    <v-dialog
      v-model="dialog"
      transition="dialog-bottom-transition"
      max-width="600px"
      ><!-- fullscreen 추가하면 모달창 화면 전체 -->
      <template v-slot:activator="{ on, attrs }">
        <!-- <v-btn color="primary" dark v-bind="attrs" v-on="on">
                Open Dialog
              </v-btn> -->
        <v-col class="yello" cols="auto" v-bind="attrs" v-on="on">
          <!-- 다시 선택 아이콘 -->
          <v-icon color="blue "> mdi-dialpad </v-icon>
          <b> 카드 선택 </b>
        </v-col>
      </template>

      <!-- 모달 페이지 -->
      <v-card>
        <!-- 최상단 bar -->
        <v-toolbar dark color="primary">
          <v-btn icon dark @click="dialog = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
          <v-toolbar-title>카드 선택</v-toolbar-title>
          <v-spacer></v-spacer>
          <v-toolbar-items>
            <v-btn dark text @click="dialog = false"> 맞춤 카드 보기 </v-btn>
          </v-toolbar-items>
        </v-toolbar>

        <!-- 카드 선택  -->
        <v-list three-line subheader>
          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title><b>카드 종류</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="5" dense >
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        <v-checkbox v-model="credit" @click="emitCheck1"></v-checkbox>
                        </v-list-item-action>
                    신용카드
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-col cols="5" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        <v-checkbox v-model="check" @click="emitCheck1"></v-checkbox>
                        </v-list-item-action>
                    체크카드
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title ><b>카드 유형</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="5" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        <v-checkbox v-model="point" @click="emitCheck2"></v-checkbox>
                        </v-list-item-action>
                    point
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-col cols="5" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        <v-checkbox v-model="mileage" @click="emitCheck2"></v-checkbox>
                        </v-list-item-action>
                    mileage
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
          <v-divider></v-divider>

          <v-list-item>
            <v-list-item-content class="ma-1">
              <v-list-item-title ><b>카드 혜택</b></v-list-item-title>
            </v-list-item-content>
            <v-row justify="start">
              <v-col cols="5" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        <v-checkbox v-model="discount" @click="emitCheck3"></v-checkbox>
                        </v-list-item-action>
                    즉시 할인
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
              <v-col cols="6" dense>
                <v-list-item-content>
                  <v-list-item-title  >
                        <v-list-item-action class="ma-0">
                        <v-checkbox v-model="stack" @click="emitCheck3"></v-checkbox>
                        </v-list-item-action>
                    point / mileage 적립
                  </v-list-item-title>
                </v-list-item-content>
              </v-col>
            </v-row>
          </v-list-item>
        </v-list>
        
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {
  name: "Card_modal",
  data: () => ({
    dialog: true,
    check: false,
    credit: false,
    point: false,
    mileage: false,
    discount: false,
    stack: false
  }),
  props:{
    /* check1 : String,
    check2 : String, */
    /* check3 : String */
  },
  methods: {
      emitCheck1(){
        if(!!this.credit && !this.check){
          this.$emit("changeCheck1",new RegExp("credit"))
        }
        else if(!!this.check&& !this.credit){
          this.$emit("changeCheck1",new RegExp("check"))
        }
        else{
          this.$emit("changeCheck1", new RegExp(""))
        }
      },
     emitCheck2(){
        if(!!this.point&& !this.mileage){
          this.$emit("changeCheck2",new RegExp("point"))
        }
        else if(!!this.mileage && !this.point){
          this.$emit("changeCheck2",new RegExp("mileage"))
        }
        else{
          this.$emit("changeCheck2", new RegExp(""))
        }
      },
      emitCheck3(){
        if(!!this.discount && !this.stack){
          this.$emit("changeCheck3",new RegExp("discount"))
        }
        else if(!!this.stack && !this.discount){
          this.$emit("changeCheck3",new RegExp("stack"))
        }
        else{
          this.$emit("changeCheck3", new RegExp(""))
        }
      },
  }
};
</script>

<style>
</style>