package com.pixeltechnology.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixeltechnology.employee.dto.EmployeeDto;
import com.pixeltechnology.employee.servic.EmployeeServic;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServic employeeService;

    @PostMapping("/create")
    ResponseEntity<EmployeeDto> createEmployeeDto(@RequestBody EmployeeDto employeeDto) {
        System.out.println("Employee Controller Dto : " + employeeDto);
        EmployeeDto createEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(createEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDto> getEmployeeDto(@PathVariable Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeDto(id);
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);

    }

    @GetMapping("/all")
    ResponseEntity<List<EmployeeDto>> getAll() {
        List<EmployeeDto> allEmployeeDto = employeeService.getAllEmployeeDto();
        return new ResponseEntity<List<EmployeeDto>>(allEmployeeDto, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        employeeService.deleteEmployeeDto(id);
        return new ResponseEntity<String>("Data deleted successfully !", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<EmployeeDto> updateEmployeeDto(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        System.out.println("Employee Controller Dto : " + employeeDto);
        EmployeeDto createEmployee = employeeService.updateEmployeeDto(id, employeeDto);
        return new ResponseEntity<EmployeeDto>(createEmployee, HttpStatus.OK);
    }
}
