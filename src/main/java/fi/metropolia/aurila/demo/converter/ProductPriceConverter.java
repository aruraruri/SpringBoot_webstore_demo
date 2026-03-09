package fi.metropolia.aurila.demo.converter;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter(autoApply = false)
public class ProductPriceConverter implements AttributeConverter<Double, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(Double attribute) {
        if (attribute == null) {
            return null;
        }
        return BigDecimal.valueOf(attribute);
    }

    @Override
    public Double convertToEntityAttribute(BigDecimal dbData) {
        if (dbData == null) {
            return Double.NaN;
        }

        return dbData.doubleValue();
    }
}
