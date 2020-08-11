package mb.amazul.siscad.model.wrapper;

import java.util.ArrayList;
import java.util.List;

import mb.amazul.siscad.model.CidadeRest;

public class CidadeRestList {

	private List<CidadeRest> cidadesRest;

	
	
	public CidadeRestList() {
		cidadesRest = new ArrayList<>();
	}

	public List<CidadeRest> getCidadesRest() {
		return cidadesRest;
	}

	public void setCidadesRest(List<CidadeRest> cidadesRest) {
		this.cidadesRest = cidadesRest;
	}
	
}
