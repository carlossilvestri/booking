import Vue from "vue";
import Router from "vue-router";
Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/login",
      name: "",
      component: () =>
        import(
          /* webpackChunkName: "WelcomeView" */ "./welcome/views/WelcomeView.vue"
        ),
    },
    {
      path: "/register",
      name: "",
      component: () =>
        import(
          /* webpackChunkName: "WelcomeView" */ "./welcome/views/RegisterView.vue"
        ),
    },
    {
      path: "/dashboard",
      name: "",
      component: () =>
        import(
          /* webpackChunkName: "WelcomeView" */ "./booking/views/AdminDashboardView.vue"
        ),
    },
    {
      path: "/",
      name: "",
      component: () =>
        import(
          /* webpackChunkName: "RegisterView" */ "./booking/views/RegisterBookingView.vue"
        ),
    },
    { path: "*", redirect: "/" },
  ],
});
