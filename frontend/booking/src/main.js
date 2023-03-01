import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Vuetify from "vuetify";
import "@mdi/font/css/materialdesignicons.css";
import { DATE_DD_MM_YYYY } from "@/common/filters/dates";
Vue.use(Vuetify);

Vue.config.productionTip = false;

Vue.filter("DATE_DD_MM_YYYY", DATE_DD_MM_YYYY);

new Vue({
  router,
  vuetify: new Vuetify(),
  render: (h) => h(App),
}).$mount("#app");
