package com.pixeltechnology.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixeltechnology.employee.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
