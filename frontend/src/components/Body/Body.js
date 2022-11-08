import * as React from "react";
import { Stack, Typography, Paper, Grid, Box } from "@mui/material";
import clock from "../../assest/clock.gif";
import lists from "../../assest/lists.gif";
import pencil from "../../assest/pencil.gif";
import profile from "../../assest/profile.gif";
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles({
  img: {
    width: "100%",
    height: "100%",
    alignItems: "center",
  },
  myBox: {
    height: "90vh",
    display: "flex",
    alignItems: "center",
  },
  boxContainer: {
    backgroundColor: "#E5E5E5",
  },
  textColor: {
    color: "#00687B",
  },
});

const Body = () => {
  const classes = useStyles();
  return (
    <Box className={classes.boxContainer}>
      <Box className={classes.myBox}>
        <Grid container justifyContent="center">
          <Grid item xs={2}>
            <Paper elevation={3} sx={{ height: "100%" }}>
              <Stack alignItems="center" py={2}>
                <img src={clock} className={classes.img}></img>
                <Typography
                  variant="h5"
                  align="center"
                  className={classes.textColor}
                >
                  Current job
                </Typography>
              </Stack>
            </Paper>
          </Grid>
          <Grid item xs={2}>
            <Paper elevation={3} sx={{ height: "100%" }}>
              <Stack alignItems="center" py={2}>
                <img src={pencil} className={classes.img}></img>
                <Typography
                  variant="h5"
                  align="center"
                  className={classes.textColor}
                >
                  Add/edit jobs
                </Typography>
              </Stack>
            </Paper>
          </Grid>
          <Grid item xs={2}>
            <Paper elevation={3} sx={{ height: "100%" }}>
              <Stack alignItems="center" py={2}>
                <img src={lists} className={classes.img}></img>
                <Typography
                  variant="h5"
                  align="center"
                  className={classes.textColor}
                >
                  Payment/Invoice (comming soon)
                </Typography>
              </Stack>
            </Paper>
          </Grid>
          <Grid item xs={2}>
            <Paper elevation={3} sx={{ height: "100%" }}>
              <Stack alignItems="center" py={2}>
                <img src={profile} className={classes.img}></img>
                <Typography
                  variant="h5"
                  align="center"
                  className={classes.textColor}
                >
                  Profile
                </Typography>
              </Stack>
            </Paper>
          </Grid>
        </Grid>
      </Box>
    </Box>
  );
};

export default Body;
