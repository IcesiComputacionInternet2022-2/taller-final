import React, { Component } from "react";
import {
    BrowserRouter,
    Route,
    Routes,
} from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import AdministratorTools from "./AdministratorView/AdministratorTools";
import CreateItem from "./AdministratorView/CreateItem";

class Main extends Component{
    render() {
        return (
          <BrowserRouter>
            <Navbar bg="dark" variant="dark">
              <Container>
                <Navbar.Brand href="/">Music Shop</Navbar.Brand>
                <Nav className="me-auto">
                  <Nav.Link href="/crear">Crear Item</Nav.Link>
                </Nav>
              </Container>
            </Navbar>
            <div className="content">
              <Routes>
                <Route exact path="/crear" element={<AdministratorTools />} />
                <Route exact path="/crearItem" element={<CreateItem />} />
              </Routes>
            </div>
          </BrowserRouter>
        );
      }
    }
    
    export default Main;