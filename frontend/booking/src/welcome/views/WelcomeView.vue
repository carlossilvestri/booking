<template>
  <layout-background>
    <login-form />
  </layout-background>
</template>
<script>
import LoginForm from "@/welcome/components/LoginForm.vue";
import LayoutBackground from "@/common/components/layouts/LayoutBackground.vue";

export default {
  name: "WelcomeView",
  components: { LoginForm, LayoutBackground },
};
</script>
