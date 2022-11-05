import React, { useState } from "react";
import { Grid } from "@mui/material";
import { useTranslation } from "react-i18next";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DesktopDatePicker } from "@mui/x-date-pickers/DesktopDatePicker";
import "./../../translations/i18n";
import BasicCard from "../../components/Card/BasicCard";
import TextField from "@mui/material/TextField";
import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
// import Text from "../../components/Text/Text";
import TextInput from "../../components/Input/TextInput";
import Btn from "../../components/Button/Btn";

const Signup = () => {
  const { t } = useTranslation();

  const [value, setValue] = useState(new Date());

  const handleChange = (newValue) => {
    setValue(newValue);
  };

  return (
    <BasicCard>
      <Typography
        id="signup-text"
        name="signup-text"
        variant="h4"
        display="block"
        sx={{ p: "2px", m: "25px 5px 40px 10px" }}
      >
        {t("create_your_account")}
      </Typography>
      <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
        {/* First Row */}
        <Grid item xs={6}>
          <TextInput
            required
            id="firstname"
            name="firstname"
            label={t("firstname")}
            variant="outlined"
            type="text"
            // onChange={handleOnChange}
            defaultvalue={t("label_firstname")}
          />
        </Grid>
        <Grid item xs={6}>
          <TextInput
            required
            id="lastname"
            name="lastname"
            label={t("lastname")}
            variant="outlined"
            type="text"
            // onChange={handleOnChange}
            defaultvalue={t("label_lastname")}
          />
        </Grid>

        {/* Second Row */}
        <Grid item xs={6}>
          <TextInput
            required
            id="email"
            name="email"
            label={t("email")}
            variant="outlined"
            type="email"
            // onChange={handleOnChange}
            defaultvalue="Email@domain.com"
          />
        </Grid>
        <Grid item xs={6}>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DesktopDatePicker
              label={t("dob")}
              inputFormat="MM/DD/YYYY"
              value={value}
              onChange={handleChange}
              renderInput={(params) => (
                <div style={{ padding: "2px", margin: "5px" }}>
                  <TextField
                    sx={{
                      width: "350px",
                    }}
                    {...params}
                  />
                </div>
              )}
            />
          </LocalizationProvider>
        </Grid>

        {/* Third Row */}
        <Grid item xs={6}>
          <TextInput
            required
            id="password"
            name="password"
            label={t("password")}
            variant="outlined"
            type="password"
            // onChange={handleOnChange}
          />
        </Grid>
        <Grid item xs={6}>
          <TextInput
            required
            id="confirmpassword"
            name="confirmpassword"
            label={t("confirmpassword")}
            variant="outlined"
            type="password"
            // onChange={handleOnChange}
          />
        </Grid>
      </Grid>

      <Grid>
        {/* Button */}
        <Grid item align="center">
          <Btn
            id="signup"
            name="signup"
            text={t("createaccount")}
            size="large"
            variant="contained"
            color="info"
            // onClick={loginAPI}
          />
        </Grid>

        {/* Login Link */}
        <Grid item align="center">
          <Typography
            id="signup-login"
            name="signup-login"
            variant="subtitle2"
            component="div"
          >
            {t("already_account_login")}
            <Link href="#"> {t("login")} </Link>
          </Typography>
        </Grid>
      </Grid>
    </BasicCard>
  );
};

export default Signup;
