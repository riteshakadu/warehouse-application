package com.mankevich.databases.warehouseapplication.service.impl;

import com.mankevich.databases.warehouseapplication.exception.RecordAlreadyExistsException;
import com.mankevich.databases.warehouseapplication.model.BaseRecord;
import com.mankevich.databases.warehouseapplication.service.EntityService;
import com.mankevich.databases.warehouseapplication.service.ObjectCopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Slf4j
public abstract class AbstractEntityService<T extends BaseRecord<ID>, ID>
	implements EntityService<T, ID> {
  private final ObjectCopyService objectCopyService;
  private final JpaRepository<T, ID> repository;

  AbstractEntityService(ObjectCopyService objectCopyService,
							   JpaRepository<T, ID> repository) {
	this.objectCopyService = objectCopyService;
	this.repository = repository;
  }

  @Transactional
  @Override
  public Optional<T> save(T entity) {
	try {
	  ID id = entity.getId();
	  if (id != null) {
		if (repository.existsById(id)) {
		  throw new RecordAlreadyExistsException(
			  String.format("%s with id [%s] already exists", entity.getClassName(),
				  id.toString()));
		} else {
		  return Optional.of(repository.save(entity));
		}
	  } else return Optional.of(repository.save(entity));
	} catch (Exception e) {
	  log.error("Error while saving [" + entity.getClassName() + "]", e);
	  return Optional.empty();
	}
  }

  @Transactional
  @Override
  public Optional<T> update(ID id, T entity) {
	Optional<T> entityOptional = getEntityOptionalById(id);
	if (entityOptional.isPresent()) {
	  T source = entityOptional.get();
	  objectCopyService.patch(source, entity, getEntityClass());
	  return Optional.of(repository.save(source));
	} else {
	  return Optional.empty();
	}
  }

  @Transactional
  @Override
  public boolean deleteById(ID id) {
	if (repository.existsById(id)) {
	  repository.deleteById(id);
	  return true;
	} else return false;
  }

  protected abstract Class<T> getEntityClass();

  protected abstract Optional<T> getEntityOptionalById(ID id);
}
