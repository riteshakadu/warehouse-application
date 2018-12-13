package com.mankevich.databases.warehouseapplication.model;

import com.mankevich.databases.warehouseapplication.annotation.Overwrite;
import com.mankevich.databases.warehouseapplication.model.fragment.AddressFragment;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "warehouse")
@Entity
public class WarehouseRecord extends BaseRecord<Long> {
  @Overwrite(false)
  @Id
  @GeneratedValue private Long id;
  private String name;
  @Embedded private AddressFragment address;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private CompanyRecord company;

  @OneToMany(mappedBy = "warehouse")
  private Set<ProductRecord> products;
}
