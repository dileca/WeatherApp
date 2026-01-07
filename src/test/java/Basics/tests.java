package Basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class tests {

    static String baseURL = "http://api.openweathermap.org";
    static String authToken = "f31404aed7e27d3bb39bb80ceea07911";
    static String stationID;

    @Test(priority = 1)
    public void registerWeatherStation() {

        String path = "/data/3.0/stations";
        String payload = "{\n" +
                "  \"external_id\": \"{{external_id}}\",\n" +
                "  \"name\": \"{{station_name}}\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .queryParam("appid", authToken)
                .body(payload)
                .log().all()
                .post().prettyPeek();

        // validate data returned for each response field
        // .body("external_id", equalTo("{{external_id}}"))//.body("name", equalTo("{{station_name}}"))
        // .body("latitude", equalTo(37.76f))
        // .body("longitude", equalTo(-122.43f))
        // .body("altitude", equalTo(150));

        //Extract station id for further use
        stationID = responseBody.jsonPath().getString("ID");
        System.out.println("Registered Station ID: " + stationID);

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201, "Status code should be 201");
    }

    @Test(priority = 2)
    public void negative_registerWeatherStationWithoutExternalId() {
        String path = "/data/3.0/stations";
        String payload = " {\n" +
                "  \"external_id\": \"\",\n" +
                "  \"name\": \"{{station_name}}\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
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
        Assert.assertEquals(actualStatusCode, 400, "Status code should be 400");
    }

    @Test(priority = 3)
    public void negative_registerWeatherStationWithoutName() {
        String path = "/data/3.0/stations";
        String payload = " {\n" +
                "  \"external_id\": \"{{external_id}}\",\n" +
                "  \"name\": \"\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
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
        Assert.assertEquals(actualStatusCode, 400, "Status code should be 400");
    }

    @Test(priority = 4)
    public void getWeatherStationInfo() {

        String path = "/data/3.0/stations/{stationID}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .pathParam("stationID", stationID)
                .queryParam("appid", authToken)
                .log().all()
                .get().prettyPeek();

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 200, "Status code should be 200");
    }
    @Test(priority = 5)
    public void updateLongitudeAndLatitude() {
        String path = "/data/3.0/stations/{stationID}";
        String payload = " {\n" +
                "  \"external_id\": \"{{external_id}}\",\n" +
                "  \"name\": \"{{station_name}}\",\n" +
                "  \"latitude\": 41.62,\n" +
                "  \"longitude\": -115.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .pathParam("stationID", stationID)
                .queryParam("appid", authToken)
                .body(payload)
                .log().all()
                .put().prettyPeek();

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 200, "Status code should be 200");
    }

    @Test(priority = 6)
    public void deleteWeatherStation() {

        String path = "/data/3.0/stations/{stationID}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .pathParam("stationID", stationID)
                .queryParam("appid", authToken)
                .log().all()
                .delete().prettyPeek();

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 204, "Status code should be 204");
    }
}






