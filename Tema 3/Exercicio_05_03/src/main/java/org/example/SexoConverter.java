package org.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String> {
    @Override
    public String convertToDatabaseColumn(Sexo sexo) {
        if (sexo == null) {
            return null;
        } else {
            return sexo.name();
        }
    }

    @Override
    public Sexo convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        } else {
            return Sexo.valueOf(s);
        }
    }
}
