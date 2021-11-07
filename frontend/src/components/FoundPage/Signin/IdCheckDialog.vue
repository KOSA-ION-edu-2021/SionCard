<template>
  <v-dialog
      v-model="dialog"
      persistent
      max-width="290"
    >
      <v-card>
        <v-card-title class="text-h5">
          중복확인
        </v-card-title>

        <v-card-text>
          {{text}}
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>

          <v-btn
            color="primary"
            text
            @click="close(true)"
          >
            확인
          </v-btn>

          <v-btn
            color="error"
            text
            @click="close(false)"
          >
            취소
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
export default {
    props:{
        dialog:Boolean,
        close:Function
    },
    data:()=>({
      text:"이미 아이디가 존재합니다."
    })
}
</script>