package com.mankevich.databases.warehouseapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bogdan Shishkin bogdanshishkin1998@gmail.com
 * created on 12/13/2018
 */
@Controller
@RequestMapping("/warehouse")
public class ViewController {

  @GetMapping("/{template}")
  public String main(Model model, @PathVariable String template) {
	model.addAttribute("layoutFile", String.format("layouts/%s.html", template));
	return "index";
  }
}
