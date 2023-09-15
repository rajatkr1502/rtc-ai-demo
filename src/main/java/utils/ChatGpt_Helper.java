package utils;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ChatGpt_Helper {
	
	public static void generateResponse(String input) {
		RestAssured.baseURI = "http://localhost:3000";
		Response response = null;
		String prompt = normaliseException(input);
		String userPrompt= prompt;
		
		System.out.println(userPrompt);
		try {
			response = RestAssured.given()
					.contentType(ContentType.JSON)
					.body(userPrompt)
					.post("/api/generate");
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++ You can try the below code snippets for the Error ++");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(new JsonPath(response.asString()).getString("result"));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("  ++ For Testing Purpose (c) Powered by ChatGPT ++");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public static String normaliseException(String prompt) {
		String escapedString = prompt.replace("\"", "");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userPrompt", escapedString);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);
        return jsonString;
	}

}
