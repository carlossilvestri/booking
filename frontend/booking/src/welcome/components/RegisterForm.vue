<template>
  <v-form
    ref="form"
    class="cont-form-register d-flex flex-column align-center"
    v-model="valid"
  >
    <h1 class="text-uppercase neutral--text text--darken-1">Register</h1>
    <v-container
      class="pa-0 ma-0 d-flex flex-column align-center justify-start"
    >
      <v-text-field
        v-model="form.firstname"
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
        v-model="form.email"
        class="text-field-custom pt-4"
        :rules="emailRules"
        label="Email"
        type="email"
      />
      <v-text-field
        v-model="form.password"
        class="text-field-custom pt-4"
        :rules="required"
        label="Password"
        type="password"
      />
    </v-container>

    <router-link class="link-app" :to="'/login'"
      >Do you already have an account? Login
    </router-link>
    <div class="cont-btn">
      <v-btn color="#b0853b" block label="Login" @click="onRegister"
        >Register</v-btn
      >
    </div>
  </v-form>
</template>

<script>
import { rulesForm } from "@/common/utils/rulesForm.utils";
import bookingService from "@/booking/services/booking.service.js";

const { required, email } = rulesForm();

export default {
  data: () => ({
    form: {
      firstname: "",
      lastname: "",
      email: "",
      password: "",
    },
    valid: false,
    emailRules: [required, email],
    required: [required],
  }),
  components: {},
  methods: {
    /**
     * onLogin() : void
     * When user clicks "Ingresar / Login" button
     */
    async onRegister() {
      const isValid = this.$refs.form.validate();
      if (!isValid) return;

      const data = await bookingService.createUser(this.form);
      if (data?.token) {
        // !TODO: Redirigir al dashboard
        this.$router.push("/login");
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
