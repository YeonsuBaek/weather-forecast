<template>
  <section class="tab tab-music">
    <header class="tab-header">
      <h2 class="tab-title">{{ weatherMessage }} 때 듣기 좋은 음악</h2>
    </header>

    <ul class="music-list">
      <li class="music-item">
        <iframe
          :src="musicLink"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
        <strong class="music-title">{{ musicTitle }}</strong>
        <span class="music-singer">{{ musicSinger }}</span>
      </li>
    </ul>
  </section>
</template>

<script>
import { ref } from "vue";
import axios from "axios";

export default {
  props: {
    weatherMessage: String,
    musicIndex: Number,
  },

  data() {
    return {
      music: ref([]),
      currentWeather: "",
      musicTitle: "",
      musicSinger: "",
      musicLink: "",
    };
  },

  mounted() {
    this.getMusicData(this.weatherMessage);
    // this.addMusicList();
    // this.changeMusicList(this.music);
  },

  methods: {
    getMusicData(weather) {
      this.currentWeather = "맑음";

      if (weather === "흐린") {
        this.currentWeather = "흐림";
      } else if (weather === "비 올") {
        this.currentWeather = "비";
      } else if (weather === "눈 올") {
        this.currentWeather = "눈";
      }

      const url = "music/findByWeather?weather=" + this.currentWeather;
      axios.get(url).then((res) => {
        this.music.push(res.data);
        this.musicTitle = this.music[0][0].title;
        this.musicSinger = this.music[0][0].singer;
        this.musicLink = this.music[0][0].link;
      });
    },

    // addMusicList() {
    //   for (let i = 0; i < 4; i++) {
    //     this.musicList.push([]);
    //   }
    // },

    // changeMusicList() {
    //   this.pushMusicList("비", 0);
    //   this.pushMusicList("눈", 1);
    //   this.pushMusicList("흐림", 2);
    //   this.pushMusicList("맑음", 3);
    // },

    // pushMusicList(currentWeather, listIndex) {
    //   const weatherIndex = music.findIndex((v) => v.weather === currentWeather);

    //   for (let i = weatherIndex; i < this.music.length; i++) {
    //     if (music[i].weather !== currentWeather) {
    //       break;
    //     }

    //     this.musicList[listIndex].push({
    //       title: music[i].title,
    //       singer: music[i].singer,
    //       link: music[i].link,
    //     });
    //   }
    // },
  },
};
</script>

<style></style>
