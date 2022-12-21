package com.amey.employee.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
