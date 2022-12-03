import * as React from 'react';
import {useEffect, useState} from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import CategoryIcon from '@mui/icons-material/Category';
import axios from "axios";
import {URLAdmin} from "../../../utils/URLManager";
import {getToken} from "../../../utils/sessionManager";


export default function ItemList() {

	const [items, setItems] = useState([])

	useEffect(() => {
		let config = {
			headers: {'Authorization': 'Bearer ' + getToken()},
		}
		axios
			.get(URLAdmin.ITEM_LIST, config)
			.then(res => {
				console.log(res.data)
				setItems(res.data)
			})
			.catch(err => {
				console.log(err)
			})
		console.log(config)
		console.log(URLAdmin.ITEM_LIST)
	}, [])

	return <div className="w-25 m-auto">
		<h1 className="text-center">
			Lista de Items
		</h1>
		<List sx={{width: '100%', maxWidth: 360, bgcolor: 'background.paper', elevation: 16}} className="shadow m-auto">

			{items.map(e => <ListItem>
				<ListItemAvatar>
					<Avatar>
						<CategoryIcon/>
					</Avatar>
				</ListItemAvatar>
				<ListItemText primary={e.name} secondary={e.description}/>

			</ListItem>)}

		</List>
	</div>
}