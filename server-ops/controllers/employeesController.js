const data = {};
data.employees = require('./../models/employees.json')

const getAllEmployees = (req,res)=>{
    res.json(data.employees)
}

const createNewEmployee = (req,res)=>{
    const newEmployee = {
        "id" : data.employees[data.employees.length-1].id+1 || 1,
        "firstName" : req.body.firstName,
        "lastName" : req.body.lastName
    }
    if(!newEmployee.firstName || !newEmployee.lastName){
        res.status(400).json({'message':'Invalid arguments'})
    }
    res.status(201).json(newEmployee)
}

const updateEmployee = (req,res)=>{
    res.json({
        "firstName" : req.body.firstName,
        "lastName" : req.body.lastName
    })
}

const deleteEmployee = (req,res)=>{
    const employee = data.employees.find((emp)=>{
        return parseInt(emp.id) == parseInt(req.body.id)
    })
    if(!employee){
        res.status(400).json({'message':'Id not found'})
    }
    const filteredEmployees = data.employees.filter(emp=>emp.id !== parseInt(req.body.id))
    res.json({
        filteredEmployees
    })
}

const getEmployee = (req,res)=>{
    const employee = data.employees.find((emp)=>{
        return parseInt(emp.id) == parseInt(req.params.id)
    })
    if(!employee){
        res.status(400).json({'message':'Id not found'})
    }
    res.json({
        employee
    })
}

module.exports ={
    getAllEmployees,
    createNewEmployee,
    updateEmployee,
    deleteEmployee,
    getEmployee
}