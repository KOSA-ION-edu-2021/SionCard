<template>
    <div class="d-flex">
        <video muted autoplay loop :style="`height:${height}; width:${width};`">
            <source type="video/mp4" :src="src"/>
        </video>
    </div>
</template>

<script>
export default {
    props:{
        width:String,
        height:String,
        src:String
    }
}
</script>

<style>
</style>