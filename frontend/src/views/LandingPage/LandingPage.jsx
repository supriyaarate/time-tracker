import React from "react";

import Grid from "@mui/material/Grid";
import Login from "../Login/Login";
import "./../../translations/i18n";
import { useTranslation } from "react-i18next";

const LandingPage = () => {
  const { t } = useTranslation();

  return (
    <Grid container spacing={2} columns={16}>
      <Grid item xs={8}>
        <p>{t("hi")}</p>
      </Grid>
      <Grid item xs={8}>
        <Login />
      </Grid>
    </Grid>
  );
};

export default LandingPage;
