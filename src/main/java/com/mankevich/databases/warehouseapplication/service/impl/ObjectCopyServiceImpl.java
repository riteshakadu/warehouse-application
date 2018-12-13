package com.mankevich.databases.warehouseapplication.service.impl;

import com.mankevich.databases.warehouseapplication.annotation.Overwrite;
import com.mankevich.databases.warehouseapplication.reflection.ReflectionHelper;
import com.mankevich.databases.warehouseapplication.service.ObjectCopyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/12/2018
 */
@Slf4j
@Service
public class ObjectCopyServiceImpl implements ObjectCopyService {
  private final ReflectionHelper reflectionHelper;

  public ObjectCopyServiceImpl(ReflectionHelper reflectionHelper) {
	this.reflectionHelper = reflectionHelper;
  }

  @Override
  public <T> void patch(T source, T patch, Class<T> targetClass) {
	Field[] fields = targetClass.getDeclaredFields();
	Stream.of(fields).forEach(field -> {
	  Object patchFieldValue = reflectionHelper.getFieldValue(field, patch, field.getType());
	  if (patchFieldValue != null) {
		if (field.isAnnotationPresent(Overwrite.class)) {
		  Overwrite overwrite = field.getDeclaredAnnotation(Overwrite.class);
		  if (overwrite.value()) {
			reflectionHelper.setFieldValue(field, source, patchFieldValue);
		  }
		} else {
		  reflectionHelper.setFieldValue(field, source, patchFieldValue);
		}
	  }
	});
  }
}
