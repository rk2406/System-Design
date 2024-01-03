const { logEvents } = require('./logEvents')

const notFoundHandler = (req,res)=>{
    res.status(404).sendFile(path.join(__dirname,'views','404.html'))
}

const errHandler = (err, req, res, next)=>{
    logEvents(`${err.name}: ${err.message}`,'errorLog.txt')
    console.error(err.stack);
    res.status(500).send(err.message)
}

module.exports = {errHandler,notFoundHandler}