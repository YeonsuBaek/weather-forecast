<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="col-lg-2">
          <CurrentTime class="lg-only" />
          <GlobalFooter
            @changeTab="moveToTab"
            :weather="weather"
            :activeShow="activeShow"
          />
        </div>
        <div class="col-sm-4 col-lg-6">
          <GlobalHeader :weather="weather" :weatherSummery="weatherSummery" />
          <WeatherContent
            v-show="weatherShow"
            :weather="weather"
            :temp="temp"
          />
          <CodiContent v-show="codiShow" />
          <MusicContent v-show="musicShow" />
        </div>

        <div class="col-lg-4 lg-only"></div>
      </div>
    </div>
  </div>
</template>

<script>
import GlobalHeader from "./components/GlobalHeader.vue";
import WeatherContent from "./components/WeatherContent.vue";
import CurrentTime from "./components/CurrentTime.vue";
import GlobalFooter from "./components/GlobalFooter.vue";
import CodiContent from "./components/CodiContent.vue";
import MusicContent from "./components/MusicContent.vue";

export default {
  name: "App",
  components: {
    GlobalHeader,
    CurrentTime,
    WeatherContent,
    GlobalFooter,
    CodiContent,
    MusicContent,
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
      weatherShow: true,
      codiShow: false,
      musicShow: false,
    };
  },

  mounted() {
    document.body.className = "";
    document.body.classList.add(this.weather);
  },

  methods: {
    moveToTab(tab) {
      if (tab === "weather") {
        this.weatherShow = true;
        this.codiShow = false;
        this.musicShow = false;
      } else if (tab === "codi") {
        this.weatherShow = false;
        this.codiShow = true;
        this.musicShow = false;
      } else if (tab === "music") {
        this.weatherShow = false;
        this.codiShow = false;
        this.musicShow = true;
      }
    },
  },
};
</script>

<style lang="scss">
@import "./styles/main.scss";
</style>
