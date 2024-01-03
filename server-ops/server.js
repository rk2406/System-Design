const express = require('express');
const path = require('path');
const app = express();
const PORT = process.env.PORT || 3500;
const cors = require('cors');
const {logger,} = require('./middleware/logEvents');
const {errHandler, notFoundHandler} = require('./middleware/errorHandler');
const corsOptions = require('./config/corsOptions');
const { verifyJwt } = require('./middleware/verifyJwt');
const cookieParser = require('cookie-parser')
const credentials = require('./middleware/credentials');
const connectDB = require('./config/databaseSetup');
const { default: mongoose } = require('mongoose');

connectDB();

app.use(logger);
app.use(cors(corsOptions))

app.use(express.urlencoded({
    extended: false
}))

app.use(express.json());

app.use(credentials);
app.use(cookieParser())

app.use('/',express.static(path.join(__dirname,'/public')))
app.use('/subdir',express.static(path.join(__dirname,'/public')))

app.use('/', require('./routes/root'))
app.use('/subdir', require('./routes/subdir'))

app.use('/register',require('./routes/register'))
app.use('/login',require('./routes/login'))
app.use('/refresh',require('./routes/refresh'))

app.use(verifyJwt)
app.use('/employees', require('./routes/api/employees'))

app.use('*',[notFoundHandler])
app.use(errHandler)

mongoose.connection.once('open',()=>{
    console.log("Connected to database")
    app.listen(PORT,()=>{
        console.log(`Server running on port ${PORT}`)
    })
})
