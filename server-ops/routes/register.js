const express = require('express');
const { handleNewUser } = require('../controllers/registerCotroller');
const router = express.Router();

router.route('/').post(
    handleNewUser
)
module.exports = router