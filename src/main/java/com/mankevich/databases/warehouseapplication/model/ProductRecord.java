package com.mankevich.databases.warehouseapplication.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mankevich.databases.warehouseapplication.annotation.Overwrite;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/11/2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "product")
@Entity
public class ProductRecord extends BaseRecord<Long> {
  @Overwrite(false)
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String photo;
  private Double price;
  private String unit;
  @Type(type = "text")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_id")
  private WarehouseRecord warehouse;
}
