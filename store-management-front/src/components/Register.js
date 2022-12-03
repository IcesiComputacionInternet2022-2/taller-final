import React from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBCardImage,
  MDBInput,
  MDBIcon,
  MDBCheckbox
}
from 'mdb-react-ui-kit';

function Register() {

  const url = "http://localhost:8080/account/register";
  const roleUrl = "http://localhost:8080/account/roles";

  const [name, setName] = React.useState("");
  const [email, setEmail] = React.useState("");
  const [password, setPassword] = React.useState("");
  const [passwordConfirmation, setPasswordConfirmation] = React.useState("");
  const [address, setAddress] = React.useState("");
  const [role, setRole] = React.useState("");

  const registerRole = 'USER'

  function handleClick () {
    if (password === passwordConfirmation) {
      
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

      fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
      })
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
        }
      );
    } else {
      alert("Passwords do not match!");
    }
  }

  return (
    <MDBContainer>
      <MDBCard className='text-black m-5' style={{borderRadius: '25px'}}>
        <MDBCardBody>
          <MDBRow>
            <MDBCol md='10' lg='6' className='order-2 order-lg-1 d-flex flex-column align-items-center'>

              <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

              {/* TODO: Search how to fill the entire column with the MDBInput*/}
              
              <div className="d-flex flex-row  align-items-center mb-4">
                <MDBIcon fas icon="user me-3" size='lg'/>
                <MDBInput label='Your Name' id='form1' type='text' value={name} onChange={e => setName(e.target.value)}/>
              </div>

              <div className="d-flex flex-row align-items-center mb-4">
                <MDBIcon fas icon="envelope me-3" size='lg'/>
                <MDBInput label='Your Email' id='form2' type='email' value={email} onChange={e => setEmail(e.target.value)}/>
              </div>

              <div className="d-flex flex-row align-items-center mb-4">
                <MDBIcon fas icon="lock me-3" size='lg'/>
                <MDBInput label='Password' id='form3' type='password' value={password} onChange={e => setPassword(e.target.value)}/>
              </div>

              <div className="d-flex flex-row align-items-center mb-4">
                <MDBIcon fas icon="key me-3" size='lg'/>
                <MDBInput label='Repeat your password' id='form4' type='password' value={passwordConfirmation} onChange={e => setPasswordConfirmation(e.target.value)}/>
              </div>

              <div className="d-flex flex-row align-items-center mb-4">
                <MDBIcon fas icon="map-marked-alt" className='me-3' size='lg'/>
                <MDBInput label='Address' id='form5' type='text' value={address} onChange={e => setAddress(e.target.value)}/>
              </div>

              <div className='mb-4'>
                <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Subscribe to our newsletter' />
              </div>

              <MDBBtn href='/' className='mb-4' size='lg' onClick={handleClick}>Register</MDBBtn>

            </MDBCol>

            <MDBCol md='10' lg='6' className='order-1 order-lg-2 d-flex align-items-center'>
              <MDBCardImage src='https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp' fluid/>
            </MDBCol>

          </MDBRow>
        </MDBCardBody>
      </MDBCard>

    </MDBContainer>
  );
}

export default Register;