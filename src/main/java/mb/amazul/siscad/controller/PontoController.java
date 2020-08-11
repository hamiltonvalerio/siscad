package mb.amazul.siscad.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mb.amazul.siscad.model.Perfil;
import mb.amazul.siscad.model.Ponto;
import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.repository.PontoRepository;
import mb.amazul.siscad.service.PontoService;
import mb.amazul.siscad.service.UsuarioService;
import mb.amazul.siscad.utils.Icones;
import mb.amazul.siscad.utils.Periodo;

@Controller
public class PontoController {

	@Autowired
	private UsuarioService usuarioService;
	

	private String periodo;

	private LocalDate datainicialperiodo;

	private LocalDate datafinalperiodo;
	
	@Autowired
	private PontoService pontoService;
	
	private Usuario usu;

	@RequestMapping(value = { "/ponto/ponto" }, method = RequestMethod.GET)
	public ModelAndView ponto(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<Usuario> users = usuarioService.findAllByCpf(auth.getName());
		for (Usuario u : users) {
			if (u.getAtivo() == 1) {
				for (Perfil p : u.getPerfis()) {
					if (!p.getNome().equalsIgnoreCase("PONTO")) {
						model.addObject("nome", u.getNome());
						usu = u;
					}
				}
			}
		}
		// Validar a data inicial e final correnspondendo o mês de batida de ponto atual

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate hoje = LocalDate.now();

		List<Periodo> enumPeriodo = Arrays.asList(Periodo.values());

		for (Periodo p : enumPeriodo) {
			LocalDate teste =  LocalDate.parse(p.getDataini(), formatter);
			
			if (hoje.now().isEqual(LocalDate.parse(p.getDataini(), formatter))
					|| hoje.now().isEqual(LocalDate.parse(p.getDatafim(), formatter))) {
				periodo = p.getNome();
				datainicialperiodo = LocalDate.parse(p.getDataini(), formatter);
				datafinalperiodo = LocalDate.parse(p.getDatafim(), formatter);
			} else if (hoje.now().isAfter(LocalDate.parse(p.getDataini(), formatter))
					&& hoje.now().isBefore(LocalDate.parse(p.getDatafim(), formatter))) {
				periodo = p.getNome();
				datainicialperiodo = LocalDate.parse(p.getDataini(), formatter);
				datafinalperiodo = LocalDate.parse(p.getDatafim(), formatter);
			}
		}
		/*System.out.println("Periodo: " + periodo);
		System.out.println("datainicialperiodo: " + datainicialperiodo);
		System.out.println("datafinalperiodo: " + datafinalperiodo);*/
		
		String di = datainicialperiodo.toString();
		String[] si= di.split("-");
		String dataprontoi = si[2]+"-"+si[1]+"-"+si[0]; 
		
		String df = datafinalperiodo.toString();
		String[] sf= df.split("-");
		String dataprontof = sf[2]+"-"+sf[1]+"-"+sf[0]; 
		
		model.addObject("periodo", dataprontoi+" <-> "+dataprontof);
		return model;
	}

	@RequestMapping(value = "/ponto/ponto/uploadfoto", method = RequestMethod.POST)
	public String uploadPhoto(@RequestParam String imgBase64, @RequestParam String hora, @RequestParam String data,
			@RequestParam String tipo, HttpServletRequest httpServletRequest, ModelMap map) {
		
		/* 
		 * Formatar data: yyyy-MM-dd
		 * 
		 * */
		
		String d = data.replaceAll("/", "-");
		String[] s = d.split("-");
		String datapronto = s[2]+"-"+s[1]+"-"+s[0]; 
		Ponto ponto = new Ponto();
		ponto.setUsuario(usu);
		ponto.setDatainicial(datainicialperiodo);
		ponto.setDatafinal(datainicialperiodo);
		ponto.setHora(LocalTime.parse(hora));
		ponto.setData(LocalDate.parse(datapronto));
		ponto.setTipo(tipo);
		String byteStr = imgBase64.split(",")[1];
		ponto.setFoto(Base64.decodeBase64(byteStr.getBytes()));
		pontoService.save(ponto);
		
		ponto = new Ponto();
		ponto.setUsuario(usu);
		
		
		return "redirect:/ponto/ponto";

	}
	
	@RequestMapping(path = "/listaponto", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Ponto> getAll() {
		List<Ponto> lista = pontoService.findAllByUsuario(usu);
		return lista;
	}
	
	

}
