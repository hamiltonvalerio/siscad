package mb.amazul.siscad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.Instensinosup;
import mb.amazul.siscad.repository.InstensinosupRepository;

@Service("instensinosupService")
public class InstensinosupServiceImpl implements InstensinosupService{

	@Autowired
	private InstensinosupRepository instensinosupRepository;
	
	@Override
	public List<Instensinosup> findAll() {
		// TODO Auto-generated method stub
		return instensinosupRepository.findAll();
	}

	@Override
	public List<Instensinosup> findByNo_ies(String input) {
		// TODO Auto-generated method stub
		return instensinosupRepository.findByNo_ies(input);
	}

	@Override
	public void save(Instensinosup ie) {
		// TODO Auto-generated method stub
		instensinosupRepository.save(ie);
	}

}
