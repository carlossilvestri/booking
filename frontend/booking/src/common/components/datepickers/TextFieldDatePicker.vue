<template>
  <v-menu v-model="hasMenu" :close-on-content-click="false">
    <template v-slot:activator="{ on, attrs }">
      <v-text-field
        :value="dateFormat"
        clearable
        :label="label"
        prepend-icon="mdi-calendar"
        readonly
        v-bind="attrs"
        v-on="on"
        @click:clear="$emit('input', null)"
      ></v-text-field>
    </template>
    <v-date-picker
      :value="value"
      v-bind="$attrs"
      @change="onChangePicker"
      @input="onInputPicker"
    ></v-date-picker>
  </v-menu>
</template>

<script>
import moment from "moment";
// import { DATE_YYYY_MM_DD } from "@/utils/filters/dates";

export default {
  name: "TextFieldDatePicker",
  props: {
    label: String,
    value: String,
    startOf: String,
    endOf: String,
    format: {
      default: "YYYY-MM",
    },
  },
  data() {
    return {
      hasMenu: false,
    };
  },
  computed: {
    dateFormat() {
      return this.formattingDate(this.value, this.format);
    },
  },
  methods: {
    onChangePicker() {
      this.hasMenu = false;
    },
    onInputPicker(value) {
      this.$emit("input", this.formattingDate(value, "YYYY-MM-DD"));
    },
    formattingDate(date, format) {
      if (!date) return null;
      if (this.startOf)
        return moment(date).startOf(this.startOf).format(format);
      if (this.endOf) return moment(date).endOf(this.endOf).format(format);

      return date;
    },
  },
};
</script>

<style></style>
