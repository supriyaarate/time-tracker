import React from "react";
import TextField from "@mui/material/TextField";

const TextInput = (prop) => {
  /*Possible Values :

    type : text, password
    variant : Outlined , Filled , Standard (Default is Outlined)

    */

  return (
    <div style={{ padding: "2px", margin: "5px" }}>
      <TextField
        sx={
          !prop.fullwidth
            ? {
                width: "350px",
              }
            : {}
        }
        required={prop.required}
        id={prop.id}
        name={prop.name}
        label={prop.label}
        type={prop.type}
        variant={prop.variant}
        onChange={prop.onChange}
        fullWidth={prop.fullwidth}
        defaultValue={prop.defaultvalue}
      />
    </div>
  );
};

export default TextInput;
