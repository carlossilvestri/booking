<template>
  <layout-background>
    <register-booking />
  </layout-background>
</template>
<script>
import RegisterBooking from "@/booking/components/RegisterBooking.vue";
import LayoutBackground from "@/common/components/layouts/LayoutBackground.vue";

export default {
  name: "WelcomeView",
  components: { RegisterBooking, LayoutBackground },
};
</script>
