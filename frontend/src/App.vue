<template>
  <div>
    <GlobalHeader weather="맑음" location="수원시 금곡동" />
    <MainContent
      :weather="weather"
      :temp="{ highest: 29, lowest: 24, current: 26 }"
    />
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
  data() {
    return {
      weather: "clear",
    };
  },
  mounted() {
    document.body.className = "";
    document.body.classList.add(this.weather);
  },
};
</script>

<style lang="scss">
@import "./styles/main.scss";
</style>
