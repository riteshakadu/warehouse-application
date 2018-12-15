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
	model.addAttribute("cssFileURL", String.format("/style/%s.css", template));
	model.addAttribute("jsFileUrl", String.format("/script/%s.js", template));
	return "index";
  }

  @GetMapping("/{template}/{id}")
  public String details(Model model,
						@PathVariable String template,
						@PathVariable Long id) {
	model.addAttribute("layoutFile", String.format("layouts/details/%s.html", template));
	model.addAttribute("cssDetailsFileURL", String.format("/style/details/%s.css", template));
	model.addAttribute("cssFileURL", String.format("/style/%s.css", template));
	model.addAttribute("jsFileUrl", String.format("/script/details/%s.js", template));
	model.addAttribute("entityId", id);
    return "index";
  }
}
