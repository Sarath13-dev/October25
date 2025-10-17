package org.steps;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	// 1. Create User defined methods
		// 2. Write Original Logic inside the user defined methods
		// 3. Convert all the inputs into Arguments and output into Return type

		public static RequestSpecification requestObject;
		public static Response response;

		// 1. Request Object
		public static void requestObject(String baseURI) {
			RestAssured.baseURI = baseURI;
			requestObject = RestAssured.given();
		}

		// 2. Attach Query parameter
		public static void attachQueryParam(String parameterName, String parameterValue) {
			requestObject.queryParam(parameterName, parameterValue);
		}

		// 3. Attach path parameter
		public static void attachPathParam(String parameterName, String parameterValue) {
			requestObject.pathParam(parameterName, parameterValue);
		}

		// 4. Attach the headers
		public static void attachHeaders(String headerName, String headerValue) {
			requestObject.header(headerName, headerValue);
		}

		// 5. Attach authentication token
		public static void authentication(String userName, String password) {
			requestObject.auth().basic(userName, password);
		}

		public static void authentication(String accessToken) {
			requestObject.auth().oauth2(accessToken);
		}

		// 6. Attach the payload
		public static void attachPayload(JSONObject jsonObject) {
			requestObject.body(jsonObject.toJSONString());
		}

		// 7. Create Response Object
		public static void responseObject(String requestType, String resources) {
			switch (requestType) {
			case "GET": {
				response = requestObject.request(Method.GET, resources); break;
			}
			case "POST": {
				response = requestObject.request(Method.POST, resources);break;
			}
			case "PUT": {
				response = requestObject.request(Method.PUT, resources);break;
			}
			default: {
				response = requestObject.request(Method.DELETE, resources);
			}
			}

		}

		// 8. Get the Response Code
		public static void getResponseCode() {
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
		}

		// 9. Get the Response body
		public static void getResponseBody() {
			String asPrettyString = response.getBody().asPrettyString();
			System.out.println(asPrettyString);
		}
		
		

}
