import { SET_CONFIG } from "./configActionType";

const initialState = {
  apiList: [
    {
      name: "",
      url: "",
    },
  ],
  userInfo: {
    id: "",
    email: "",
    firstName: "",
    lastName: "",
    username: "",
  },
};

const configReducer = (state = initialState, action) => {
  switch (action.type) {
    case SET_CONFIG:
      return {
        ...state,
        apiList: action.payload.apiList,
        userInfo: action.payload.userInfo,
      };
    default:
      return state;
  }
};

export default configReducer;
