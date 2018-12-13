package com.mankevich.databases.warehouseapplication.reflection;

import java.lang.reflect.Field;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/12/2018
 */
public interface ReflectionHelper {
  <T> T getFieldValue(Field field, Object source, Class<T> fieldType);
  Object getFieldValue(Field field, Object source);
  void setFieldValue(Field field, Object source, Object value);
}
