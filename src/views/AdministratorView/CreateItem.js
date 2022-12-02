import React, {Component} from "react";
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';

class CreateItem extends Component{
  
  async createItem(formData){
    formData.preventDefault();
    const data = new FormData(formData.target);
    const itemData = {
      name: data.get("name"),
      description: data.get("description"),
      price: data.get("price"),
    };
    console.log(itemData)
    const response = await fetch("http://localhost:8080/rest/item", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(itemData)
    });
    const msg = await response.json();
    if (response.status === 200) {
      alert("Se ha creado el item exitosamente")
      formData.target.reset();
    } else {
        alert(msg.message);
    }
    console.log(data);
  }//End createItem
  
  render(){
    return(
      <div style={{'padding-top':'5%', 'padding-left':'30%'}}>
        <Container>
          <form onSubmit={this.createItem}>
            <fieldset>
              <legend style={{'padding-left':'17%'}}>Crear item</legend>
              <table>
                <tr>
                  <td><label>Nombre: </label></td>
                  <td><input type="text" id="name" name="name"></input></td>
                </tr>
                <tr>
                  <td><label>Descripcion: </label></td>
                  <td><input type="text" id="description" name="description"></input></td>
                </tr>
                <tr>
                  <td><label>Precio: </label></td>
                  <td><input type="text" id="price" name="price"></input></td>
                </tr>
                <tr>
                  <td><label>Imagen: </label></td>
                  <td><input type="file" id="image" name="image" accept="image/png, .jpeg, .jpg"></input></td>
                </tr>
                <tr>
                <td><input type="submit" value="Crear"/></td>
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