import React from "react";
import Navbar from "../../bootstrapComponents/Navbar";
import UserList from "./UserList";
import ItemList from "./ItemList";
import CreateItem from "./CreateItem";
import CreateAdmin from "./CreateAdmin";

export default class AdminMenu extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			page: 0
		}
	}

	pageA = e => {
		this.setState({page: 0})
	}
	pageB = e => {
		this.setState({page: 1})
	}

	navbarOptions = [
		{
			name: "Usuarios",
			page: this.pageA
		},
		{
			name: "Productos",
			page: this.pageB
		},


	]

	render() {
		let currentPage = this.state.page
		switch (currentPage) {
			case 0:
				return <div>
					<Navbar options={this.navbarOptions}>
						<div className="d-flex flex-wrap border rounded w-100">
							<UserList></UserList>
							<CreateAdmin> </CreateAdmin>
						</div>

					</Navbar>
				</div>

			case 1:
				return <div>
					<Navbar options={this.navbarOptions}>
						<div className="d-flex flex-wrap border rounded w-100">
							<ItemList/>
							<CreateItem></CreateItem>
						</div>
					</Navbar>
				</div>

			default:
				break;
		}
	}
}