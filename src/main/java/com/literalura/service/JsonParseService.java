package com.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.literalura.util.DataConverter;
import org.springframework.stereotype.Service;

@Service
public class JsonParseService implements DataConverter {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> className) {
        try {
            return objectMapper.readValue(json,className);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
