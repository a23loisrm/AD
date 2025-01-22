package org.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstadoCivilConverter implements AttributeConverter<EstadoCivil, String> {
    @Override
    public String convertToDatabaseColumn(EstadoCivil estadoCivil) {
        if (estadoCivil == null){
            return null;
        }else {
            return estadoCivil.name();
        }
    }

    @Override
    public EstadoCivil convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        } else {
            return EstadoCivil.valueOf(s);
        }
    }
}
