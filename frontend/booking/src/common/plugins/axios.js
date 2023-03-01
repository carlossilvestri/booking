import axios from "axios";

const requestInterceptorToken = (config) => {
  const token = localStorage.getItem("access_token");
  // config.headers["Content-Type"] = `application/json`;
  // config.headers["X-Requested-With"] = `XMLHttpRequest`;
  if (token) config.headers["Authorization"] = `Bearer ${token}`;
  return config;
};

const axiosInstance = axios.create({
  baseURL: process.env.VUE_APP_BACKEND_URL,
});
axiosInstance.interceptors.request.use(requestInterceptorToken);

export default axiosInstance;
