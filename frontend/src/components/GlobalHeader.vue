<template>
  <header class="header">
    <span class="header-message">지금 한신대는</span>
    <h1 class="current-condition">{{ weather }}</h1>

    <a
      class="hs-button"
      href="https://www.hs.ac.kr/"
      target="_blank"
      type="button"
    >
      <img src="../assets/icons/icon-hs-white.svg" alt="" />
    </a>
  </header>
</template>

<script>
export default {
  name: "GlobalHeader",

  props: {
    weather: String,
  },
  data() {
    return {
      isActiveSearchModal: false,
    };
  },
};
</script>
