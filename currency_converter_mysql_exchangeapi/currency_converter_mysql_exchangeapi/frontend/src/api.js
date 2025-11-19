import axios from "axios";

// ------------------- Client APIs -------------------
const CLIENT_API_URL = "http://127.0.0.1:8000/user";

export const clientRegister = (email, password) =>
  axios.post(`${CLIENT_API_URL}/register`, { email, password });

export const clientLogin = (email, password) =>
  axios.post(`${CLIENT_API_URL}/login`, { email, password });

export const clientConvert = (token, from_currency, to_currency, amount) =>
  axios.post(`${CLIENT_API_URL}/convert`, 
    { from_currency, to_currency, amount },
    { headers: { Authorization: `Bearer ${token}` } }
  );

export const clientGetConversions = (token) =>
  axios.get(`${CLIENT_API_URL}/conversions`, {
    headers: { Authorization: `Bearer ${token}` },
  });

  export const clientForgotPassword = (email) =>
  axios.post(`${CLIENT_API_URL}/forgot-password`, { email });

export const clientResetPassword = (token, newPassword) =>
  axios.post(`${CLIENT_API_URL}/reset-password`, {
    token,
    new_password: newPassword
  });




// ------------------- Admin APIs -------------------
const ADMIN_API_URL = "http://127.0.0.1:8000/admin";

export const adminLogin = (email, password) =>
  axios.post(`${ADMIN_API_URL}/login`, { email, password });

export const adminGetConversions = (token) =>
  axios.get(`${ADMIN_API_URL}/conversions`, {
    headers: { Authorization: `Bearer ${token}` },
  });
export const adminDeleteConversion = (id, token) =>
  axios.delete(`http://127.0.0.1:8000/delete_conversion/${id}`, {
    headers: { Authorization: `Bearer ${token}` },
  });


// export const adminDeleteConversion = (token, logId) =>
//   axios.delete(`${ADMIN_API_URL}/delete_conversion/${logId}`, {
//     headers: { Authorization: `Bearer ${token}` },
//   });



// import axios from "axios";

// const API_URL = "http://127.0.0.1:8000/user";
// // const API_URL = "http://127.0.0.1:8000/auth";

// export const register = (email, password) => axios.post(`${API_URL}/register`, { email, password });
// export const login = (email, password) => axios.post(`${API_URL}/login`, { email, password });
// export const convert = (token, from_currency, to_currency, amount) =>
//   axios.post(`${API_URL}/convert`, { from_currency, to_currency, amount }, { headers: { Authorization: `Bearer ${token}` } });
// export const getConversions = (token) =>
//   axios.get(`${API_URL}/conversions`, { headers: { Authorization: `Bearer ${token}` } });
