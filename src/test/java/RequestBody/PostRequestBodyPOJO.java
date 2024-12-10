package RequestBody;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class PostRequestBodyPOJO {
	
	@Test
	void requestPOJO() throws JsonProcessingException
	
	{
		POJOClass pj = new POJOClass();
		
		pj.setName("Apple MacBook Pro 16");
	    
		Map<String,Object> Dataob = new LinkedHashMap();
		
		Dataob.put("year", "1990");
		Dataob.put("price", "1990");
		Dataob.put("CPUModel", "BNV");
		Dataob.put("Harddisksize", "1 TB");
		
		String message = Dataob.toString();
		
		pj.setData(message);
		
			
		
	given()
	  .contentType("application/json")
	  .body(pj)
	.when()
	  .post("https://api.restful-api.dev/objects")
	  
	 .then()
	   .statusCode(200)
	   //.body("id", equalTo("ff80818192925da7019300b7ea246fd4"))
	   .log().all();
	}

}
