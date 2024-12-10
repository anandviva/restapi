package JSONSchemaValidation;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



// JSON Schema Validator - https://jsonformatter.org/json-to-jsonschema
//Sample API - https://apipheny.io/free-api/

public class JSONSchemaValidation {
	
	@Test
	void jsonSchemaValidation()
	{
		given()
		.when()
		  .get("https://official-joke-api.appspot.com/random_joke")
		.then()
		     // Here we are validating entire response body schema 
		    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemaex.json"))
		    .log().body();
		
		
		
		
	}

}
