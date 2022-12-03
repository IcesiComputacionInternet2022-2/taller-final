import StockGrid from "./Stock/StockGrid";


import React from "react";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemAvatar from "@mui/material/ListItemAvatar";
import Avatar from "@mui/material/Avatar";
import SportsEsportsIcon from "@mui/icons-material/SportsEsports";
import ListItemText from "@mui/material/ListItemText";

export default class Sore extends React.Component{


    constructor(props) {
        super(props);
        this.state = {
            items : []
        }
    }

    addShoppingItem(e,obj){
        let items  = this.state.items;

        items.push(obj)

        this.setState({
            items:items
        })
    }

    render(){
        return <div className="d-flex flex-wrap">


            <div className="w-50 m-auto">
                <StockGrid buy = {this.addShoppingItem}></StockGrid>
            </div>










            <div className="w-25 m-auto">
                <div>
                    <h1 className="text-center">Shopping car</h1>
                    <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper', elevation: 16 }} className="shadow ">

                        {this.state.items.map(e=> <ListItem>
                            <ListItemAvatar>
                                <Avatar>
                                    <SportsEsportsIcon></SportsEsportsIcon>
                                </Avatar>
                            </ListItemAvatar>
                            <ListItemText primary={e.name} secondary={e.price} />
                        </ListItem>)}

                    </List>
                </div>
            </div>

        </div>
    }
}