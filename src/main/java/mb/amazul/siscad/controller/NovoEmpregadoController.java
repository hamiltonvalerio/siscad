package mb.amazul.siscad.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.script.ScriptException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mb.amazul.siscad.model.Adm_Hierarquias;
import mb.amazul.siscad.model.Adm_Unidades;
import mb.amazul.siscad.model.Cs_Cargos;
import mb.amazul.siscad.model.Cs_Classes;
import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.Fp_Turnos;
import mb.amazul.siscad.model.Perfil;
import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.service.EmpregadoService;
import mb.amazul.siscad.service.PerfilService;
import mb.amazul.siscad.service.UsuarioService;
import mb.amazul.siscad.service.UsuarioServiceImpl;
import mb.amazul.siscad.service.UsuarioSession;

@Controller
public class NovoEmpregadoController {

	private List<Cs_Cargos> listaCargos;
	private List<Adm_Unidades> listaUnidades;
	private List<Adm_Hierarquias> listaHierarquias;
	private List<Cs_Classes> listaNiveis;
	private List<Fp_Turnos> listaTurnos;
	private String webserviceBasePath = "http://10.28.96.63:8080/webservice/";

	@Autowired
	private UsuarioSession usuarioSession;

	@Autowired
	private EmpregadoService empregadoService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = { "/empregado/interno/novo_empregado" }, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.setViewName("empregado/interno/novo_empregado");
		carregaCargos();
		model.addObject("selectCargos", listaCargos);
		carregaUnidades();
		model.addObject("selectUnidades", listaUnidades);
		carregaHierarquias();
		model.addObject("selectAreas", listaHierarquias);
		carregaNiveis();
		model.addObject("selectNiveis", listaNiveis);
		carregaTurnos();
		model.addObject("selectTurnos", listaTurnos);
		model.addObject("empregado", new Empregado());
		return model;
	}

	public void carregaCargos() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Cs_Cargos>> response = rt.exchange(webserviceBasePath + "listacargos", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Cs_Cargos>>() {
				});
		listaCargos = response.getBody();
	}

	public void carregaUnidades() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Adm_Unidades>> response = rt.exchange(webserviceBasePath + "listaunidadesativas",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Adm_Unidades>>() {
				});
		listaUnidades = response.getBody();
	}

	public void carregaHierarquias() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Adm_Hierarquias>> response = rt.exchange(webserviceBasePath + "listahierarqs",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Adm_Hierarquias>>() {
				});
		listaHierarquias = response.getBody();
	}

	public void carregaNiveis() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Cs_Classes>> response = rt.exchange(webserviceBasePath + "listaniveis", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Cs_Classes>>() {
				});
		listaNiveis = response.getBody();
	}

	public void carregaTurnos() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Fp_Turnos>> response = rt.exchange(webserviceBasePath + "listaturnos", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Fp_Turnos>>() {
				});
		listaTurnos = response.getBody();
		System.out.println("teste");
	}

	@PostMapping("/empregado/interno/novo_empregado/salvarNovoEmpregado")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String salvarPesquisa(@Valid @ModelAttribute(value = "empregado") Empregado empregado,
			BindingResult bindingResult, ModelMap map, RedirectAttributes redirectAttributes)
			throws ScriptException, IllegalArgumentException, IllegalAccessException {

		// inserir datal e usualt
		empregado.setDatalt(new Date());
		empregado.setUsualt("INTERNO");
		empregado.setFinalizadoexterno(false);
		empregado.setExcluido(false);

		// verificar se ja existe pelo cpf
		if (empregadoService.findByCpf(empregado.getCpf()) != null) {
			redirectAttributes.addFlashAttribute("message", "Cpf já registrado no banco!");
			redirectAttributes.addFlashAttribute("alertClass", "error");
			return "redirect:/empregado/interno/novo_empregado";
		} else {
			try {
				// salvar no banco
				empregadoService.save(empregado);
				if (empregado.getId() != null) {
					User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					// gerar login e senha
					Usuario usuario = new UsuarioServiceImpl().converteEmpregadoParaUsuario(empregado);
					usuario.setAtivo(0);
					usuario.setDatalt(new Date());
					usuario.setUsualt(user.getUsername());
					Perfil perfil = perfilService.findByNome("EXTERNO");
					usuario.setPerfis(new HashSet<Perfil>(Arrays.asList(perfil)));
					// capturar senha antes pois gera hash
					String pass = empregado.getCpf().replaceAll("[^0-9]", "").substring(0, 6);// new GeradorSenha(6).geraSenha();
					usuario.setPassword(pass);
					usuarioService.save(usuario);
					// enviar por email
					// String email = new EmailController().sendMail(empregado.getEmail());
					// System.out.println(email);
					System.out.println("Email Enviado para: " + empregado.getEmail() + " Senha: " + pass);
					// limpar objetos
					redirectAttributes.addFlashAttribute("message", "Inserido com sucesso!");
					redirectAttributes.addFlashAttribute("alertClass", "sucesso");
					redirectAttributes.addAttribute(new Empregado());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return "redirect:/empregado/interno/novo_empregado";
	}

}
