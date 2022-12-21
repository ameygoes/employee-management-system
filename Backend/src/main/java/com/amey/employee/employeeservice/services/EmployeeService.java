package com.amey.employee.employeeservice.services;


import com.amey.employee.employeeservice.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel createEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getEmployees();
}
