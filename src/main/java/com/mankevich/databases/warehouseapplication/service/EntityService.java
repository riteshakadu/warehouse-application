package com.mankevich.databases.warehouseapplication.service;

import com.mankevich.databases.warehouseapplication.model.BaseRecord;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
public interface EntityService<T extends BaseRecord, ID> {
  Optional<T> save(T entity);

  Optional<T> update(ID id, T entity);

  boolean deleteById(ID id);
}
