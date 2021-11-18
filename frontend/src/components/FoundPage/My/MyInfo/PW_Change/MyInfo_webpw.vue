<template>
    <v-container>
        <v-row class="mt-5">
          <v-col class="text-h4 font-weight-bold">
            본인 인증
          </v-col>
        </v-row>
        <pw_table/>
        
    </v-container>
</template>

<script>
import pw_table from './webpw_table.vue'

export default {
    name: "myinfo_webpw",
    data: () => ({
      radioValues: 'email',
    }),
    components:{
      pw_table
    },
    methods:{
      emailCheck(){
        this.radioValues = 'email'
      },
      cardCheck(){
        this.radioValues = 'card'
      }

    }
}
</script>

<style>

</style>