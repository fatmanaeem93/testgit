package artcourse;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Courses {
	 public String accessToken;
	 
	 @Test
	 public void register() {
			
			JSONObject reqParams = new JSONObject();
			reqParams.put("email","fatma@mail.com");
			reqParams.put("password","bestPassw0rd");
			baseURI = "http://localhost:3000";
			RequestSpecification req =given();
			req.header("content-type","application/json");
			req.body(reqParams.toString());
			Response res =req.post("/register");
			int statusCode =res.getStatusCode();
			Assert.assertEquals(statusCode,201);
			accessToken =res.jsonPath().get("accessToken");	
		}
	@BeforeTest
	public void login () {
		org.json.JSONObject reqParams = new JSONObject();
		reqParams.put("email","fatma@mail.com");
		reqParams.put("password","bestPassw0rd");
		baseURI = "http://localhost:3000";
		RequestSpecification req =given();
		req.header("content-type","application/json");
		req.body(reqParams.toString());
		Response res =req.post("/login");
		int statusCode =res.getStatusCode();
		Assert.assertEquals(statusCode,200);
		System.out.println(res.body().prettyPrint());
		String email= res.jsonPath().get("user.email");
		Assert.assertEquals(email,"fatma@mail.com");
		accessToken =res.jsonPath().get("accessToken");	

	}
	@Test
	public void getAllCourses () {
		baseURI = "http://localhost:3000/660";
		RequestSpecification req =given();
		req.header("content-type","application/json");
		req.header("Authorization", "Bearer " + accessToken);
		Response res =req.get("/courses");
		int statusCode =res.getStatusCode();
		Assert.assertEquals(statusCode,200);
		System.out.println(res.body().prettyPrint());
		
	}
	
	@Test
	public void getCourse () {
		baseURI = "http://localhost:3000";
		given().get("/courses/1").then().statusCode(200);
	}
	
	@Test
	public void postCource () {
		baseURI = "http://localhost:3000";
		given().put("/courses/1").then().statusCode(200);
	}
}
