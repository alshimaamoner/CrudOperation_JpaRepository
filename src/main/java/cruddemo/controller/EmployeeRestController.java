package cruddemo.controller;


import cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private cruddemo.service.EmployeeService EmployeeService;

    @Autowired
    public EmployeeRestController(cruddemo.service.EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return EmployeeService.findAll();
    }
    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id){
        Employee employee= EmployeeService.findById(id);
        if(employee==null)
            throw  new RuntimeException("Employee Not Found"+id);
        return employee;
    }
    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        //must pass id
        employee.setId(0);
        EmployeeService.save(employee);
        return employee;
    }
    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){
        //must pass id
        EmployeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Employee employee=EmployeeService.findById(id);
        if (employee==null)
            throw new RuntimeException("id not found "+id);
        EmployeeService.deleteById(id);
        return "Employee Deleted Successfully ";
    }
}
