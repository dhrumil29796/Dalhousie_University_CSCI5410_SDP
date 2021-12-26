import axios from 'axios';


const addUser=(userDetails)=>{
    axios.post("https://register-api-service-b7oqskezaq-uc.a.run.app/register",userDetails)
    .then((response)=>{
        console.log(response);
    },(error)=>{
        console.log(error);
    })
}

const loginUser= (loginCredentials)=>{
    return axios.post("https://login-api-service-b7oqskezaq-uc.a.run.app/login",loginCredentials)
    .then((response)=>{
        if(response.data){
            localStorage.setItem("username", JSON.stringify(response.data.id));
        }
        return response.data;
    },(error)=>{
        console.log(error);
    })
}

const logoutUser = (loginCredentials1)=>{
    return axios.post("https://login-api-service-b7oqskezaq-uc.a.run.app/logout",loginCredentials1)
    .then((response)=>{
        if(response.data){
            localStorage.removeItem("username");
        }
    },(error)=>{
        console.log(error);
    })
}

const getAllUsers = ()=>{
    return axios.get("https://users-api-service-b7oqskezaq-uc.a.run.app/users");
}

export default {
    addUser,
    loginUser,
    logoutUser,
    getAllUsers
}