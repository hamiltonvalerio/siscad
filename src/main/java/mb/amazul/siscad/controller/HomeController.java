package mb.amazul.siscad.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.Perfil;
import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.service.EmpregadoService;
import mb.amazul.siscad.service.UsuarioService;
import mb.amazul.siscad.transporter.UsuarioTransporter;
import mb.amazul.siscad.utils.Icones;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class HomeController {

	@Autowired
	private EmpregadoService empregadoService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private DataSource dataSource;

	@RequestMapping(value = { "/home/home" }, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<Usuario> users = usuarioService.findAllByCpf(auth.getName());
		for (Usuario u : users) {
			if (u.getAtivo() == 1) {
				for (Perfil p : u.getPerfis()) {
					if (!p.getNome().equalsIgnoreCase("EXTERNO")) {
						model.setViewName("home/home");
					} else {
						model.addObject("empregado", u);
						UsuarioTransporter.setUsuario(u);
						model.setViewName("redirect:/externo/home_externo");

					}
				}
			}
		}

		return model;
	}

	@RequestMapping(path = "/listaemp", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Empregado> getAll() {
		List<Empregado> lista = empregadoService.getEmpregados();
		for (Empregado e : lista) {
			Usuario usu = usuarioService.findByCpf(e.getCpf());
			if (usu != null) {
				if (usu.getAtivo() == 0) {
					e.setIdUsu(usu.getId());
					e.setUsuAtivo(Icones.USERINATIVO.getImagem());
				} else {
					e.setIdUsu(usu.getId());
					e.setUsuAtivo(Icones.USEREMADMISSAO.getImagem());
				}
			}
		}

		return lista;
	}

	@RequestMapping(value = "/home/imprimirficha", method = RequestMethod.GET)
	@ResponseBody
	public void imprimirficha(@RequestParam("codigo") Integer id, HttpServletResponse response) throws JRException, IOException, SQLException {
		Map<String, Object> param = new HashMap<>();
		param.put("EMPREGADO_ID", id);
		InputStream js_form = this.getClass().getResourceAsStream("/relatorios/ficha_subreport_form.jasper");
		param.put("MY_SUB_REPORT_FORM", js_form);
		InputStream js_depen = this.getClass().getResourceAsStream("/relatorios/ficha_subreport_depen.jasper");
		param.put("MY_SUB_REPORT_DEPEN", js_depen);
		InputStream js_logo = this.getClass().getResourceAsStream("/relatorios/logo_Amazul.jpg");
		param.put("LOGO", js_logo);
		imprimirRelatório(param, "/relatorios/ficha.jasper", response);
	}

	@RequestMapping(value = { "/home/imprimirdecacum" }, method = RequestMethod.GET)
	@ResponseBody
	public void imprimirdecacum(@RequestParam("codigo") Integer id, HttpServletResponse response) throws SQLException, JRException, IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("EMPREGADO_ID", id);
		InputStream js_logo = this.getClass().getResourceAsStream("/relatorios/logo_Amazul.jpg");
		param.put("LOGO", js_logo);
		imprimirRelatório(param, "/relatorios/acumulacao.jasper", response);
	}

	@RequestMapping(value = { "/home/imprimirdecbio" }, method = RequestMethod.GET)
	public String imprimirdecbio(Long id) {
		System.out.println("imprimir: " + id);
		return "home/home";
	}

	@RequestMapping(value = { "/home/imprimirformtcu" }, method = RequestMethod.GET)
	@ResponseBody
	public void imprimirformtcu(@RequestParam("codigo") Integer id, HttpServletResponse response) throws SQLException, JRException, IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("EMPREGADO_ID", id);
		InputStream js_logo = this.getClass().getResourceAsStream("/relatorios/logo_tcu.png");
		param.put("LOGO", js_logo);
		imprimirRelatório(param, "/relatorios/formulario_tcu.jasper", response);
	}
	
	@RequestMapping(value = { "/home/imprimirfichaconflito" }, method = RequestMethod.GET)
	@ResponseBody
	public void imprimirfichaconflito(@RequestParam("codigo") Integer id, HttpServletResponse response) throws SQLException, JRException, IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("EMPREGADO_ID", id);
		InputStream js_logo = this.getClass().getResourceAsStream("/relatorios/logo_Amazul.jpg");
		param.put("LOGO", js_logo);
		imprimirRelatório(param, "/relatorios/conflito.jasper", response);
	}
	
	@RequestMapping(value = { "/home/imprimirfichabenef" }, method = RequestMethod.GET)
	@ResponseBody
	public void imprimirfichabenef(@RequestParam("codigo") Integer id, HttpServletResponse response) throws SQLException, JRException, IOException {
		Map<String, Object> param = new HashMap<>();
		param.put("EMPREGADO_ID", id);
		InputStream js_logo = this.getClass().getResourceAsStream("/relatorios/logo_Amazul.jpg");
		param.put("LOGO", js_logo);
		imprimirRelatório(param, "/relatorios/beneficios.jasper", response);
	}

	@RequestMapping(value = { "/home/imprimirfichatodos" }, method = RequestMethod.GET)
	public String imprimirfichatodos(Long id) {
		System.out.println("imprimir: " + id);
		return "home/home";
	}

	@RequestMapping(value = { "/home/editar" }, method = RequestMethod.GET)
	public String editar(Long id) {
		System.out.println("editar");
		return "redirect:/externo/ficha_cadastral?id=" + id;
	}

	@RequestMapping(value = { "/home/excluir" }, method = RequestMethod.GET)
	public String excluir(Long id) {
		System.out.println("excluir");

		empregadoService.updateexcluido(id);

		return "home/home";
	}

	@RequestMapping(value = { "/home/voltarcadastro" }, method = RequestMethod.GET)
	public String voltarcadastro(Long id) {
		System.out.println("voltarcadastro");

		empregadoService.updatefinalizaexternofalse(id);

		return "home/home";
	}

	@RequestMapping(value = { "/home/enviarbenner" }, method = RequestMethod.GET)
	public String enviarbenner(Long id, RedirectAttributes redirectAttributes) {
		System.out.println("ENVIANDO PARA O BENNER");
		
		Empregado empregado = empregadoService.findById(id);
		
		
		
		
		
		redirectAttributes.addFlashAttribute("messageusu", "Empregado inserido no Benner!");
		redirectAttributes.addFlashAttribute("alertClass", "sucesso");
		
		return "redirect:/home/home";
	}
	
	public void imprimirRelatório(Map<String, Object> param, String nomerelatorio, 
			HttpServletResponse response)
			throws SQLException, JRException, IOException {
		Connection con = dataSource.getConnection();
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream(nomerelatorio);
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no
		// caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, con);
		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do
		// arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		// response.setHeader("Content-Disposition", "inline; filename=ficha.pdf");
		response.setHeader("Content-Disposition", "attachment");
		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}

	@RequestMapping(value = { "/home/status" }, method = RequestMethod.GET)
	public String status(Long id, String cpf, String status, RedirectAttributes redirectAttributes) {
		if (status.equalsIgnoreCase(Icones.USERINATIVO.getImagem())) {
			usuarioService.updateAtivo(id, 1);
			redirectAttributes.addFlashAttribute("messageusu", "Usuário ativado com sucesso!");
			redirectAttributes.addFlashAttribute("alertClass", "sucesso");
		} else {
			redirectAttributes.addFlashAttribute("messageusu", "Usuário inativado!");
			redirectAttributes.addFlashAttribute("alertClass", "sucesso");
			usuarioService.updateAtivo(id, 0);
		}
		return "redirect:/home/home";
	}

}
