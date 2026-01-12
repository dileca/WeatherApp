package requestBuilder;

import com.github.fge.jsonschema.core.processing.ProcessorSelectorPredicate;
import com.github.fge.jsonschema.core.report.MessageProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static commom.Base.baseURL;
import static io.restassured.RestAssured.post;
import static payloadBuilder.WSPayload.registerWeatherStationPayload;

public class WSRequestBuilder {


   public static String apiKey = "f31404aed7e27d3bb39bb80ceea07911";
   public static String stationID;

    public static Response registerWeatherStationResponse() {

        Response response = RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS002", 37, -122, 150))
                .post()
                .then()
                .extract().response();

        stationID = response.jsonPath().getString("ID");
        return response;
    }

    public static Response getWeatherStationInfoResponse(String stationID) {

        return   RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + stationID)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .get()
                .then()
                .extract().response();
    }

    public static Response updateLongitudeAndLatitudeResponse(String stationID, Double latitude, Double longitude) {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + stationID)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS005", 39, -122, null))
                .put()
                .then()
                .extract().response();
    }

    public static Response deleteWeatherStationResponse(String stationID) {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + stationID)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .delete()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStationWithoutStationNameResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("", "WS002", 37, -122, 150))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStationWithoutExternalIDResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "", 37, -122, 150))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStationWithoutLatitudeResponse() {

        return   RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", Integer.valueOf(" ".toString()), -122, 150))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStationWithoutLongitudeResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS004", 37, Integer.valueOf(" ".toString()), 150))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStationWithoutAltitudeResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS005", 37, -122, Integer.valueOf(" ".toString())))
                .post()
                .then()
                .extract().response();
    }

}
