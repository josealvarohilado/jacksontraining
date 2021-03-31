package com.jacksontutorial.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

class JsonTest {
	
	private String jsonSource = "{\"title\": \"Coder From Scratch\", \"author\":\"coder\"}";

	@Test
	void parse() throws IOException {
		JsonNode node = Json.parse(jsonSource);
		assertEquals(node.get("title").asText(), "Coder From Scratch");
	}
	
	@Test
	void fromJson() throws IOException {
		JsonNode node = Json.parse(jsonSource);
		TutorialPojo pojo = Json.fromJson(node, TutorialPojo.class);
		
		assertEquals(pojo.getTitle(), "Coder From Scratch");
	}
	
	@Test
	void toJson() throws IOException {
		TutorialPojo pojo = new TutorialPojo();
		pojo.setTitle("Testing 123");
		
		JsonNode node = Json.toJson(pojo);
		assertEquals("Testing 123", node.get("title").asText());
	}
	
	@Test
	void stringify() throws JsonProcessingException {
		TutorialPojo pojo = new TutorialPojo();
		pojo.setTitle("Testing 123");
		
		JsonNode node = Json.toJson(pojo);
		System.out.println(Json.stringify(node));
		System.out.println(Json.prettyStringify(node));
	}
}
