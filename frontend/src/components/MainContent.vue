<template>
  <main>
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <div class="current">
            <p class="temp-summery">
              <span class="temp-highest" aria-label="최고 기온">{{
                temp.highest
              }}</span>
              <span class="temp-lowest" aria-label="최저 기온">{{
                temp.lowest
              }}</span>
            </p>
            <strong
              class="temp-current"
              :class="weather"
              aria-label="현재 기온"
              >{{ temp.current }}</strong
            >
            <div class="current-image" :class="weather"></div>
          </div>

          <div class="daily">
            <ul class="daily-list">
              <li class="daily-item">
                <span class="daily-time">지금</span>
                <i class="daily-icon" aria-label="맑음"></i>
                <span class="daily-temp" aria-label="기온">26</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">22시</span>
                <i class="daily-icon" aria-label="구름"></i>
                <span class="daily-temp" aria-label="기온">25</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">23시</span>
                <i class="daily-icon" aria-label="비"></i>
                <span class="daily-temp" aria-label="기온">25</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">내일</span>
                <i class="daily-icon" aria-label="맑음"></i>
                <span class="daily-temp" aria-label="기온">26</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">1시</span>
                <i class="daily-icon" aria-label="구름"></i>
                <span class="daily-temp" aria-label="기온">25</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">2시</span>
                <i class="daily-icon" aria-label="비"></i>
                <span class="daily-temp" aria-label="기온">25</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">3시</span>
                <i class="daily-icon" aria-label="맑음"></i>
                <span class="daily-temp" aria-label="기온">26</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">4시</span>
                <i class="daily-icon" aria-label="구름"></i>
                <span class="daily-temp" aria-label="기온">25</span>
              </li>
              <li class="daily-item">
                <span class="daily-time">5시</span>
                <i class="daily-icon" aria-label="비"></i>
                <span class="daily-temp" aria-label="기온">25</span>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: "MainContent",
  props: {
    weather: String,
    temp: Object,
  },
};
</script>
