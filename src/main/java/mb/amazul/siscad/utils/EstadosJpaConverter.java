package mb.amazul.siscad.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EstadosJpaConverter implements AttributeConverter<Estados, String>{

	@Override
	public String convertToDatabaseColumn(Estados estados) {
		// TODO Auto-generated method stub
		if(estados == null) {
			return null;
		}
		return estados.toString();
	}

	@Override
	public Estados convertToEntityAttribute(String string) {
		// TODO Auto-generated method stub
		if(string == null) {
			return null;
		}
		try {
			return Estados.valueOf(string);
		} catch (Exception e) {
			return null;
		}
	}

}
