import React, { useState } from "react";
import {
  Grid,
  TextField,
  Button,
  CardContent,
  Typography,
  Link,
} from "@mui/material";
import { LocalizationProvider, DatePicker } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { Box } from "@mui/system";
import BasicCard from "../../components/Card/BasicCard";
import { useTranslation } from "react-i18next";
import "../../translations/i18n";
const Signup = () => {
  const { t } = useTranslation();

  const [value, setValue] = useState(new Date());
  const handleChange = (newValue) => {
    setValue(newValue);
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
            <TextField
              required
              id="firstname"
              name="firstname"
              label={t("firstname")}
              variant="outlined"
              type="text"
              fullWidth
            ></TextField>
          </Grid>
          {/* last name */}
          <Grid item xs={12} sm={6}>
            <TextField
              required
              id="lastname"
              name="lastname"
              label={t("lastname")}
              type="text"
              fullWidth
            ></TextField>
          </Grid>
          {/* email */}
          <Grid item xs={12} sm={6}>
            <TextField
              required
              id="email"
              name="email"
              label={t("email")}
              type="email"
              fullWidth
            ></TextField>
          </Grid>
          {/* dob */}
          <Grid item xs={12} sm={6}>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <DatePicker
                onChange={handleChange}
                value={value}
                renderInput={(params) => (
                  <TextField
                    {...params}
                    fullWidth
                    required
                    id="dob"
                    name="dob"
                    label={t("dob")}
                    type="text"
                  />
                )}
              ></DatePicker>
            </LocalizationProvider>
          </Grid>
          {/* password */}
          <Grid item xs={12} sm={6}>
            <TextField
              required
              id="password"
              name="password"
              label={t("password")}
              type="password"
              fullWidth
            ></TextField>
          </Grid>
          {/* confirm password */}
          <Grid item xs={12} sm={6}>
            <TextField
              required
              id="confirmpassword"
              name="confirmpassword"
              label={t("confirmpassword")}
              type="password"
              fullWidth
            ></TextField>
          </Grid>
        </Grid>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            mt: "30px",
          }}
        >
          <Button
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
          </Button>
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
