import React from 'react';
import {PostMethod} from '../utils/PostMethod'

export default class create extends React.Component{


    constructor(props){
        super(props)
        this.state = {
            loginAttribute : "",
            password:"",
        }
    }

    handleSubmit = async e=>{
        e.preventDefault();
        const response = await PostMethod.post(this.state, "login");
        if(response.token != null){
            localStorage.setItem("webToken",response.token)
            this.props.onFormSwitch('register')
        }
    }

    handleChange = e=> {
        switch (e.target.name){
            case "loginAttribute": this.setState({
                loginAttribute: e.target.value
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
                    <label htmlFor="loginAttribute">Email or Phone number</label>
                    <input value={this.loginAttribute} onChange={this.handleChange}type="loginAttribute" placeholder="youremail@gmail.com or +57xxxxxxxxxx" id="loginAttribute" name="loginAttribute" />
                    <label htmlFor="password">password</label>
                    <input value={this.password} onChange={this.handleChange} type="password" placeholder="********" id="password" name="password" />
                    <button type="submit">Log In</button>
                </form>
                <button className="link-btn" onClick={() => this.props.onFormSwitch('register')}>Don't have an account? Register here.</button>
            </div>
        )
    }
}