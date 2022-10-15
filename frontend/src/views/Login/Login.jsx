import React, { useEffect, useState } from "react";

import axios from "axios";
import { VscArrowSmallRight } from "react-icons/vsc";

import TextInput from "../../components/Input/TextInput";
import Btn from "../../components/Button/Btn";
import Text from "../../components/Text/Text";
import TextLink from "../../components/Link/TextLink";

const Login = () => {

  const [token, setToken] = useState(null);
  const [success, setSuccess] = useState(false);
  
  const [loginData, setLoginData] = useState( {
    username: "",
    password: ""
  })
  
  const loginAPI = async (e) => {
      e.preventDefault();
      const {data} = await axios.post("http://localhost:8080/authenticate" , loginData);
      setToken(data.token);
      setSuccess(true);
  }

  const handleOnChange = (e) => {
      setLoginData (prevState => ({...prevState ,[e.target.name] : e.target.value}))
  }
  

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
        label="username" 
        variant="outlined" 
        type="text" 
        onChange={handleOnChange} />
      <TextInput
        id="password"
        name="password" 
        label="password"
        variant="outlined"
        type="password"
        onChange={handleOnChange}
      />
      <Btn
        id="login-btn"
        name="login-btn"
        text="Login"
        size="medium"
        endIcon={<VscArrowSmallRight />}
        variant="outlined"
        onClick={loginAPI}
      />

      <div>
        <Text text="Don't have an account yet?" variant="caption" />
      </div>
      <div>
        <TextLink text="Sign up Here" variant="caption" url="www.google.com" />
      </div>
    </div>
  );
};

export default Login;
