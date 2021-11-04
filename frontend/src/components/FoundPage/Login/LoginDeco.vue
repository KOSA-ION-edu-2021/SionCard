<template>
  <v-card class="d-flex align-center " tile flat height="330">
    <div class="d-flex flex-column">
      <div class="text-h4">
        <pre>{{ introduce.title }}</pre>
      </div>
      <div class="text-body-2">
        <pre>{{ introduce.sub }}</pre>
      </div>
    </div>
  </v-card>
</template>

<script>
export default {
  data: () => ({
    introduce: {
      title: "안녕하세요.\nSionCard 입니다",
      sub: "행복을 주는 카드 시온카드 입니다.\n오늘도 행복한 하루 되세요!",
    },
  }),
};
</script>

<style>
</style>