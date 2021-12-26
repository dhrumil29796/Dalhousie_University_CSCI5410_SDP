import React, { useEffect, useState } from 'react';
import UserService from "../services/user.service";

const Navbar = () => {

    const [showloggedin, setloggedin] = useState(false);

    useEffect(() =>{
        if(localStorage.getItem("userID")){
            setloggedin(true);
        }
    })

    function handlelogout() {
        const loginDetails = { id: localStorage.getItem("userID")}
        UserService.logoutUser(loginDetails).then(() => {
            console.log(localStorage.getItem("userID"));
            window.location.reload();
        });
    }

    return ( <nav className="navbar navbar-expand-lg navbar-light bg-light" id="home-navbar">
    <a className="navbar-brand" href="#">Assignment 2 CSCI 5410</a>
    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="#navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse justify-content-between" id="navbarContent">
        <ul className="navbar-nav">
            { !showloggedin && <li><a className="nav-item nav-link" href="/login">Login</a></li>}
            <li><a className="nav-item nav-link" href="/register">Register</a></li>
            { showloggedin && (<li><a className="nav-item nav-link" href="/users">Users</a></li>) }
            { showloggedin && (<li><a className="nav-item nav-link" href="/login" onClick={handlelogout}>Logout</a></li>) }
        </ul>
    </div>
</nav> );
}
 
export default Navbar;