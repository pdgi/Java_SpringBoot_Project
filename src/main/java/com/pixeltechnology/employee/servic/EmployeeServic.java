package com.pixeltechnology.employee.servic;

import java.util.List;

import com.pixeltechnology.employee.dto.EmployeeDto;

public interface EmployeeServic {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeDto(Long id);

    public List<EmployeeDto> getAllEmployeeDto();

    public void deleteEmployeeDto(Long id);

    public EmployeeDto updateEmployeeDto(Long id, EmployeeDto employeeDto);
}
