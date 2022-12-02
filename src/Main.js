import React, { Component } from "react";
import { Navigate } from "react-router-dom";
import {
    BrowserRouter,
    Route,
    Routes,
} from "react-router-dom";
import Login from "./Login";
import Content from "./Content";

class Main extends Component{
  
  renderView(view){
      let toRender = <Content />;
      return(
        toRender
      );
  }
    
  render() {
    return (
      <div>
        {this.renderView()}
      </div>
    );
  }
}  
export default Main;