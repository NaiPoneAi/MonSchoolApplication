package org.mon_edu.service.employeeservice;

import org.mon_edu.model.Employee;
import org.mon_edu.repository.EmployeeRepository;
import org.mon_edu.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService, CrudService<Employee> {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public void delete(Employee entity) {
        employeeRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(List<Employee> entities) {
        employeeRepository.deleteInBatch(entities);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean authenticate(String emp, String password) {
        Employee employee = this.findByEmail(emp);
        if (employee == null)
        {
            return false;
        } else
        {
            return password.equals(employee.getPassword());
        }
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}
