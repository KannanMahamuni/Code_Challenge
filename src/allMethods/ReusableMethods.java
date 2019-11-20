package allMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

	public static JsonPath rawToJson(Response r)
	{
		String response = r.asString();
		System.out.println(response);
		JsonPath x = new JsonPath(response);
		return x;
	}
}
