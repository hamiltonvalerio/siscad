package mb.amazul.siscad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServidorController {

	@GetMapping("/servidor")
	public String getServidor(Model model) {
		return "servidor";
	}
}
