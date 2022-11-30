import React, { Component } from "react";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

class AdministratorTools extends Component{
  render(){
    return(
      <div class="DOM_MARGIN">
        <Container fluid>
          <Row>
            <Col>
              <Card style={{ width: '15rem' }}>
                <Card.Img variant="top" src="holder.js/100px180" />
                <Card.Body>
                  <Card.Text>Crear un nuevo item para la tienda.</Card.Text>
                  <a href="/crearItem">
                    <Button variant="primary">Crear item</Button>
                  </a>
                </Card.Body>
              </Card>
            </Col>
            <Col>
              <Card style={{ width: '15rem' }}>
                <Card.Img variant="top" src="holder.js/100px180" />
                <Card.Body>
                  <Card.Text>Listar y modificar los items actualmente creados en la tienda.</Card.Text>
                  <a href="/modifyItem">
                    <Button variant="primary">Ver items</Button>
                  </a>
                </Card.Body>
              </Card>
            </Col>
            <Col>
              <Card style={{ width: '15rem' }}>
                <Card.Img variant="top" src="holder.js/100px180" />
                <Card.Body>
                  <Card.Text>Ver y modificar los pedidos actuales de la tienda.</Card.Text>
                  <a href="/modifyOrder">
                    <Button variant="primary">Ver pedidos</Button>
                  </a>
                </Card.Body>
              </Card>
            </Col>
            <Col>
              <Card style={{ width: '15rem' }}>
                <Card.Img variant="top" src="holder.js/100px180" />
                <Card.Body>
                  <Card.Text>Listar todos los usuarios registrados en la aplicacion y ver su informacion. </Card.Text>
                  <a href="/crear">
                    <Button variant="primary">Ver usuarios</Button>
                  </a>
                </Card.Body>
              </Card>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }//End render
}//End AdministratorTools

export default AdministratorTools;