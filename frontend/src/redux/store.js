import { combineReducers, createStore, applyMiddleware } from "redux";
import logger from "redux-logger";
import { composeWithDevTools } from "redux-devtools-extension";
import authReducer from "./reducer/Auth/authReducer";
import configReducer from "./reducer/Config/configReducer";

const rootReducer = combineReducers({
  auth: authReducer,
  config: configReducer,
});
const store = createStore(
  rootReducer,
  composeWithDevTools(applyMiddleware(logger))
);

export default store;
