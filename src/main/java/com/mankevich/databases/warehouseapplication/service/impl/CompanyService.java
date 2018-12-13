package com.mankevich.databases.warehouseapplication.service.impl;

import com.mankevich.databases.warehouseapplication.model.CompanyRecord;
import com.mankevich.databases.warehouseapplication.repository.CompanyRepository;
import com.mankevich.databases.warehouseapplication.service.ObjectCopyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Service
public class CompanyService extends AbstractEntityService<CompanyRecord, Long> {
  private final CompanyRepository companyRepository;

  CompanyService(ObjectCopyService objectCopyService,
				 CompanyRepository repository) {
	super(objectCopyService, repository);
	this.companyRepository = repository;
  }

  @Override
  protected Class<CompanyRecord> getEntityClass() {
	return CompanyRecord.class;
  }

  @Override
  protected Optional<CompanyRecord> getEntityOptionalById(Long id) {
	return companyRepository.getById(id);
  }
}
