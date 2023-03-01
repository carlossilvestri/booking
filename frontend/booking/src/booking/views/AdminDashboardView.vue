<template>
  <layout-background>
    <v-container class="bg-surface-variant">
      <v-row no-gutters>
        <v-col cols="12">
          <v-btn icon @click="goTo('/login')">
            <v-icon>mdi-arrow-left</v-icon>
          </v-btn>
        </v-col>
        <v-col cols="12">
          <booking-data-table />
        </v-col>
      </v-row>
    </v-container>
  </layout-background>
</template>
<script>
import LayoutBackground from "@/common/components/layouts/LayoutBackground.vue";
import BookingDataTable from "@/booking/components/BookingDataTable.vue";

export default {
  name: "AdminDashboardView",
  components: { LayoutBackground, BookingDataTable },
  methods: {
    goTo(route) {
      this.$router.push(route);
    },
  },
};
</script>
