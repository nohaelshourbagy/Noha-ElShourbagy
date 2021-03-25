import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestB_Stores {
	
	//verify that the api accepts the post request if its missing the non mandatory fields.
	@Test
	void test_PostStores() {
		JSONObject request = new JSONObject();


		request.put("name", "itouch");
		request.put("type", "electronics");
		request.put("address", "Egypt");
		request.put("address2", "United States");
		request.put("city", "cairo");
		request.put("state", "California");
		request.put("zip", "123234");
		request.put("lat", 122234435);
		request.put("lng", 122234435);

		request.put("hours", "15");

		System.out.println(request);

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("http://localhost:3030/stores").
		then().
		statusCode(201);

		//searching for the name of the just created product, 
		//and if its status is 200 then it has been created successfully

		Response response = get("http://localhost:3030/stores/?name=itouch");
		int statusCode= response.getStatusCode();
		System.out.println(response.asPrettyString());
		Assert.assertEquals(statusCode, 200);

	}
	
	
	//verifies that the returned statuscode is correct
	//@Test
	void test_GetStatusCode() {

		Response response = get("http://localhost:3030/stores?$limit=5");		

		System.out.println(response.getBody().asString());


		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}
	
	//delete store with a certain id, and then try to get the just deleted store but  will fail to find it.
	//@Test
	void test_DeleteStores() {
		
	
		when().
			delete("http://localhost:3030/stores/11").
		then().
			statusCode(200).
			log().all();
		
		when().
		get("http://localhost:3030/stores/11").
	then().
		statusCode(404).
		log().all();
	}

	
	
	
}
