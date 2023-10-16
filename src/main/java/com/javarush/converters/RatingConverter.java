package com.javarush.converters;

import com.javarush.domain.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.persistence.Id;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {

    @Override
    public String convertToDatabaseColumn(Rating attribute) {
        return attribute.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        var values = Rating.values();
        for (Rating rating: values) {
            if(rating.getValue().equals(dbData)){
                return rating;
            }
        }
        return null;
    }
}
