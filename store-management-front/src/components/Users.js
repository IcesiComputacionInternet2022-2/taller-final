import React, { useState, useEffect } from 'react';
import DataTable from 'react-data-table-component';
import NewAdmin from './NewAdmin';


const usersURL = 'http://localhost:8080/account';

const mockData = [
    {
        userId: 1,
        userName: 'John Doe',
        email: 'alexssjr2002@gmail.com',
        address: '1234 Main St',
        role: { 
            roleId: 2,
            roleName: 'ADMIN',
            roleDescription: 'Common user role'
        }
    },
    {
        userId: 2,
        userName: 'Jane Doe',
        email: 'alexssjr2002@gmail.com',
        address: '1234 Main St',
        role: { 
            roleId: 2,
            roleName: 'USER',
            roleDescription: 'Common user role'
        }
    }
];


const columns = [
    {
        name: 'Id',
        selector: row => row.userId,
        grow: 3,
    },
    {
        name: 'Name',
        selector: row => row.userName,
        sortable: true,
    },
    {
        name: 'Email',
        selector: row => row.email,
        sortable: true,
    },
    {
        name: 'Address',
        selector: row => row.address,
        sortable: true,
    },
    {
        name: 'Role',
        selector: row => row.role.roleName,
        sortable: true,
    },
];



export default function Users() {
    const [users, setUsers] = useState([]);

    function getUsers () {
        fetch(usersURL)
            .then(response => response.json())
            .then(responseJson => {
                setUsers(responseJson);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
    
    useEffect(() => {
        getUsers();
    }, [users]);

    return (
        <DataTable
            title="All Users"
            columns={columns}
            data={mockData}
            pagination
            fixedHeader
            fixedHeaderScrollHeight="600px"
            horizontalScroll
            highlightOnHover
            actions={<NewAdmin/>}
        />
    );
}