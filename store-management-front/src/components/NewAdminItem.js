import React, { useState } from 'react';
import {
    MDBInput,
    MDBBtn,
    MDBModal,
    MDBModalDialog,
    MDBModalContent,
    MDBModalHeader,
    MDBModalTitle,
    MDBModalBody,
    MDBModalFooter,
    MDBTextArea
} from 'mdb-react-ui-kit';
import { token } from '../data/Token';

const createItemUrl = 'http://localhost:8080/store/item';

export default function NewAdminItem() {
    const [basicModal, setBasicModal] = useState(false);
    
    const [name, setName] = React.useState("");
    const [description, setDescription] = React.useState("");
    const [price, setPrice] = React.useState("");

    const toggleShow = () => setBasicModal(!basicModal);

    function handleClick () {
        setBasicModal(!basicModal); 
    
        const item = {
            name: name,
            description: description,
            price: price,
        };
    
        fetch(createItemUrl, {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
            },
            body: JSON.stringify(item),
        })
            .then((response) => response.json())
            .then((data) => {
            console.log(data);
            }
        );
        
    }

    return (
        <>
        <MDBBtn onClick={toggleShow}>Create New Item</MDBBtn>
        <MDBModal show={basicModal} setShow={setBasicModal} tabIndex='-1'>
            <MDBModalDialog>
            <MDBModalContent>
                <MDBModalHeader>
                <MDBModalTitle>New Item</MDBModalTitle>
                <MDBBtn className='btn-close' color='none' onClick={toggleShow}></MDBBtn>
                </MDBModalHeader>
                <MDBModalBody>
                    <form>
                        <MDBInput className='mb-3 pt-3 pb-2' label='Name' id='nameInput' type='text' onChange={e => setName(e.target.value)} required />
                        <MDBInput className='my-3 pt-3 pb-2' label='Price' id='priceInput' type='number' step='.10' min='0' onChange={e => setPrice(e.target.value)}/>
                        <MDBTextArea className='my-3 pt-3 pb-2' label='Description' id='descriptionInput' rows={4}  onChange={e => setDescription(e.target.value)}/>
                    </form>
                </MDBModalBody>
                <MDBModalFooter>
                <MDBBtn color='secondary' onClick={toggleShow}>
                    Close
                </MDBBtn>
                <MDBBtn onClick={handleClick}>Create</MDBBtn>
                </MDBModalFooter>
            </MDBModalContent>
            </MDBModalDialog>
        </MDBModal>
        </>
    );
}