package APIChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class APIChainingSIngle {
	
	int id;
	String bToken = "12a91be4dc16443ed53850e699c93201ea824ac4c7237dba5de6bedccd4d551a";
	
@Test (priority =1)
	
	void createGOuser()
	{
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		
		
		id = given()
		  .headers("Authorization", "Bearer "+bToken)
		  .contentType("application/json")
		  .body(data.toString())
		.when()
		  .post("https://gorest.co.in/public/v2/users")
		  .jsonPath().getInt("id");
		
	System.out.println(id);	
		
	}

@Test (priority =2)
 void getGOuser()
  {
	
	
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

@Test (priority =3)

void updateGOuser()
{
	Faker faker = new Faker();
	
	JSONObject data = new JSONObject();
	
	data.put("name", faker.name().fullName());
	data.put("gender", "Female");
	data.put("email", faker.internet().emailAddress());
	data.put("status", "inactive");
	

	
	 given()
	  .headers("Authorization", "Bearer "+bToken)
	  .contentType("application/json")
	  .pathParam("id", id)
	  .body(data.toString())
	.when()
	  .put("https://gorest.co.in/public/v2/users/{id}")
	.then()
	  .statusCode(200)
	  .log().body();	
}



@Test (priority =4)

void deleteGOuser()

{
	
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
