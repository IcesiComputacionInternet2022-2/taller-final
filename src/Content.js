import React, {Component} from "react";
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
import Login from "./login";

class Content extends Component{
  componentDidMount(){
    if(window.location.href == "http://localhost:3000/")
      window.location.href = "/view/admin/tools"; 
  }//End componentDidMount
  
  render(){
    return(
      <BrowserRouter>
        <Navbar bg="dark" variant="dark">
          <Container>
            <Navbar.Brand href="/">Music Shop</Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link href="/"></Nav.Link>
              <Nav.Link href="/"></Nav.Link>
              <Nav.Link href="/"></Nav.Link>
            </Nav>
          </Container>
        </Navbar>
        <div className="content">
          <Routes>
            <Route exact path="/view/admin/tools" element={<AdministratorTools />} />
            <Route exact path="/view/admin/tools/crear-item" element={<CreateItem />} />
            <Route exact path="/view/admin/tools/modify-item" element={<ModifyItem />} />
            <Route exact path="/view/admin/tools/modify-order" element={<ModifyOrder />} />
            <Route exact path="/view/admin/tools/list-users" element={<ListUsers />} />
            <Route exact path="/view/login" element={<Login />} />
          </Routes>
        </div>
      </BrowserRouter>
    );
  }//End render
}//End Content

export default Content;