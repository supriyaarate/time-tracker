import React, { useState } from "react";
import {
  Grid,
  // TextField,
  // Button,
  CardContent,
  Typography,
  Link,
} from "@mui/material";
import { useTranslation } from "react-i18next";
import "./../../translations/i18n";
//import { LocalizationProvider, DatePicker } from "@mui/x-date-pickers";
//import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { Box } from "@mui/system";
import BasicCard from "../../components/Card/BasicCard";
import TextInput from "../../components/Input/TextInput";
import Btn from "../../components/Button/Btn";
import { axiosPost } from "../../utils/axiosService";
import { useNavigate } from "react-router-dom";

const Signup = () => {
  const { t } = useTranslation();
  const navigate = useNavigate();

  // const [dobDate, setDobDate] = useState(new Date());
  const [signupData, setSignupData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    // dob: new Date(),
    username: "",
    password: "",
    confirmPassword: "",
  });

  const signupAPI = async (e) => {
    try {
      e.preventDefault();
      console.log("API CALLED");
      // const { data } = await axiosPost("authenticate", loginData);
      const { data } = await axiosPost("/public/registration", signupData);
      if (data.status == "200") {
        navigate("/login");
      }
    } catch (error) {
      console.log(error);
    }
  };

  const handleOnChange = (e) => {
    setSignupData((prevState) => ({
      ...prevState,
      [e.target.name]: e.target.value,
    }));
  };

  // const handleOnChangeDob = (newValue) => {
  //   setSignupData((prevState) => ({
  //     ...prevState,
  //     dob: newValue,
  //   }));
  // };

  // Styling objects
  // Text field styling
  const textInputStyle = {
    divStyle: { padding: "2px", margin: "5px" }, // this contains div styling
    sxStyle: { width: "350px" }, // (apply sx styling to textbox)
  };

  // Button Styling
  const btnStyle = {
    divStyle: { padding: "20px", margin: "10px" }, // this contains div styling
    sxStyle: { width: "70%", borderRadius: "15px", fontSize: 17 }, // (apply sx styling to button)
  };

  return (
    <BasicCard>
      <CardContent>
        <Typography
          sx={{ typography: { md: "h4", xs: "h5" } }}
          mb={5}
          mt={4}
          textAlign="left"
          color="#00687B"
        >
          {t("create_your_account")}
        </Typography>
        <Grid container rowSpacing={2} columnSpacing={3}>
          {/* first name */}
          <Grid item xs={12} sm={6}>
            <TextInput
              required
              id="firstname"
              name="firstName"
              label={t("firstname")}
              variant="outlined"
              type="text"
              onChange={handleOnChange}
              styleText={textInputStyle}
            />
          </Grid>
          {/* last name */}
          <Grid item xs={12} sm={6}>
            <TextInput
              required
              id="lastname"
              name="lastName"
              label={t("lastname")}
              variant="outlined"
              type="text"
              onChange={handleOnChange}
              styleText={textInputStyle}
            />
          </Grid>

          {/* Second Row */}
          <Grid item xs={12} sm={6}>
            <TextInput
              required
              id="email"
              name="email"
              label={t("email")}
              variant="outlined"
              type="email"
              onChange={handleOnChange}
              styleText={textInputStyle}
            />
          </Grid>
          <Grid item xs={12} sm={6}>
            {/* <LocalizationProvider dateAdapter={AdapterDayjs}>
                  <DesktopDatePicker
                    name="dob"
                    label={t("dob")}
                    inputFormat="MM/DD/YYYY"
                    value={signupData.dob}
                    onChange={handleOnChangeDob}
                    renderInput={(params) => (
                      <div style={textInputStyle.divStyle}>
                        <TextField
                          sx={{
                            width: "350px",
                          }}
                          {...params}
                        />
                      </div>
                    )}
                  />
                </LocalizationProvider> */}
            <TextInput
              required
              id="username"
              name="username"
              label={t("username")}
              variant="outlined"
              type="text"
              onChange={handleOnChange}
              styleText={textInputStyle}
            />
          </Grid>

          {/* Third Row */}
          <Grid item xs={12} sm={6}>
            <TextInput
              required
              id="password"
              name="password"
              label={t("password")}
              variant="outlined"
              type="password"
              onChange={handleOnChange}
              styleText={textInputStyle}
            />
          </Grid>
          <Grid item xs={12} sm={6}>
            <TextInput
              required
              id="confirmpassword"
              name="confirmPassword"
              label={t("confirmpassword")}
              variant="outlined"
              type="password"
              onChange={handleOnChange}
              styleText={textInputStyle}
            />
          </Grid>
        </Grid>

        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            mt: "30px",
          }}
        >
          <Btn
            id="signup"
            name="signup"
            text={t("createaccount")}
            size="large"
            variant="contained"
            color="info"
            btnStyle={btnStyle}
            onClick={signupAPI}
          />
          {/*<Button
              sx={{
                width: "80%",
                borderRadius: "15px",
                backgroundColor: "#00687B",
                "&:hover": {
                  backgroundColor: "#197788",
                },
              }}
              id="signup"
              name="signup"
              text="create account"
              variant="contained"
            >
              {t("createaccount")}
            </Button> */}
        </Box>
        <Typography
          id="signup-login"
          name="signup-login"
          variant="subtitle2"
          component="div"
          sx={{
            display: "flex",
            justifyContent: "center",
            marginTop: "20px",
          }}
        >
          {t("already_account_login")}
          <Link href="#" sx={{ color: "#00687B" }}>
            {t("login")}
          </Link>
        </Typography>
      </CardContent>
    </BasicCard>
  );
};

export default Signup;
