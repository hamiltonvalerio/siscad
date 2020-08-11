package mb.amazul.siscad.service;

import java.util.List;

import mb.amazul.siscad.model.Instensinosup;

public interface InstensinosupService {

	public List<Instensinosup> findAll();
	
	public List<Instensinosup> findByNo_ies(String input);

	public void save(Instensinosup ie);
	
}
