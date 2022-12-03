import React from "react";
import Users from "./Users";
import AdminItems from "./AdminItem";
import { MDBContainer } from "mdb-react-ui-kit";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

export default function AdminDashboard() {
    return (
        <MDBContainer fluid className='d-flex flex-column justify-content-center vh-100'>
            <div>
                <Routes>
                    <Route path='/users' element={<Users/>} />
                    <Route path='/items' element={<AdminItems/>} />
                </Routes>
            </div>
        </MDBContainer>
    );
}


