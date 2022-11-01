import { SET_AUTH } from "./authActionType";

const initialState = {
  loggedIn: false,
  token: null,
};

const authReducer = (state = initialState, { type, payload }) => {
  switch (type) {
    case SET_AUTH:
      return {
        ...state,
        loggedIn: true,
        token: payload.token,
      };
    default:
      return state;
  }
};

export default authReducer;
