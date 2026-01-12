package basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class tests {

    static String baseURL = "http://api.openweathermap.org";
    static String apiKey = "f31404aed7e27d3bb39bb80ceea07911";
    static String stationID;
    static String externalID;
    static String stationName;

    @Test(priority = 1)
    public void registerWeatherStation() {

        String path = "/data/3.0/stations";
        String payload = " {\n" +
                "  \"external_id\": \"{{externalID}}\",\n" +
                "  \"name\": \"{{stationName}}\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .body(payload)
                .log().all()
                .post().prettyPeek();

                //validate data returned for each response field
//                .body()
//                .body("name", equalTo("{{stationName}}"))
//                .body("latitude", equalTo(37.76f))
//                .body("longitude", equalTo(-122.43f))
//                .body("altitude", equalTo(150));

        //Extract station id for further use
        stationID = responseBody.jsonPath().getString("ID");
        System.out.println("Registered Station ID: " + stationID);

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 201, "Status code should be 201");

        //create a method to generate external_id and station_name in response
        String externalID = "station_" + System.currentTimeMillis();
        String stationName = "Weather Station " + System.currentTimeMillis();
        System.out.println("Generated externalID: " + externalID);
        System.out.println("Generated stationName: " + stationName);
    }

    @Test(priority = 2)
    public void negative_registerWeatherStationWithoutExternalId() {
        String path = "/data/3.0/stations";
        String payload = "{\n" +
                "  \"external_id\": \"\",\n" +
                "  \"name\": \"{{stationName}}\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
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
        String payload = "{\n" +
                "  \"external_id\": \"{{externalID}}\",\n" +
                "  \"name\": \"\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
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
                .queryParam("appid", apiKey)
                .log().all()
                .get().prettyPeek();

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 200, "Status code should be 200");
    }

    @Test(priority = 5)
    public void updateLongitudeAndLatitude() {
        String path = "/data/3.0/stations/{stationID}";
        String payload = "{\n" +
                "  \"external_id\": \"{{externalID}}\",\n" +
                "  \"name\": \"{{stationName}}\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response responseBody = RestAssured.given()
                .baseUri(baseURL)
                .basePath(path)
                .header("Content-Type", "application/json")
                .pathParam("stationID", stationID)
                .queryParam("appid", apiKey)
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
                .queryParam("appid", apiKey)
                .log().all()
                .delete().prettyPeek();

        System.out.println(responseBody.getBody().asString());

        int actualStatusCode = responseBody.getStatusCode();
        Assert.assertEquals(actualStatusCode, 204, "Status code should be 204");
    }
}






