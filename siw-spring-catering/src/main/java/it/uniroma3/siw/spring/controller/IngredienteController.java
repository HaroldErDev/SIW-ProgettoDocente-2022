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

import it.uniroma3.siw.spring.controller.validator.IngredienteValidator;
import it.uniroma3.siw.spring.model.Ingrediente;
import it.uniroma3.siw.spring.service.IngredienteService;
import it.uniroma3.siw.spring.service.PiattoService;

@Controller
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private IngredienteValidator ingredienteValidator;
	
	@Autowired
	private PiattoService piattoService;
	
	@GetMapping("/ingrediente/{id}")
	public String getIngrediente(@PathVariable("id") Long id, Model model) {
		Ingrediente ingrediente = ingredienteService.findIngredienteById(id);
		model.addAttribute("ingrediente", ingrediente);
		return "ingrediente.html";
	}
	
	@GetMapping("/admin/{piattoId}/ingredienteForm")
	public String getNewIngrediente(@PathVariable("piattoId") Long piattoId, Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		model.addAttribute("piatto", this.piattoService.findPiattoById(piattoId));
		return "admin/ingredienteForm.html";
	}
	
	@PostMapping("/admin/{piattoId}/ingrediente")
	public String addIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult, @PathVariable("piattoId") Long piattoId, Model model) {
		this.ingredienteValidator.validate(ingrediente, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.ingredienteService.save(ingrediente, this.piattoService.findPiattoById(piattoId));
			model.addAttribute("ingrediente", new Ingrediente());
		}
		
		model.addAttribute("piatto", this.piattoService.findPiattoById(piattoId));
		return "admin/ingredienteForm.html";
	}
	
	@GetMapping("/admin/modifyIngrediente")
	public String modifyIngrediente(Model model) {
		List<Ingrediente> ingredienti = this.ingredienteService.findAllIngredienti();
		model.addAttribute("ingredienti", ingredienti);
		return "admin/modifyIngrediente.html";
	}
	
	@PostMapping("/admin/deleteIngrediente/{id}")
	public String deleteIngrediente(@PathVariable("id") Long id, Model model) {
		Ingrediente ingrediente = this.ingredienteService.findIngredienteById(id);
		this.ingredienteService.delete(ingrediente);
		return "admin/home.html";
	}
	
	@GetMapping("/admin/modifyIngredienteDataForm/{id}")
	public String modifyIngredienteData(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ingrediente", this.ingredienteService.findIngredienteById(id));
		return "admin/modifyIngredienteDataForm.html";
	}
	
	@PostMapping("/admin/modifyIngredienteData/{id}")
	public String modifyIngredienteData(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
		this.ingredienteValidator.validateUpdate(ingrediente, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.ingredienteService.save(ingrediente);
			model.addAttribute("ingrediente", ingrediente);
			return "ingrediente.html";
		}
		
		return "admin/modifyIngredienteDataForm.html";
	}
	
}
