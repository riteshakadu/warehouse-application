package com.mankevich.databases.warehouseapplication.reflection.impl;

import com.mankevich.databases.warehouseapplication.exception.TypeException;
import com.mankevich.databases.warehouseapplication.reflection.ReflectionHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/12/2018
 */
@Slf4j
@Component
public class ReflectionHelperImpl implements ReflectionHelper {

  @Override
  public <T> T getFieldValue(Field field, Object source, Class<T> fieldType) {
	try {
	  field.setAccessible(true);
	  Object fieldValue = field.get(source);
	  if (fieldValue == null) {
		return null;
	  }
	  if (fieldType.equals(field.getType())) {
		return fieldType.cast(fieldValue);
	  } else throw new TypeException(String.format("Field [%s] is not of type [%s]",
		  field.toString(), fieldType.toString()));
	} catch (IllegalAccessException e) {
	  log.error("Error while reading field value", e);
	  throw new TypeException(e);
	}
  }

  @Override
  public Object getFieldValue(Field field, Object source) {
	return this.getFieldValue(field, source, Object.class);
  }

  @Override
  public void setFieldValue(Field field, Object source, Object value) {
	try {
	  field.set(source, value);
	} catch (IllegalAccessException e) {
	  log.error("Error while setting field value", e);
	  throw new RuntimeException(e);
	}
  }
}
