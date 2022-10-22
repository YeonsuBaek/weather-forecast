<template>
  <section class="tab tab-codi">
    <div class="codi-women">
      <header class="tab-header">
        <h2 class="tab-title">여성 코디 추천</h2>
        <a
          class="codi-site-button"
          href="https://store.musinsa.com/app/codimap/lists"
          target="_blank"
          >더보기</a
        >
      </header>

      <ul class="codi-list">
        <li
          class="codi-item"
          v-for="(codi, index) in womenList[codiIndex]"
          :key="index"
        >
          <a class="codi-button" :href="codi.link" target="_blank">
            <img :src="codi.image" :alt="codi.alt" />
          </a>
        </li>
      </ul>
    </div>

    <div class="codi-men">
      <header class="tab-header">
        <h2 class="tab-title">남성 코디 추천</h2>
        <a
          class="codi-site-button"
          href="https://store.musinsa.com/app/codimap/lists"
          target="_blank"
          >더보기</a
        >
      </header>

      <ul class="codi-list">
        <li
          class="codi-item"
          v-for="(codi, index) in menList[codiIndex]"
          :key="index"
        >
          <a class="codi-button" :href="codi.link" target="_blank">
            <img :src="codi.image" :alt="codi.alt" />
          </a>
        </li>
      </ul>
    </div>
  </section>
</template>

<script>
import womenCodi from "@/assets/data/women.json";
import menCodi from "@/assets/data/men.json";
import { ref } from "vue";

export default {
  props: {
    codiIndex: Number,
  },

  data() {
    return {
      women: womenCodi,
      men: menCodi,
      womenList: ref([]),
      menList: ref([]),
    };
  },

  mounted() {
    this.addCodiIndex();
    this.changeWomenCodiList(this.women);
    this.changeMenCodiList(this.men);
  },

  methods: {
    changeWomenCodiList(women) {
      for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 6; j++) {
          this.womenList[i].push({
            image: women[i][j].image,
            link: women[i][j].link,
            alt: women[i][j].alt,
          });
        }
      }
    },

    changeMenCodiList(men) {
      for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 6; j++) {
          this.menList[i].push({
            image: men[i][j].image,
            link: men[i][j].link,
            alt: men[i][j].alt,
          });
        }
      }
    },

    addCodiIndex() {
      for (let i = 0; i < 4; i++) {
        this.womenList.push([]);
        this.menList.push([]);
      }
    },
  },
};
</script>

<style></style>
