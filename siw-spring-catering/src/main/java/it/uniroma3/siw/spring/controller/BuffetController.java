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

import it.uniroma3.siw.spring.controller.validator.BuffetValidator;
import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.service.BuffetService;
import it.uniroma3.siw.spring.service.ChefService;

@Controller
public class BuffetController {
	
	@Autowired
	private BuffetService buffetService;
	
	@Autowired
	private ChefService chefService;
	
	@Autowired
	private BuffetValidator buffetValidator;
	
	@GetMapping("/buffet/{id}")
	public String getBuffet(@PathVariable("id") Long id, Model model) {
		Buffet buffet = buffetService.findBuffetById(id);
		model.addAttribute("buffet", buffet);
		return "buffetDesc.html";
	}
	
	@GetMapping("/buffet")
	public String getAllBuffet(Model model) {
		List<Buffet> buffet = buffetService.findAllBuffet();
		model.addAttribute("buffetList", buffet);
		return "buffet.html";
	}
	
	@GetMapping("/admin/{chefId}/buffetForm")
	public String getBuffetAndChef(@PathVariable("chefId") Long chefId, Model model) {
		model.addAttribute("buffet", new Buffet());
		model.addAttribute("chefId", chefId);
		return "admin/buffetForm.html";
	}
	
	@PostMapping("/admin/{chefId}/buffet")
	public String addBuffet(@Valid @ModelAttribute Buffet buffet, @PathVariable("chefId") Long chefId, BindingResult bindingResult, Model model) {
		this.buffetValidator.validate(buffet, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.buffetService.save(buffet, this.chefService.findChefById(chefId));
			model.addAttribute("buffet", buffet);
			return "admin/home.html";
		}
		
		return "admin/buffetForm.html";
	}
	
	@GetMapping("/admin/deleteBuffetForm")
	public String deleteBuffet(Model model) {
		List<Buffet> buffetList = this.buffetService.findAllBuffet();
		model.addAttribute("buffetList", buffetList);
		return "admin/deleteBuffetForm.html";
	}
	
	@PostMapping("/admin/deleteBuffet/{buffetId}")
	public String deleteBuffet(@PathVariable("buffetId") Long buffetId, Model model) {
		Buffet buffet = this.buffetService.findBuffetById(buffetId);
		this.buffetService.deleteBuffet(buffet);
		return "admin/home.html";
	}
	
}
