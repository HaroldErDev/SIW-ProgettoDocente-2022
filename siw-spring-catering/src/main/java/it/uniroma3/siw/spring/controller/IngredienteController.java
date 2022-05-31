package it.uniroma3.siw.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.spring.model.Ingrediente;
import it.uniroma3.siw.spring.service.IngredienteService;
import it.uniroma3.siw.spring.service.PiattoService;

@Controller
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private PiattoService piattoService;
	
	@GetMapping("/ingrediente/{id}")
	public String getIngrediente(@PathVariable("id") Long id, Model model) {
		Ingrediente ingrediente = ingredienteService.findIngredienteById(id);
		model.addAttribute("ingrediente", ingrediente);
		return "ingrediente.html";
	}
	
	@PostMapping("/admin/{piattoId}/ingrediente")
	public String addIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, @PathVariable("piattoId") Long piattoId, BindingResult bindingResult, Model model) {
		if(!bindingResult.hasErrors()) {
			this.ingredienteService.save(ingrediente, this.piattoService.findPiattoById(piattoId));
			//model.addAttribute("ingrediente", ingrediente);
		}
		
		model.addAttribute("piatto", this.piattoService.findPiattoById(piattoId));
		return "admin/ingredienteForm.html";
	}
	
}
