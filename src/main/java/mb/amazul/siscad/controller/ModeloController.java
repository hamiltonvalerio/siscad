package mb.amazul.siscad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeloController {

	@GetMapping("/modelo")
	public String getModelo(Model model) {
		return "modelo";
	}
}
