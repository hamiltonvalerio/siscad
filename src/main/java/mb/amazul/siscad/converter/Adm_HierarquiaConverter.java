package mb.amazul.siscad.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mb.amazul.siscad.model.Adm_Hierarquias;

@Component
public class Adm_HierarquiaConverter implements Converter<String, Adm_Hierarquias>{

	@Override
	public Adm_Hierarquias convert(String source) {
		// TODO Auto-generated method stub
		String array[] = new String[3];
		array = source.split(",");
		return new Adm_Hierarquias(null,Long.parseLong(array[0]),array[1],array[2]);
	}
	
}
