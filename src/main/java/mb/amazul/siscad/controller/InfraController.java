package mb.amazul.siscad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfraController {
	
	@GetMapping("/infra")
	public String getInfra(Model model) {
		return "infra";
	}
}
