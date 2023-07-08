package Utilities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookie.Builder;
import io.restassured.response.Response;

public class API {

	public static Response GETRequest() {
		baseURI = "http://10.244.218.130:8080/team";

		Response response=given().
			get();
		return response;
	}

	
	public static Response POSTRequest(String URI,String jsonString) {


		Response response=given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(jsonString).
		when().
			post(URI);
		return response;

	}

	
	
	
}
