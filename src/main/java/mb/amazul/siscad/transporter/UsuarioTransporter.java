package mb.amazul.siscad.transporter;

import mb.amazul.siscad.model.Usuario;

public class UsuarioTransporter {

	private static boolean usuarioDisponivel = false;
	private static Usuario usuario;
	
	public static Usuario getUsuario() {
		usuarioDisponivel = false;
		return usuario;
	}
	public static void setUsuario(Usuario usuario) {
		UsuarioTransporter.usuario = usuario;
		usuarioDisponivel = true;
	}
	public static boolean isUsuarioDisponivel() {
		return usuarioDisponivel;
	}
	
	
}
