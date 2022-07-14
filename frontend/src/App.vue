<template>
  <div>
    <GlobalHeader />
    <MainContent />
  </div>
</template>

<script>
import GlobalHeader from "./components/GlobalHeader.vue";
import MainContent from "./components/MainContent.vue";

export default {
  name: "App",
  components: {
    GlobalHeader,
    MainContent,
  },
};
</script>

<style lang="scss">
@import "./styles/main.scss";
</style>
