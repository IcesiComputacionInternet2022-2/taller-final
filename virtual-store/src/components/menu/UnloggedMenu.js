import React from "react";
import Login from "../user/Login"
import Signup from "../user/Signup";

export default class UnLoggedMenu extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            page: 0
        }
    }

    changePage = e=>{
        if (this.state.page === 0){
            this.setState({
                page: 1
            })
        }else{
            this.setState({
                page: 0
            })
        }
    }
    render(){
        if (this.state.page === 0) return <Login linkMethod={this.changePage} roleMethod = {this.props.method}></Login>
        else return <Signup linkMethod = {this.changePage}></Signup>

    }

}
