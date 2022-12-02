import React, {Component} from "react";
import Container from 'react-bootstrap/Container';
import "./style/login.css";
import { Navigate } from "react-router-dom";
import {
    BrowserRouter,
    Route,
    Routes,
} from "react-router-dom";


class Login extends Component{
  
  constructor(props) {
    super(props);
    this.state = {
      logged: false,
    };
  }
  
  componentDidMount(){
    const token = "valido";
    const type = "a";
    if(token === "valido"){
      this.setState({logged: true});
      if(type === "admin")
        window.location.href = "/view/admin/tools"; 
      else
        window.location.href = "/view/items/list-items"; 
    }else
      this.setState({logged: false});
  }//End componentDidMount
  
  handleSubmit(formData){
    formData.preventDefault();
    const data = new FormData(formData.target);
    console.log(data.get("email"));
    if(data.get("email") === "admin")
      window.location.href = "/view/admin/tools"; 
    else
      window.location.href = "/view/items/list-items"; 
  }
  
  renderLogin(){
    if(!this.state.logged)
      return(
          <div class="margin">
            <form onSubmit={this.handleSubmit} autoComplete="off">
              <fieldset>
                <div class="header"><legend>Ingresar</legend></div>
                <table>
                  <tr>
                    <td><input type="text" id="email" name="email" placeholder="Ingrese su email"/></td>
                  </tr>
                  <div style={{'padding-top': '2%'}}></div>
                  <tr>
                    <td><input type="text" id="password" name="password" placeholder="Ingrese su password"/></td>
                  </tr>
                  <div style={{'padding-top': '2%'}}></div>
                  <tr>
                    <div class="boton">
                      <td>
                        <button type="submit">Ingresar</button>
                      </td>
                      <td><div class="espaciado"></div></td>
                      <td>
                        <a href="/view/register">
                          <button type="button">Registrar</button>
                        </a>
                      </td>
                    </div>
                  </tr>
                </table>
              </fieldset>
            </form>
          </div>
      );
  }
  
  render(){
    return(
      <div>{this.renderLogin()}</div>
    );
  }//End render
}//End Login

export default Login;