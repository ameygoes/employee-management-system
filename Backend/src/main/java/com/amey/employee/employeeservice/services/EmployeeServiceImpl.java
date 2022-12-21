package com.amey.employee.employeeservice.services;

import com.amey.employee.employeeservice.entities.EmployeeEntity;
import com.amey.employee.employeeservice.model.EmployeeModel;
import com.amey.employee.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeModel, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employeeModel;
    }

    @Override
    public List<EmployeeModel> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeModel> employees = employeeEntities.
                stream().
                map(emp -> new EmployeeModel(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId())).
                collect(Collectors.toList());
        return employees;
    }
}
