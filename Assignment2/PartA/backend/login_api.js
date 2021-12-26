const express = require('express');
const app = express();
const port = 8001;
const firestore = require("./db");    
const cors = require('cors');

app.use(cors({origin:'http://localhost:3000'}));

app.get('/', (req, res) => {
    res.send('Hello.... This is your Login/Logout Container')
})

app.post('/login',(req,res)=>{
    if(!req.body){
        res.status(400).send({
            message: "Content cannot be empty"
        })
    }

    console.log("my request",req.body);
    const userCredentials = {
        Email: req.body.email,
        Password: req.body.password    
    }

    registerUser(userCredentials,(err,data)=>{
        if(err){
            res.status(500).send({
                message: err.message || "some error occurred while creating the user"
            });
        }else{
            res.send(data);
        }
    })

})

app.post('/logout',(req,res)=>{
    if(!req.body){
        res.status(400).send({
            message: "Content cannot be empty"
        })
    }

    console.log("my request",req.body.id);
    const loginId = {
        id: req.body.id
    }

    logoutUser(loginId,(err,data)=>{
        if(err){
            res.status(500).send({
                message: err.message || "some error occurred while logging out the user"
            });
        }else{
            res.send(data);
        }
    })

})

registerUser = (newUser,result)=>{
    
    const loginquery =  await db.collection('users').get();
    snapshot.forEach((doc) => {
      console.log(doc.id, '=>', doc.data());
    });;
    
}


app.listen(port, () => {
    console.log(`Server Started and listening on http://localhost:${port}`)
})