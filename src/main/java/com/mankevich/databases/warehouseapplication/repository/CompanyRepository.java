package com.mankevich.databases.warehouseapplication.repository;

import com.mankevich.databases.warehouseapplication.model.CompanyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/11/2018
 */
public interface CompanyRepository extends JpaRepository<CompanyRecord, Long> {
  Optional<CompanyRecord> getById(Long id);
}
