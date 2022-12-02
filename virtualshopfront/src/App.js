import React, { useState } from "react";
import logo from './logo.svg';
import './App.css';
import styled from 'styled-components';
import Login from "./pages/login";
import Register from "./pages/register";

function App() {
  return (
      <AppComponent>
  
      </AppComponent>
    );
}

const Main = styled.main`
    position: relative;
    overflow: hidden;
    transition: all .15s;
    padding: 0 20px;
    margin-left: ${props => (props.expanded ? 240 : 64)}px;
`;

class AppComponent extends React.Component {

  
  onSelect = (selected) => {
    this.setState({ selected: selected });
  };

  

  constructor(props){
    super(props)
    this.state = {
      selected: 'login',
    }
  }

  render(){

    return(
      <div className="App">
          <Main>
            {this.changepage()}
          </Main>
      </div>
        
    )
  }

  changepage(){
    switch (this.state.selected){
      case "login": return <Login onFormSwitch={this.onSelect} />
      case "register": return <Register onFormSwitch={this.onSelect} />
      default: return <Login onFormSwitch={this.onSelect} />

    }
  }

}


export default App;
