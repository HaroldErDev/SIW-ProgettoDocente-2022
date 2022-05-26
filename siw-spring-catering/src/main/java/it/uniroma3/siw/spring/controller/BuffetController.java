package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.service.BuffetService;

@Controller
public class BuffetController {
	
	@Autowired
	private BuffetService buffetService;
	
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
	
}
