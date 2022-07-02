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

import it.uniroma3.siw.spring.controller.validator.PiattoValidator;
import it.uniroma3.siw.spring.model.Ingrediente;
import it.uniroma3.siw.spring.model.Piatto;
import it.uniroma3.siw.spring.service.BuffetService;
import it.uniroma3.siw.spring.service.PiattoService;

@Controller
public class PiattoController {
	
	@Autowired
	private PiattoService piattoService;
	
	@Autowired
	private PiattoValidator piattoValidator;
	
	@Autowired
	private BuffetService buffetService;
	
	@GetMapping("/admin/{buffetId}/piattoForm") 
	public String getNewPiattoAndBuffet(@PathVariable("buffetId") Long buffetId, Model model) {
		model.addAttribute("piatto", new Piatto());
		model.addAttribute("buffetId", buffetId);
		return "admin/piattoForm.html";
	}
	
	@PostMapping("/admin/{buffetId}/piatto")
	public String addPiatto(@Valid @ModelAttribute("piatto") Piatto piatto, BindingResult bindingResult, @PathVariable("buffetId") Long buffetId, Model model) {
		this.piattoValidator.validate(piatto, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.piattoService.save(piatto, this.buffetService.findBuffetById(buffetId));
			model.addAttribute("piatto", piatto);
			model.addAttribute("ingrediente", new Ingrediente());
			return "admin/ingredienteForm.html";
			//return "admin/home.html";
		}
		
		return "admin/piattoForm.html";
	}
	
	@GetMapping("/piatto/{id}")
	public String getPiatto(@PathVariable("id") Long id, Model model) {
		Piatto piatto = this.piattoService.findPiattoById(id);
		model.addAttribute("piatto", piatto);
		return "piatto.html";
	}
	
	@GetMapping("/admin/modifyPiatto")
	public String deletePiatto(Model model) {
		List<Piatto> piatti = this.piattoService.findAllPiatti();
		model.addAttribute("piatti", piatti);
		return "/admin/modifyPiatto.html";
	}
	
	@PostMapping("/admin/deletePiatto/{id}")
	public String deletePiatto(@PathVariable("id") Long id, Model model) {
		Piatto piatto = this.piattoService.findPiattoById(id);
		this.piattoService.deletePiatto(piatto);
		return "/admin/home.html";
	}
	
	@GetMapping("/admin/piattoSelection")
	public String getAllPiattiAdmin(Model model) {
		List<Piatto> piatti = this.piattoService.findAllPiatti();
		model.addAttribute("piatti", piatti);
		return "admin/piattoSelection.html";
	}
	
	@GetMapping("/admin/modifyPiattoDataForm/{id}")
	public String modifyPiattoData(@PathVariable("id") Long id, Model model) {
		Piatto piatto = this.piattoService.findPiattoById(id);
		model.addAttribute("piatto", piatto);
		return "/admin/modifyPiattoDataForm.html";
	}
	
	@PostMapping("/admin/modifyPiattoData/{id}")
	public String modifyPiattoData(@Valid @ModelAttribute("editedPiatto") Piatto editedPiatto, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
		//this.buffetValidator.validate(buffet, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			Piatto piatto = this.piattoService.findPiattoById(id);
			piatto.setNome(editedPiatto.getNome());
			piatto.setDescrizione(editedPiatto.getDescrizione());
			this.piattoService.save(piatto);
			return "admin/home.html";
		}
		
		return "admin/modifyPiattoDataForm.html";
	}
	
}
