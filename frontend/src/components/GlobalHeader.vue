<template>
  <header class="header">
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <button class="location" type="button" @click="openSearchModal">
            <h1 class="location-name">{{ location }}</h1>
            <strong class="location-weather">{{ weather }}</strong>
          </button>
        </div>
      </div>
    </div>

    <SearchModal :isActive="isActive" />
  </header>
</template>

<script>
import SearchModal from "./SearchModal.vue";

export default {
  name: "GlobalHeader",
  components: {
    SearchModal,
  },
  props: {
    weather: String,
    location: String,
  },
  data() {
    return {
      isActive: false,
    };
  },
  methods: {
    openSearchModal() {
      this.isActive = !this.isActive;
    },
  },
};
</script>
