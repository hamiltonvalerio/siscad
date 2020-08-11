package mb.amazul.siscad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mb.amazul.siscad.model.ArquivosEmp;
import mb.amazul.siscad.model.CidadeRest;
import mb.amazul.siscad.model.DependenteEmp;
import mb.amazul.siscad.model.Empregado;
import mb.amazul.siscad.model.FormacaoEmp;
import mb.amazul.siscad.model.Fp_raisdesligamentotipos;
import mb.amazul.siscad.model.Instensinosup;
import mb.amazul.siscad.model.Ta_areasconhecimento;
import mb.amazul.siscad.model.Ta_bancos;
import mb.amazul.siscad.model.Ta_emissoresdocumentos;
import mb.amazul.siscad.model.Ta_estadoscivis;
import mb.amazul.siscad.model.Ta_formacoes;
import mb.amazul.siscad.model.Ta_grausensino;
import mb.amazul.siscad.model.Ta_niveisescolaridade;
import mb.amazul.siscad.model.Ta_racacor;
import mb.amazul.siscad.model.Ta_religioes;
import mb.amazul.siscad.model.Ta_terceiros;
import mb.amazul.siscad.model.Ta_tipossangue;
import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.model.wrapper.ArquivoContainer;
import mb.amazul.siscad.service.ArquivosEmpService;
import mb.amazul.siscad.service.DependenteEmpService;
import mb.amazul.siscad.service.EmpregadoService;
import mb.amazul.siscad.service.FormacaoEmpService;
import mb.amazul.siscad.service.InstensinosupService;
import mb.amazul.siscad.service.UsuarioService;
import mb.amazul.siscad.utils.Estados;
import mb.amazul.siscad.utils.TiposSanguineos;

@Controller
public class FichaCadastralController {

	@Autowired
	private EmpregadoService empservice;

	@Autowired
	private InstensinosupService instensinosupService;

	@Autowired
	private FormacaoEmpService formacaoEmpService;

	@Autowired
	private DependenteEmpService dependenteEmpService;

	@Autowired
	private ArquivosEmpService arquivosEmpService;

	@Autowired
	private UsuarioService usuarioService;

	private String webserviceBasePath = "http://10.28.96.63:8080/webservice/";
	// private String webserviceBasePath = "http://localhost:8088/";

	List<FormacaoEmp> listaformacao = new ArrayList<>();
	List<DependenteEmp> listadependentes = new ArrayList<>();
	List<ArquivosEmp> listaarquivos = new ArrayList<>();
	List<String> listaEmissorEmp = new ArrayList<>();

	Usuario usu = null;
	Empregado emp = null;
	String adminLogado = "";
	Empregado empr = new Empregado();
	String fotoPerfil = "";

	@RequestMapping(value = { "/externo/ficha_cadastral" }, method = RequestMethod.GET)
	public ModelAndView signup(HttpServletRequest request, Long id) throws Exception {
		if (id != null) {
			emp = empservice.findById(id);
			usu = (Usuario) request.getSession().getAttribute("usuario");
			adminLogado = usuarioService.getAuthenticatedUser().getNome();
		} else {
			usu = (Usuario) request.getSession().getAttribute("usuario");
			if(usu != null) {
				emp = empservice.findByCpf(usu.getCpf());
			}
		}
		if (emp == null) {
			emp = new Empregado();
			emp.setNome(usu.getNome());
			emp.setCpf(usu.getCpf());
			empservice.save(emp);
		} else {
			listaformacao = formacaoEmpService.findByEmpregado(emp);
			listadependentes = dependenteEmpService.findByEmpregado(emp);
			listaarquivos = arquivosEmpService.findByEmpregado(emp);
			ArquivosEmp ae = arquivosEmpService.findByEmpregadoAndDescricao(emp, "Foto do perfil");
			if (ae != null) {
				fotoPerfil = Base64.encodeBase64String(ae.getConteudo());
				emp.setFotoPerfil(fotoPerfil);
			}

			/*
			 * if(emp.getFinalizadoexterno().equals(true)) { if(listaformacao != null) { for
			 * (FormacaoEmp f : listaformacao) { f.setFinalizadoexterno(true); } } }
			 */

			empr = emp.clone();
		}
		ModelAndView model = new ModelAndView();
		model.addObject("selectEstados", Estados.values());
		if (emp.getEstados() != null) {
			model.addObject("selectMunicipios", carregaCidadesRest(emp.getEstados()));
		} else {
			model.addObject("selectMunicipios", null);
		}
		if (emp.getEstadosres() != null) {
			model.addObject("selectMunicipiosRes", carregaCidadesRest(emp.getEstadosres()));
		} else {
			model.addObject("selectMunicipiosRes", null);
		}
		if (emp.getUfag() != null) {
			model.addObject("selectMunicipiosMunag", carregaCidadesRest(emp.getUfag()));
		} else {
			model.addObject("selectMunicipiosMunag", null);
		}

		model.addObject("selectTiposSanguineos", TiposSanguineos.values());
		model.setViewName("externo/ficha_cadastral");
		model.addObject("selectEstadosRes", Estados.values());
		model.addObject("selectEstadosUfag", Estados.values());
		model.addObject("selectRgEmissor", carregaRgEmissor());
		model.addObject("selectEstadosCivis", carregaEstadosCivis());
		model.addObject("selectReligiao", carregaReligioes());
		model.addObject("selectRacaCor", carregaRacaCor());
		model.addObject("selectTiposSanguineos", carregaTpSangue());
		model.addObject("selectNaturezaAp", carregaNaturezaAp());
		model.addObject("selectNivelEscolaridade", carregaNivelEscolaridade());
		model.addObject("selectCurso", carregaCursos());
		model.addObject("selectInstEns", carregaInstituicaoEnsino());
		model.addObject("selectbancocontaemp", carregaBancos());
		model.addObject("selectgrausensino", carregaGrausEnsino());
		model.addObject("selectareasonhecimento", carregaAreasConhecimento());
		model.addObject("empregado", emp);
		return model;
	}

