import React from "react";

import Grid from "@mui/material/Grid";
import Login from "../Login/Login";

const LandingPage = () => {
  return (
    <Grid container spacing={2} columns={16}>
      <Grid item xs={8}>
        <p>Hi</p>
      </Grid>
      <Grid item xs={8}>
        <Login />
      </Grid>
    </Grid>
  );
};

export default LandingPage;
