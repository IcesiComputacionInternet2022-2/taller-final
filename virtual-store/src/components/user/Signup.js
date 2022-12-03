
import React from "react";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

import {unsignedPost} from "../../utils/communicator";
import {URLSessions} from "../../utils/URLManager";

export default class Signup extends React.Component{
    constructor(props) {
        super(props);

        this.state = {
            form: {
                email: "",
                password: "",
                address: "",
                phoneNumber: "",
                roleName: "client"
            }
        }

    }



    handleSubmit = async e=>{
        e.preventDefault()
        if (this.state.form.address === "" && this.state.form.phoneNumber === ""){
            alert("You must fill at least one, phone number or address")
        }else{

            console.log(this.state.form)

            let response = await unsignedPost(URLSessions.SIGNUP, this.state.form);
            console.log(response)

        }
    }

    handleChange =e=>{
        let eventName = e.target.name

        switch (eventName){
            case "email":
                this.setState({
                    form: {
                        ...this.state.form, email:e.target.value
                    }
                })
            break;
            case "password":
                this.setState({
                    form: {
                        ...this.state.form, password: e.target.value
                    }
                })
            break;
            case "phoneNumber":
                this.setState({
                    form:{
                        ...this.state.form,phoneNumber:e.target.value
                    }
                })
            break;
            case "address":
                this.setState({
                    form:{
                        ...this.state.form,address:e.target.value
                    }
                })
            break;
            default: break;
        }
    }
        render(){
            return(
                <div className="card p-3 m-auto mt-5 shadow border rounded w-25">
                    <h1 className="text-center">Create an Account</h1>
                    <form onSubmit={this.handleSubmit}>
                       <div className="w-75 m-auto">
                           <TextField  label="Email" variant="outlined" type="email"
                                      onChange={this.handleChange} name="email" value={this.state.form.email}
                                      required className="w-100 m-1"
                           />
                       </div>
                        <div className="w-75 m-auto">
                            <TextField  label="Password" variant="outlined" type="password"
                                       onChange={this.handleChange} name="password" value={this.state.form.password}
                                       required className="w-100 m-1"
                            />
                        </div>
                        <div className="w-75 m-auto">
                            <TextField  label="Phone Number" variant="outlined" type="text"
                                       onChange={this.handleChange} name="phoneNumber" value={this.state.form.phoneNumber}
                                        className="w-100 m-1"

                            />
                        </div>
                        <div className="w-75 m-auto">
                            <TextField  label="Address" variant="outlined" type="text"
                                       onChange={this.handleChange} name="address" value={this.state.form.address}
                                        className="w-100 m-1"
                            />
                        </div>



                        <div className="w-25 m-auto">
                            <Button variant="contained" type = "submit" className="w-100">Login</Button>
                        </div>
                    </form>
                    <div>
                        <b  onClick={this.props.linkMethod}> Login</b>
                    </div>
                </div>
            )
        }

}