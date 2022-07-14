<template>
  <div>
    <GlobalHeader />
  </div>
</template>

<script>
import GlobalHeader from "./components/GlobalHeader.vue";

export default {
  name: "App",
  components: {
    GlobalHeader,
  },
};
</script>

<style lang="scss">
@import "./styles/main.scss";
</style>
