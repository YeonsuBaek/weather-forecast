<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="col-lg-2">
          <CurrentTime class="lg-only" />
          <GlobalFooter @changeTab="moveToTab" :weather="weather" />
        </div>
        <div class="col-sm-4 col-lg-6">
          <GlobalHeader :weather="weather" :weatherSummery="weatherSummery" />
          <WeatherContent
            v-show="weatherShow"
            :weather="weather"
            :temp="temp"
            :weatherDetail="weatherDetail"
            :dailyWeather="dailyWeather"
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
import weatherList from "./assets/data/weather.json";
import { ref } from "vue";

const weatherData = weatherList;

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
        highest: 0,
        lowest: 0,
        current: 0,
      },
      weatherDetail: {
        humd: "0",
        wind: "없음",
        rainPercent: "0",
        rainShape: "없음",
      },
      weatherShow: true,
      codiShow: false,
      musicShow: false,
      weatherData,
      dailyWeather: ref([]),
      weatherTime: 0,
      dateComparison: 0,
      weatherCondition: "",
    };
  },

  mounted() {
    this.isWeather(this.weatherData);
    this.isTemp(this.weatherData);
    this.isWeatherDetail(this.weatherData);
    this.getDailyWeather(this.weatherData);
  },

  methods: {
    isWeather(weatherData) {
      this.weatherSummery = weatherData[2].fcstValue;

      if (weatherData[2].fcstValue === "맑음") {
        this.weather = "clear";
      }
      if (weatherData[2].fcstValue === "구름많음") {
        this.weather = "cloudy";
      }
      if (weatherData[2].fcstValue === "흐림") {
        this.weather = "blur";
      }
      if (
        weatherData[2].fcstValue === "비" ||
        weatherData[2].fcstValue === "소나기"
      ) {
        this.weather = "rainy";
      }
      if (weatherData[2].fcstValue === "눈") {
        this.weather = "snowy";
      }

      document.body.className = "";
      document.body.classList.add(this.weather);
    },

    isTemp(weatherData) {
      this.temp.current = weatherData[0].fcstValue.slice(0, -1);

      const highestIndex = this.weatherData.findIndex(
        (v) => v.category === "일 최고기온"
      );
      const lowestIndex = this.weatherData.findIndex(
        (v) => v.category === "일 최저기온"
      );
      this.temp.highest = weatherData[highestIndex].fcstValue.slice(0, -1);
      this.temp.lowest = weatherData[lowestIndex].fcstValue.slice(0, -1);
    },

    isWeatherDetail(weatherData) {
      const humdIndex = this.weatherData.findIndex(
        (v) => v.category === "습도"
      );
      const windIndex = this.weatherData.findIndex(
        (v) => v.category === "풍속"
      );
      const rainPercentIndex = this.weatherData.findIndex(
        (v) => v.category === "강수확률"
      );
      const rainShapeIndex = this.weatherData.findIndex(
        (v) => v.category === "강수형태"
      );

      this.weatherDetail.humd = weatherData[humdIndex].fcstValue + "%";
      this.weatherDetail.wind = weatherData[windIndex].fcstValue;
      this.weatherDetail.rainPercent =
        weatherData[rainPercentIndex].fcstValue + "%";
      this.weatherDetail.rainShape = weatherData[rainShapeIndex].fcstValue;
    },

    getDailyWeather(weatherData) {
      for (let i = 0; i < weatherData.length; i += 24) {
        if (weatherData[i].category !== "1시간 기온") {
          i++;
          continue;
        }

        this.weatherTime = Number(weatherData[i].fcstTime) / 100;
        this.dateComparison = weatherData[i].fcstDate - weatherData[i].baseDate;

        if (this.weatherTime === 0) {
          if (this.dateComparison === 0) {
            this.weatherTime = "오늘";
          } else if (this.dateComparison === 1) {
            this.weatherTime = "내일";
          } else if (this.dateComparison === 2) {
            this.weatherTime = "모레";
          } else if (this.dateComparison === 3) {
            this.weatherTime = "글피";
          }
        } else {
          this.weatherTime = this.weatherTime + "시";
        }

        this.weatherCondition = weatherData[i + 2].fcstValue;

        if (this.weatherCondition === "맑음") {
          this.weatherCondition = "clear";
        } else if (this.weatherCondition === "구름많음") {
          this.weatherCondition = "cloudy";
        } else if (this.weatherCondition === "흐림") {
          this.weatherCondition = "blur";
        } else if (
          this.weatherCondition === "비" ||
          this.weatherCondition === "소나기"
        ) {
          this.weatherCondition = "rainy";
        } else if (this.weatherCondition === "눈") {
          this.weatherCondition = "snowy";
        }

        this.dailyWeather.push({
          time: this.weatherTime,
          weather: this.weatherCondition,
          temp: weatherData[i].fcstValue.slice(0, -1),
        });
      }
    },

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
