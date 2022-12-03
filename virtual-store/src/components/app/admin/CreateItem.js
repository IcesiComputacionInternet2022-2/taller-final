import React from "react";

import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import {signedPost} from "../../../utils/communicator";
import {URLAdmin} from "../../../utils/URLManager";


export default class CreateItem extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            form : {
                name: "",
                description: "",
                price: 0
            }
        }

    }

    handleChange = e =>{
        let name = e.target.name
        switch (name){
            case "name": this.setState({
                form : {
                    ...this.state.form, name: e.target.value
                }
            }); break;

            case "description": this.setState({
                form: {
                    ...this.state.form, description:e.target.value
                }
            }); break;

            case "price": this.setState({
                form: {
                    ...this.state.form, price: e.target.value
                }
            }); break;

            default: break;
        }
    }

    handleSubmit = async e=>{
        e.preventDefault()
        let response = await signedPost(URLAdmin.CREATE_ITEM, this.state.form)
        console.log(response)
    }
    render(){
        return <div className="card p-3 m-auto shadow border rounded w-50">

            <h1 className="text-center my-4">Create Item</h1>
            <form onSubmit={this.handleSubmit}>
                <div className="w-75 m-auto">
                    <TextField  label="Nombre del producto" variant="outlined" type="text"
                                onChange={this.handleChange} name="name" value={this.state.form.email}
                                className="w-100 "
                    />
                </div>
                <br/>
                <div className="w-75 m-auto">
                    <TextField  label="Descripción" variant="outlined" type="text" multiline
                                onChange={this.handleChange} name="description" value={this.state.form.email}
                                className="w-100 "
                    />
                </div>
                <br/>
                <div className="w-75 m-auto">
                    <TextField  label="Precio" variant="outlined" type="number"
                                onChange={this.handleChange} name="price" value={this.state.form.email}
                                className="w-100 "
                    />
                </div>
                <br/>

               <div className="w-50 m-auto my-3">
                   <Button className="w-100" variant="contained" type = "submit">Create Item</Button>
               </div>

            </form>
        </div>
    }
}