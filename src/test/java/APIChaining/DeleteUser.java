package APIChaining;


import org.testng.ITestContext;
import org.testng.annotations.Test;

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




public class DeleteUser {
	
	
	@Test
	
	void deleteGOuser(ITestContext context)
	
	{
		
		int id = (int) context.getAttribute("user_id");
		String bToken = "12a91be4dc16443ed53850e699c93201ea824ac4c7237dba5de6bedccd4d551a";
		
		 given()
		  .headers("Authorization", "Bearer "+bToken)
		  .contentType("application/json")
		  .pathParam("id", id)
		  
		.when()
		  .delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		  .statusCode(204);
		  
		
		
		
	}
	
	
	

}
