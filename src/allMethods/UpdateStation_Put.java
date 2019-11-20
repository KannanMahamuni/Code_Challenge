package allMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateStation_Put {

	@Test
	public void updatestation(){
		RestAssured.baseURI ="http://api.openweathermap.org";
		
		Response response = given().
				header("Content-Type","application/json").
				body("{\"external_id\":\"SFSTAUPD_TEST001\","
						+ "\"name\":\"San Francisco Updated Test Station\","
						+ "\"latitude\":39.77,"
						+ "\"longitude\":-122.23,"
						+ "\"altitude\":144}").when().
				put("/data/3.0/stations/5dd38a296c634e00011dfda2?appid=2bf78131342a5beaae32924cce166ff0").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("external_id", equalTo("SFSTAUPD_TEST001")).
				and().body("name", equalTo("San Francisco Updated Test Station")).
				extract().response();
		
		JsonPath js= ReusableMethods.rawToJson(response);
		String ID=js.get("ID");
		System.out.println(ID);
}
}
