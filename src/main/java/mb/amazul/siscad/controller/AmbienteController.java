package mb.amazul.siscad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AmbienteController {

	@GetMapping("/ambiente")
	private String getAmbiente(Model model) {
		return "ambiente";
	}
	
}
