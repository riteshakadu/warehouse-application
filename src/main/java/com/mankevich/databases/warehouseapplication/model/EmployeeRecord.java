package com.mankevich.databases.warehouseapplication.model;

import com.mankevich.databases.warehouseapplication.annotation.Overwrite;
import lombok.*;

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
@Table(name = "employee")
@Entity
public class EmployeeRecord extends BaseRecord<Long> {
  @Id
  @GeneratedValue
  @Overwrite(false)
  private Long id;
  private String name;
  private String phone;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  private CompanyRecord company;
}
