import axiosInstance from "@/common/plugins/axios";

export default {
  async createUser(payload) {
    try {
      if (!payload) return;
      const { data } = await axiosInstance.post("/auth/register", payload);
      return data;
    } catch (error) {
      console.log(error);
    }
  },
  async createBooking(payload) {
    try {
      if (!payload) return;
      const { data } = await axiosInstance.post("/booking/create", payload);
      return data;
    } catch (error) {
      console.log(error);
    }
  },
  async get(payload) {
    try {
      if (!payload) return;
      const { data } = await axiosInstance.get(`/booking${payload}`);
      return data;
    } catch (error) {
      console.log(error);
    }
  },
  async modify(payload) {
    try {
      if (!payload) return;
      const { data } = await axiosInstance.patch(
        `/booking/${payload.id}`,
        payload.payload
      );
      return data;
    } catch (error) {
      console.log(error);
    }
  },
};
