package allMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetStation {
	
	@Test
	public void getstationcreated(){
		RestAssured.baseURI ="http://api.openweathermap.org";
		
		Response response = given().
				header("Content-Type","application/json").
				get("/data/3.0/stations/5dd38a296c634e00011dfda2?appid=2bf78131342a5beaae32924cce166ff0").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("external_id", equalTo("SFSTA_TEST001")).
				and().body("name", equalTo("San Francisco Test Station")).
				extract().response();
		
		
		JsonPath js= ReusableMethods.rawToJson(response);
		String stationid=js.get("id");
		System.out.println(stationid);
	}
}
