<template>
    <div class="d-flex">
        <video muted autoplay loop :style="`height:${height}; width:${width};`">
            <source type="video/mp4" src="../../../assets/main1.mp4"/>
        </video>
    </div>
</template>

<script>

export default {
    props:{
        width:String,
        height:String,
    },
}
</script>

<style>
</style>