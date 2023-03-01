import moment from "moment";

export const datePrimary = (value, format = "LL") => {
  if (!value) return "";
  value = value.toString();
  return moment(value).format(format);
};

export const DATE_DD_MM_YYYY = (value) => {
  return datePrimary(value, "DD MMM YYYY");
};
