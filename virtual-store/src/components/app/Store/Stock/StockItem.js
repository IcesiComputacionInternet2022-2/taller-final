import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';

export default class StockItem extends React.Component{






    render (){
        return (
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
                            {this.props.name}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            {this.props.description}
                        </Typography>

                        <Typography variant="body2" color="text.secondary">
                            ${this.props.price}
                        </Typography>
                    </CardContent>
                </CardActionArea>
                <CardActions>
                    <Button size="small" color="primary" >
                        Buy
                    </Button>
                </CardActions>
            </Card>
        );
    }
}