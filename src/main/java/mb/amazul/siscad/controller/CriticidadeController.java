package mb.amazul.siscad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CriticidadeController {

	@GetMapping("/criticidade")
	public String getCriticidade(Model model) {
		return "criticidade";
	}
}
