import * as React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import {useState, useEffect} from "react";
import axios from "axios";
import {URLAdmin} from "../../../utils/URLManager";
import {getToken} from "../../../utils/sessionManager";



export default function UserList(){

    const [users, setUsers] = useState([])



    useEffect(()=>{
        let config = {
            headers: {'Authorization': 'Bearer ' + getToken()},

        }
        axios
            .get(URLAdmin.USER_LIST, config)
            .then(res =>{
                console.log(res.data)
                setUsers(res.data)
            })
            .catch(err=>{
                console.log(err)
            })



    },[])

    return <div className="w-25 m-auto">
        <h1 className="text-center">
            Lista de usuarios
        </h1>
        <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper', elevation: 16 }} className="shadow m-auto">

            {users.map(e=> <ListItem>
                <ListItemAvatar>
                    <Avatar>
                        <AccountCircleIcon></AccountCircleIcon>
                    </Avatar>
                </ListItemAvatar>
                <ListItemText primary={e.email} secondary={e.role.name} />
            </ListItem>)}

        </List>
    </div>

}