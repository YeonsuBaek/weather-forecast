<template>
  <section class="tab tab-music">
    <header class="tab-header">
      <h2 class="tab-title">{{ weatherMessage }} 때 듣기 좋은 음악</h2>
    </header>

    <ul class="codi-list">
      <li>
        <iframe
          src="https://www.youtube.com/embed/kTJi9YpmE3M?controls=0"
          title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  props: {
    weather: Object,
  },

  data() {
    return {
      weatherMessage: "",
    };
  },

  mounted() {
    this.isWeatherMessage(this.weather);
  },

  methods: {
    isWeatherMessage(currentWeather) {
      if (currentWeather === "clear") {
        this.weatherMessage = "맑을";
      } else if (currentWeather === "cloudy") {
        this.weatherMessage = "구름 많을";
      } else if (currentWeather === "blur") {
        this.weatherMessage = "흐릴";
      } else if (currentWeather === "rainy") {
        this.weatherMessage = "비올";
      } else if (currentWeather === "snowy") {
        this.weatherMessage = "눈 올";
      }
    },
  },
};
</script>

<style></style>
