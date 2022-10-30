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
    this.addMusicList();
    this.changeMusicList(this.music);
  },

  methods: {
    addMusicList() {
      for (let i = 0; i < 4; i++) {
        this.musicList.push([]);
      }
    },

    changeMusicList() {
      this.pushMusicList("비", 0);
      this.pushMusicList("눈", 1);
      this.pushMusicList("흐림", 2);
      this.pushMusicList("맑음", 3);
    },

    pushMusicList(currentWeather, listIndex) {
      const weatherIndex = music.findIndex((v) => v.weather === currentWeather);

      for (let i = weatherIndex; i < this.music.length; i++) {
        if (music[i].weather !== currentWeather) {
          break;
        }

        this.musicList[listIndex].push({
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
