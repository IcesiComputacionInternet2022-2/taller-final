import React from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBIcon
}
from 'mdb-react-ui-kit';
import "./../styles/Login.css"
import { currentUser } from "../data/CurrentUser";
import { token } from "../data/Token";

function Login() {

  const LOGIN_API = "http://localhost:8080/account/login";
  const usersUrl = "http://localhost:8080/account";


  const [email, setEmail] = React.useState("");
  const [password, setPassword] = React.useState("");

  function handleLogin () {
    fetch(LOGIN_API, {
      method: "POST",
      headers: {  
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: email,
        password: password,
      }),
    })
      .then((response) => response.json())
      .then((data) => {
        token = data.token;
        console.log(data);
        getRole();
        showWindow();
      }
    );
  }

  function getRole() {
    fetch(usersUrl, {
      method: "GET",
      headers: {
        "Content-Type": "application/json"
      },
    })
      .then((response) => response.json())
      .then((data) => {
        data.map((user) => {
          if (user.email === email) {
            currentUser.id = user.id;
            currentUser.name = user.name;
            currentUser.email = user.email;
            currentUser.address = user.address;
            currentUser.password = user.password;
            currentUser.roleId = user.role.roleId;
            currentUser.roleName = user.role.name;

          }
        })
      })
  }

  function showWindow() {
    if (currentUser.roleName === "ADMIN") {
      window.location.href = "/admin";
    } else if (currentUser.roleName === "USER") {
      window.location.href = "/list";
    }
  }

  return (
    <MDBContainer fluid>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol col='12'>

          <MDBCard className='bg-light text-dark my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '400px'}}>
            <MDBCardBody className='p-5 d-flex flex-column align-items-center mx-auto w-100'>

              <h2 className="fw-bold mb-2 text-uppercase">Login</h2>
              <p className="text-dark-50 mb-5">Please enter your login and password!</p>

              <MDBInput value={email} onChange={e => setEmail(e.target.value)} wrapperClass='mb-4 mx-5 w-100' labelClass='text-dark' label='Email address' id='formControlLg' type='email' size="lg"/>
              <MDBInput value={password} onChange={e => setPassword(e.target.value)} wrapperClass='mb-4 mx-5 w-100' labelClass='text-dark' label='Password' id='formControlLg' type='password' size="lg"/>

              <p className="small mb-3 pb-lg-2"><a class="text-dark-50" href="#!">Forgot password?</a></p>
              <MDBBtn outline className='mx-2 px-5' color='white' size='lg' onClick={handleLogin}>
                Login
              </MDBBtn>

              <div className='d-flex flex-row mt-3 mb-5'>
                <MDBBtn href='https://github.com/cuatrosr/store-managment-front' tag='a' color='dark' className='m-3' style={{ color: 'white' }}>
                  <MDBIcon fab icon='github' size="lg"/>
                </MDBBtn>
              </div>

              <div>
                <p className="mb-0">Don't have an account? <a href="/register" class="text-dark-50 fw-bold">Sign Up</a></p>

              </div>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
  );
}

export default Login;