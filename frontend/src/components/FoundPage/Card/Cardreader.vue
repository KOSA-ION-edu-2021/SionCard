<template>
<v-card
        class="d-flex mt-16"
        tile flat
        height="300"
    >
        <div class="d-flex flex-column">
            <div class="text-h4">
                <pre>{{card0.name}}</pre>
            </div>
            <div class="text-body-3" style="margin-top:10px">
                <pre>{{card0.title}}</pre>
            </div>  
            <div class="text-body-2" style="margin-top:40px">
                <pre>{{card0.benefit1}}</pre>
            </div>
            <div class="text-body-2" style="margin-top:20px">
                <pre>{{card0.benefit2}}</pre>
            </div>
            <div class="text-body-2" style="margin-top:20px">
                <pre>{{card0.benefit3}}</pre>
            </div>
        </div>
    </v-card>
</template>

<script>
export default {
    data:()=>({
        card0:{
            name : "요기요 카드",
            title : "맛있는 생활의 필수 혜택 카드",
            benefit1 : "요기요 할인 최대 2만원 할인",
            benefit2 : "요기요 캐시백 추가 5천원 캐시백",
            benefit3 : "홈Life 서비스 최대 2만5천원 할인"
        },
    }),
}
</script>

<style>

</style>