import axios from "axios";

let authTokens = localStorage.getItem("token")
  ? localStorage.getItem("token")
  : null;

const instance = axios.create({
  baseURL: "http://localhost:8080/",
  headers: {
    Authorization: `Bearer ${authTokens}`,
    "Cache-Control": "no-cache",
    "Content-Type": "application/json",
  },
});

export default instance;
