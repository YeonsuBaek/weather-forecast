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
                <div class="dropdown-group">
                  <div class="dropdown">
                    <button class="dropdown-toggle" type="button">시/도</button>

                    <ul class="dropdown-menu">
                      <li class="dropdown-option">
                        <button type="button">서울특별시</button>
                      </li>
                      <li class="dropdown-option">
                        <button type="button">경기도</button>
                      </li>
                      <li class="dropdown-option">
                        <button type="button">대전광역시</button>
                      </li>
                      <li class="dropdown-option">
                        <button type="button">부산광역시</button>
                      </li>
                    </ul>
                  </div>

                  <div class="dropdown">
                    <button class="dropdown-toggle" type="button">
                      시/군/구
                    </button>

                    <ul class="dropdown-menu">
                      <li class="dropdown-option">
                        <button type="button">수원시권선구</button>
                      </li>
                    </ul>
                  </div>

                  <div class="dropdown">
                    <button class="dropdown-toggle" type="button">
                      동/읍/면
                    </button>

                    <ul class="dropdown-menu">
                      <li class="dropdown-option">
                        <button type="button">금곡동</button>
                      </li>
                    </ul>
                  </div>
                  <!-- <input type="text" placeholder="시/도" />
                  <input type="text" placeholder="시/군/구" />
                  <input type="text" placeholder="동/읍/면" /> -->
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
    closeSearchModal() {
      this.$emit("closeModal");
    },
    openSearchForm() {
      this.isOpen = !this.isOpen;
    },
  },
};
</script>
