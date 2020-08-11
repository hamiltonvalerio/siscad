package mb.amazul.siscad.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import mb.amazul.siscad.model.Sistema;
import mb.amazul.siscad.service.SistemaService;

@Controller
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;
	
	@GetMapping("/sistema/sistema")
	public String getSistema(Model model) {
		return "/sistema/sistema";
	}
	
	public ModelAndView createSistema(@Valid Sistema sistema, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		
		if(bindingResult.hasErrors()){
			model.setViewName("/sistema/sistema");
		}else {
			sistemaService.save(sistema);
			model.addObject("msg", "Sistema registrado com sucesso!");
			model.addObject("sistema", new Sistema());
			model.setViewName("/sistema/sistema");
		}
		
		return model;
	}
	
}
