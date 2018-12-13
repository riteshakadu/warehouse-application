package com.mankevich.databases.warehouseapplication.model.fragment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/11/2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class AddressFragment {
  private String country;
  private String city;
  private String street;
  private String house;
}
