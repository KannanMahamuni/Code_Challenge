package allMethods;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Invalidrequest_Post {
	
	@Test
	public void createstation_withoutapikey(){
		RestAssured.baseURI ="http://api.openweathermap.org";
		
		Response response = given().
				header("Content-Type","application/json").
				body("{\"external_id\":\"SFSTA_TEST001\","
						+ "\"name\":\"San Francisco Test Station\","
						+ "\"latitude\":37.76,"
						+ "\"longitude\":-122.43,"
						+ "\"altitude\":150}").when().
				post("/data/3.0/stations").
				then().assertThat().statusCode(401).
				extract().response();
	}

}
