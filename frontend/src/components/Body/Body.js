/* eslint-disable prettier/prettier */
// import React from "react";
// import "./Body.css";
// import clock from "../../assest/clock.gif";
// import lists from "../../assest/lists.gif";
// import pencil from "../../assest/pencil.gif";
// import profile from "../../assest/profile.gif";
// import { Box, Typography, Paper,Grid } from "@mui/material";
// import { createTheme } from "@mui/material/styles";

// const theme = createTheme({
//   typography: {
//     h5: {
//       color: "#00687B",
//     },
//   },
// });

// const Body = () => {
//   console.log(theme);
//   return (
//     <>
//       <Grid container spacing={2}>
//   <Grid item xs={8}>

//       <Box
//         sx={{
//           backgroundColor: "#E5E5E5",
//           height: "100vh",
//         }}
//       >
//         <Paper
//           elevation={0}
//           sx={{
//             margin: "0 70px",
//           }}
//         >
//           <Box
//             sx={{
//               display: "flex",
//               flexDirection: "row",
//               justifyContent: "center",
//               alignItems: "center",
//             }}
//           >
//             <Box
//               sx={{
//                 display: "flex",
//                 flexDirection: "column",
//                 width: "10rem",
//               }}
//             >
//               <img src={clock} alt="clock" />
//               <Typography variant="h5" element="p">
//                 Current job
//               </Typography>
//             </Box>
//             <Box
//               sx={{
//                 display: "flex",
//                 flexDirection: "column",
//                 width: "10rem",
//               }}
//             >
//               <img src={pencil} alt="pencil" />
//               <Typography variant="h5" element="p">
//                 Add/edit jobs
//               </Typography>
//             </Box>
//             <Box
//               sx={{
//                 display: "flex",
//                 flexDirection: "column",
//                 width: "10rem",
//               }}
//             >
//               <img src={lists} alt="lists" />
//               <Typography variant="h5" element="p">
//                 Payment/Invoice (comming soon)
//               </Typography>
//             </Box>
//             <Box
//               sx={{
//                 display: "flex",
//                 flexDirection: "column",
//                 width: "10rem",
//               }}
//             >
//               <img src={profile} alt="profile" />
//               <Typography variant="h5" element="p">
//                 Profile
//               </Typography>
//             </Box>
//           </Box>
//         </Paper>
//       </Box>
//   </Grid>

// </Grid>
//     </>
//   );
// };

// export default Body;

import React from "react";
import { Grid, Typography, Stack, Paper, Box } from "@mui/material";
import clock from "../../assest/clock.gif";
import lists from "../../assest/lists.gif";
import pencil from "../../assest/pencil.gif";
import profile from "../../assest/profile.gif";
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles({
  img: {
    width: "210px",
    height: "100%",
  },
  text: {
    color: "#00687B",
  },
});

const Body = () => {
  const classes = useStyles();
  return (
    <Box
      sx={{
        backgroundColor: "#E5E5E5",
      }}
    >
      <Grid
        container
        alignItems="center"
        justifyContent="center"
        style={{ height: "90vh" }}
      >
        <Grid item md={2} sm="auto" xs="auto">
          <Paper
            variant="outlined"
            elevation={3}
            sx={{
              height: "100%",
              display: "flex",
              alignItems: "center",
              flexDirection: "column",
            }}
          >
            <Stack alignItems="center" py={1} pb={3}>
              <img src={clock} alt="pencil" className={classes.img} />
              <Typography variant="h5" element="p" className={classes.text}>
                Current job
              </Typography>
            </Stack>
          </Paper>
        </Grid>

        <Grid item md={2} sm="auto" xs="auto">
          <Paper
            variant="outlined"
            elevation={3}
            sx={{
              height: "100%",
              display: "flex",
              alignItems: "center",
              flexDirection: "column",
            }}
          >
            <Stack alignItems="center" py={1} pb={3}>
              <img src={pencil} alt="pencil" className={classes.img} />
              <Typography variant="h5" element="p" className={classes.text}>
                Add/edit jobs
              </Typography>
            </Stack>
          </Paper>
        </Grid>
        <Grid item md={2} sm="auto" xs="auto">
          <Paper
            variant="outlined"
            elevation={3}
            sx={{
              height: "100%",
              display: "flex",
              alignItems: "center",
              flexDirection: "column",
            }}
          >
            <Stack alignItems="center" py={1} pb={3}>
              <img src={lists} alt="pencil" className={classes.img} />
              <Typography variant="h5" element="p" className={classes.text}>
                Payment/Invoice
              </Typography>
            </Stack>
          </Paper>
        </Grid>
        <Grid item md={2} sm="auto" xs="auto">
          <Paper
            variant="outlined"
            elevation={3}
            sx={{
              height: "100%",
              display: "flex",
              alignItems: "center",
              flexDirection: "column",
            }}
          >
            <Stack alignItems="center" py={1} pb={3}>
              <img src={profile} alt="pencil" className={classes.img} />
              <Typography variant="h5" element="p" className={classes.text}>
                Profile
              </Typography>
            </Stack>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default Body;
