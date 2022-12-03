import {useEffect, useState} from "react";
import {getToken} from "../../../../utils/sessionManager";
import axios from "axios";
import {URLAdmin} from "../../../../utils/URLManager";
import Card from "@mui/material/Card";
import {Button, CardActionArea, CardActions} from "@mui/material";
import CardMedia from "@mui/material/CardMedia";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import * as React from "react";



export default function StockGrid(){

    const [items, setItems] = useState([])

    useEffect(()=>{
        let config = {
            headers: {'Authorization': 'Bearer ' + getToken()},

        }
        axios
            .get(URLAdmin.CREATE_ITEM, config)
            .then(res =>{
                console.log(res.data)
                setItems(res.data)
            })
            .catch(err=>{
                console.log(err)
            })



    },[])

    return <div>
        <h1 className="text-center">Tienda virtual</h1>
        <div className="d-flex flex-wrap w-100 shadow rounded">

            {items.map(e=>
                <Card sx={{ maxWidth: 345 }}>
                    <CardActionArea>
                        <CardMedia
                            component="img"
                            height="140"
                            image="https://cdnx.jumpseller.com/la-cali/image/8313008/resize/1200/1200?1652484103"
                            alt="green iguana"
                        />
                        <CardContent>
                            <Typography gutterBottom variant="h5" component="div">
                                {e.name}
                            </Typography>
                            <Typography variant="body2" color="text.secondary">
                                {e.description}
                            </Typography>

                            <Typography variant="body2" color="text.secondary">
                                ${e.price}
                            </Typography>
                        </CardContent>
                    </CardActionArea>
                    <CardActions>
                        <Button size="small" color="primary"  >
                            Buy
                        </Button>
                    </CardActions>
                </Card>
            )}
        </div>
    </div>
}