import axiosInstance from "@/common/plugins/axios";
export default {
  /**
   * Authenticate the user.
   * @param { email: string, password: string} : payload
   * @returns { token: string}
   */
  async login(payload) {
    try {
      if (!payload) return;
      const { data } = await axiosInstance.post("/auth/authenticate", payload);
      if (data?.token) {
        localStorage.setItem("access_token", data.token);
      }
      return data;
    } catch (error) {
      console.log(error);
    }
  },
};
