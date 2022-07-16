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
            <strong class="temp-current" aria-label="현재 기온">{{
              temp.current
            }}</strong>
            <div class="current-image">
              <img src="../assets/icon-clear.svg" alt="대체로 맑음" />
            </div>
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
