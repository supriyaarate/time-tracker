import React from "react";

import Typography from "@mui/material/Typography";

const Text = (prop) => {
  /*Possible Values : 

    variant : h1,h2,h3,h4,h5,h6,subtitle1,subtitle2,body1,body2,button,caption,overline
    display : block
    component : div

    */

  return (
    <>
      <Typography
        id={prop.id}
        name={prop.name}
        variant={prop.variant}
        component={prop.component}
        display={prop.display}
        gutterBottom
      >
        {prop.text}
      </Typography>
    </>
  );
};

export default Text;
