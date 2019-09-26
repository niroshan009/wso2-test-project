package com.niroshan;

import static org.assertj.core.api.Assertions.assertThat;

import com.niroshan.support.APIMRequests;
import com.niroshan.support.APIMResponse;
import com.niroshan.support.ResourceFileLoader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Properties;


public class DummyTest {

    public String apiBaseUrl = "http://localhost:8280/mock/success";
    public String apiHost;
    public APIMResponse apiManagerResponse;
    public APIMRequests apiManagerRequests = new APIMRequests();

    @When("I pretend to do something")
    public void pretendToDoSomething() {
        System.out.println("I pretend to do something");
        ;
    }

    @Then("Something start to happen")
    public void somethingHappen() {
        System.out.println("Something start to happen");
    }

    @Given("^I call the mock endpoint")
    public void callGetApiWithPostId() throws ClientProtocolException, IOException {
        apiHost = apiBaseUrl;
        apiManagerResponse = apiManagerRequests.getRequest(apiHost, "application/json");
    }

    @Given("^I call the posts context to get all posts$")
    public void callGetAllPosts() throws ClientProtocolException, IOException {
        apiManagerResponse = apiManagerRequests.getRequest(apiBaseUrl, "application/json");
    }


    @Then("^the response code is (\\d+)$")
    public void verifyResponseCode(Integer statusCode) {
        assertThat(apiManagerResponse.getStatusCode()).isEqualTo(statusCode);
    }


    @SuppressWarnings("unchecked")
    @Then("^the response body should match with \"(.*?)\" file$")
    public void isResponMatchingWithInput(String payload) throws ParseException, IOException {
        assertThat(convertResponseToJsonObject(apiManagerResponse.getEntityAsString()))
                .isEqualTo(convertResponseToJsonObject(ResourceFileLoader.readResourceContent(payload)));
    }

    private JSONObject convertResponseToJsonObject(String apiManagerResponse) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        JSONObject responseJson = (JSONObject) parser.parse(apiManagerResponse);
        return responseJson;
    }

    private JSONArray convertResponseToJsonArray(APIMResponse apiManagerResponse) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        JSONArray responseJsonArray = (JSONArray) parser.parse(apiManagerResponse.getEntityAsString());
        return responseJsonArray;
    }


}
