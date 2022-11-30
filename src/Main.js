import React, { Component } from "react";

import Login from "./login";
import Content from "./Content";

class Main extends React.Component{
  
  renderView(view){
      let toRender = <Content />;
      return(
        toRender
      );
  }
    
  render() {
    return (
      <div>{this.renderView()}</div>
    );
  }
}  
export default Main;