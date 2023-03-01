<template>
  <layout-background>
    <register-form />
  </layout-background>
</template>
<script>
import RegisterForm from "@/welcome/components/RegisterForm.vue";
import LayoutBackground from "@/common/components/layouts/LayoutBackground.vue";

export default {
  name: "WelcomeView",
  components: { RegisterForm, LayoutBackground },
};
</script>
