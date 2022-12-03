import axios from "./axiosCustomize";

export const axiosGet = async (url, token = null) => {
  const data = await axios.get(url, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
  return data;
};

export const axiosPost = async (url, data, token = null) => {
  const result = await axios.post(url, data, {
    headers: { Authorization: `Bearer ${token}` },
  });
  return result;
};
