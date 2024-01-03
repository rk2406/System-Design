const users ={
    users: require('../models/users.json'),
    setUsers: (data) => {users.users = data}
}
const fsPromises = require('fs').promises
const path = require('path')
const bcrypt = require('bcrypt')

const handleNewUser = async (req,res)=>{
    const {user,pwd} = req.body;
    if(!user || !pwd){
        return res.status(400).json({
            'message' : 'Username  and password are required'
        })
    }
    const duplicate = users.users.find( person => person.userName === user)
    if(duplicate){
        return res.status(400).json({
            'message' : 'Username  already present'
        })
    }
    try{
        const hashedPwd = await bcrypt.hash(pwd,10);
        const newUser = {
            userName : user,
            roles:{
                "User": 2001
            },
            password: hashedPwd,
        }
        users.setUsers([...users.users,newUser])
        console.log(users)
        await fsPromises.writeFile(
            path.join(__dirname,'..','models','users.json'),
            JSON.stringify(users.users)
        )
        return res.status(201).json({
            'message' : 'New user created'
        })
    }   
    catch(err){
        return res.status(500).json({
            'message' : err.message
        })
    }
}

 module.exports ={
    handleNewUser
 }