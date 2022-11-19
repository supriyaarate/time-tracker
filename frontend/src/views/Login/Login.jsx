import React, { useState } from "react";
import axios from "axios";
import { VscArrowSmallRight } from "react-icons/vsc";
import TextInput from "../../components/Input/TextInput";
import Btn from "../../components/Button/Btn";
import Text from "../../components/Text/Text";
import TextLink from "../../components/Link/TextLink";
import "./../../translations/i18n";
import { useTranslation } from "react-i18next";
import { API_URL } from "../../config/constants.js";
import { SET_AUTH } from "../../redux/reducer/Auth/authActionType";
import { useDispatch } from "react-redux";
const Login = () => {
  const { t } = useTranslation();
  const dispatch = useDispatch();
  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });

  const loginAPI = async (e) => {
    try {
      e.preventDefault();
      const { data } = await axios.post(`${API_URL}/authenticate`, loginData);
      if (data && data.token) {
        localStorage.setItem("token", data.token);
        localStorage.setItem("username", loginData.username);
        dispatch({
          type: SET_AUTH,
          payload: {
            token: data.token,
            username: loginData.username,
          },
        });
      }
    } catch (error) {
      console.log(error);
    }
  };

  const handleOnChange = (e) => {
    setLoginData((prevState) => ({
      ...prevState,
      [e.target.name]: e.target.value,
    }));
  };

  return (
    <div>
      <Text
        id="login-text"
        name="login-text"
        variant="h4"
        component="div"
        text="Login"
      />
      <TextInput
        id="username"
        name="username"
        label={t("username")}
        variant="outlined"
        type="text"
        onChange={handleOnChange}
      />
      <TextInput
        id="password"
        name="password"
        label={t("password")}
        variant="outlined"
        type="password"
        onChange={handleOnChange}
      />
      <Btn
        id="login-btn"
        name="login-btn"
        text={t("login")}
        size="medium"
        endIcon={<VscArrowSmallRight />}
        variant="outlined"
        onClick={loginAPI}
      />

      <div>
        <Text text={t("donthaveaccout")} variant="caption" />
      </div>
      <div>
        <TextLink
          text={t("signuphere")}
          variant="caption"
          url="www.google.com"
        />
      </div>
    </div>
  );
};

export default Login;
