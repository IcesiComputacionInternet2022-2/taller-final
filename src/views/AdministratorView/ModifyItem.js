import React, {Component} from "react";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function ToModify(props){
  return(
    <div>
      <form>
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

function Item(props) {
  return (
    <Col>
      <Card style={{ width: '15rem' }}>
        <Card.Img variant="top" src="holder.js/100px150" />
        <Card.Body>
          <Card.Title>{props.value[1]}</Card.Title>
          <Row><Col>{props.value[0]}</Col></Row>
          <Row><Col>{props.value[2]}</Col></Row>
          <Row><Col>{props.value[3]}</Col></Row>
          <Button variant="primary" onClick={props.onClick}>Modificar item</Button>
        </Card.Body>
      </Card>
    </Col>
  );
}

function toEdit(props){
  return(
    <div>
      
    </div>
  );
}

class ModifyItem extends Component{
  
  constructor(props) {
    super(props);
    this.state = {
      items: [["Album", "Descripcion", 2900],["Album", "Descripcion", 1800]]
    };
  }
  
  handleClick(){}
  
  renderContent(){
    let content = document.getElementById("content");
    content.innerHTML += 
            <ToModify 
            value={item}
            onClick={() => this.handleClick()}
            />  
  }
  
  renderItems(){
    let items = [];
    let content = document.getElementById("content");
    for(let item of this.state.items){
      content.innerHTML += 
            <Item 
            value={item}
            onClick={() => this.handleClick()}
            />
    }//End for
    
  }
  
  render(){
    return(
        <Container>
          <div class="search_bar">
            <Row>
              <form onSubmit={this.renderContent}>
                <tr>
                  <td><input type="text" placeholder="Ingresa el nombre del item"/></td>
                  <td><input type="submit" value="Buscar"/></td>
                </tr>
              </form>            
            </Row>
          </div>
          <div class="search_result" id="content">
          {this.renderItems()}
          </div>
        </Container>
    );
  }//End render
}//End ModifyItem

export default ModifyItem;