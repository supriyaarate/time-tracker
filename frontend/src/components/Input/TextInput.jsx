import React from "react";
import TextField from "@mui/material/TextField";

const TextInput = (prop) => {

    /*Possible Values : 

    type : text, password
    variant : Outlined , Filled , Standard (Default is Outlined)
    
    */


  return (
    <div style={{padding:"2px"}}>
      <TextField 
        id={prop.id}
        name={prop.name}
        label={prop.label} 
        type={prop.type}
        variant={prop.variant}
        onChange={prop.onChange} 
        />
    </div>
  );
};

export default TextInput;
