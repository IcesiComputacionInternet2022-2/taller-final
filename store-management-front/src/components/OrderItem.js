import React from "react";

import {
    MDBBtn,
    MDBCardImage,
    MDBCol,
    MDBIcon,
    MDBInput,
    MDBRipple,
    MDBRow,
    MDBTooltip,
} from "mdb-react-ui-kit";
import { order } from "../data/OrderItem"

export default function OrderItem(props) {

    const { index, id, name, description, price, onChange, disable, showButton } = props;
    
    function handleChange (event) {
        console.log(index)
        order.orderItem[index].quantity = event.target.value;
        onChange();
        console.log(JSON.stringify(order));
    }

    /* function increase () {
        var value = parseInt(document.getElementById('quantity').value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        document.getElementById('quantity').value = value;
    }

    function decrease () {
        var value = parseInt(document.getElementById('quantity').value, 10);
        value = isNaN(value) ? 0 : value;
        if (value < 1) {
            value = 1;
        } else {
            value = '';
        }
        value--;
        document.getElementById('quantity').value = value;
    } */

    return (
        <MDBRow>
            <MDBCol lg="3" md="12" className="mb-4 mb-lg-0">
            <MDBRipple rippleTag="div" rippleColor="light"
                className="bg-image rounded hover-zoom hover-overlay">
                <MDBCardImage
                src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Bugatti_Chiron_%2836559710091%29.jpg/1200px-Bugatti_Chiron_%2836559710091%29.jpg"
                className="w-100" 
                alt="" />
                
                <a href="#!">
                <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.2)" , }}>
                </div>
                </a>
            </MDBRipple>
            </MDBCol>

            <MDBCol lg="5" md="6" className=" mb-4 mb-lg-0">
            <p>
                <strong>{name}</strong>
            </p>
            <p className="text-truncate">{description}</p>
            <p className="text-primary text-opacity-50 small">{id}</p>
            <MDBTooltip wrapperProps={{ size: "sm" }} wrapperClass="me-1 mb-2"
                title="Remove item">
                <MDBIcon fas icon="trash" />
            </MDBTooltip>

            <MDBTooltip wrapperProps={{ size: "sm" , color: "danger" }} wrapperClass="me-1 mb-2"
                title="Move to the wish list">
                <MDBIcon fas icon="heart" />
            </MDBTooltip>
            </MDBCol>
            <MDBCol lg="4" md="6" className="mb-4 mb-lg-0">
            <div className="d-flex mb-4" style={{ maxWidth: "300px" }}>

                {
                    showButton && 
                    <MDBBtn className="px-3 me-2" /* onChange={decrease} */>
                        <MDBIcon fas icon="minus" />
                    </MDBBtn>
                }
                

                <MDBInput defaultValue={1} min={0} type="number" label="Quantity" disabled={disable} onChange={handleChange}/>

                {
                    showButton && 
                    <MDBBtn className="px-3 ms-2" /* onChange={increase} */>
                        <MDBIcon fas icon="plus" />
                    </MDBBtn>
                }
                
            </div>

            <p className="text-start text-md-center">
                <strong>${price}</strong>
            </p>
            </MDBCol>
        </MDBRow>
    );
}