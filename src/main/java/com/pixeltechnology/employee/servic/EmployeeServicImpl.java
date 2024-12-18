package com.pixeltechnology.employee.servic;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeltechnology.employee.dto.AddressDto;
import com.pixeltechnology.employee.dto.EmployeeDto;
import com.pixeltechnology.employee.entity.Address;
import com.pixeltechnology.employee.entity.Employee;
import com.pixeltechnology.employee.exception.RecordNotFoundException;
import com.pixeltechnology.employee.repository.EmployeeRepository;

@Service
public class EmployeeServicImpl implements EmployeeServic {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        System.out.println("EmployeeServiceImpl  Dto  : " + employeeDto);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        System.out.println("Convert employee Dto to employee ");
        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeDto(Long id) {
        // TODO Auto-generated method
        Employee findById = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record not found with the given id :  " + id));
        EmployeeDto employeeDto = modelMapper.map(findById, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployeeDto() {
        // TODO Auto-generated method stub
        List<Employee> findAll = employeeRepository.findAll();
        List<EmployeeDto> employeeDto = findAll.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        return employeeDto;
    }

    @Override
    public void deleteEmployeeDto(Long id) {
        // TODO Auto-generated method stub
        Employee findById = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record not found with the given id :  " + id));
        employeeRepository.deleteById(id);

    }

    @Override
    public EmployeeDto updateEmployeeDto(Long id, EmployeeDto employeeDto) {
        // Fetch the existing employee record
        Employee oldEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record not found with the given id: " + id));

        // Update the fields of the existing employee with the data from the DTO
        oldEmployee.setFirstName(employeeDto.getFirstName());
        oldEmployee.setLastName(employeeDto.getLastName());
        oldEmployee.setDepartment(employeeDto.getDepartment());
        oldEmployee.setSalary(employeeDto.getSalary());
        oldEmployee.setContact(employeeDto.getContact());
        oldEmployee.setDateOfJoining(employeeDto.getDateOfJoining());
        oldEmployee.setDesignation(employeeDto.getDesignation());

        AddressDto addressDto = employeeDto.getAddress();
        if (addressDto != null) {
            Address address = oldEmployee.getAddress();
            if (address == null) {
                address = new Address();
                oldEmployee.setAddress(address);
            }
            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setZipcode(addressDto.getZipcode());
            address.setState(addressDto.getState());
        }

        // Save the updated employee entity
        Employee updatedEmployee = employeeRepository.save(oldEmployee);

        // Convert the updated employee entity back to DTO
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }
}
