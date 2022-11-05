import { SET_AUTH } from "./authActionType";

const initialState = {
  loginData: {
    username: "",
    password: "",
    success: false,
    token: null,
  },

  loggedIn: false,
};

const authReducer = (state = initialState, { type, payload }) => {
  switch (type) {
    case SET_AUTH:
      return {
        ...state,
        success: true,
        token: payload.token,
        loginData: {
          username: "",
          password: "",
        },
        loggedIn: true,
      };
    default:
      return state;
  }
};

export default authReducer;
