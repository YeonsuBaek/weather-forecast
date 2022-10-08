<template>
  <aside class="phoneBook" :class="{ 'is-open': isOpenPhoneBook }">
    <header class="phoneBook-header">
      <h2 class="title">한신대학교 전화번호부</h2>
      <button class="close-button" type="button">
        <i class="ic-close" @click="clickCloseButton"></i>
      </button>
    </header>

    <div class="phoneBook-search">
      <input
        class="phoneBook-search-form"
        type="text"
        placeholder="전화번호 또는 소속을 입력해주세요"
        @input="searchPhone($event)"
      />
      <i class="ic-search"></i>
    </div>

    <div class="phoneBook-list-header">
      <span>소속</span>
      <span>세부소속</span>
      <span>전화번호</span>
    </div>

    <ul class="phoneBook-list">
      <li
        v-for="(phone, index) in phoneList"
        :key="index"
        class="phoneBook-item"
      >
        <span>{{ phone.department }}</span>
        <span>{{ phone.department_detail }}</span>
        <span>
          <a :href="phone.phone">{{ phone.phone }}</a>
        </span>
      </li>
    </ul>
  </aside>
</template>

<script>
import phone from "@/assets/data/phone.json";

const phoneList = phone;

export default {
  props: {
    isOpenPhoneBook: Boolean,
  },

  data() {
    return {
      phoneList,
    };
  },

  methods: {
    clickCloseButton() {
      this.$emit("alertClosePhoneBook");
    },

    searchPhone(event) {
      console.log(event.target.value);

      for (let i = 0; i < this.phoneList.length; i++) {
        if (
          this.phoneList[i].phone.includes(event.target.value) === false &&
          this.phoneList[i].department.includes(event.target.value) === false &&
          this.phoneList[i].department_detail.includes(event.target.value) ===
            false
        ) {
          document.querySelectorAll(".phoneBook-item")[i].style.display =
            "none";
        } else {
          document.querySelectorAll(".phoneBook-item")[i].style.display =
            "flex";
        }
      }
    },
  },
};
</script>

<style></style>
