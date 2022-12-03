import React, { useState, useEffect } from 'react';
import DataTable from 'react-data-table-component';
import NewAdminItem from './NewAdminItem';


const itemsUrl = 'http://localhost:8080/store/item';


const columns = [
    {
        name: 'Id',
        selector: row => row.itemId,
        grow: 3,
    },
    {
        name: 'Name',
        selector: row => row.itemName,
        sortable: true,
    },
    {
        name: 'Description',
        selector: row => row.itemDescription,
        sortable: true,
    },
    {
        name: 'Price',
        selector: row => row.price,
        sortable: true,
    },
];



export default function AdminItem() {
    const [items, setItems] = useState([]);

    function getItems () {
        fetch(itemsUrl)
            .then(response => response.json())
            .then(responseJson => {
                setItems(responseJson);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
    
    useEffect(() => {
        getItems();
    }, [items]);

    return (
        <DataTable
            title="All Items"
            columns={columns}
            data={items}
            pagination
            fixedHeader
            fixedHeaderScrollHeight="600px"
            horizontalScroll
            highlightOnHover
            actions={<NewAdminItem/>}
        />
    );
}