<template>
  <footer class="footer" :class="weather">
    <ul class="tab-list">
      <li class="tab-item">
        <button
          type="button"
          class="tab-button"
          :class="{ isActive: weatherActive }"
          @click="clickTab('weather')"
        >
          <i class="ic-temp" :class="weather"></i>
        </button>
      </li>

      <li class="tab-item">
        <button
          type="button"
          class="tab-button"
          :class="{ isActive: codiActive }"
          @click="clickTab('codi')"
        >
          <i class="ic-closet" :class="weather"></i>
        </button>
      </li>

      <li class="tab-item">
        <button
          type="button"
          class="tab-button"
          :class="{ isActive: musicActive }"
          @click="clickTab('music')"
        >
          <i class="ic-music" :class="weather"></i>
        </button>
      </li>
    </ul>
  </footer>
</template>

<script>
export default {
  props: {
    weather: String,
  },

  data() {
    return {
      weatherActive: true,
      codiActive: false,
      musicActive: false,
    };
  },

  methods: {
    clickTab(tab) {
      this.$emit("changeTab", tab);

      if (tab === "weather") {
        this.weatherActive = true;
        this.codiActive = false;
        this.musicActive = false;
      }
      if (tab === "codi") {
        this.weatherActive = false;
        this.codiActive = true;
        this.musicActive = false;
      }
      if (tab === "music") {
        this.weatherActive = false;
        this.codiActive = false;
        this.musicActive = true;
      }
    },
  },
};
</script>
