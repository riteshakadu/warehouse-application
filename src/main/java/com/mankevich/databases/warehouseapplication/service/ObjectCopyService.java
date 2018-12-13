package com.mankevich.databases.warehouseapplication.service;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/12/2018
 */
public interface ObjectCopyService {

  /**
   * Patches source object by patch object
   *
   * @param source      object which is going to be updated
   * @param patch       patch object - contains diff which should be applied to source
   * @param targetClass target class
   * @param <T>         updated object type
   */
  <T> void patch(T source, T patch, Class<T> targetClass);
}
