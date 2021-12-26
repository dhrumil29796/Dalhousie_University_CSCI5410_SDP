const express = require('express');
const bodyparser = require('body-parser');
const app = express();
const port = 8000;
const firestore = require("./db");    
const cors = require('cors');

app.use(cors({origin:'http://localhost:3000'}));
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended:true}));

app.get('/', (req, res) => {
    res.send('Hello.... This is your Register Container')
})

app.post('/register',(req,res)=>{
    if(!req.body){
        res.status(400).send({
            message: "Content cannot be empty"
        })
    }

    console.log("my request",req.body);
    const user = {
        Name: req.body.name,
        Email: req.body.email,
        Password: req.body.password    
    }

    registerUser(user,(err,data)=>{
        if(err){
            res.status(500).send({
                message: err.message || "some error occured while creating the user"
            });
        }else{
            res.send(data);
        }
    })

})

registerUser = (newUser,result)=>{
    async function addDocument(db) {
        const res = await db.collection('users').add({
          name: Name,
          email: Email,
          password: Password
        });
      }
}
  
app.listen(port, () => {
    console.log(`Server Started and listening on http://localhost:${port}`)
})