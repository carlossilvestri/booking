<template>
  <v-card>
    <v-card-title>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="bookings"
      :search="search"
      :loading="isLoading"
    >
      <template v-slot:[`item.date`]="{ item }">
        <span>{{ item.date | DATE_DD_MM_YYYY }}</span>
      </template>
      <template v-slot:[`item.actions`]="{ item }">
        <v-menu bottom left v-if="item.status == 'CREATED'">
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">
              <slot name="trigger">
                <v-btn icon v-bind="attrs" v-on="on">
                  <v-icon>mdi-dots-vertical</v-icon>
                </v-btn>
              </slot>
            </span>
          </template>
          <v-list>
            <v-list-item
              class="d-flex flex-row align-center"
              @click="onClickItem(item)"
            >
              <v-list-item-icon>
                <v-icon>mdi-check-all</v-icon>
              </v-list-item-icon>
              <v-list-item-title>Confirm</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </template>
    </v-data-table>
  </v-card>
</template>

<script>
import bookingService from "@/booking/services/booking.service.js";

export default {
  data() {
    return {
      isLoading: false,
      search: "",
      headers: [
        {
          text: "Name",
          align: "start",
          filterable: true,
          value: "name",
        },
        { text: "Lastname", value: "lastname", filterable: true },
        { text: "Type of document", value: "type_of_document" },
        { text: "Identification", value: "identification" },
        { text: "Email", value: "email" },
        { text: "Status", value: "status" },
        { text: "Date", value: "date" },
        { text: "type of reserve", value: "type_of_reserve" },
        { text: "Quantity person", value: "quantity_person" },
        { text: "Description", value: "description" },
        { text: "", value: "actions" },
      ],
      bookings: [],
    };
  },
  methods: {
    async onClickItem(item) {
      const payload = { id: item.id, payload: { status: "CONFIRMED" } };
      await bookingService.modify(payload);
      await this.init();
    },
    async getData() {
      this.isLoading = true;
      const { content } = await bookingService.get("?page=0&size=20&sort=id");
      if (content) {
        this.bookings = content;
      }
      this.isLoading = false;
    },
    async init() {
      await Promise.all([this.getData()]);
    },
  },
  async mounted() {
    await this.init();
  },
};
</script>
<style scoped lang="scss"></style>
