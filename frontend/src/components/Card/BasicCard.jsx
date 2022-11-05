import React from "react";
import Card from "@mui/material/Card";

const BasicCard = (props) => {
  return (
    <Card sx={{ width: "50%", mx: "20%", my: "5%", p: "3%" }}>
      {props.children}
    </Card>
  );
};

export default BasicCard;
