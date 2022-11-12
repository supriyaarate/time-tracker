import { SET_AUTH } from "./authActionType";

const initialState = {
  loginInfo: {
    loggedIn: false,
    token: null,
    username: "",
  },
};

const authReducer = (state = initialState, { type, payload }) => {
  console.log(type, payload);
  switch (type) {
    case SET_AUTH:
      return {
        ...state,
        loginInfo: {
          ...state.loginInfo,
          loggedIn: true,
          token: payload.token,
          username: payload.username,
        },
      };

    default:
      return state;
  }
};

export default authReducer;
