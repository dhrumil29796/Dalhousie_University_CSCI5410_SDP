import React, { useState } from 'react';
import { Redirect } from 'react-router';
import UserService from "../services/user.service";



const Login = () => {

    const [loginDetails,setUserDetails] = useState("");

    function handleUserChange(e){
        let attribute = e.target.name;
        let value = e.target.value;
        setUserDetails({...loginDetails, [attribute] : value.trim()});
    }

    function submitLoginRequest(){
        UserService.loginUser(loginDetails).then(() => {
            window.location.reload();
        });
    }

    return ( <div className="row justify-content-center" >
    <div className="col-xl-3 col-md-4 col-sm-6 col-12">
        <h1 className="text-center mt-5">Login</h1>
        <div className="mt-4">
            <form>
                <div className="form-group">
                    <input type="text" className="form-control" name="email" placeholder="Email" onChange={handleUserChange}/>
                    <small id="emailHelp" className="form-text text-danger"></small>
                </div>
                <div className="form-group ">
                    <input type="password" className="form-control" name="password" placeholder="Password" onChange={handleUserChange}/>
                    <small id="passwordHelp" className="form-text text-danger"></small>
                </div>
                <div className="text-center mt-5">
                    <button type="button" onClick={submitLoginRequest} className="btn btn-primary" placeholder="Submit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div> );
}
 
export default Login;