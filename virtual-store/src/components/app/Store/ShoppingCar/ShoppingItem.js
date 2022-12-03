import React from "react";
import ListItem from "@mui/material/ListItem";
import ListItemAvatar from "@mui/material/ListItemAvatar";
import Avatar from "@mui/material/Avatar";
import SportsEsportsIcon from '@mui/icons-material/SportsEsports';
import ListItemText from "@mui/material/ListItemText";
import List from "@mui/material/List";
export default class ShoppingItem extends React.Component{



    render(){
        return <div>
            <h1 className="text-center">Shopping car</h1>
            <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper', elevation: 16 }} className="shadow ">

                {this.props.items.map(e=> <ListItem>
                    <ListItemAvatar>
                        <Avatar>
                            <SportsEsportsIcon></SportsEsportsIcon>
                        </Avatar>
                    </ListItemAvatar>
                    <ListItemText primary={e.name} secondary={e.price} />
                </ListItem>)}

            </List>
        </div>
    }
}