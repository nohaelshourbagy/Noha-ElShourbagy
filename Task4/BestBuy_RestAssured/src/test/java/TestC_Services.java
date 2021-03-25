import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class TestC_Services {
	@Test
	public void testPatch() {
		JSONObject request = new JSONObject();


		request.put("name", "itouch");

		System.out.println(request);

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("http://localhost:3030/services/2").
		then().
		statusCode(200);
		Response response = get("http://localhost:3030/services/?name=itouch");

		Assert.assertEquals(request.get("name"), "itouch");
		

	}


	//@Test
	void test_GetStatusCode() {

		Response response = get("http://localhost:3030/services?$limit=5");		

		System.out.println(response.getBody().asString());


		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	//@Test
	void test_DeleteServices() {


		when().
		delete("http://localhost:3030/services/9").
		then().
		statusCode(200).
		log().all();

		when().
		get("http://localhost:3030/services/9").
		then().
		statusCode(404).
		log().all();
	}


}
