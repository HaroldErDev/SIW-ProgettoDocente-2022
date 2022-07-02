package it.uniroma3.siw.spring.controller;

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

import it.uniroma3.siw.spring.controller.validator.ChefValidator;
import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.service.ChefService;

@Controller
public class ChefController {
	
	@Autowired
	private ChefService chefService;
	
	@Autowired
	private ChefValidator chefValidator;
	
	@GetMapping("/chef")
	public String getAllChef(Model model) {
		List<Chef> chefList = chefService.findAllChef();
		model.addAttribute("chefList", chefList);
		return "chef.html";
	}
	
	@GetMapping("/chef/{id}")
	public String getChef(@PathVariable("id") Long id, Model model) {
		Chef chef = chefService.findChefById(id);
		model.addAttribute("chef", chef);
		return "chefDesc.html";
	}
	
	@GetMapping("/admin/chefForm")
	public String getNewChef(Model model) {
		model.addAttribute("chef", new Chef());
		return "admin/chefForm.html";
	}
	
	@PostMapping("/admin/chef")
	public String addChef(@Valid @ModelAttribute("chef") Chef chef, BindingResult bindingResult, Model model) {
		this.chefValidator.validate(chef, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.chefService.save(chef);
			model.addAttribute("chef", chef);
			return "chefDesc.html";
		}
		
		return "admin/chefForm.html";
	}
	
	@GetMapping("/admin/modifyChef")
	public String modifyChef(Model model) {
		List<Chef> chefList = this.chefService.findAllChef();
		model.addAttribute("chefList", chefList);
		return "admin/modifyChef.html";
	}
	
	@GetMapping("/admin/modifyChefDataForm/{id}")
	public String modifyChefData(@PathVariable("id") Long id, Model model) {
		model.addAttribute("chef", this.chefService.findChefById(id));
		return "admin/modifyChefDataForm.html";
	}
	
	@PostMapping("/admin/modifyChefData/{id}")
	public String modifyChefData(@Valid @ModelAttribute("chef") Chef chef, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
		this.chefValidator.validate(chef, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.chefService.save(chef);
			model.addAttribute("chef", chef);
			return "chefDesc.html";
		}
		
		return "admin/modifyChefDataForm.html";
	}
	
	@PostMapping("/admin/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long id, Model model) {
		Chef chef = this.chefService.findChefById(id);
		this.chefService.deleteChef(chef);
		return "admin/home.html";
	}
	
	@GetMapping("/admin/chefSelection")
	public String getAllChefAdmin(Model model) {
		List<Chef> chefList = chefService.findAllChef();
		model.addAttribute("chefList", chefList);
		return "admin/chefSelection.html";
	}
	
}
