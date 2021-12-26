import React, { useState } from 'react';
import addUser from '../services/user.service';

const Register = () => {

    const [userDetails,setUserDetails] = useState("");

    function handleUserChange(e){
        let attribute = e.target.name;
        let value = e.target.value;
        setUserDetails({...userDetails, [attribute] : value.trim()});
    }

    function submitUser(e){
        addUser(userDetails);
    }

    return ( <div className="row justify-content-center">
    <div className="col-md-6 col-sm-8">
        <h1 className="text-center mt-5">Register</h1>
        <div className="mt-4">
            <form onSubmit={submitUser} >
                <div className="form-group">
                    <input type="text" className="form-control" name="name" onChange={handleUserChange} placeholder="First Name" />
                </div>
                <div className="form-group">
                    <input type="text" className="form-control" name="email" onChange={handleUserChange} placeholder="Email"/>
                </div>
                <div className="form-group">
                    <input type="password" className="form-control" name="password" onChange={handleUserChange} placeholder="Password"/>
                </div>
                <div className="text-center mt-5">
                    <button type="submit"  className="btn btn-primary" placeholder="Submit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>  );
}
 
export default Register;