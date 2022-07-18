<template>
  <aside class="search-modal" :class="{ 'is-active': isActive }">
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <header class="search-modal-header">
            <button class="back-button" type="button" @click="closeSearchModal">
              <img src="../assets/icon-caret.png" alt="뒤로가기" />
            </button>
            <h1>위치 검색하기</h1>
          </header>

          <div class="button-group">
            <button class="gps-button" type="button">
              <h2>GPS 현재 위치</h2>
              <div class="button-icon" aria-hidden>
                <img src="../assets/icon-gps.png" alt="" />
              </div>
            </button>

            <div class="direct-search" :class="{ 'is-open': isOpen }">
              <button
                class="display-button"
                type="button"
                @click="openSearchForm"
              >
                <h2>직접 위치 검색</h2>
                <div class="button-icon" aria-hidden>
                  <img src="../assets/icon-caret.png" alt="" />
                </div>
              </button>

              <div class="search-form">
                <div class="input-group">
                  <input type="text" placeholder="시/도" />
                  <input type="text" placeholder="시/군/구" />
                  <input type="text" placeholder="동/읍/면" />
                </div>

                <button class="search-button" type="button">검색하기</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </aside>
</template>

<script>
export default {
  name: "SearchModal",
  props: {
    isActive: Boolean,
  },
  data() {
    return {
      isOpen: false,
    };
  },
  methods: {
    openSearchForm() {
      this.isOpen = !this.isOpen;
    },
  },
};
</script>
