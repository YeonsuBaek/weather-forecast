<template>
  <section class="tab tab-codi">
    <div class="codi-women">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="codi-header">
              <h2 class="codi-title">여성 코디 추천</h2>
              <a
                class="codi-site-button"
                href="https://store.musinsa.com/app/codimap/lists"
                target="_blank"
                >더보기</a
              >
            </header>
          </div>
        </div>

        <ul class="row codi-list">
          <li v-for="(codi, index) in women" :key="index" class="col-sm-2">
            <a class="codi-item" :href="codi.link" target="_blank">
              <img :src="codi.image" :alt="codi.alt" />
            </a>
          </li>
        </ul>
      </div>
    </div>

    <div class="codi-men">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="codi-header">
              <h2 class="codi-title">남성 코디 추천</h2>
              <a
                class="codi-site-button"
                href="https://store.musinsa.com/app/codimap/lists"
                target="_blank"
                >더보기</a
              >
            </header>
          </div>
        </div>

        <ul class="row codi-list">
          <li v-for="(codi, index) in men" :key="index" class="col-sm-2">
            <a class="codi-item" :href="codi.link" target="_blank">
              <img :src="codi.image" :alt="codi.alt" />
            </a>
          </li>
        </ul>
      </div>
    </div>
  </section>
</template>

<script>
import womenCodi from "@/assets/data/women.json";
import menCodi from "@/assets/data/men.json";

export default {
  setup() {
    const women = womenCodi;
    const men = menCodi;

    return {
      women,
      men,
    };
  },
};
</script>

<style></style>
