package allMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;


public class CreateStation_Post {
	
	@Test
	public void createstation(){
		RestAssured.baseURI ="http://api.openweathermap.org";
		
		Response response = given().
				header("Content-Type","application/json").
				body("{\"external_id\":\"SFSTA_TEST001\","
						+ "\"name\":\"San Francisco Test Station\","
						+ "\"latitude\":37.76,"
						+ "\"longitude\":-122.43,"
						+ "\"altitude\":150}").when().
				post("/data/3.0/stations?appid=2bf78131342a5beaae32924cce166ff0").
				then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().body("external_id", equalTo("SFSTA_TEST001")).
				and().body("name", equalTo("San Francisco Test Station")).
				extract().response();
		
		JsonPath js= ReusableMethods.rawToJson(response);
		String ID=js.get("ID");
		System.out.println(ID);
		
		//Station ID ="5dd38a296c634e00011dfda2";
		
	}

}
