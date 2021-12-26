const express = require('express');
const bodyparser = require('body-parser');
const app = express();
const port = 8002;
const firestore = require("./db");    
const cors = require('cors');

app.use(cors({origin:'http://localhost:3000'}));
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended:true}));

app.get('/', (req, res) => {
    res.send('Hello.... This is your Users Container')
})

app.get('/users',(req,res)=>{
    viewAllusers((err,data)=>{
        if(err){
            res.status(500).send({
                message: err.message || "some error occured while logging out the user"
            });
        }else{
            res.send(data);
        }
    })
})

viewAllusers = (result)=>{
    const snapshot = await db.collection('users').get();
    snapshot.forEach((doc) => {
      console.log(doc.id, '=>', doc.data());
    });
}

app.listen(port, () => {
    console.log(`Server Started and listening on http://localhost:${port}`)
})