package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getRequest {
	
	@Test
	public void get() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		response.getBody();
	}

}
