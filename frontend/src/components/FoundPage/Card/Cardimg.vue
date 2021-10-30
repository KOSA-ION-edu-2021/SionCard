<template>
    <v-card
        class="d-flex flex-column ma-auto" 
        width="330"
        height="300" 
        tile flat>
        <v-img
        max-height="250px"
        max-width="250px"
        contain
        style="margin-top:30px"
        src="@/assets/cardimg/yogiyo.png"
      />
        

    </v-card>
</template>

<script>
export default {
     data:()=>({
        card0:{
            img : "../../assets/cardimg/yogiyo.png"
        },
    }),
}
</script>