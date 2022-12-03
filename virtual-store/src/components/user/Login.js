import React from "react";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import {unsignedPost} from "../../utils/communicator";
import {URLSessions} from "../../utils/URLManager";
import {saveCookie} from "../../utils/sessionManager";

export default class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            form: {
                username: '',
                password: ''
            }
        }
    }

    handleChange = e => {
        if (e.target.name === 'username') {
            this.setState({
                form: {
                    ...this.state.form, username: e.target.value
                }
            })
        } else {
            this.setState({
                form: {
                    ...this.state.form,
                    password: e.target.value
                }
            })
        }


    }


    handleSubmit = async e => {
        e.preventDefault()

        let response = await unsignedPost(URLSessions.LOGIN, this.state.form)
        saveCookie(response)
        this.setState({
            form: {
                username : "",
                password: ""
            }
        })

        this.props.roleMethod()
    }



    render(){
        return (
            <div className="card p-3 m-auto mt-5 shadow border rounded w-25">
                <h1 className="text-center">Sign in</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className="w-75 m-auto">
                        <TextField  label="Email or Phone number" variant="outlined" type="text"
                                    onChange={this.handleChange} name="username" value={this.state.form.username}
                                    className="w-100 "
                        />
                    </div>
                    <br/>
                    <div className="w-75 m-auto">
                        <TextField  label="Password" variant="outlined" type="password"
                                    onChange={this.handleChange} name="password" value={this.state.form.password}
                                    className="w-100 "
                        />
                    </div>
                    <br/>

                    <div className="w-25 m-auto">
                        <Button className="w-100" variant="contained" type = "submit">Login</Button>
                    </div>
                </form>
                <div>
                    <b  onClick={this.props.linkMethod}> Create an account</b>
                </div>
            </div>
        )
    }
}