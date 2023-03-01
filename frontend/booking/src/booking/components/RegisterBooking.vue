<template>
  <v-form
    ref="form"
    class="cont-form-register d-flex flex-column align-center"
    v-model="valid"
  >
    <h1 class="text-uppercase neutral--text text--darken-1">
      Create a booking
    </h1>
    <v-container
      class="pa-0 ma-0 d-flex flex-column align-center justify-start"
    >
      <v-text-field
        v-model="form.name"
        class="text-field-custom pt-4"
        :rules="required"
        label="Name"
        type="text"
      />
      <v-text-field
        v-model="form.lastname"
        class="text-field-custom pt-4"
        :rules="required"
        label="Lastname"
        type="text"
      />
      <v-text-field
        v-model="form.type_of_document"
        class="text-field-custom pt-4"
        :rules="required"
        label="Type of Document"
        type="text"
      />
      <v-text-field
        v-model="form.identification"
        class="text-field-custom pt-4"
        :rules="required"
        label="Identification"
        type="text"
      />
      <v-text-field
        v-model="form.email"
        class="text-field-custom pt-4"
        :rules="emailRules"
        label="Email"
        type="email"
      />
      <v-select
        label="Select"
        class="text-field-custom pt-4"
        v-model="form.type_of_reserve"
        :items="['Cena', 'Almuerzo', 'Onces', 'Cumpleaños', 'Ocasión_especial']"
      ></v-select>
      <v-text-field
        v-model="form.quantity_person"
        class="text-field-custom pt-4"
        :rules="required"
        label="Quantity person"
        min="1"
        type="number"
      />
      <div class="d-flex w-100">
        <text-field-date-picker
          v-model="form.date"
          label="Date of booking"
          :rules="required"
        />
      </div>
      <v-textarea
        label="Description"
        v-model="form.description"
        class="text-field-custom pt-4"
        :rules="required"
      ></v-textarea>
    </v-container>
    <router-link class="link-app" to="/login">Login </router-link>
    <div class="cont-btn">
      <v-btn color="#b0853b" block label="Login" @click="onCreateBooking"
        >Book</v-btn
      >
    </div>
  </v-form>
</template>

<script>
import { rulesForm } from "@/common/utils/rulesForm.utils";
import TextFieldDatePicker from "@/common/components/datepickers/TextFieldDatePicker.vue";
import bookingService from "@/booking/services/booking.service.js";
import Swal from "sweetalert2";
const { required, email } = rulesForm();

export default {
  name: "RegisterBooking",
  data: () => ({
    form: {
      name: "",
      lastname: "",
      type_of_document: "",
      identification: "",
      email: "",
      date: "",
      type_of_reserve: "",
      quantity_person: null,
      description: "",
    },
    valid: false,
    emailRules: [required, email],
    required: [required],
  }),
  components: { TextFieldDatePicker },
  methods: {
    /**
     * onCreateBooking() : void
     * When user clicks "Booking" button
     */
    async onCreateBooking() {
      const isValid = this.$refs.form.validate();
      if (!isValid) return;
      const data = await bookingService.createBooking(this.form);
      if (data?.active) {
        Swal.fire("Booking created!", "Now, wait to be confirmed", "success");
        setTimeout(() => {
          this.$refs.form.reset();
        }, 3000);
      }
    },
  },
};
</script>

<style scoped lang="scss">
.text-field-custom {
  width: 454px;
  // margin: 20px 0;
  @media (max-width: 650px) {
    width: 70vw;
  }
}

.cont-btn {
  width: 456px;
  height: 44px !important;
  font-size: 16px;
  line-height: 24px;
  @media (max-width: 650px) {
    width: 70vw;
  }
}

.cont-form-register {
  width: 552px;
  background: $white;
  border-radius: 2px;
  @media (max-width: 650px) {
    width: 90vw;
  }

  h1 {
    padding-top: 10px;
    padding-bottom: 27px;
    font-size: 24px;
    font-family: $primary-font;
    font-style: normal;
    font-weight: 600;
    font-size: 24px;
    line-height: 32px;
  }

  .link-app {
    font-family: $secondary-font;
    font-style: normal;
    font-weight: 400;
    font-size: 14px;
    line-height: 17px;
    text-align: center;
    text-decoration-line: underline;
    color: $neutral-darken1;
    margin: 24px 0 19px 0;
  }
}
</style>
