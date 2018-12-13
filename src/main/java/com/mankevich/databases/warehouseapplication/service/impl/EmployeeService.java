package com.mankevich.databases.warehouseapplication.service.impl;

import com.mankevich.databases.warehouseapplication.model.EmployeeRecord;
import com.mankevich.databases.warehouseapplication.repository.EmployeeRepository;
import com.mankevich.databases.warehouseapplication.service.ObjectCopyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Service
public class EmployeeService extends AbstractEntityService<EmployeeRecord, Long> {
  private final EmployeeRepository employeeRepository;

  EmployeeService(ObjectCopyService objectCopyService,
				  EmployeeRepository repository) {
	super(objectCopyService, repository);
	this.employeeRepository = repository;
  }

  @Override
  protected Class<EmployeeRecord> getEntityClass() {
	return null;
  }

  @Override
  protected Optional<EmployeeRecord> getEntityOptionalById(Long id) {
	return employeeRepository.getById(id);
  }
}
