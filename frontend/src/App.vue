<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="col-lg-2 lg-only">
          <CurrentTime />
        </div>
        <div class="col-sm-4 col-lg-6">
          <GlobalHeader :weather="weatherSummery" />
          <WeatherContent
            v-show="weatherShow"
            :weather="weather"
            :temp="temp"
          />
          <ClosetContent v-show="closetShow" />
          <MusicContent v-show="musicShow" />
          <GlobalFooter @changeTab="moveToTab" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GlobalHeader from "./components/GlobalHeader.vue";
import WeatherContent from "./components/WeatherContent.vue";
import CurrentTime from "./components/CurrentTime.vue";
import GlobalFooter from "./components/GlobalFooter.vue";
import ClosetContent from "./components/ClosetContent.vue";
import MusicContent from "./components/MusicContent.vue";

export default {
  name: "App",
  components: {
    GlobalHeader,
    CurrentTime,
    WeatherContent,
    GlobalFooter,
    ClosetContent,
    MusicContent,
  },

  data() {
    return {
      weather: "cloudy",
      weatherSummery: "맑음",
      temp: {
        highest: 29,
        lowest: 24,
        current: 26,
      },
      weatherShow: true,
      closetShow: false,
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
        this.closetShow = false;
        this.musicShow = false;
      } else if (tab === "closet") {
        this.weatherShow = false;
        this.closetShow = true;
        this.musicShow = false;
      } else if (tab === "music") {
        this.weatherShow = false;
        this.closetShow = false;
        this.musicShow = true;
      }
    },
  },
};
</script>

<style lang="scss">
@import "./styles/main.scss";
</style>
