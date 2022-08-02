<template>
  <header class="header">
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <button class="location" type="button" @click="openSearchModal">
            <h1 class="location-name">
              {{ location }}
            </h1>
            <strong class="location-weather">{{ weather }}</strong>
          </button>
        </div>
      </div>
    </div>

    <SearchModal
      :isActiveSearchModal="isActiveSearchModal"
      @closeModal="closeActiveModal"
      :placeState="placeState"
      :placeCity="placeCity"
      :placeTown="placeTown"
      @selectPlace="viewPlaceName"
    />
  </header>
</template>

<script>
import SearchModal from "./SearchModal.vue";
import PlaceState from "@/assets/data/state.json";
import PlaceCity from "@/assets/data/city.json";
import PlaceTown from "@/assets/data/town.json";

const placeState = PlaceState;
const placeCity = PlaceCity;
const placeTown = PlaceTown;

export default {
  name: "GlobalHeader",
  components: {
    SearchModal,
  },
  props: {
    weather: String,
  },
  data() {
    return {
      isActiveSearchModal: false,
      location: "수원시 금곡동",
      placeState,
      placeCity,
      placeTown,
    };
  },
  methods: {
    openSearchModal() {
      this.isActiveSearchModal = !this.isActiveSearchModal;
    },
    closeActiveModal() {
      this.isActiveSearchModal = !this.isActiveSearchModal;
    },
    viewPlaceName(city, town) {
      if (city !== "시/군/구" && town !== "동/읍/면") {
        this.location = `${city} ${town}`;
      }
    },
  },
};
</script>
