package mb.amazul.siscad.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.transporter.UsuarioTransporter;

@Controller
public class HomeExternoController {

	private Usuario usuario;

	@RequestMapping(value= {"/externo/home_externo"}, method=RequestMethod.GET) 
	 public ModelAndView signup(HttpServletRequest request, HttpSession session, Model model_sessao) {
	  ModelAndView model = new ModelAndView();
	  if(UsuarioTransporter.isUsuarioDisponivel()) {
		  this.usuario = UsuarioTransporter.getUsuario();
		  request.getSession().setAttribute("usuario", this.usuario);
	  }
	  
	  model.setViewName("externo/home_externo");
	  return model;
	 }
	
}
