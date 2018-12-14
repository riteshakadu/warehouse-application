package com.mankevich.databases.warehouseapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Setter
@Getter
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class BaseRecord<ID> {
  public abstract ID getId();
  public String getClassName() {
    return this.getClass().getName();
  }

  @Column(name = "added_date")
  private Date addedDate;
}
