export const rulesForm = () => ({
  required: (value) =>
    (Array.isArray(value) ? value.length > 0 : !!value) || `Field is required`,
  min: (value, min) =>
    (value && value.length >= min) || `Minimum value is ${min}`,
  max: (value, max) =>
    (value && value.length <= max) || `Maximum value is ${max}`,
  email: (value) => /.+@.+\..+/.test(value) || `Not valid email address`,
  oneDigit: (value) => (value && /\d/.test(value)) || "At least one digit",
  oneCapitalize: (value) =>
    (value && /[A-Z]{1}/.test(value)) || "At least one capital latter",
  oneSpecialCharacter: (value) =>
    (value && /[^A-Za-z0-9]/.test(value)) || "At least one special character",
  phone: (value) => {
    const regex = /^\(?([0-9]{4})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
    return regex.test(value) || "Invalid number phone";
  },
  number: (v) => parseFloat(v) > 0 || "Number has required",
});
