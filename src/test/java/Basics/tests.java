package Basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.instanceOf;

public class tests {

    static String baseURL = "http://api.openweathermap.org";
    static String authToken = "f31404aed7e27d3bb39bb80ceea07911" ;
   

    @Test
    public void registerWeatherStation() {

        String path = "/data/3.0/stations";
        String payload = " {\n" +
                "  \"external_id\": \"WS-001\",\n" +
                "  \"name\": \"Downtown Weather Station\",\n" +
                "  \"owner\": \"NYC Municipality\",\n" +
                "  \"latitude\": 40.7128,\n" +
                "  \"longitude\": -74.0060,\n" +
                "  \"exclude\": \"minutely,alerts\",\n" +
                "  \"units\": \"metric\",\n" +
                "  \"language\": \"english\"\n" +
                " \n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .queryParam("appid", authToken)
                .body(payload)
                .log().all()
                .post().prettyPeek();

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201, "Status code should be 201");
    }




}



