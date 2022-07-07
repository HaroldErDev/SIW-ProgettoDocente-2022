package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Piatto;
import it.uniroma3.siw.spring.service.PiattoService;

@Component
public class PiattoValidator implements Validator {
	
	@Autowired
	private PiattoService piattoService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Piatto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Piatto piatto = (Piatto)target;
		
		/*if(this.piattoService.getPiattoByNome(piatto.getNome().trim()) != null) {
			errors.reject("piatto.nome.duplicato");
		}*/
		
		if(this.piattoService.alreadyExists(piatto)) {
			errors.reject("piatto.duplicato");
		}
	}
	
	public void validateUpdate(Object target, Errors errors) {
		Piatto piatto = (Piatto)target;
		
		if(this.piattoService.alreadyExistsWithDifferentId(piatto)) {
			errors.reject("piatto.duplicato");
		}
	}

}
