package mb.amazul.siscad.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mb.amazul.siscad.model.Cs_Cargos;

@Component
public class Cs_CargoConverter implements Converter<String, Cs_Cargos>{

	@Override
	public Cs_Cargos convert(String source) {
		// TODO Auto-generated method stub
		String array[] = new String[2];
		array = source.split(",");
		return new Cs_Cargos(null,Long.parseLong(array[0]),array[1]);
	}

}
