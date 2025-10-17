Feature: Test the Reqres website
Scenario: Test GET request url using rest assured
Given User creates the request object "https://reqres.in"
When User adds the query parameter "page" and "2"
And User creates the response object "GET"
Then User validates the response code 200
