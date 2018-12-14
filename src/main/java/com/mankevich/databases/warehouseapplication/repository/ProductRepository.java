package com.mankevich.databases.warehouseapplication.repository;

import com.mankevich.databases.warehouseapplication.model.ProductRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/11/2018
 */
public interface ProductRepository extends JpaRepository<ProductRecord, Long> {
  Optional<ProductRecord> getById(Long id);
}
