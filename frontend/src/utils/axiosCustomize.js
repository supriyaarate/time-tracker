import axios from "axios";

let authTokens = localStorage.getItem("token")
  ? JSON.parse(JSON.stringify(localStorage.getItem("token")))
  : null;

// console.log(authTokens);

const instance = axios.create({
  baseURL: "http://localhost:8080/",
  headers: { Authorization: `Bearer ${authTokens}` },
});

export default instance;
