import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestA_Products {


	//verifies that the status code is returned correctly
	//@Test
	void test_GetStatusCode() {

		Response response = get("http://localhost:3030/products?$limit=5");		

		System.out.println(response.getBody().asString());


		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);





	}

	//verifies that the first ID returned , is correct as postman.
	//@Test
	void test_GetID() {

		//int id=43900;
		given()

		.get("http://localhost:3030/products/?id=43900")
		.then()
		.statusCode(200)
		.log().all()
		.body("data.id[0]",equalTo(43900));


	}	
	
	//verifing that creating a product will succeed.
	//@Test
	void test_PostProducts() {
		JSONObject request = new JSONObject();


		request.put("name", "IPhoneX");
		request.put("type", "test");
		request.put("price", 8898);
		request.put("shipping", 0);
		request.put("upc", "Test");
		request.put("description", "Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
		request.put("manufacturer", "Apple");
		request.put("model", "MN2400B4Z");

		request.put("url", "https//:apple.com");
		request.put("image", "String");

		System.out.println(request.toJSONString());

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("http://localhost:3030/products").
		then().
		statusCode(201);

		//searching for the name of the just created product, 
		//and if its status is 200 then it has been created successfully

		Response response = get("http://localhost:3030/products/?name=IPhoneX");
		int statusCode= response.getStatusCode();

		Assert.assertEquals(statusCode, 200);


	}
	
	
	@Test
	void test_PostProductswithoutRequiredName() {
		JSONObject request = new JSONObject();


		//request.put("name", "IPhoneX");
		request.put("type", "CellPhone");
		request.put("price", 12000);
		request.put("shipping", 0);
		request.put("upc", "Test");
		request.put("description", "Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
		request.put("manufacturer", "Apple");
		request.put("model", "MN2400B4Z");

		request.put("url", "https//:apple.com");
		request.put("image", "String");

		System.out.println(request.toJSONString());

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("http://localhost:3030/products").
		then().
		statusCode(400);

		//The test will succeed because the expected status code is 400,
		//because the name field is not sent and its mandatory.

	}

}
