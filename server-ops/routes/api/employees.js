const express = require('express');
const { getAllEmployees, createNewEmployee, updateEmployee, deleteEmployee, getEmployee } = require('../../controllers/employeesController');
const router = express.Router();
const verifyRoles = require('./../../middleware/verifyRoles')
const ROLES_LIST = require('./../../config/role_list')

router.route('/')
.get(
    getAllEmployees
)
.post(
    verifyRoles(1991,2001),
    createNewEmployee
)
.put(
    updateEmployee
)
.delete(
    deleteEmployee
)

router.route('/:id')
.get(
    getEmployee
)

module.exports = router