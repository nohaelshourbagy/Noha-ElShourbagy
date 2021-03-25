import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class TestD_Categories {
	
	
	//adds a category and verify its added successfully
	//@Test
	public static void PostCategories() {
		JSONObject request = new JSONObject();


		request.put("name", "Fashion");
		request.put("id", "0128");
		

		System.out.println(request.toJSONString());

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("http://localhost:3030/categories").
		then().
		statusCode(201);

		//searching for the name of the just created product, 
		//and if its status is 200 then it has been created successfully

		Response response = get("http://localhost:3030/categories/?name=Fashion");
		int statusCode= response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);

	}
	
	@Test
	public static void PostNonUniqueId() {
		JSONObject request = new JSONObject();


		request.put("name", "TestPost12");
		request.put("id", "12");
		

		System.out.println(request.toJSONString());

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("http://localhost:3030/categories").
		then().
		statusCode(400);
		

		//searching for the name of the just created product, 
		//and if its status is 200 then it has been created successfully

		Response response = get("http://localhost:3030/categories/?name=TestPost12");
		int statusCode= response.getStatusCode();
		System.out.println(response.asPrettyString());
		JsonPath responseJSON = response.jsonPath();
		Assert.assertEquals(responseJSON.getInt("total"), 0);
}
}