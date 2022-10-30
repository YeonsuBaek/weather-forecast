<template>
  <aside v-if="showLoadingSpinner" class="loading-spinner">
    <div class="thumbnail-list">
      <div class="thumbnail clear">
        <img src="@/assets/icons/icon-clear.svg" alt="" />
      </div>
      <div class="thumbnail clear-night">
        <img src="@/assets/icons/icon-clear-night.svg" alt="" />
      </div>
      <div class="thumbnail blur">
        <img src="@/assets/icons/icon-blur.svg" alt="" />
      </div>
      <div class="thumbnail rainy">
        <img src="@/assets/icons/icon-rainy.svg" alt="" />
      </div>
      <div class="thumbnail snowy">
        <img src="@/assets/icons/icon-snowy.svg" alt="" />
      </div>
    </div>

    <h1 class="loading-spinner-message">Loading...</h1>
  </aside>
</template>

<script>
export default {
  data() {
    return {
      showLoadingSpinner: true,
    };
  },
  mounted() {
    this.closeLoadingSpinner();
  },

  methods: {
    closeLoadingSpinner() {
      setTimeout(() => this.closeLoadingSpinner2(), 6000);
    },

    closeLoadingSpinner2() {
      this.showLoadingSpinner = false;
    },
  },
};
</script>

<style></style>
