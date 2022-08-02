<template>
  <div class="current-time">
    <div class="wrapper">
      <strong class="date">{{ month }}.{{ day }}</strong>
      <span class="time">{{ hour }}:{{ minute }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "CurrentTime",
  data() {
    return {
      month: "00",
      day: "00",
      hour: "00",
      minute: "00",
    };
  },
  created() {
    this.setCurrentTime();
  },

  methods: {
    setCurrentTime() {
      let today = new Date();
      let month = ("0" + (today.getMonth() + 1)).slice(-2);
      let day = ("0" + today.getDate()).slice(-2);
      let hour = ("0" + today.getHours()).slice(-2);
      let minute = ("0" + today.getMinutes()).slice(-2);

      this.month = month;
      this.day = day;
      this.hour = hour;
      this.minute = minute;
    },
  },
};
</script>
