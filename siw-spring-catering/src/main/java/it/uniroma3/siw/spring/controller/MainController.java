package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/index")
	public String getPaginaIndex(Model model) {
		return "index.html";
	}
	
	@GetMapping("/informazioni")
	public String getPaginaInformazioni(Model model) {
		return "informazioni.html";
	}
	
	@GetMapping("/admin/home")
	public String getPaginaOperazioniAmministratore(Model model) {
		return "admin/home.html";
	}
	
}
