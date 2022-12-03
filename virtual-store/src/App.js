import './App.css';
import LoggedMenu from "./components/menu/LoggedMenu";
import UnLoggedMenu from "./components/menu/UnloggedMenu";
import React from "react";
import Header from "./components/bootstrapComponents/Header";
import {getRole} from "./utils/sessionManager";
import AdminMenu from "./components/app/admin/AdminMenu";




class App extends React.Component{
  constructor(props) {
    super(props);
    this.state = {
      page: 1,
      role: false
    }
  }

  changePage = e=>{
    if (this.state.page === 0)this.setState({page: 1})
    else this.setState({page:0})
  }

  changeRole = e=>{
    this.setState({role: true})
  }

  render(){
    let roll = getRole()
    console.log(roll)
    if (roll === "client"){
      return (
          <Header>
            <LoggedMenu></LoggedMenu>
          </Header>
      )
    }else if (roll === "admin"){
      return <Header>
       <div><AdminMenu></AdminMenu>  </div>
      </Header>
    }else return <Header>
       <UnLoggedMenu method = {this.changeRole}></UnLoggedMenu>
    </Header>
  }
}
export default App;
