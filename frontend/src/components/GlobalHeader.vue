<template>
  <header class="header" :class="weather">
    <span class="header-message">지금 한신대는</span>
    <h1 class="current-condition">{{ weatherSummery }}</h1>

    <button
      class="phoneBookButton headerIcon"
      type="button"
      @click="clickPhoneBook"
    >
      <i class="ic-call"></i>
    </button>

    <a
      class="hs-button headerIcon"
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
    weatherSummery: String,
  },
  data() {
    return {
      isActiveSearchModal: false,
    };
  },

  methods: {
    clickPhoneBook() {
      this.$emit("alertOpenPhoneBook");
    },
  },
};
</script>
