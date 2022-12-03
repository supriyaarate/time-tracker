import React, { useEffect } from "react";
import Body from "../../components/Body/Body";
import Header from "../../components/Header/Header";
import { axiosGet } from "../../utils/axiosService";
import { useDispatch } from "react-redux";
import { SET_CONFIG } from "../../redux/reducer/Config/configActionType";
const HomePage = () => {
  const dispatch = useDispatch();
  const fetchConfigData = async () => {
    let authTokens = localStorage.getItem("token");
    try {
      let getConfig = await axiosGet("config", authTokens);
      const apiList = getConfig.data.response.apiList;
      const userInfo = getConfig.data.response.userInfo;
      dispatch({
        type: SET_CONFIG,
        payload: {
          apiList,
          userInfo,
        },
      });
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchConfigData();
  }, []);

  return (
    <>
      <Header />
      <Body />
    </>
  );
};

export default HomePage;
