package com.mankevich.databases.warehouseapplication.service.impl;

import com.mankevich.databases.warehouseapplication.model.ProductRecord;
import com.mankevich.databases.warehouseapplication.repository.ProductRepository;
import com.mankevich.databases.warehouseapplication.service.ObjectCopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/12/2018
 */
@Slf4j
@Service
public class ProductService extends AbstractEntityService<ProductRecord, Long> {
  private final ProductRepository productRepository;

  public ProductService(ObjectCopyService objectCopyService,
						ProductRepository productRepository) {
	super(objectCopyService, productRepository);
	this.productRepository = productRepository;
  }

  @Override
  protected Class<ProductRecord> getEntityClass() {
	return ProductRecord.class;
  }

  @Override
  protected Optional<ProductRecord> getEntityOptionalById(Long id) {
	return productRepository.getById(id);
  }
}