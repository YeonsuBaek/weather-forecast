<template>
  <header class="header">
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <button class="location" type="button">
            <h1 class="location-name">{{ location }}</h1>
            <strong class="location-weather">{{ weather }}</strong>
          </button>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "GlobalHeader",
  props: {
    weather: String,
    location: String,
  },
};
</script>
