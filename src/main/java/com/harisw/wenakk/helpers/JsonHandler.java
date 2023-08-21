package com.harisw.wenakk.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;

import java.util.HashMap;

public class JsonHandler implements AttributeConverter<HashMap, String> {

    @Override
    public String convertToDatabaseColumn(HashMap stringObjectMap) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap<String, Object> convertToEntityAttribute(String s) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(s, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}
