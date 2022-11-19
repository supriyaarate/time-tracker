import React from "react";
import {
  AppBar,
  Toolbar,
  IconButton,
  Typography,
  Stack,
  Box,
} from "@mui/material";
import LogoutIcon from "@mui/icons-material/Logout";
import { useSelector } from "react-redux";
import "./../../translations/i18n";
import { useTranslation } from "react-i18next";
import "../../translations/i18n";

const Header = () => {
  const username = useSelector((state) => state.auth.loginInfo.username);

  const { t } = useTranslation();
  console.log(t);
  return (
    <div>
      <AppBar position="static" style={{ backgroundColor: "#00687B" }}>
        <Toolbar>
          <Box
            sx={{
              display: "flex",
              flexDirection: "row",
              alignItems: "center",
              justifyContent: "space-between",
              p: 1,
              m: 1,
              width: "100%",
            }}
          >
            <Box
              sx={{
                display: "flex",
                flexDirection: "row",
                alignItems: "center",
                justifyContent: "space-between",
                p: 1,
                m: 1,
              }}
            >
              <IconButton
                varian="h6"
                edge="start"
                color="inherit"
                aria-label="logo"
              >
                {t("icon")}
              </IconButton>
              <Typography variant="h6" sx={{ flexGrow: 1 }}>
                {t("hello")} {username}
              </Typography>
            </Box>
            <Box>
              <LogoutIcon />
              <Stack direction="row">
                <Typography>{t("logout")}</Typography>
              </Stack>
            </Box>
          </Box>
        </Toolbar>
      </AppBar>
    </div>
  );
};

export default Header;
