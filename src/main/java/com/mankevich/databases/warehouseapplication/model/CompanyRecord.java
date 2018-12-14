package com.mankevich.databases.warehouseapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @Column(name = "registration_date")
  private Date registrationDate;
  private String photo;

  @JsonIgnore
  @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
  private Set<EmployeeRecord> employees;

  @JsonIgnore
  @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
  private Set<WarehouseRecord> warehouses;
}
