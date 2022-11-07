import { combineReducers, createStore, applyMiddleware } from "redux";
import logger from "redux-logger";

import authReducer from "./reducer/Auth/authReducer";

const rootReducer = combineReducers({
  auth: authReducer,
});
const store = createStore(rootReducer, applyMiddleware(logger));

export default store;
