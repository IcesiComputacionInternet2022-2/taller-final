import React, {Component} from "react";
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';

class CreateItem extends Component{
  render(){
    return(
      <div class="DOM_MARGIN">
        <Container>
          <form>
            <fieldset>
              <legend>Crear item</legend>
              <table>
                <tr>
                  <td><label>Nombre: </label></td>
                  <td><input type="text"></input></td>
                </tr>
                <tr>
                  <td><label>Descripcion: </label></td>
                  <td><input type="text"></input></td>
                </tr>
                <tr>
                  <td><label>Precio: </label></td>
                  <td><input type="text"></input></td>
                </tr>
                <tr>
                  <td><label>Imagen: </label></td>
                  <td><input type="file" accept="image/png, .jpeg, .jpg"></input></td>
                </tr>
              </table>
            </fieldset>
          </form>
        </Container>
      </div>
    );
  }//End render
}//End CreateItem

export default CreateItem;