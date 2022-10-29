import React, { useState } from "react";

import axios from "axios";
import { VscArrowSmallRight } from "react-icons/vsc";

import TextInput from "../../components/Input/TextInput";
import Btn from "../../components/Button/Btn";
import Text from "../../components/Text/Text";
import TextLink from "../../components/Link/TextLink";
import "./../../translations/i18n";
import { useTranslation } from "react-i18next";

const Login = () => {
  const { t } = useTranslation();

  const [setToken] = useState(null);
  const [setSuccess] = useState(false);

  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });

  const loginAPI = async (e) => {
    e.preventDefault();
    const { data } = await axios.post(
      "http://localhost:8080/authenticate",
      loginData
    );
    setToken(data.token);
    setSuccess(true);
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
