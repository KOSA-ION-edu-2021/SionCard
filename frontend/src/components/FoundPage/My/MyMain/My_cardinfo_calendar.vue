<template>
  <div class="text-center">
    <v-dialog
      v-model="dialog"
      width="300px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-text-field
         class="mb-n6"
        v-model="dateRangeText"
        label="Date range"
        prepend-icon="mdi-calendar"
        readonly
        color="grey darken-3"
        v-bind="attrs"
        v-on="on"
      ></v-text-field>
      </template>

      <v-date-picker
        v-model="dates"
        range
        color="grey darken-3"
        locale="ko"
      ></v-date-picker>
    </v-dialog>
  </div>
</template>

<script>
import dayjs from 'dayjs'

export default {
    name:"calendar",
    data: ()=>({
        dialog: false,
        dates: [dayjs().subtract(30, 'day').format("YYYY-MM-DD"), dayjs().format("YYYY-MM-DD") ], //[ 30일 전 날짜 , 오늘 날짜 ]
    }),
    computed: {
      dateRangeText () {
        return this.dates.join(' ~ ')
      },
    },
    component: { 
        dayjs,
    },

}
</script>

<style>

</style>