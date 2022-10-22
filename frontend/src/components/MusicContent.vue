<template>
  <section class="tab tab-music">
    <header class="tab-header">
      <h2 class="tab-title">{{ weatherMessage }} 때 듣기 좋은 음악</h2>
    </header>

    <ul class="music-list">
      <li class="music-item">
        <iframe
          src="https://www.youtube.com/embed/kTJi9YpmE3M"
          title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
        <strong class="music-title">눈사람</strong>
        <span class="music-singer">정승환</span>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  props: {
    weatherMessage: Object,
  },

  data() {
    return {};
  },
};
</script>

<style></style>
