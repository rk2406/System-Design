const users = {
    users: require('../models/users.json'),
    setUsers: (data) => { users.users = data }
}

require('dotenv').config();
const jwt = require('jsonwebtoken')

const handleRefreshToken = async (req, res) => {
    const cookies = req.cookies;

    if (!cookies?.jwt) {
        console.log(cookies)
        return res.status(401).json({
            'message': 'Unauthorized'
        })
    }
    const refreshToken = cookies.jwt
    const foundUser = users.users.find(person => person.refreshToken === refreshToken)
    if (!foundUser) {
        return res.status(403).json({
            'message': 'Forbidden'
        })
    }

    jwt.verify(
        refreshToken,
        process.env.REFRESH_TOKEN_SECRET,
        (err,decoded)=>{
            if(err || foundUser.userName !== decoded.userName){
                return res.status(401).json({
                    'message': 'Unauthorized'
                })
            }
            const roles = Object.values(foundUser.roles)
            const accessToken = jwt.sign(
                {
                    "userInfo":{
                        "userName" : decoded.userName,
                        "roles": roles
                    }
                },
                process.env.ACCESS_TOKEN_SECRET,
                {
                    expiresIn : '30s'
                }
            )
            return res.status(200).json(accessToken)
        }
    )
}

module.exports = { handleRefreshToken }