package HTTPBasicSetup;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; // These 3 packages static for the rest assured
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


/*  given()
 * 
 *     Content type, set cookie, add auth, add param, set headers info.. etc   all the prerequisite
 *     
 *   
 *  when()
 *  
 *     HTTP Methods (GET, POST,PUT, DELETE) and URL of API's 
 *    
 * then ()
 * 
 *  validate the response (Status code, time of response, body of the content, extract headers & cookies)
 *  
 *  
 * 
 * 
 * 
 * 
 */



public class BasicHTTPSetup {
	
	int id;
	
	@Test (priority=1)
	void getuser()
	
	{
		
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		   
		
		.then()
		 .statusCode(200)
		 .body("page", equalTo(2))
		 .log().all();
		
	}
	
	@Test (priority=2)
	void createuser()
	{
		
		
		HashMap data = new HashMap();
		
		data.put("name", "Reva");
		data.put("job", "GmKhan");
		
		
      id=given()
           .contentType("application/json")
           .body(data)
		
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");
		
		
		
		
		
	}
	
	@Test (priority=3, dependsOnMethods = {"createuser"})
	void updateuser()
	{
		
		
		HashMap data = new HashMap();
		
		data.put("name", "Rajiv");
		data.put("job", "Smuk");
		
		
       given()
           .contentType("application/json")
           .body(data)
		
		.when()
		   .put("https://reqres.in/api/users/"+id)
		   
		.then()
		    .statusCode(200)
		    .log().all();
	
      
	}
	
	@Test (priority=4)
	void deleteuser()
	{
		
		
		  given()
          
		.when()
		   .delete("https://reqres.in/api/users/"+id)
		   
		.then()
		    .statusCode(204);
		   // .log().all();
	
		
	}

}
