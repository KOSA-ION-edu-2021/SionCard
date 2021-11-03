<template>
    <v-container>
    
    <v-card
        tile flat
        style="margin-top:166px"
    >
        <v-row class="ma-auto pa-auto">
            
            <v-col cols="5" class="pa-0 d-none d-md-block">
                <LoginDeco/>
            </v-col>
            <v-col cols="12" md="7" class="pa-0">
                <LoginForm/>
            </v-col>
           
        </v-row>
    </v-card>

    </v-container>
</template>

<script>
import LoginForm from "./LoginForm.vue"
import LoginDeco from "./LoginDeco.vue"

export default {

    components:{
        LoginForm,
        LoginDeco
    }
};
</script>
