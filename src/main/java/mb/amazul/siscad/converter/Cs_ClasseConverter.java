package mb.amazul.siscad.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mb.amazul.siscad.model.Cs_Classes;

@Component
public class Cs_ClasseConverter implements Converter<String, Cs_Classes>{

	@Override
	public Cs_Classes convert(String source) {
		// TODO Auto-generated method stub
		String array[] = new String[3];
		array = source.split(",");
		return new Cs_Classes(null,Long.parseLong(array[0]),array[1],Integer.parseInt(array[2]));
	}

}
