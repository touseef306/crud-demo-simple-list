package org.springbootcourse.service;

import org.springbootcourse.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();
    @Override
    public Employee createEmployee(Employee employee) {
         employeeList.add(employee);
         return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(employee1 -> employee1.getId() == id)
                .findFirst();

        if (optionalEmployee.isPresent()){
            Employee employee1 = optionalEmployee.get();
            employee1.setEmail(employee.getEmail());
            employee1.setName(employee.getName());
            return  employee1;
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();

        if (optionalEmployee.isPresent()){
            employeeList.remove(optionalEmployee.get());

            return  true;
        }
        return false;
    }
}
