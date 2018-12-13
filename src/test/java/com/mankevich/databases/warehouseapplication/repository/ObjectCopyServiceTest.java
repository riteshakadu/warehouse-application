package com.mankevich.databases.warehouseapplication.repository;

import com.mankevich.databases.warehouseapplication.model.TestDocument;
import com.mankevich.databases.warehouseapplication.reflection.impl.ReflectionHelperImpl;
import com.mankevich.databases.warehouseapplication.service.impl.ObjectCopyServiceImpl;
import com.mankevich.databases.warehouseapplication.service.ObjectCopyService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
public class ObjectCopyServiceTest {
  private ObjectCopyService objectCopyService;

  @Before
  public void init() {
	this.objectCopyService = new ObjectCopyServiceImpl(new ReflectionHelperImpl());
  }

  @Test
  public void shouldNotChangeSource() {
	TestDocument source = TestDocument.builder().id(1L).name("1").price(1.1)
		.numbers(new HashSet<>(Arrays.asList(1, 2, 3))).build();
	TestDocument copy = TestDocument.builder().id(1L).name("1").price(1.1)
		.numbers(new HashSet<>(Arrays.asList(1, 2, 3))).build();
	TestDocument patch = new TestDocument();
	objectCopyService.patch(source, patch, TestDocument.class);
	assertEquals(source.getId(), copy.getId());
	assertEquals(source.getName(), copy.getName());
	assertEquals(source.getPrice(), copy.getPrice());
	assertEquals(source.getNumbers(), copy.getNumbers());
  }

  @Test
  public void shouldUpdateSource() {
	TestDocument source = TestDocument.builder().id(1L).name("1").price(1.1)
		.numbers(new HashSet<>(Arrays.asList(1, 2, 3))).build();
	TestDocument patch = TestDocument.builder().name("Bogdan").build();
	objectCopyService.patch(source, patch, TestDocument.class);
	assertEquals(source.getName(), patch.getName());
  }

  @Test
  public void shouldNotOverwriteAnnotated() {
	String description = "description1";
	TestDocument source = TestDocument.builder().id(1L).name("1").price(1.1)
		.numbers(new HashSet<>(Arrays.asList(1, 2, 3))).description(description).build();
	TestDocument updated = TestDocument.builder().description("updated").build();
	objectCopyService.patch(source, updated, TestDocument.class);
	assertEquals(source.getDescription(), description);
  }

}
