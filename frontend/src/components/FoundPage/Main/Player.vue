<template>
    <div class="video-box d-flex blue-grey">
        <video muted autoplay loop :style="`height:${height}; width:${width};`">
            <source type="video/mp4" src="../../../assets/main1.mp4"/>
        </video>
        <div class="video-text">
            편리한 카드생활의 모든것 <br>
            <strong>SI-ON Card</strong>와 함께
        </div>
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

<style scoped>
.video-box{
    position: relative;
    /* overflow: hidden; */
    height: 648px;
}
video{
    width: 100%;
}

.video-text{
    width: 100%;
    position: absolute;
    text-align: center;
    align-self: center;
    justify-self: center;
    margin: auto;
    font-size: 66px;
}
.video-text strong{
    color: white;
}
</style>