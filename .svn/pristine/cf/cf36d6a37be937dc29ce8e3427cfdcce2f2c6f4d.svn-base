package mb.amazul.siscad.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mb.amazul.siscad.model.Usuario;
import mb.amazul.siscad.service.UsuarioService;

@Component
public class UsuarioValidator implements Validator{

	@Autowired
	private UsuarioService userService;

	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Usuario usuario = (Usuario) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "Campo Vazio");
		if(usuario.getNome().length() < 6 || usuario.getNome().length() > 32) {
			errors.rejectValue("nome", "Size.usuarioFormulario.nome");
		}
		if(userService.findByCpf(usuario.getCpf()) != null) {
			errors.rejectValue("cpf", "Duplicate.usuarioFormulario.cpf");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Campo Vazio");
		if(usuario.getPassword().length() < 8 || usuario.getPassword().length() > 32) {
			errors.rejectValue("passwor", "Size.usuarioFormulario.password");
		}
		if(!usuario.getPasswordConfirm().equals(usuario.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.usuarioForm.passwordConfirm");
		}
		
		
	}

}
