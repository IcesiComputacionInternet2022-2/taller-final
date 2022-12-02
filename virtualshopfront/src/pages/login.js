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
            password:"",
        }
    }

    handleSubmit = async e => {
        e.preventDefault()

        let response = await unsignedPost(URLSessions.LOGIN, this.state)
        saveCookie(response)
        console.log(this.state.email)

        const {token} = response
        if (!token) alert("Error " + response.code + "\n" + response.message)
    }

    handleChange = e=> {
        switch (e.target.name){
            case "email": this.setState({
                email: e.target.value,
                phoneNumber: e.target.value
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
                <h2>User Login</h2>
                <form className="login-form" onSubmit={this.handleSubmit}>
                    <label htmlFor="email">Email or Phone number</label>
                    <input value={this.email} onChange={this.handleChange}type="email" placeholder="youremail@gmail.com or +57xxxxxxxxxx" id="email" name="email" />
                    <label htmlFor="password">password</label>
                    <input value={this.password} onChange={this.handleChange} type="password" placeholder="********" id="password" name="password" />
                    <button type="submit" onClick={this.handleSubmit}>Log In</button>
                </form>
                <button className="link-btn" onClick={() => this.props.onFormSwitch('register')}>Don't have an account? Register here.</button>
            </div>
        )
    }
}