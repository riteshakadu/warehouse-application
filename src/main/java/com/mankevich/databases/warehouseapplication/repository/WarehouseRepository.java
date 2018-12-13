package com.mankevich.databases.warehouseapplication.repository;

import com.mankevich.databases.warehouseapplication.model.WarehouseRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/11/2018
 */
public interface WarehouseRepository extends JpaRepository<WarehouseRecord, Long> {
  Optional<WarehouseRecord> getById(Long id);
}
