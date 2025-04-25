package com.ra.orderapp_java.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class LongListConverter implements AttributeConverter<List<Long>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

//    @Override
//    public String convertToDatabaseColumn(List<Long> attribute) {
//        try {
//            return objectMapper.writeValueAsString(attribute);
//        } catch (JsonProcessingException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public List<Long> convertToEntityAttribute(String dbData) {
//        try {
//            return dbData == null ? null : objectMapper.readValue(dbData, new TypeReference<List<Long>>() {});
//        } catch (JsonProcessingException e) {
//            return null;
//        }
//    }


    @Override
    public String convertToDatabaseColumn(List<Long> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;  // Handle empty or null lists
        }

        return attribute.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }


    @Override
    public List<Long> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue("[" + dbData + "]", objectMapper.getTypeFactory().constructCollectionType(List.class, Long.class));
        } catch (JsonProcessingException e) {
            return null;
        }

    }
}
