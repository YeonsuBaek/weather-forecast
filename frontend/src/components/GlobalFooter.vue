<template>
  <footer class="footer">
    <ul class="tab-list">
      <li class="tab-item">
        <button type="button" class="tab-button" @click="clickTab('weather')">
          날씨
        </button>
      </li>

      <li class="tab-item">
        <button type="button" class="tab-button" @click="clickTab('closet')">
          코디
        </button>
      </li>

      <li class="tab-item">
        <button type="button" class="tab-button" @click="clickTab('music')">
          음악
        </button>
      </li>
    </ul>
  </footer>
</template>

<script>
export default {
  methods: {
    clickTab(tab) {
      this.$emit("changeTab", tab);
    },
  },
};
</script>

<style>
footer {
  position: fixed;
  bottom: 0;
}
</style>
