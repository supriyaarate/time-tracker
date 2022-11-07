import React from "react";
import "./App.css";
import LandingPage from "./views/LandingPage/LandingPage";
import { Routes, Route } from "react-router-dom";
import Login from "./views/Login/Login";
import HomePage from "./views/HomePage/HomePage";
const App = () => {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<HomePage />} />
      </Routes>
    </div>
  );
};

export default App;
