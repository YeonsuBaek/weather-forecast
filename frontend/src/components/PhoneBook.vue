<template>
  <aside class="phoneBook">
    <header class="phoneBook-header">
      <h2 class="title">한신대학교 전화번호부</h2>
      <button class="close-button" type="button">
        <i class="ic-close"></i>
      </button>
    </header>

    <div class="phoneBook-search">
      <input
        class="phoneBook-search-form"
        type="text"
        placeholder="전화번호 또는 소속을 입력해주세요"
      />
      <i class="ic-search"></i>
    </div>

    <div class="phoneBook-list-header">
      <span>소속</span>
      <span>세부소속</span>
      <span>전화번호</span>
    </div>

    <ul class="phoneBook-list">
      <li class="phoneBook-item">
        <span>한신학원</span>
        <span>이사장</span>
        <span>
          <a href="tel:031-379-0005">031-379-0005</a>
        </span>
      </li>

      <li class="phoneBook-item">
        <span>한신학원2</span>
        <span>이사장2</span>
        <span>
          <a href="tel:031-379-0006">031-379-0006</a>
        </span>
      </li>

      <li class="phoneBook-item">
        <span>한신학원3</span>
        <span>이사장3</span>
        <span>
          <a href="tel:031-379-0007">031-379-0007</a>
        </span>
      </li>
    </ul>
  </aside>
</template>

<script>
export default {};
</script>

<style></style>
