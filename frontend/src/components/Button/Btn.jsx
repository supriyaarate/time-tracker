import React from "react";
import Button from "@mui/material/Button";

const Btn = (prop) => {
  /*Possible Values :

    variant : contained, outlined
    color (Optional) : secondary , success, error   (Default is Blue)
    size (Optional) : small , medium , large        (Default is Medium)
    startIcon (Optional) : Pass any ICON has <ICON /> from props (Default is no ICON)

    */

  return (
    <div style={{ padding: "20px", margin: "10px" }}>
      <Button
        sx={{
          width: "70%",
          borderRadius: "15px",
          fontSize: 17,
        }}
        id={prop.id}
        name={prop.name}
        variant={prop.variant}
        color={prop.color}
        size={prop.size}
        startIcon={prop.startIcon}
        endIcon={prop.endIcon}
        onClick={prop.onClick}
      >
        {prop.text}
      </Button>
    </div>
  );
};

export default Btn;
