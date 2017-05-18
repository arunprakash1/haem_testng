/**
 * 
 */
package com.apiTesting.chatter;

import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author aprakash
 *
 */
public class ChatterTest {
	
	String url = "http://chatter-test.us-east-1-vpc-88394aef.slb-internal.test.aws.away.black/message/query";
	String authToken = "5e30a6c8d47a305a";
	String request = "I want to go to book an apartment in Singapore";
	
	@Test()
	public void httpPost() throws JSONException,InterruptedException {
		
		//Initializing Rest API's URL
		String APIUrl = "http://chatter-test.us-east-1-vpc-88394aef.slb-internal.test.aws.away.black/message/query";
			
		//Initializing payload or API body (e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}")
		String APIBody = "{\"authToken\" : \"5e30a6c8d47a305a\", \"query\" : \"I want to go to book an apartment in Singapore\"}";
		
					
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
			
		//Setting API's body
		builder.setBody(APIBody);
			
		//Setting content type as application/json or application/xml
		builder.setContentType("application/json");
			
		RequestSpecification requestSpec = builder.build();

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = given().authentication().preemptive().basic("","")
					.spec(requestSpec).when().post(APIUrl);
//		JSONObject JSONResponseHeader = new JSONObject(response.getHeaders());
//		System.out.println("JSONResponseHeader is ::"+JSONResponseHeader);
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		System.out.println("JSONResponseBody is ::"+JSONResponseBody);

		//Fetching the desired value of a parameter
		//String result = JSONResponseBody.getString({key});
			
		//Asserting that result of Norway is Oslo
		//Assert.assertEquals(result, "{expectedValue}");

	}


}
