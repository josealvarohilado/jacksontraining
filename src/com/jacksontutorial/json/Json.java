package com.jacksontutorial.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json {
	
	private static ObjectMapper objectMapper = getDefaultObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultObjectMapper;
	}
	
	public static JsonNode parse(String src) throws IOException {
		return objectMapper.readTree(src);
		
	}
	
	public static <T> T fromJson(JsonNode node, Class<T> cls) throws JsonProcessingException, IllegalArgumentException {
		return objectMapper.treeToValue(node, cls);
	}
	
	public static JsonNode toJson(Object a) {
		return objectMapper.valueToTree(a);
	}
	
	public static String stringify(JsonNode node) throws JsonProcessingException {
		ObjectWriter objectWriter = objectMapper.writer();
		
		return objectWriter.writeValueAsString(node);
	}
	
	public static String prettyStringify(JsonNode node) throws JsonProcessingException {
		ObjectWriter objectWriter = objectMapper.writer();
		objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
		return objectWriter.writeValueAsString(node);
	}

}
