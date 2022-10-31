<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="col-lg-2">
          <CurrentTime class="lg-only" />
          <GlobalFooter @changeTab="moveToTab" :weather="weather" />
        </div>
        <div class="col-sm-4 col-lg-6">
          <GlobalHeader
            :weather="weather"
            :weatherSummery="weatherSummery"
            @alertOpenPhoneBook="openPhoneBook"
          />
          <WeatherContent
            v-show="weatherShow"
            :weather="weather"
            :temp="temp"
            :weatherDetail="weatherDetail"
            :dailyWeather="dailyWeather"
          />
          <CodiContent v-show="codiShow" :codiIndex="codiIndex" />
          <MusicContent
            v-show="musicShow"
            :weatherMessage="weatherMessage"
            :musicIndex="musicIndex"
          />
        </div>

        <div class="col-lg-4">
          <PhoneBook
            :weather="weather"
            :isOpenPhoneBook="isOpenPhoneBook"
            @alertClosePhoneBook="closePhoneBook"
          />
        </div>
      </div>
    </div>

    <LoadingSpinner />
  </div>
</template>

<script>
import GlobalHeader from "./components/GlobalHeader.vue";
import WeatherContent from "./components/WeatherContent.vue";
import CurrentTime from "./components/CurrentTime.vue";
import GlobalFooter from "./components/GlobalFooter.vue";
import CodiContent from "./components/CodiContent.vue";
import MusicContent from "./components/MusicContent.vue";
// import weatherList from "./assets/data/weather.json";
import PhoneBook from "./components/PhoneBook.vue";
import LoadingSpinner from "./components/LoadingSpinner.vue";
import { ref } from "vue";
import axios from "axios";

// const weatherData = weatherList;

export default {
  name: "App",
  components: {
    GlobalHeader,
    CurrentTime,
    WeatherContent,
    GlobalFooter,
    CodiContent,
    MusicContent,
    PhoneBook,
    LoadingSpinner,
  },

  data() {
    return {
      weatherData: ref([]),
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
      weatherWind: "",
      dailyWeather: ref([]),
      weatherTime: 0,
      dateComparison: 0,
      weatherCondition: "",
      changeDate: false,
      isOpenPhoneBook: false,
      weatherMessage: "",
      musicIndex: 0,
      codiIndex: 0,
    };
  },

  mounted() {
    this.getWeatherData();
  },

  methods: {
    getWeatherData() {
      const baseTimeList = ["2", "5", "8", "11", "14", "17", "20", "23"];
      let today = new Date();
      let year = ("0" + today.getFullYear()).slice(-2);
      let month = ("0" + (today.getMonth() + 1)).slice(-2);
      let day = ("0" + today.getDate()).slice(-2);
      let hour = ("0" + today.getHours()).slice(-2);
      // let minute = ("0" + today.getMinutes()).slice(-2);

      for (let i = Number(hour); i > 0; i--) {
        if (baseTimeList.includes(i.toString())) {
          hour = i;
          break;
        }
      }

      const url = `/weather/fcst/20${year}${month}${day}/${hour}00?state=경기도&city=오산시&town=세마동`;

      axios.get(url).then((res) => {
        this.weatherData.push(res.data);
        this.getWeather(this.weatherData[0]);
        this.getTemp(this.weatherData[0]);
        this.getWeatherDetail(this.weatherData[0]);
        this.getDailyWeather(this.weatherData[0]);
        this.getCodiIndex(this.temp.highest);
        this.isWeatherMessage(this.weatherData[0]);
        this.getMusicIndex(this.weatherMessage);
      });
    },

    getWeather(weatherData) {
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

    getTemp(weatherData) {
      this.temp.current = weatherData[0].fcstValue.slice(0, -1);

      const highestIndex = weatherData.findIndex(
        (v) => v.category === "일 최고기온"
      );
      const lowestIndex = weatherData.findIndex(
        (v) => v.category === "일 최저기온"
      );
      this.temp.highest = Math.floor(
        weatherData[highestIndex].fcstValue.slice(0, -1)
      );
      this.temp.lowest = Math.floor(
        weatherData[lowestIndex].fcstValue.slice(0, -1)
      );
    },

    getWeatherDetail(weatherData) {
      const humdIndex = weatherData.findIndex((v) => v.category === "습도");
      const windIndex = weatherData.findIndex((v) => v.category === "풍속");
      const rainPercentIndex = weatherData.findIndex(
        (v) => v.category === "강수확률"
      );
      const rainShapeIndex = weatherData.findIndex(
        (v) => v.category === "강수형태"
      );

      this.weatherWind = weatherData[windIndex].fcstValue.slice(0, -3);

      if (this.weatherWind === 0) {
        this.weatherWind = "없음";
      } else if (this.weatherWind > 0 && this.weatherWind <= 8) {
        this.weatherWind = "약함";
      } else if (this.weatherWind > 8 && this.weatherWind <= 16) {
        this.weatherWind = "강함";
      } else if (this.weatherWind > 16) {
        this.weatherWind = "날아감";
      }

      this.weatherDetail.humd = weatherData[humdIndex].fcstValue + "%";
      this.weatherDetail.wind = this.weatherWind;
      this.weatherDetail.rainPercent =
        weatherData[rainPercentIndex].fcstValue + "%";
      this.weatherDetail.rainShape = weatherData[rainShapeIndex].fcstValue;
    },

    getDailyWeather(weatherData) {
      for (let i = 0; i < weatherData.length; i += 24) {
        if (weatherData[i].category !== "1시간 기온") {
          i -= 23;
          continue;
        }

        this.weatherTime = Number(weatherData[i].fcstTime) / 100;
        this.dateComparison = weatherData[i].fcstDate - weatherData[i].baseDate;

        if (this.weatherTime === 0) {
          this.changeDate = true;

          const weatherDay = Number(weatherData[i].fcstDate.substr(6, 2));

          this.weatherTime = `${weatherDay}일`;
        } else {
          this.changeDate = false;
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
          date: this.changeDate,
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

    openPhoneBook() {
      this.isOpenPhoneBook = true;
    },

    closePhoneBook() {
      this.isOpenPhoneBook = false;
    },

    getCodiIndex(highestTemp) {
      let today = new Date();

      if (highestTemp < 10) {
        this.codiIndex = 3;
      } else if (highestTemp < 20) {
        if (today.getMonth() < 7) {
          this.codiIndex = 0;
        } else {
          this.codiIndex = 2;
        }
      } else {
        this.codiIndex = 1;
      }
    },

    isWeatherMessage(weatherData) {
      const currentSky = weatherData[2].fcstValue;

      if (currentSky === "맑음") {
        this.weatherMessage = "맑을";
      } else if (currentSky === "구름많음") {
        this.weatherMessage = "구름 많을";
      } else if (currentSky === "흐림") {
        this.weatherMessage = "흐릴";
      } else if (currentSky === "비") {
        this.weatherMessage = "비 올";
      } else if (currentSky === "눈") {
        this.weatherMessage = "눈 올";
      }
    },

    getMusicIndex(weatherMessage) {
      if (weatherMessage === "맑을" || weatherMessage === "구름 많을") {
        this.musicIndex = 3;
      } else if (weatherMessage === "흐림") {
        this.musicIndex = 2;
      } else if (weatherMessage === "눈") {
        this.musicIndex = 1;
      } else if (weatherMessage === "비") {
        this.musicIndex = 0;
      }
    },
  },
};
</script>

<style lang="scss">
@import "./styles/main.scss";
</style>
