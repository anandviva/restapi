package APIChaining;


import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import com.github.javafaker.Faker;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;






/*
 * Sample API site is - Gorest API and get the access(bearer token)
 * 
 *  bToken - 12a91be4dc16443ed53850e699c93201ea824ac4c7237dba5de6bedccd4d551a
 * 
 * 
 * 
 * 
 */

public class CreateUser {
	
	
@Test
	
	void createGOuser(ITestContext context)
	{
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bToken = "12a91be4dc16443ed53850e699c93201ea824ac4c7237dba5de6bedccd4d551a";
		
		int id = given()
		  .headers("Authorization", "Bearer "+bToken)
		  .contentType("application/json")
		  .body(data.toString())
		.when()
		  .post("https://gorest.co.in/public/v2/users")
		  .jsonPath().getInt("id");
		
	System.out.println(id);
	context.setAttribute("user_id", id);
	
		
		
		
		
	}

}
