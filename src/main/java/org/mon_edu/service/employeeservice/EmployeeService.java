package org.mon_edu.service.employeeservice;

import org.mon_edu.model.Employee;

public interface EmployeeService {
    boolean authenticate(String email, String password);

    Employee findByEmail(String email);
}
