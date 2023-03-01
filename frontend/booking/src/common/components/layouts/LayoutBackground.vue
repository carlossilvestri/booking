<template>
  <div class="cont-card">
    <section class="d-flex align-center justify-center">
      <slot></slot>
    </section>
  </div>
</template>

<script>
export default {
  name: "LayoutBackground",
  props: {},
};
</script>

<style lang="scss" scoped>
.cont-card {
  // min-height: 100vh;
  height: 100%;
  background: $color-neutral-100;
  display: flex;
  justify-content: center;
  align-items: center;
}
.vh-100 {
  height: 100vh;
}
</style>
