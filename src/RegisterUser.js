import React, {Component} from "react";
import Container from 'react-bootstrap/Container';

class RegisterUser extends Component{
  render(){
    return(
      <Container>
        <form>
          <fieldset>
            <legend>Registrar usuario</legend>
            <table>
              <tr>
                <td><input type="text" placeholder="Ingresa tu correo electronico"/></td>
              </tr>
              <tr>
                <td><input type="text" placeholder="Ingresa tu contraseña"/></td>
              </tr>
              <tr>
                <td><input type="text" placeholder="Ingresa tu direccion"/></td>
              </tr>
              <tr>
                <td><input type="text" placeholder="Ingresa tu numero de telefono"/></td>
              </tr>
              <tr>
                <td><input type="submit" value="Registrar"/></td>
              </tr>
            </table>
          </fieldset>
        </form>
      </Container>
    );
  }
}//End RegisterUser

export default RegisterUser;