import React from 'react';

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
        e.preventDefault();
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
                <input value={this.phoneNumber} onChange={this.handleChange} type="phoneNumber" placeholder="youremail@gmail.com" id="phoneNumber" name="phoneNumber" />
                <label htmlFor="address">Address</label>
                <input value={this.address} onChange={this.handleChange} type="address" placeholder="youremail@gmail.com" id="address" name="address" />
                <label htmlFor="password">Password</label>
                <input value={this.password} onChange={this.handleChange} type="password" placeholder="********" id="password" name="password" />
                <button type="submit" >Register</button>
            </form>
            <button className="link-btn" onClick={() => this.props.onFormSwitch('login')}>Already have an account? Login here.</button>
        </div>
            
        )
    }
}