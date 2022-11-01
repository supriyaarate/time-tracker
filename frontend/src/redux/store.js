import { combineReducers, createStore } from "redux";
import authReducer from "./reducer/Auth/authReducer";

const rootReducer = combineReducers({
  auth: authReducer,
});
const store = createStore(rootReducer);

export default store;
