const serviceAccount = require('./csci-5410-326706-9c6d8aeaee53.json');
const admin = require('firebase-admin');


async function initializeApp() {
  
    admin.initializeApp({
      credential: admin.credential.cert(serviceAccount)
    });
  
    const db = admin.firestore();
    await db.terminate();
    return db;
  }

db.connect(error => {
    if(error){
        console.log(error);
    }else{
        console.log("Successfully Connected to the Database")
    }    
});

module.exports = connection;
