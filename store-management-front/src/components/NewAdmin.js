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
    MDBModalFooter
} from 'mdb-react-ui-kit';
import { token } from '../data/Token';

const createAdminURL = 'http://localhost:8080/accunt/register';
const roleUrl = "http://localhost:8080/account/roles";

export default function NewAdmin() {
    const [basicModal, setBasicModal] = useState(false);

    const registerRole = 'ADMIN'
    
    const [name, setName] = React.useState("");
    const [email, setEmail] = React.useState("");
    const [password, setPassword] = React.useState("");
    const [address, setAddress] = React.useState("");
    const [role, setRole] = React.useState("");

    const toggleShow = () => setBasicModal(!basicModal);

    function handleClick () {
        setBasicModal(!basicModal);

      
        fetch(roleUrl, {
            method: "GET",
            headers: {
            "Content-Type": "application/json",
            },
            })
            .then((response) => response.json())
            .then((data) => {
                data.map((role) => {
                if (role.name === registerRole) {
                    setRole(role.id)
                }
                })
            })
    
    
    
        const user = {
            name: name,
            email: email,
            password: password,
            address: address,
            role: role
        };
    
        fetch(createAdminURL, {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
            },
            body: JSON.stringify(user),
        })
            .then((response) => response.json())
            .then((data) => {
            console.log(data);
            }
        );
        
    }

    return (
        <>
        <MDBBtn onClick={toggleShow}>Create New Admin</MDBBtn>
        <MDBModal show={basicModal} setShow={setBasicModal} tabIndex='-1'>
            <MDBModalDialog>
            <MDBModalContent>
                <MDBModalHeader>
                <MDBModalTitle>New Admin</MDBModalTitle>
                <MDBBtn className='btn-close' color='none' onClick={toggleShow}></MDBBtn>
                </MDBModalHeader>
                <MDBModalBody>
                    <form>
                        <MDBInput className='mb-3 pt-3 pb-2' label='Name' id='nameInput' type='text' onChange={e => setName(e.target.value)} required />
                        <MDBInput className='my-3 pt-3 pb-2' label='Email' id='emailInput' type='email' onChange={e => setEmail(e.target.value)}/>
                        <MDBInput className='my-3 pt-3 pb-2' label='Password' id='passwordInput' onChange={e => setPassword(e.target.value)} type='text' />
                        <MDBInput className='pt-3 pb-2' label='Address' id='addressInput' onChange={e => setAddress(e.target.value)} type='text' />
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