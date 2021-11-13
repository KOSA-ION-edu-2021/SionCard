<template>
    <v-card
        class="d-flex mt-16"
        tile flat
        height="330"
    >
        <div class="d-flex flex-column">
            <div class="text-h4">
                <v-pre>안녕하세요.<br>SionCard 입니다</v-pre>
            </div>
            <div class="text-body-2">
                <v-pre>행복을 주는 카드 시온카드 입니다.<br>오늘도 행복한 하루 되세요!</v-pre>
            </div>
        </div>
    </v-card>
</template>

<script>
export default {
    data:()=>({
        introduce:{
            title:"안녕하세요.SionCard 입니다",
            sub:"행복을 주는 카드 시온카드 입니다.오늘도 행복한 하루 되세요!"
        },
    }),
}
</script>
