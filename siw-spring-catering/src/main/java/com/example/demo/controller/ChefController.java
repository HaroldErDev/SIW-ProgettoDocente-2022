package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.validator.ChefValidator;
import com.example.demo.model.Chef;
import com.example.demo.service.ChefService;

@Controller
public class ChefController {
	
	@Autowired
	private ChefService chefService;
	
	@Autowired
	private ChefValidator chefValidator;
	
	@GetMapping("/chef")
	public String getAllChef(Model model) {
		List<Chef> chefList = chefService.findAll();
		model.addAttribute("chefList", chefList);
		return "chef.html";
	}
	
	@GetMapping("/chef/{id}")
	public String getChef(@PathVariable("id") Long id, Model model) {
		Chef chef = chefService.findChefById(id);
		model.addAttribute("chef", chef);
		return "chefDesc.html";
	}
	
	@GetMapping("/chefForm")
	public String getChef(Model model) {
		model.addAttribute("chef", new Chef());
		return "admin/chefForm.html";
	}
	
	@PostMapping("/chef")
	public String addChef(@Valid @ModelAttribute Chef chef, BindingResult bindingResult, Model model) {
		this.chefValidator.validate(chef, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.chefService.save(chef);
			model.addAttribute("chef", chef);
			return "admin/home.html";
		}
		
		return "admin/chefForm.html";
	}
	
	@GetMapping("/deleteChefForm")
	public String deleteChef(Model model) {
		List<Chef> chefList = this.chefService.findAll();
		model.addAttribute("chefList", chefList);
		return "admin/deleteChefForm.html";
	}
	
	@PostMapping("/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long id, Model model) {
		Chef chef = this.chefService.findChefById(id);
		this.chefService.deleteChef(chef);
		return "admin/home.html";
	}
	
}
