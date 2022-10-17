<template>
  <section class="tab tab-weather">
    <div class="current">
      <p class="temp-summery">
        <span class="temp-highest" aria-label="최고 기온">{{
          temp.highest
        }}</span>
        <span class="temp-lowest" aria-label="최저 기온">{{
          temp.lowest
        }}</span>
      </p>
      <strong class="temp-current" :class="weather" aria-label="현재 기온">{{
        temp.current
      }}</strong>
      <div class="current-image" :class="weather"></div>
    </div>

    <div class="summary">
      <dl class="summary-list">
        <div class="summary-item">
          <dt>
            습도
            <i class="ic-humd" :class="weather"></i>
          </dt>
          <dd>{{ weatherDetail.humd }}</dd>
        </div>

        <div class="summary-item">
          <dt>
            바람
            <i class="ic-wind" :class="weather"></i>
          </dt>
          <dd>{{ weatherDetail.wind }}</dd>
        </div>

        <div class="summary-item">
          <dt>
            강수확률
            <i class="ic-water" :class="weather"></i>
          </dt>
          <dd>{{ weatherDetail.rainPercent }}</dd>
        </div>

        <div class="summary-item">
          <dt>
            강수형태
            <i class="ic-rain" :class="weather"></i>
          </dt>
          <dd>{{ weatherDetail.rainShape }}</dd>
        </div>
      </dl>
    </div>

    <div class="daily">
      <ul class="daily-list">
        <li
          v-for="(daily, index) in dailyWeather"
          :key="index"
          class="daily-item"
        >
          <span
            class="daily-time"
            :class="[{ changeDate: daily.date }, weather]"
            >{{ daily.time }}</span
          >
          <i class="daily-icon" :class="daily.weather" aria-label="맑음"></i>
          <span class="daily-temp" aria-label="기온">{{ daily.temp }}</span>
        </li>
      </ul>
    </div>
  </section>
</template>

<script>
export default {
  name: "MainContent",
  props: {
    weather: String,
    temp: Object,
    weatherDetail: Object,
    dailyWeather: Array,
  },
};
</script>
