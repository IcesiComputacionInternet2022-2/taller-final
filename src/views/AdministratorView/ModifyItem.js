import React, {Component} from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function Item(props) {
  return (
    <div>
      <form onSubmit={this.renderContent}>
        <fieldset>
          <legend>Modificar item</legend>
          <table>
            <tr>
              <td><label>Codigo:</label></td>
              <td><label>{props.value[0]}</label></td>
            </tr>
            <tr>
              <td><label>Nombre:</label></td>
              <td><input type="text" value={props.value[1]}/></td>
            </tr>
            <tr>
              <td><label>Descripcion:</label></td>
              <td><input type="text" value={props.value[2]}/></td>
            </tr>
            <tr>
              <td><label>Price:</label></td>
              <td><input type="text" value={props.value[3]}/></td>
            </tr>
            <tr>
              <td><input type="submit" value="modificar"/></td>
            </tr>
          </table>
        </fieldset>
      </form>
    </div>
  );
}

class ModifyItem extends Component{
  
  constructor(props) {
    super(props);
    this.state = {
      items: ["asdadasdasdasdasd","Album", "Descripcion", 2900]
    };
  }
  handleClick(){}
  
  renderItems(){
    return(
            <Item 
            value={this.items}
            onClick={() => this.handleClick()}
            />
      );
    }//End for
  
  render(){
    return(
        <Container>
          <div class="search_bar">
            <Row>
              <form onSubmit={this.renderItems}>
                <tr>
                  <td><input type="text" placeholder="Ingresa el nombre del item"/></td>
                  <td><input type="submit" value="Buscar"/></td>
                </tr>
              </form>            
            </Row>
          </div>
          <div class="search_result">
            {this.state.items.map((item) => (
               <div>
                  <form onSubmit={this.renderContent}>
                    <fieldset>
                      <legend>Modificar item</legend>
                      <table>
                        <tr>
                          <td><label>Codigo:</label></td>
                          <td><label>{props.value[0]}</label></td>
                        </tr>
                        <tr>
                          <td><label>Nombre:</label></td>
                          <td><input type="text" value={props.value[1]}/></td>
                        </tr>
                        <tr>
                          <td><label>Descripcion:</label></td>
                          <td><input type="text" value={props.value[2]}/></td>
                        </tr>
                        <tr>
                          <td><label>Price:</label></td>
                          <td><input type="text" value={props.value[3]}/></td>
                        </tr>
                        <tr>
                          <td><input type="submit" value="modificar"/></td>
                        </tr>
                      </table>
                    </fieldset>
                  </form>
                </div>
              ))}
          </div>
        </Container>
    );
  }//End render
}//End ModifyItem

export default ModifyItem;