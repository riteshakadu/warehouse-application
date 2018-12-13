package com.mankevich.databases.warehouseapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/12/2018
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TypeException extends RuntimeException {
  public TypeException(String message) {
	super(message);
  }

  public TypeException(Throwable cause) {
	super(cause);
  }
}
