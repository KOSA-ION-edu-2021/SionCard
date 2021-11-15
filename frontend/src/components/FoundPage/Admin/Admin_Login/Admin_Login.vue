<template>
  <v-card tile flat class="grey lighten-2"><!-- style="margin-top: 166px" -->
    <v-container class="grey lighten-2">
      <v-row class="ma-auto pa-auto" justify="center">
        <v-col cols="1"></v-col>
        <v-col cols="10" md="6" class="pa-0">
          <LoginForm />
        </v-col>
        <v-col cols="1"></v-col> 
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import LoginForm from "./Admin_LoginForm.vue";


export default {
  components: {
    LoginForm,
  },
};
</script>
