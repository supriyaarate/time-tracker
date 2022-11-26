import React, { useState } from "react";
import { VscArrowSmallRight } from "react-icons/vsc";
// import TextInput from "../../components/Input/TextInput";
// import Btn from "../../components/Button/Btn";
// import Text from "../../components/Text/Text";
// import TextLink from "../../components/Link/TextLink";
import "./../../translations/i18n";
import { useTranslation } from "react-i18next";
import { SET_AUTH } from "../../redux/reducer/Auth/authActionType";
import { useDispatch } from "react-redux";
import { Button, TextField, Typography } from "@mui/material";
// import Link from "@mui/material";
import axios from "../../utils/axiosCustomize";

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
      const { data } = await axios.post("authenticate", loginData);
      if (data && data.token) {
        localStorage.setItem("token", data.token);
        localStorage.setItem("username", loginData.username);
        dispatch({
          type: SET_AUTH,
          payload: {
            token: data.token,
            username: loginData.username,
            loading: false,
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
      <Typography
        id="login-text"
        name="login-text"
        variant="h4"
        component="div"
        text="Login"
      />
      <TextField
        id="username"
        name="username"
        label={t("username")}
        variant="outlined"
        type="text"
        onChange={handleOnChange}
      />
      <TextField
        id="password"
        name="password"
        label={t("password")}
        variant="outlined"
        type="password"
        onChange={handleOnChange}
      />
      <Button
        id="login-btn"
        name="login-btn"
        text={t("login")}
        size="medium"
        endIcon={<VscArrowSmallRight />}
        variant="outlined"
        onClick={loginAPI}
      />

      <div>
        <Typography text={t("donthaveaccout")} variant="caption" />
      </div>
      {/* <div>
        <Link text={t("signuphere")} variant="caption" url="www.google.com" />
      </div> */}
    </div>
  );
};

export default Login;
