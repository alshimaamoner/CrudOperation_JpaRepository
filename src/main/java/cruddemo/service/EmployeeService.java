package cruddemo.service;

import cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
}
