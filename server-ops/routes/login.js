const express = require('express');
const { handleLogin } = require('../controllers/authController');
const router = express.Router();

router.route('/').post(
    handleLogin
)
module.exports = router