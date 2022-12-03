import React from 'react';
import {
    MDBContainer,
    MDBNavbar,
    MDBNavbarBrand,
    MDBNavbarNav,
    MDBNavbarItem,
    MDBNavbarLink,
    MDBIcon,
    MDBBadge
} from 'mdb-react-ui-kit';
import logo from './../images/cart.ico';
import { order } from "../data/OrderItem"

export default function Navbar() {

    const validPath = window.location.pathname !== "/" && window.location.pathname !== "/login" && window.location.pathname !== "/register";

  return (
    <>
        <MDBNavbar light bgColor='light'>
            <MDBContainer fluid>
                <MDBNavbarNav className='d-flex flex-row'>
                    <MDBNavbarBrand href='/'>
                        <img
                        src= {logo}
                        height='30'
                        alt=''
                        loading='lazy'
                        />            
                        <div className='mx-3'>
                            Virtual Store
                        </div>
                    </MDBNavbarBrand>

                    {
                        validPath && 
                        <MDBNavbarItem className='ms-auto'> 
                            <MDBNavbarLink href='cart'>
                                <MDBBadge pill color='danger'>{order.orderItem.length}</MDBBadge>
                                <span>
                                    <MDBIcon fas icon='shopping-cart'></MDBIcon>
                                </span>
                            </MDBNavbarLink>
                        </MDBNavbarItem>
                    }

                </MDBNavbarNav>
            </MDBContainer>
        </MDBNavbar>
    </>
  );
}