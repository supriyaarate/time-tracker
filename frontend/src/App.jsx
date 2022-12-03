import React from "react";
import "./App.css";
import HomePage from "./views/HomePage/HomePage";
// import Signup from "./views/Signup/Signup";
import Login from "../src/views/Login/Login";
import { useSelector } from "react-redux";

const App = () => {
  const { loggedIn } = useSelector((state) => state.auth.loginInfo);

  return (
    <div className="App">
      {/* <Signup /> */}
      {!loggedIn && !localStorage.getItem("token") ? <Login /> : <HomePage />}
    </div>
  );
};

export default App;
