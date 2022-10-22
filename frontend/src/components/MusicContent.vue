<template>
  <section class="tab tab-music">
    <header class="tab-header">
      <h2 class="tab-title">{{ weatherMessage }} 때 듣기 좋은 음악</h2>
    </header>

    <ul class="music-list">
      <li
        v-for="(music, index) in musicList[musicIndex]"
        :key="index"
        class="music-item"
      >
        <iframe
          :src="music.link"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
        <strong class="music-title">{{ music.title }}</strong>
        <span class="music-singer">{{ music.singer }}</span>
      </li>
    </ul>
  </section>
</template>

<script>
import music from "@/assets/data/music.json";
import { ref } from "vue";

export default {
  props: {
    weatherMessage: String,
    musicIndex: Number,
  },

  data() {
    return {
      music: music,
      musicList: ref([]),
    };
  },

  mounted() {
    this.changeMusicList(this.music);
  },

  methods: {
    changeMusicList() {
      for (let i = 0; i < 4; i++) {
        this.musicList.push([]);
      }

      let rainyIndex = music.findIndex((v) => v.weather === "비");
      let snowyIndex = music.findIndex((v) => v.weather === "눈");
      let blurIndex = music.findIndex((v) => v.weather === "흐림");
      let clearIndex = music.findIndex((v) => v.weather === "맑음");

      const leng = this.music.length;

      for (let i = rainyIndex; i < leng; i++) {
        if (music[i].weather !== "비") {
          break;
        }

        this.musicList[0].push({
          title: music[i].title,
          singer: music[i].singer,
          link: music[i].link,
        });
      }

      for (let i = snowyIndex; i < leng; i++) {
        if (music[i].weather !== "눈") {
          break;
        }

        this.musicList[1].push({
          title: music[i].title,
          singer: music[i].singer,
          link: music[i].link,
        });
      }

      for (let i = blurIndex; i < leng; i++) {
        if (music[i].weather !== "흐림") {
          break;
        }

        this.musicList[2].push({
          title: music[i].title,
          singer: music[i].singer,
          link: music[i].link,
        });
      }

      for (let i = clearIndex; i < leng; i++) {
        if (music[i].weather !== "맑음") {
          break;
        }

        this.musicList[3].push({
          title: music[i].title,
          singer: music[i].singer,
          link: music[i].link,
        });
      }
    },
  },
};
</script>

<style></style>
