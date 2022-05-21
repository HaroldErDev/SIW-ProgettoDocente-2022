package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Chef;
import com.example.demo.service.ChefService;

@Controller
public class ChefController {
	
	@Autowired
	private ChefService chefService;
	
	@GetMapping("/chef")
	public String getAllChef(Model model) {
		List<Chef> chef = chefService.findAll();
		model.addAttribute("chef", chef);
		return "chef.html";
	}
	
}
