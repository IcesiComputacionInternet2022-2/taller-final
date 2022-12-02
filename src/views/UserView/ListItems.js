import React, {Component} from "react";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function Item(props) {
  return (
    <Col>
      <Card style={{ width: '15rem' }}>
        <Card.Img variant="top" src="holder.js/100px180" />
        <Card.Body>
          <Card.Title>{props.value[0]}</Card.Title>
          <Row><Col>{props.value[1]}</Col></Row>
          <Row><Col>{props.value[2]}</Col></Row>
          <Button variant="primary" onClick={props.onClick}>Agregar al carrito</Button>
        </Card.Body>
      </Card>
    </Col>
  );
}


class ListItems extends Component{
  
  constructor(props) {
    super(props);
    this.state = {
      items: [["Album", "Descripcion", 2900],["Album", "Descripcion", 1800]]
    };
  }
  
  /*componentDidMount() {
    fetch("http://localhost:8080/rest/item")
      .then((response) => response.json())
      .then(
        (items) => {
          this.setState({ items: items });
        },
        (error) => {
          alert("Aun no hay items en la tienda");
        }
      );
  }*/
  
  handleClick() {}
  
  renderItems(){
    let items = [];
    for(let item of this.state.items){
        items.push(
            <Item 
            value={item}
            onClick={() => this.handleClick()}
            />
        );
    }//End for
    if(items.length > 0)
      return(
        items
      );
    else
      return(<Container></Container>);
  }
  
  render(){
    return(
      <Container>
        {this.renderItems()}
      </Container>
    );
  }//End render
}//End ListItems

export default ListItems;