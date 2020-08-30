package cruddemo.service;


import cruddemo.dao.EmployeeRepository;
import cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServieImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
   @Autowired
    public EmployeeServieImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return  employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Optional<Employee> result=employeeRepository.findById(id);
       Employee employee=null;

       if(result.isPresent()) {
           employee = result.get();
       }else{
           throw new RuntimeException("id not found" + id);
       }
       return employee;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


}
