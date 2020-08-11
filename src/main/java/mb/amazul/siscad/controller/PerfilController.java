package mb.amazul.siscad.controller;

import java.text.Normalizer;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mb.amazul.siscad.model.Perfil;
import mb.amazul.siscad.service.PerfilService;
import mb.amazul.siscad.service.UsuarioService;

@Controller
public class PerfilController {
	
	public static String value = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ß à á â ã ä å æ ç è é ê ë ì í î ï ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ ";
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value= {"/perfil/perfilcad"}, method=RequestMethod.GET)
	public ModelAndView signup() {
	  ModelAndView model = new ModelAndView();
	  Perfil perfil = new Perfil();
	  model.addObject("perfil",perfil);
	  model.setViewName("perfil/perfilcad");
	  return model;
	}
	
	@RequestMapping(value= {"/perfil/perfilcad/salvar"}, method=RequestMethod.POST)
	public ModelAndView salvar(@Valid Perfil perfil, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		Perfil perfilExists = perfilService.findByNome(normalizaString(perfil.getNome()));
		
		if(perfilExists != null) {
			bindingResult.rejectValue("perfil", "error.perfil", "Este Perfil já está cadastrado!");
		}else {
			Perfil perfilNormalizado = new Perfil();
			perfilNormalizado.setNome(normalizaString(perfil.getNome()));
			perfilNormalizado.setUsualt(usuarioService.getAuthenticatedUser().getNome());
			perfilNormalizado.setDatalt(new Date());
			perfilService.save(perfilNormalizado);
			model.addObject("msg", "Perfil registrado com sucesso!");
			model.addObject("perfil", new Perfil());
			model.setViewName("perfil/perfilcad");
		}
		return model;
	}
	
	
	//método para tirar acentuação e colocar tudo maiúsculo
	public static String normalizaString(String string) {
	    String normaliza = Normalizer.normalize(string, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(normaliza).replaceAll("").toUpperCase();
	}
	
	@RequestMapping(path="/listaperfil", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Perfil> getAll(){
		List<Perfil> lista= perfilService.getPerfils();
		return lista;
	}
}
