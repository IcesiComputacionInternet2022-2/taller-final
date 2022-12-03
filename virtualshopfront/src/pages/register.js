import React from 'react';
import {unsignedPost} from "../utils/com";
import {URLSessions} from "../utils/url";
import {saveCookie} from "../utils/ses";

export default class create extends React.Component{


    constructor(props){
        super(props)
        this.state = {
            email : "",
            phoneNumber: "",
            address:"",
            password:"",
        }
    }

    handleSubmit = async e=>{
        e.preventDefault()
            let response = await unsignedPost(URLSessions.SIGNUP, this.state);
            const {code,email,phoneNumber} = response
            if (code) alert(response.code + "\n" + response.message)
            else if (email) alert("created user with email "+email)
            else if(phoneNumber) alert("created user with phone number "+phoneNumber)

    }

    handleChange = e=> {
        switch (e.target.name){
            case "email": this.setState({
                email: e.target.value
            });
            break;
            case "phoneNumber": this.setState({
                phoneNumber: e.target.value,
            });
            break;
            case "address": this.setState({
                address: e.target.value
            });
            break;
            case "password": this.setState({
                password: e.target.value
            });
            break;
            default:
            break;
        }
    }


    render(){
        return (
            <div className="auth-form-container">
            <h2>Register</h2>
            <form className="register-form" onSubmit={this.handleSubmit}>
                <label htmlFor="email">Email</label>
                <input value={this.email} onChange={this.handleChange} type="email" placeholder="youremail@gmail.com" id="email" name="email" />
                <label htmlFor="phoneNumber">Phone Number</label>
                <input value={this.phoneNumber} onChange={this.handleChange} type="phoneNumber" placeholder="+573166670887" id="phoneNumber" name="phoneNumber" />
                <label htmlFor="address">Address</label>
                <input value={this.address} onChange={this.handleChange} type="address" placeholder="Calle 6ta..." id="address" name="address" />
                <label htmlFor="password">Password</label>
                <input value={this.password} onChange={this.handleChange} type="password" placeholder="********" id="password" name="password" />
                <button type="submit" >Register</button>
            </form>
            <button className="link-btn" onClick={() => this.props.onFormSwitch('login')}>Already have an account? Login here.</button>
        </div>
            
        )
    }
}