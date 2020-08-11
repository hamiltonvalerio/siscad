package mb.amazul.siscad.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mb.amazul.siscad.model.Adm_Unidades;

@Component
public class Adm_UnidadeConverter implements Converter<String, Adm_Unidades>{

	@Override
	public Adm_Unidades convert(String source) {
		// TODO Auto-generated method stub
		String array[] = new String[2];
		array = source.split(",");
		return new Adm_Unidades(null,Long.parseLong(array[0]),array[1]);
	}

	

}
