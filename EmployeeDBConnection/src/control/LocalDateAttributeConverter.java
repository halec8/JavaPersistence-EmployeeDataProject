package control;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Converter;

/**
 * @author Cody Hale - chale
 * CIS175 - Fall 2021
 * Oct 5, 2021
 */

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {
	
	
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		
		return (attribute == null ? null : Date.valueOf(attribute));
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date dbData ) {
		
		return(dbData == null ? null : dbData.toLocalDate());
	}

}
