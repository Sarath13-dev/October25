package org.steps;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class StepDefinition extends BaseClass{
	
	@Given("User creates the request object {string}")
	public void user_creates_the_request_object(String string) {
	   requestObject(string);
	   attachHeaders("x-api-key", "reqres-free-v1");
	    
	}
	@When("User adds the query parameter {string} and {string}")
	public void user_adds_the_query_parameter_and(String string, String string2) {
	   attachQueryParam(string, string2);
	    
	}
	@When("User creates the response object {string}")
	public void user_creates_the_response_object(String string) {
	   responseObject(string, "api/users");
	    
	}
	@Then("User validates the response code {int}")
	public void user_validates_the_response_code(Integer int1) {
		getResponseBody();
		getResponseCode();
	   int statusCode = response.getStatusCode();
	   Assert.assertEquals(200, statusCode);
	   System.out.println("==========Status Code is validated=========");
	   //TO validate the response Body
	   Object object = response.jsonPath().get("data[1].first_name");
	   String name = (String)object;
	   Assert.assertEquals("Lindsay", name);
	   System.out.println("=============Response Body is validated====");
	   
	    
	}


}
