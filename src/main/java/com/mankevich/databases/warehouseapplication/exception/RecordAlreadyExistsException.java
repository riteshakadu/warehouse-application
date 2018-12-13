package com.mankevich.databases.warehouseapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecordAlreadyExistsException extends RuntimeException {
  public RecordAlreadyExistsException(String message) {
	super(message);
  }
}
