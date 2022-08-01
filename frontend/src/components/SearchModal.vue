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
                    <button
                      class="dropdown-toggle"
                      :class="{ 'is-active': isSelected[0] }"
                      type="button"
                      @click="toggleDropdown(0)"
                    >
                      {{ selectedState }}
                    </button>

                    <ul
                      class="dropdown-menu"
                      :class="{ 'is-open': isOpenDropdown[0] }"
                    >
                      <li
                        class="dropdown-option"
                        v-for="data in state"
                        :key="data"
                      >
                        <button type="button" @click="selectState(data)">
                          {{ data }}
                        </button>
                      </li>
                    </ul>
                  </div>

                  <div class="dropdown">
                    <button
                      class="dropdown-toggle"
                      :class="{ 'is-active': isSelected[1] }"
                      type="button"
                      @click="toggleDropdown(1)"
                    >
                      {{ selectedCity }}
                    </button>

                    <ul
                      class="dropdown-menu"
                      :class="{ 'is-open': isOpenDropdown[1] }"
                    >
                      <li
                        class="dropdown-option"
                        v-for="data in city"
                        :key="data"
                      >
                        <button type="button" @click="selectCity(data)">
                          {{ data }}
                        </button>
                      </li>
                    </ul>
                  </div>

                  <div class="dropdown">
                    <button
                      class="dropdown-toggle"
                      :class="{ 'is-active': isSelected[2] }"
                      type="button"
                      @click="toggleDropdown(2)"
                    >
                      {{ selectedTown }}
                    </button>

                    <ul
                      class="dropdown-menu"
                      :class="{ 'is-open': isOpenDropdown[2] }"
                    >
                      <li
                        class="dropdown-option"
                        v-for="data in town"
                        :key="data"
                      >
                        <button type="button" @click="selectTown(data)">
                          {{ data }}
                        </button>
                      </li>
                    </ul>
                  </div>
                </div>

                <button
                  class="search-button"
                  type="button"
                  @click="selectPlaceAll"
                >
                  검색하기
                </button>
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
    placeState: Array,
    placeCity: Array,
    placeTown: Array,
  },
  data() {
    return {
      isOpen: false,
      isOpenDropdown: [false, false, false],
      selectedState: "시/도",
      selectedCity: "시/군/구",
      selectedTown: "동/읍/면",
      state: this.placeState,
      city: this.placeCity,
      town: this.placeTown,
      isSelected: [false, false, false],
    };
  },
  methods: {
    closeSearchModal() {
      this.$emit("closeModal");
    },
    openSearchForm() {
      this.isOpen = !this.isOpen;
    },
    toggleDropdown(num) {
      this.isOpenDropdown[num] = !this.isOpenDropdown[num];
    },
    selectState(item) {
      this.selectedState = item;
      this.toggleDropdown(0);
      this.isSelected[0] = !this.isSelected[0];
    },
    selectCity(item) {
      this.selectedCity = item;
      this.toggleDropdown(1);
      this.isSelected[1] = !this.isSelected[1];
    },
    selectTown(item) {
      this.selectedTown = item;
      this.toggleDropdown(2);
      this.isSelected[2] = !this.isSelected[2];
    },
    selectPlaceAll() {
      console.log(this.selectedCity, this.selectedTown);
      this.$emit("selectPlace", this.selectedCity, this.selectedTown);
      this.$emit("closeModal");
    },
  },
};
</script>
