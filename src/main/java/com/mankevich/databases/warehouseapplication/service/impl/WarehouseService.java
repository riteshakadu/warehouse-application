package com.mankevich.databases.warehouseapplication.service.impl;

import com.mankevich.databases.warehouseapplication.model.WarehouseRecord;
import com.mankevich.databases.warehouseapplication.repository.WarehouseRepository;
import com.mankevich.databases.warehouseapplication.service.ObjectCopyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Service
public class WarehouseService extends AbstractEntityService<WarehouseRecord, Long> {
  private final WarehouseRepository warehouseRepository;

  public WarehouseService(WarehouseRepository warehouseRepository,
						  ObjectCopyService objectCopyService) {
	super(objectCopyService, warehouseRepository);
	this.warehouseRepository = warehouseRepository;
  }

  @Override
  protected Class<WarehouseRecord> getEntityClass() {
	return WarehouseRecord.class;
  }

  @Override
  protected Optional<WarehouseRecord> getEntityOptionalById(Long id) {
	return warehouseRepository.getById(id);
  }
}
