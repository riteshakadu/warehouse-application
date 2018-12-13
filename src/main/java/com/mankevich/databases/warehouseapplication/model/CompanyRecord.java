package com.mankevich.databases.warehouseapplication.model;

import com.mankevich.databases.warehouseapplication.annotation.Overwrite;
import com.mankevich.databases.warehouseapplication.model.fragment.AddressFragment;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/11/2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id", callSuper = false)
@Table(name = "company")
@Entity
public class CompanyRecord extends BaseRecord<Long> {
  @Overwrite(false)
  @Id
  @GeneratedValue private Long id;
  private String name;
  @Embedded private AddressFragment address;
  private Date date;
  private String photo;

  @OneToMany(mappedBy = "company")
  private Set<EmployeeRecord> employees;

  @OneToMany(mappedBy = "company")
  private Set<WarehouseRecord> warehouses;
}
