package com.example.distribuidora.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BooleanCustomDeserializerService extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        if ("activo".equalsIgnoreCase(text)) {
            return true;
        } else if ("desactivo".equalsIgnoreCase(text)) {
            return false;
        } else {
            return Boolean.parseBoolean(text);
        }
    }

}