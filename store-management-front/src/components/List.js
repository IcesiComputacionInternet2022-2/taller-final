import React, { useEffect, useState } from "react";
import { MDBContainer } from "mdb-react-ui-kit";
import Item from "./Item";

const ITEMS_URL = "http://localhost:3000/items";

function List() {
  const {items, setItems} = useState('')

  const getData = () => {
    fetch(ITEMS_URL)
      .then((response) => response.json())
      .then((data) => {
        setItems(data);
      });
  };

  useEffect(() => {
    getData();
  }, []);


  return (
    <MDBContainer fluid>
              
      {
        items && items.length > 0 && items.map((item) => {
          return <Item 
                  id={item.id}
                  name={item.name} 
                  description={item.description} 
                  price={item.price}
                  />
        })
      }
    </MDBContainer>
  );
}

export default List;