	@PostMapping("/externo/ficha_cadastral/salvar")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String salvar(@Valid @ModelAttribute(value = "empregado") Empregado empregado, BindingResult bindingResult,
			ModelMap map, RedirectAttributes redirectAttributes)
			throws ScriptException, IllegalArgumentException, IllegalAccessException {

		// Empregado e = new Empregado();
		// copyNonNullProperties(empregado, e);
		// empregado.setCs_Cargos(null);

		if (empregado.getFile() != null) {
			System.out.println("foi");
		}

		if (empregado.getEstados() != null) {
			empregado.setNomeestadosnasc(Estados.getStatus(empregado.getEstados()).getNome());
		}
		if (empregado.getEstadosres() != null) {
			empregado.setNomeestadosres(Estados.getStatus(empregado.getEstadosres()).getNome());
		}

		empregado.setDatalt(new Date());
		if (!adminLogado.isEmpty()) {
			empregado.setUsualt(adminLogado);
		} else {
			empregado.setUsualt("EXTERNO");
		}

		// fazer aqui o finalizadoexterno para formacao, dependente e arquivos

		if (empregado.getFinalizadoexterno().equals(true)) {
			listaformacao = formacaoEmpService.findByEmpregado(emp);
			if (listaformacao != null) {
				for (FormacaoEmp f : listaformacao) {
					f.setFinalizadoexterno(true);
				}
			}
			listadependentes = dependenteEmpService.findByEmpregado(emp);
			if (listadependentes != null) {
				for (DependenteEmp d : listadependentes) {
					d.setFinalizadoexterno(true);
				}
			}
			listaarquivos = arquivosEmpService.findByEmpregado(emp);
			if (listaarquivos != null) {
				for (ArquivosEmp a : listaarquivos) {
					a.setFinalizadoexterno(true);
				}
			}else {
				listaarquivos = new ArrayList<>();
			}
		}
		
		empregado.setExcluido(false);

		empservice.save(empregado);

		return "redirect:/externo/ficha_cadastral?id=" + empregado.getId();

	}

	public static void copyNonNullProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	private RestTemplate createRestTemplate() throws Exception {
		final String username = "siscad";
		final String password = "Siscad123*Mudar";
		/*final String username = "84025166100";
		final String password = "Valentina@Oliver2729";*/
		final String proxyUrl = "proxy-amazul.mb";
		final int port = 6060;

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(proxyUrl, port),
				new UsernamePasswordCredentials(username, password));

		HttpHost myProxy = new HttpHost(proxyUrl, port);
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();

		clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();

		HttpClient httpClient = clientBuilder.build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(httpClient);

