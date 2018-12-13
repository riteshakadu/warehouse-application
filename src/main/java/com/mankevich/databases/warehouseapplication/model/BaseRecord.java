package com.mankevich.databases.warehouseapplication.model;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
public abstract class BaseRecord<ID> {
  public abstract ID getId();
  public String getClassName() {
    return this.getClass().getName();
  }
}
