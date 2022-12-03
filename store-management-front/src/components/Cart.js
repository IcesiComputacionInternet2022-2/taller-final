import {
    MDBBtn,
    MDBCard,
    MDBCardBody,
    MDBCardHeader,
    MDBCol,
    MDBContainer,
    MDBIcon,
    MDBListGroup,
    MDBListGroupItem,
    MDBRow,
    MDBTypography,
} from "mdb-react-ui-kit";
import React, { useEffect } from "react";
import { order } from "../data/OrderItem"
import OrderItem from "./OrderItem";
import { token } from "../data/Token";

export default function Cart() {

    const ORDER_API = "http://localhost:8080/store/order";

    const { orderItem } = order;

    const [totalPrice, setTotalPrice] = React.useState(0);

    const [ show , setShow ] = React.useState(true);
    const [ disable, setDisable ] = React.useState(false);

    function calculateTotal() {
        var total = 0;
        orderItem.forEach((el) => {
            total += el.item.price * el.quantity;
        });
        setTotalPrice(total);
    }

    useEffect(() => {
        calculateTotal();
    }, [  ]);

    function buyItems () {
        order.total = totalPrice;

        fetch(ORDER_API, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + token
            },
            body: JSON.stringify(order),
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
            }
        );
        setShow(false);
        setDisable(true);
    }


    return (
        <section className="h-100 gradient-custom">
            <MDBContainer className="py-5 h-100">
            <MDBRow className="justify-content-center my-4">
                <MDBCol md="8">
                <MDBCard className="mb-4">
                    <MDBCardHeader className="py-3">
                    <MDBTypography tag="h5" className="mb-0">
                        Cart - { orderItem.length === 1 ? orderItem.length + " item" : orderItem.length + " items" } 
                    </MDBTypography>
                    </MDBCardHeader>
                    <MDBCardBody>
                    {   
                        orderItem && orderItem.length > 0 && orderItem.map((el, i = 0) => {
                            return <>
                                        <OrderItem 
                                        index = {i++}
                                        id={el.item.id}
                                        name={el.item.name} 
                                        description={el.item.description} 
                                        price={el.item.price}
                                        onChange={() => calculateTotal()}
                                        disable={disable}
                                        showButton={show}
                                        />
                                        <hr className="my-4" />
                                        
                                    </>     
                        })
                    }

                    </MDBCardBody>
                </MDBCard>

                <MDBCard className="mb-4">
                    <MDBCardBody>
                    <p>
                        <strong>Expected shipping delivery</strong>
                    </p>
                    <p className="mb-0">12.10.2020 - 14.10.2020</p>
                    </MDBCardBody>
                </MDBCard>

                <MDBCard className="mb-4 mb-lg-0">
                    <MDBCardBody>
                    <p>
                        <strong>We accept</strong>
                    </p>
                    <MDBIcon fab icon="cc-visa" className="me-2" size="3x" color="primary"/>
                    <MDBIcon fab icon="cc-mastercard" className="me-2" size="3x" color="danger"/>
                    <MDBIcon fab icon="cc-paypal" className="me-2" size="3x" style={{color:'#009cde'}}/>
                    </MDBCardBody>
                </MDBCard>
                </MDBCol>
                <MDBCol md="4">
                    <MDBCard className="mb-4">
                        <MDBCardHeader>
                            <MDBTypography tag="h5" className="mb-0">
                                Summary
                            </MDBTypography>
                        </MDBCardHeader>
                        <MDBCardBody>
                            <MDBListGroup>
                                <MDBListGroupItem
                                className="d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                Products
                                <span>${totalPrice}</span>
                                </MDBListGroupItem>
                                <MDBListGroupItem className="d-flex justify-content-between align-items-center px-0">
                                Shipping
                                <span>Free</span>
                                </MDBListGroupItem>
                                <MDBListGroupItem
                                className="d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                <div>
                                    <strong>Total amount</strong>
                                    <strong>
                                    <p className="mb-0">(including VAT)</p>
                                    </strong>
                                </div>
                                <span>
                                    <strong>${totalPrice}</strong>
                                </span>
                                </MDBListGroupItem>
                            </MDBListGroup>
                            {   
                                show &&  
                                <MDBBtn block size="lg" onClick={buyItems}>
                                    Buy
                                </MDBBtn>
                            }
                        </MDBCardBody>
                    </MDBCard>
                </MDBCol>
            </MDBRow>
            </MDBContainer>
        </section>
    );
}