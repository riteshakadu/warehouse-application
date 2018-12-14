package com.mankevich.databases.warehouseapplication.controller.rest;

import com.mankevich.databases.warehouseapplication.exception.DataErrorException;
import com.mankevich.databases.warehouseapplication.exception.NotFoundException;
import com.mankevich.databases.warehouseapplication.model.ProductRecord;
import com.mankevich.databases.warehouseapplication.repository.ProductRepository;
import com.mankevich.databases.warehouseapplication.service.impl.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/11/2018
 */
@Slf4j
@RestController
@RequestMapping({"/api/product", "/api/products"})
public class ProductController {
  private final ProductRepository productRepository;
  private final ProductService productService;

  public ProductController(ProductRepository productRepository,
						   ProductService productService) {
	this.productRepository = productRepository;
	this.productService = productService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductRecord> getById(@PathVariable Long id) {
	return ResponseEntity.ok(productRepository
		.getById(id).orElseThrow(() ->
			new NotFoundException(String.format("No product found with id [%d]", id))));
  }

  @GetMapping
  public ResponseEntity<List<ProductRecord>> getAll() {
	return ResponseEntity.ok(productRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<ProductRecord> save(@RequestBody ProductRecord productRecord) {
	return ResponseEntity.ok(productService
		.save(productRecord).orElseThrow(() ->
			new DataErrorException("Product was not saved")));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ProductRecord> update(@RequestBody ProductRecord productRecord,
											  @PathVariable Long id) {
	return ResponseEntity.ok(productService
		.update(id, productRecord).orElseThrow(() ->
			new NotFoundException(String.format("No product with such id: [%d]", id))));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
	if (productService.deleteById(id)) {
	  return ResponseEntity.ok().build();
	} else {
	  log.info("No product with such id: [{}]", id);
	  throw new NotFoundException(String.format("No product with such id: [%d]", id));
	}
  }
}
