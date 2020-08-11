package mb.amazul.siscad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mb.amazul.siscad.model.LogTrace;
import mb.amazul.siscad.repository.LogTraceServiceRepository;

@Service
public class LogTraceServiceImpl implements LogTraceService{

	@Autowired
	LogTraceServiceRepository logTraceServiceRepository;  
	
	@Override
	public void save(LogTrace logtrace) {
		// TODO Auto-generated method stub
		
		logTraceServiceRepository.save(logtrace);
		
	}

}
