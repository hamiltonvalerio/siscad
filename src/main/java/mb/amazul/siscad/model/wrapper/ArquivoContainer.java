package mb.amazul.siscad.model.wrapper;

import org.springframework.web.multipart.MultipartFile;

public class ArquivoContainer {
	
	MultipartFile file;
	
	String descricao;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
