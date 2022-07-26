<template>
  <div>
    <GlobalHeader :weather="weatherSummery" :location="location" />
    <MainContent :weather="weather" :temp="temp" />
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
      location: "수원시 금곡동",
      weatherSummery: "맑음",
      temp: {
        highest: 29,
        lowest: 24,
        current: 26,
      },
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
