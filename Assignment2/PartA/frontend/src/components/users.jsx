import React, { useEffect, useState } from 'react';
import UserService from '../services/user.service';

const Users = () => {

    let [userstate, setUserState] = useState([]);

    useEffect(() => {
       UserService.getAllUsers().then((response)=>{
           console.log(response.data);
           setUserState(response.data);
       })
    },[]);

    return (
    <div>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Status</th>
                </tr>
            </thead>
            <tbody>
                { userstate.map((eachrow => 
                    <tr>
                        <td>{eachrow.Id}</td>
                        <td>{eachrow.Name}</td>
                        <td>{eachrow.Email}</td>
                        <td>{eachrow.State}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>);
}

export default Users;