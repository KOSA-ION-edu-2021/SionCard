<template>
  <v-card tile flat ><!-- style="margin-top: 166px" -->
    <v-container >
      <v-row class="ma-auto pa-auto">
        <v-col cols="1" md="" />
        <v-col cols="3" class="pa-0 d-none d-md-block">
          <LoginDeco />
        </v-col>
        <v-col cols="10" md="6" class="pa-0">
          <LoginForm />
        </v-col>
        <v-col cols="1" />
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import LoginForm from "./LoginForm.vue";
import LoginDeco from "./LoginDeco.vue";


export default {
  components: {
    LoginForm,
    LoginDeco,
  },
};
</script>