		return new RestTemplate(factory);
	}

	public List<Ta_emissoresdocumentos> carregaRgEmissor() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_emissoresdocumentos>> response = rt.exchange(webserviceBasePath + "emissoresdocumentos",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Ta_emissoresdocumentos>>() {
				});
		return response.getBody();
	}

	public List<Ta_estadoscivis> carregaEstadosCivis() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_estadoscivis>> response = rt.exchange(webserviceBasePath + "estadoscivis",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Ta_estadoscivis>>() {
				});
		return response.getBody();
	}

	public List<Ta_religioes> carregaReligioes() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_religioes>> response = rt.exchange(webserviceBasePath + "religioes", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ta_religioes>>() {
				});
		return response.getBody();
	}

	public List<Ta_racacor> carregaRacaCor() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_racacor>> response = rt.exchange(webserviceBasePath + "racacor", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ta_racacor>>() {
				});
		return response.getBody();
	}

	public List<Ta_tipossangue> carregaTpSangue() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_tipossangue>> response = rt.exchange(webserviceBasePath + "tipossangue", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ta_tipossangue>>() {
				});
		return response.getBody();
	}

	public List<Fp_raisdesligamentotipos> carregaNaturezaAp() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Fp_raisdesligamentotipos>> response = rt.exchange(
				webserviceBasePath + "raisdesligamentotipos", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Fp_raisdesligamentotipos>>() {
				});
		return response.getBody();
	}

	public List<Ta_niveisescolaridade> carregaNivelEscolaridade() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_niveisescolaridade>> response = rt.exchange(webserviceBasePath + "niveisescolaridade",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Ta_niveisescolaridade>>() {
				});
		return response.getBody();
	}

	public List<Ta_formacoes> carregaCursos() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_formacoes>> response = rt.exchange(webserviceBasePath + "formacoes", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ta_formacoes>>() {
				});
		return response.getBody();
	}

	public List<Ta_terceiros> carregaInstituicaoEnsino() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_terceiros>> response = rt.exchange(webserviceBasePath + "terceiros", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ta_terceiros>>() {
				});
		return response.getBody();
	}

	public List<Ta_grausensino> carregaGrausEnsino() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_grausensino>> response = rt.exchange(webserviceBasePath + "grausensino", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ta_grausensino>>() {
				});
		return response.getBody();
	}

	public List<Ta_areasconhecimento> carregaAreasConhecimento() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_areasconhecimento>> response = rt.exchange(webserviceBasePath + "areasconhecimento",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Ta_areasconhecimento>>() {
				});
		return response.getBody();
	}

	public List<Ta_bancos> carregaBancos() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Ta_bancos>> response = rt.exchange(webserviceBasePath + "bancos", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ta_bancos>>() {
				});
		return response.getBody();
	}

	public List<CidadeRest> carregaCidadesRest(Integer estado) throws Exception {
		String urldados = "http://servicodados.ibge.gov.br/api/v1/localidades/estados/" + estado + "/municipios";
		RestTemplate rt = createRestTemplate();
		ResponseEntity<List<CidadeRest>> response = rt.exchange(urldados, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CidadeRest>>() {
				});
		return response.getBody();
	}

	@GetMapping("/externo/ficha_cadastral/searchinst")
	public ResponseEntity<String> doAutoComplete(@RequestParam("q") String input) {
		List<Instensinosup> strings = instensinosupService.findByNo_ies(input);

		ObjectMapper mapper = new ObjectMapper();
		String resp = "";

		try {
			resp = mapper.writeValueAsString(strings);
		} catch (JsonProcessingException e) {
		}

		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	@RequestMapping(path = "/listaformacoes", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<FormacaoEmp> getAll() {
		List<FormacaoEmp> lista = formacaoEmpService.findByEmpregado(empr);
		if (empr.getFinalizadoexterno().equals(true)) {
			if (lista != null) {
				for (FormacaoEmp f : lista) {
					f.setFinalizadoexterno(true);
				}
			}
		}
		return lista;
	}

	@RequestMapping(path = "/listadependentes", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<DependenteEmp> getAllDep() {
		List<DependenteEmp> lista = dependenteEmpService.findByEmpregado(empr);
		if (empr.getFinalizadoexterno().equals(true)) {
			if (lista != null) {
				for (DependenteEmp d : lista) {
					d.setFinalizadoexterno(true);
				}
			}
		}
		return lista;
	}

	@RequestMapping(path = "/listaarquivos", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<ArquivosEmp> getAllArq() {
		List<ArquivosEmp> lista = arquivosEmpService.findByEmpregado(empr);
		if (empr.getFinalizadoexterno().equals(true)) {
			if (lista != null) {
				for (ArquivosEmp a : lista) {
					a.setFinalizadoexterno(true);
				}
			}
		}
		return lista;
	}

	@RequestMapping(path = "/externo/ficha_cadastral/excluirformacao", method = RequestMethod.GET)
	public String excluirFormacao(Long id, RedirectAttributes redirectAttributes) {
		formacaoEmpService.deleteById(id.toString());
		return "redirect:/externo/ficha_cadastral";
	}

	@RequestMapping(path = "/externo/ficha_cadastral/excluirdependente", method = RequestMethod.GET)
	public String excluirDependente(Long id, RedirectAttributes redirectAttributes) {
		dependenteEmpService.deleteById(id.toString());
		return "redirect:/externo/ficha_cadastral";
	}

	@RequestMapping(value="/externo/ficha_cadastral/incluir", method=RequestMethod.GET)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String incluir(@Valid @ModelAttribute("empregado") Empregado empregado, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		
		FormacaoEmp form = new FormacaoEmp();
		if (empregado.getId() != null) {
			form.setEmpregado(empregado);
		}
		if (empregado.getGrausensino() != null) {
			form.setGrausensino(empregado.getGrausensino());
			form.setGrausensinonome(empregado.getGrausensinonome());
		}
		if (empregado.getAreasconhecimento() != null) {
			form.setAreasconhecimento(empregado.getAreasconhecimento());
			form.setAreasconhecimentonome(empregado.getAreasconhecimentonome());
		}
		
		
		
		if (empregado.getCurso() != null) {
			if(empregado.getCurso() != 1) {
				form.setCurso(empregado.getCurso());
				form.setCursoemp(empregado.getNomecurso());
			}else {
				//procedimento novo
				Ta_formacoes tf = new Ta_formacoes();
				tf.setNome(empregado.getCursoemp());
				RestTemplate rtf = new RestTemplate();
				Ta_formacoes tfo = rtf.postForObject(webserviceBasePath + "insereformacao", tf, Ta_formacoes.class);
				if(tfo != null) {
					if(tfo.getHandle() != null) {
						form.setCurso((int) (long) tfo.getHandle());
						form.setCursoemp(tfo.getNome());
					}else {
						//bindingResult.rejectValue("email", "error.user", "An account already exists for this email.");
						
						//redirectAttributes.addAttribute("cursoexiste", "Usuário ativado com sucesso!");
						redirectAttributes.addFlashAttribute("cursoexiste", "Usuário ativado com sucesso!");
						return "redirect:/externo/ficha_cadastral";
					}
				}else {
					return "redirect:/externo/ficha_cadastral";
				}
			}
		}
		
		/*
		 * if (empregado.getCurso() != null) { form.setCurso(empregado.getCurso());
		 * form.setCursoemp(empregado.getNomecurso()); } else if
		 * (empregado.getCursoemp() != null || empregado.getCursoemp() != "") {
		 * form.setCursoemp(empregado.getCursoemp()); }
		 */
		
		
		
		if (empregado.getDataconclusaoemp() != null) {
			form.setAnoconclusao(empregado.getDataconclusaoemp());
		}
		if (empregado.getInstensinonovo() != null) {
			if (empregado.getInstensinonovo() != "") {
				Ta_terceiros t = new Ta_terceiros();
				t.setNome(empregado.getInstensinonovo());
				RestTemplate rt = new RestTemplate();
				Ta_terceiros tt = rt.postForObject(webserviceBasePath + "insereterceiro", t, Ta_terceiros.class);
				form.setInstensinosup((int) (long) tt.getHandle());
				form.setNomeinstensinosup(tt.getNome());
			}
		}
		if (empregado.getInstensinosupemp() != null) {
			if(empregado.getInstensinosupemp() != 1) {
				form.setInstensinosup(empregado.getInstensinosupemp());
				form.setNomeinstensinosup(empregado.getNomeinstensinosupemp());
			}
		}
		form.setDatalt(new Date());
		form.setUsualt("EXTERNO");
		
		formacaoEmpService.save(form);
		return "redirect:/externo/ficha_cadastral/";
	}

	@PostMapping("/externo/ficha_cadastral/incluirdependente")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String incluirdependente(@Valid @ModelAttribute(value = "empregado") Empregado empregado,
			BindingResult bindingResult, ModelMap map, RedirectAttributes redirectAttributes)
			throws ScriptException, IllegalArgumentException, IllegalAccessException {

		DependenteEmp dep = new DependenteEmp();
		if (empregado.getId() != null) {
			dep.setEmpregado(empregado);
		}
		if (empregado.getNomcompdpemp() != null || empregado.getNomcompdpemp() != "") {
			dep.setNomcompdepen(empregado.getNomcompdpemp());
		}
		if (empregado.getGraupardpemp() != null || empregado.getGraupardpemp() != "") {
			dep.setGraupardepen(empregado.getGraupardpemp());
		}
		if (empregado.getCpfdpemp() != null || empregado.getCpfdpemp() != "") {
			dep.setCpfdepen(empregado.getCpfdpemp());
		}
		if (empregado.getDtnascdpemp() != null) {
			dep.setDtnascdepen(empregado.getDtnascdpemp());
		}
		if (empregado.getNmaedpemp() != null || empregado.getNmaedpemp() != "") {
			dep.setNmaedepen(empregado.getNmaedpemp());
		}	
		if (empregado.getDepirdpemp() != null || empregado.getDepirdpemp() != "") {
			dep.setDepirdepen(empregado.getDepirdpemp());
		}
		dep.setDatalt(new Date());
		dep.setUsualt("EXTERNO");

		dependenteEmpService.save(dep);
		return "/externo/ficha_cadastral";

	}

	@RequestMapping(path = "/externo/ficha_cadastral/incluirArquivo", method = RequestMethod.GET)
	public String incluirArquivo(Long id, RedirectAttributes redirectAttributes) {
		Empregado e = empservice.findById(id);

		ArquivoContainer arquivoContainer = new ArquivoContainer();
		redirectAttributes.addAttribute("arquivoContainer", arquivoContainer);

		List<ArquivosEmp> arqs = arquivosEmpService.findByEmpregado(e);
		redirectAttributes.addAttribute("arqs", arqs);

		return "redirect:/externo/ficha_cadastral";
	}

	@PostMapping(value = { "/externo/ficha_cadastral/upload" }, consumes = { "multipart/form-data" })
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String upload(@RequestParam("myFileKey") MultipartFile file,
			@RequestParam("descricaoarq") String descricaoarq, RedirectAttributes redirectAttributes, ModelMap map) {
		ArquivosEmp arq = new ArquivosEmp();
		empr.setArquivoContainer(new ArquivoContainer());
		if (file != null) {
			empr.getArquivoContainer().setFile(file);
			if (empr.getId() != null) {
				arq.setEmpregado(empr);
			}
			if (descricaoarq != null || descricaoarq != "") {
				arq.setDescricao(descricaoarq);
			}
			if (empr.getArquivoContainer().getFile() != null) {
				arq.setNome(empr.getArquivoContainer().getFile().getOriginalFilename());
				arq.setTipo(empr.getArquivoContainer().getFile().getContentType());
				try {
					arq.setConteudo(empr.getArquivoContainer().getFile().getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				arq.setDatalt(new Date());
				arq.setUsualt("EXTERNO");
				arquivosEmpService.save(arq);
			}
		}
		map.addAttribute(empr);
		return "redirect:/externo/ficha_cadastral";
	}

	@RequestMapping(path = "/externo/ficha_cadastral/excluirarquivo", method = RequestMethod.GET)
	public String excluirArquivo(Long id, RedirectAttributes redirectAttributes) {
		arquivosEmpService.deleteById(id.toString());
		return "redirect:/externo/ficha_cadastral";
	}

	@RequestMapping(value = { "/externo/ficha_cadastral/download" }, method = RequestMethod.GET)
	public void downloadDocument(Long id, HttpServletResponse response) throws IOException {
		ArquivosEmp document = arquivosEmpService.findById(id.toString());
		response.setContentType(document.getTipo());
		response.setContentLength(document.getConteudo().length);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getNome() + "\"");
		FileCopyUtils.copy(document.getConteudo(), response.getOutputStream());

	}

	@RequestMapping(value = "/externo/ficha_cadastral/uploadfoto", method = RequestMethod.POST)
	public String uploadPhoto(@RequestParam String imgBase64, @RequestParam String user, @RequestParam String userid,
			HttpServletRequest httpServletRequest, ModelMap map) {

		ArquivosEmp arq = arquivosEmpService.findByEmpregadoAndDescricao(empr, "Foto do perfil");
		if (arq != null) {
			String byteStr = imgBase64.split(",")[1];
			arq.setConteudo(Base64.decodeBase64(byteStr.getBytes()));
			arq.setDatalt(new Date());
			arq.setUsualt("EXTERNO");
		} else {
			arq = new ArquivosEmp();
			arq.setEmpregado(empr);
			arq.setDescricao("Foto do perfil");
			arq.setNome("fotoCam" + this.empr.getId() + ".jpg");
			arq.setTipo("image/jpeg");
			String byteStr = imgBase64.split(",")[1];
			arq.setConteudo(Base64.decodeBase64(byteStr.getBytes()));
			arq.setDatalt(new Date());
			arq.setUsualt("EXTERNO");
		}

		arquivosEmpService.save(arq);

		return "redirect:/externo/ficha_cadastral";

	}

}
