package mb.amazul.siscad.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mb.amazul.siscad.model.Fp_Turnos;

@Component
public class Fp_TurnoConverter implements Converter<String, Fp_Turnos>{

	@Override
	public Fp_Turnos convert(String source) {
		// TODO Auto-generated method stub
		String array[] = new String[3];
		array = source.split(",");
		return new Fp_Turnos(null,Long.parseLong(array[0]),array[1],array[2]);
	}
	
}
