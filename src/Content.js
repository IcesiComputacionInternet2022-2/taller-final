import React, {Component} from "react";
import { Navigate } from "react-router-dom";
import {
    BrowserRouter,
    Route,
    Routes,
} from "react-router-dom";
import Container from 'react-bootstrap/Container';
import AdministratorTools from "./views/AdministratorView/AdministratorTools";
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import CreateItem from "./views/AdministratorView/CreateItem";
import ModifyItem from "./views/AdministratorView/ModifyItem";
import ModifyOrder from "./views/AdministratorView/ModifyOrder";
import ListUsers from "./views/AdministratorView/ListUsers";
import ListItems from "./views/Items/ListItems";
import ShoppingCart from "./views/Items/ShoppingCart";
import RegisterUser from "./RegisterUser";
import Login from "./Login";
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import "./style/login.css";

class Content extends Component{
  /*componentDidMount(){
    if(window.location.href == "http://localhost:3000/")
      window.location.href = "/view/admin/tools"; 
  }//End componentDidMount
  */
  
  render(){
    return(
      <BrowserRouter>
        <Row>
          <Navbar bg="dark" variant="dark">
            <Container>
                <Col><Navbar.Brand href="/">Music Shop</Navbar.Brand></Col>
                <Col><Navbar.Toggle aria-controls="responsive-navbar-nav" /></Col>
                <Nav className="me-auto">
                  <Nav.Link href="/view/items/list-items">Ver productos</Nav.Link>
                  <Nav.Link href="/view/items/shopping-cart">Ver carrito</Nav.Link>
                  <Nav.Link href="/">Ver ordenes</Nav.Link>
                  <Nav.Link>
                    <button class="salir" onClick={()=>alert("saliendo")}>Salir</button>
                  </Nav.Link>
                </Nav>
            </Container>
          </Navbar>
        </Row>
        <div className="content">
          <Routes>
            <Route exact path="/view/admin/tools" element={<AdministratorTools />} />
            <Route exact path="/view/admin/tools/crear-item" element={<CreateItem />} />
            <Route exact path="/view/admin/tools/modify-item" element={<ModifyItem />} />
            <Route exact path="/view/admin/tools/modify-order" element={<ModifyOrder />} />
            <Route exact path="/view/admin/tools/list-users" element={<ListUsers />} />
            <Route exact path="/view/register" element={<RegisterUser />} />
            <Route exact path="/view/login" element={<Login />} />
            <Route exact path="/view/items/list-items" element={<ListItems />} />
            <Route exact path="/view/items/shopping-cart" element={<ShoppingCart />} />
            <Route exact path='/' element={<Navigate to="/view/login"/>}/>
          </Routes>
        </div>
      </BrowserRouter>
    );
  }//End render
}//End Content

export default Content;