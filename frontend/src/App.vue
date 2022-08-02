<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="col-sm-4 col-lg-2">
          <CurrentTime />
        </div>
        <div class="col-sm-4 col-lg-6">
          <GlobalHeader :weather="weatherSummery" />
          <MainContent :weather="weather" :temp="temp" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GlobalHeader from "./components/GlobalHeader.vue";
import MainContent from "./components/MainContent.vue";
import CurrentTime from "./components/CurrentTime.vue";

export default {
  name: "App",
  components: {
    GlobalHeader,
    MainContent,
    CurrentTime,
  },
  data() {
    return {
      weather: "clear",
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
