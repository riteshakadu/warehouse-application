package com.mankevich.databases.warehouseapplication.controller;

import com.mankevich.databases.warehouseapplication.exception.DataErrorException;
import com.mankevich.databases.warehouseapplication.exception.NotFoundException;
import com.mankevich.databases.warehouseapplication.model.WarehouseRecord;
import com.mankevich.databases.warehouseapplication.repository.WarehouseRepository;
import com.mankevich.databases.warehouseapplication.service.impl.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Slf4j
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
  private final WarehouseRepository warehouseRepository;
  private final WarehouseService warehouseService;

  public WarehouseController(WarehouseRepository warehouseRepository,
							 WarehouseService warehouseService) {
	this.warehouseRepository = warehouseRepository;
	this.warehouseService = warehouseService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<WarehouseRecord> getById(@PathVariable Long id) {
	return ResponseEntity.ok(warehouseRepository
		.getById(id).orElseThrow(() ->
			new NotFoundException(String.format("No warehouse found with id [%d]", id))));
  }

  @GetMapping
  public ResponseEntity<List<WarehouseRecord>> getAll() {
	return ResponseEntity.ok(warehouseRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<WarehouseRecord> save(@RequestBody WarehouseRecord warehouseRecord) {
	return ResponseEntity.ok(warehouseService
		.save(warehouseRecord).orElseThrow(() ->
			new DataErrorException("Warehouse was not saved")));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<WarehouseRecord> update(@RequestBody WarehouseRecord warehouseRecord,
												@PathVariable Long id) {
	return ResponseEntity.ok(warehouseService
		.update(id, warehouseRecord).orElseThrow(() ->
			new NotFoundException(String.format("No warehouse with such id: [%d]", id))));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
	if (warehouseService.deleteById(id)) {
	  return ResponseEntity.ok().build();
	} else {
	  log.info("No warehouse with such id: [{}]", id);
	  throw new NotFoundException(String.format("No warehouse with such id: [%d]", id));
	}
  }
}
