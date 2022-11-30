import React, {Component} from "react";
import Container from 'react-bootstrap/Container';
import "./style/login.css";
class Login extends Component{
  render(){
    return(
        <div class="margin">
          <form>
            <table>
              <fieldset>
                <div class="header"><legend>Ingresar</legend></div>
                <tr>
                  <td><input type="text" id="content" placeholder="Ingrese su usuario"/></td>
                </tr>
                <div style={{'padding-top': '2%'}}></div>
                <tr>
                  <td><input type="text" id="content" placeholder="Ingrese su usuario"/></td>
                </tr>
                <div style={{'padding-top': '2%'}}></div>
                <tr>
                  <td><input type="submit"/></td>
                </tr>
              </fieldset>
            </table>
          </form>
        </div>
    );
  }//End render
}//End Login

export default Login;