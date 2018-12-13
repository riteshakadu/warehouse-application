package com.mankevich.databases.warehouseapplication.model;

import com.mankevich.databases.warehouseapplication.annotation.Overwrite;
import lombok.*;

import java.util.Set;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class TestDocument {
  private Long id;
  private String name;
  private Double price;
  private Set<Integer> numbers;

  @Overwrite(false)
  private String description;
}
