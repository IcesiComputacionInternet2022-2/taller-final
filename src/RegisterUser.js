import React, {Component} from "react";
import Container from 'react-bootstrap/Container';

class RegisterUser extends Component{
  
  goingToLogIn(){
    window.location.href = "/view/login"; 
  }
  
  render(){
    return(
      <Container>
        <div style={{'padding-top': '5%', 'padding-left': '30%'}}>
          <form>
            <fieldset>
              <div class="header">
              <legend>Registrar usuario</legend>
              </div>
              <div style={{'padding-top': '10%'}}></div>
              <table>
                <tr>
                  <td><label>Correo: </label></td>
                  <td><input type="text" placeholder="Ingresa tu correo electronico" required/></td>
                </tr>
                <div style={{'padding-top': '10%'}}></div>
                <tr>
                  <td><label>Contraseña: </label></td>
                  <td><input type="text" placeholder="Ingresa tu contraseña" required/></td>
                </tr>
                <div style={{'padding-top': '10%'}}></div>
                <tr>
                  <td><label>Direccion: </label></td>
                  <td><input type="text" placeholder="Ingresa tu direccion"/></td>
                </tr>
                <div style={{'padding-top': '10%'}}></div>
                <tr>
                  <td><label>Telefono: </label></td>
                  <td><input type="text" placeholder="Ingresa tu numero de telefono"/></td>
                </tr>
                <div style={{'padding-top': '20%'}}></div>
              </table>
            </fieldset>
            <table>
              <tr>
                <div style={{'padding-left': '50%'}}>
                  <td><button type="submit">Registrar</button></td>
                  <td><div style={{'width': '30px'}}></div></td>
                  <td><button type="button" onAction={this.goingToLogIn()}>Ingresar</button></td>
                </div>
              </tr>
            </table>
          </form>
        </div>
      </Container>
    );
  }
}//End RegisterUser

export default RegisterUser;