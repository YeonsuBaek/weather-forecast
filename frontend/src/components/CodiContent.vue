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
        <li class="codi-item" v-for="(codi, index) in womenList" :key="index">
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
        <li class="codi-item" v-for="(codi, index) in menList" :key="index">
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
  data() {
    return {
      women: womenCodi,
      men: menCodi,
      womenList: ref([]),
      menList: ref([]),
    };
  },

  mounted() {
    this.changeWomenCodiList(this.women);
    this.changeMenCodiList(this.men);
  },

  methods: {
    changeWomenCodiList(women) {
      const womenIndex = this.codiIndex();

      for (let i = 0; i < women[womenIndex].length; i++) {
        this.womenList.push({
          image: women[womenIndex][i].image,
          link: women[womenIndex][i].link,
          alt: women[womenIndex][i].alt,
        });
      }
    },

    changeMenCodiList(men) {
      const menIndex = this.codiIndex();

      for (let i = 0; i < men[menIndex].length; i++) {
        this.menList.push({
          image: men[menIndex][i].image,
          link: men[menIndex][i].link,
          alt: men[menIndex][i].alt,
        });
      }
    },

    codiIndex() {
      let today = new Date();

      if (today.getMonth() >= 3 && today.getMonth() <= 5) {
        return 0;
      } else if (today.getMonth() >= 6 && today.getMonth() <= 8) {
        return 1;
      } else if (today.getMonth() >= 9 && today.getMonth() <= 10) {
        return 2;
      } else {
        return 3;
      }
    },
  },
};
</script>

<style></style>
