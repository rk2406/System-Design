const users = {
    users: require('../models/users.json'),
    setUsers: (data) => { users.users = data }
}
const fsPromises = require('fs').promises
const path = require('path')
require('dotenv').config();
const jwt = require('jsonwebtoken')
const bcrypt = require('bcrypt')


const handleLogin = async (req, res) => {
    const { user, pwd } = req.body;
    if (!user || !pwd) {
        return res.status(400).json({
            'message': 'Username  and password are required'
        })
    }
    const foundUser = users.users.find(person => person.userName === user)
    if (!foundUser) {
        return res.status(401).json({
            'message': 'Unauthorized'
        })
    }
    const match = await bcrypt.compare(pwd, foundUser.password);
    if (match) {
        const roles = Object.values(foundUser.roles)
        const accessToken = jwt.sign({
                "userInfo":{
                    "userName": foundUser.userName,
                    "roles": roles
                }
            },
            process.env.ACCESS_TOKEN_SECRET,
            {
                expiresIn: '30s'
            });

        const refreshToken = jwt.sign({
            "userName": foundUser.userName
        },
            process.env.REFRESH_TOKEN_SECRET,
            {
                expiresIn: '1d'
            });

        const otherUsers = users.users.filter(person => person.userName != foundUser.userName)
        const currentUser = { ...foundUser, refreshToken };
        users.setUsers([...otherUsers, currentUser]);
        await fsPromises.writeFile(path.join(__dirname, '..', 'models', 'users.json'),
            JSON.stringify(users.users))
        
        res.cookie('jwt',refreshToken,{
            httpOnly:true,
            sameSite: 'None', 
            secure: false, 
            maxAge: 24 * 60 * 60 * 1000
        });
        return res.status(200).json({
            'accessToken': accessToken
        })
    }
    else {
        return res.status(401).json({
            'message': 'Unauthorized'
        })
    }
}

module.exports = { handleLogin }