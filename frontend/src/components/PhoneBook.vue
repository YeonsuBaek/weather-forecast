<template>
  <aside class="phoneBook-modal" :class="weather">
    <button class="phoneBook-button lg-only" type="button">
      <h2 class="phoneBook-title">한신대학교 전화번호부</h2>
      <i class="ic-call"></i>
    </button>

    <main class="phoneBook" :class="{ 'is-open': isOpenPhoneBook }">
      <header class="phoneBook-header lg-hidden">
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
          <button
            class="phoneBook-detail-button"
            type="button"
            @click="openPhoneBookDetail(index)"
          >
            <span>{{ phone.department }}</span>
            <span>{{ phone.department_detail }}</span>
            <span>{{ phone.phone }}</span>
          </button>

          <aside class="phoneBook-detail">
            <button
              class="close-button lg-only"
              type="button"
              @click="closePhoneBookDetail"
            >
              <i class="ic-close"></i>
            </button>
            <dl class="phoneBook-detail-list">
              <div class="phoneBook-detail-item">
                <dt>소속</dt>
                <dd>{{ phone.department }}</dd>
              </div>
              <div class="phoneBook-detail-item">
                <dt>세부소속</dt>
                <dd>{{ phone.department_detail }}</dd>
              </div>
              <div class="phoneBook-detail-item">
                <dt>이름</dt>
                <dd>{{ phone.name }}</dd>
              </div>
              <div class="phoneBook-detail-item phone">
                <dt>전화번호</dt>
                <dd>
                  <a :href="phone.phone">{{ phone.phone }}</a>
                </dd>
              </div>
              <div class="phoneBook-detail-item">
                <dt>실번호</dt>
                <dd>{{ phone.room }}</dd>
              </div>
            </dl>
          </aside>
        </li>
      </ul>

      <div
        class="overlay"
        :class="{ 'is-active': openDetail }"
        @click="closePhoneBookDetail"
      ></div>
    </main>
  </aside>
</template>

<script>
import phone from "@/assets/data/phone.json";

const phoneList = phone;

export default {
  props: {
    isOpenPhoneBook: Boolean,
    weather: String,
  },

  data() {
    return {
      phoneList,
      openDetail: false,
    };
  },

  methods: {
    clickCloseButton() {
      this.$emit("alertClosePhoneBook");
    },

    searchPhone(event) {
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

    openPhoneBookDetail(idx) {
      this.openDetail = true;
      const phoneBookDetail =
        document.querySelectorAll(".phoneBook-detail")[idx];
      phoneBookDetail.classList.add("is-active");
    },

    closePhoneBookDetail() {
      this.openDetail = false;
      document
        .querySelector(".phoneBook-detail.is-active")
        .classList.remove("is-active");
    },
  },
};
</script>

<style></style>
