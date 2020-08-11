package mb.amazul.siscad.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.service.PerfilService;
import mb.amazul.siscad.service.UsuarioService;
import mb.amazul.siscad.service.UsuarioSession;
import mb.amazul.siscad.utils.Icones;
import mb.amazul.siscad.validator.UsuarioValidator;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@SuppressWarnings("unused")
	@Autowired
	private UsuarioValidator usuarioValidator;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private UsuarioSession usuarioSession;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();

		model.setViewName("user/login");
		return model;
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView logina() {
		ModelAndView model = new ModelAndView();

		model.setViewName("user/login");
		return model;
	}

	@RequestMapping(value = { "/user/signup" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		Usuario usuario = new Usuario();
		model.addObject("usuario", usuario);
		model.addObject("listaPerfil", perfilService.getPerfils());
		model.setViewName("user/signup");

		return model;
	}

	@RequestMapping(value = { "/user/signup" }, method = RequestMethod.POST)
	public ModelAndView createUser(@Valid Usuario user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		Usuario userExists = usuarioService.findByCpf(user.getCpf());
		if (userExists != null) {
			bindingResult.rejectValue("cpf", "error.user", "Este Cpf já está cadastrado!");
		}
		if (bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		} else {
			user.setUsualt(usuarioService.getAuthenticatedUser().getNome());
			user.setDatalt(new Date());
			usuarioService.save(user);
			model.addObject("msg", "Usuário registrado com sucesso!");
			model.addObject("usuario", new Usuario());
			model.addObject("listaPerfil", perfilService.getPerfils());
			model.setViewName("user/signup");
		}
		return model;
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<Usuario> users = usuarioService.findAllByCpf(auth.getName());
		for (Usuario u : users) {
			if (u.getAtivo() == 1) {
				usuarioSession.setUsuario(u);
				model.addObject("userName", u.getNome());
			}
		}

		model.setViewName("redirect:/home/home");
		return model;
	}

	@RequestMapping(value = { "/errors/access_denied" }, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		//model.setViewName("errors/access_denied");
		model.setViewName("/");
		return model;
	}

	@RequestMapping(path = "/listausuarios", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Usuario> getAll() {
		List<Usuario> lista = usuarioService.getUsuarios();
		for (Usuario usu : lista) {
			if(usu.getAtivo() == 0) {
				usu.setUsuIcone(Icones.USERINATIVO.getImagem());
			}else{
				usu.setUsuIcone(Icones.USEREMADMISSAO.getImagem());
			}
		}
		
		/*
		 * for (Usuario us : lista) { System.out.println(us.getNome()); for (Perfil p :
		 * us.getPerfis()) { System.out.println(p.getNome()); } }
		 */
		return lista;
	}
	
	/*
	 * public Usuario getUsuarioLogado() {
	 * 
	 * Object usuarioLogado =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
	 * username; if (usuarioLogado instanceof UserDetails) { username =
	 * ((UserDetails) usuarioLogado).getUsername(); } else { username =
	 * usuarioLogado.toString(); }
	 * 
	 * Usuario u = usuarioService.findByCpf(username);
	 * 
	 * usuarioSession.setUsuario(u);
	 * 
	 * return u; }
	 */
	
	@RequestMapping(value= {"/user/status"}, method=RequestMethod.GET)
	public String status(Long id, String cpf, String status, RedirectAttributes redirectAttributes) {
		if(status.equalsIgnoreCase(Icones.USERINATIVO.getImagem())) {
			usuarioService.updateAtivo(id, 1);
			redirectAttributes.addFlashAttribute("messageusu", "Usuário ativado com sucesso!");
			redirectAttributes.addFlashAttribute("alertClass", "sucesso");
		}else {
			redirectAttributes.addFlashAttribute("messageusu", "Usuário inativado!");
			redirectAttributes.addFlashAttribute("alertClass", "sucesso");
			usuarioService.updateAtivo(id, 0);
		}
	  return "redirect:/user/signup";
	}

}
