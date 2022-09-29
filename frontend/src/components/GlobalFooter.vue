<template>
  <footer class="footer">
    <ul class="tab-list">
      <li class="tab-item">
        <button type="button" class="tab-button" @click="clickTab('weather')">
          <i class="ic-icon-temp" :class="weather"></i>
        </button>
      </li>

      <li class="tab-item">
        <button type="button" class="tab-button" @click="clickTab('closet')">
          <i class="ic-icon-closet" :class="weather"></i>
        </button>
      </li>

      <li class="tab-item">
        <button type="button" class="tab-button" @click="clickTab('music')">
          <i class="ic-icon-music" :class="weather"></i>
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

  methods: {
    clickTab(tab) {
      this.$emit("changeTab", tab);
    },
  },
};
</script>
