import React from "react";
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBCardImage,
  MDBRipple,
  MDBBtn,
} from "mdb-react-ui-kit";
import "./../styles/Item.css";
import {order} from "../data/OrderItem"

function Item(props) {
    const {id, name, description, price} = props;
    var clickCounter = 0;

    function addToCart() {
        console.log("addToCart");
        const orderItem = {
            quantity: 1,
            item: {
                id: id,
                name: name,
                description: description,
                price: price        
            }
        }
        
        if (clickCounter === 0) {
            order.orderItem.push(orderItem);
            clickCounter++;
            console.log(clickCounter);
            console.log(JSON.stringify(order));
        }
    }

    return (
        <MDBContainer fluid>
        <MDBRow className="justify-content-center my-3">
            <MDBCol md="12" xl="10">
            <MDBCard className="shadow-0 border rounded-3">
                <MDBCardBody>
                <MDBRow>
                    <MDBCol md="12" lg="3" className="mb-4 mb-lg-0">
                    <MDBRipple
                        rippleColor="light"
                        rippleTag="div"
                        className="bg-image rounded hover-zoom hover-overlay"
                    >
                        <MDBCardImage
                        src="https://www.navigation.com/static/WFS/Shop-CitroenEMEA-Site/-/Shop-CitroenEMEA/en_GB/Product%20Not%20Found.png"
                        fluid
                        className="img-thumbnail  w-100 h-100" 
                        style={{
                            background: "lightgray",
                            borderWidth: 5,
                        }}
                        />
                        <a href="#!">
                        <div
                            className="mask"
                            style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}
                        ></div>
                        </a>
                    </MDBRipple>
                    </MDBCol>

                    {/* Product Details */}
                    
                    
                    <MDBCol md="6">
                        {/* Name */}
                        <h5>{name}</h5>

                        {/* Description */}
                        <p className=" mb-4 mb-md-0">
                            {description}
                        </p>
                    </MDBCol>
                    <MDBCol
                    md="6"
                    lg="3"
                    className="border-sm-start-none border-start"
                    >
                    <div className="d-flex flex-row align-items-center mb-1">

                        {/* Price */}
                        <h4 className="mb-1 me-1">${price}</h4>
                    </div>
                    <h6 className="text-success">Free shipping</h6>
                    <div className="d-flex flex-column mt-4">
                        <MDBBtn color="primary" size="lg" onClick={addToCart}>
                        Add to cart
                        </MDBBtn>
                    </div>
                    </MDBCol>
                </MDBRow>
                </MDBCardBody>
            </MDBCard>
            </MDBCol>
        </MDBRow>
        </MDBContainer>
    );
}

export default Item;