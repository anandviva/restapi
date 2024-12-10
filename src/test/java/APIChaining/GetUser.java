package APIChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GetUser {
	
	
@Test
	
	void getGOuser(ITestContext context)
	{
		
		int id = (int) context.getAttribute("user_id"); //This should come from create user id
		
		String bToken = "12a91be4dc16443ed53850e699c93201ea824ac4c7237dba5de6bedccd4d551a";
		
	  given()
		  .headers("Authorization", "Bearer "+bToken)
		  .contentType("application/json")
		  .pathParam("id", id)
		  
		.when()
		  .get("https://gorest.co.in/public/v2/users/{id}")
	    .then()
	      .statusCode(200)
	      .log().body();
	  
	  
	}	 
		


}
