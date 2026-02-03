package requestBuilder;

import com.github.fge.jsonschema.core.processing.ProcessorSelectorPredicate;
import com.github.fge.jsonschema.core.report.MessageProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static commom.Base.baseURL;
import static io.restassured.RestAssured.post;
import static payloadBuilder.WSPayload.*;

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
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS001", 37, -122, 150))
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

    public static Response updateLongitudeAndLatitudeResponse(String stationID) {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + stationID)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(updateWeatherStationPayload("Downtown Weather Station", "WS002", 41, -106, 150))
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
                .body(registerWeatherStationPayload("", "WS003", 28, -142, 130))
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
                .body(registerWeatherStationPayload("Boston Weather Station", "", 28, -142, 130))
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
                .body(registerWeatherStationPayloadWithStringLatitude("Boston Weather Station", "WS003", "", -142, 130))
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
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", 28, null, 130))
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
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", 28, -142, null))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStation_LatitudeOutOfRangeResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", 95, -142, 100))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStation_LongitudeOutOfRangeResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", 28, -190, 100))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStation_LatitudeAsStringResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", Integer.valueOf("one hundred".toString()), -142, Integer.valueOf("One hundred".toString())))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStation_LongitudeAsStringResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", 28, Integer.valueOf("two hundred".toString()), Integer.valueOf("One hundred".toString())))
                .post()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStation_AltitudeAsStringResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", 28, -142, Integer.valueOf("three hundred".toString())))
                .post()
                .then()
                .extract().response();
    }

    public static Response updateWeatherStation_LatitudeOutOfRangeResponse(String stationID) {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + stationID)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(updateWeatherStationPayload("Downtown Weather Station", "WS002", 95, -106, 150))
                .put()
                .then()
                .extract().response();
    }

    public static Response updateWeatherStation_LongitudeOutOfRangeResponse(String stationID) {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations/" + stationID)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(updateWeatherStationPayload("Downtown Weather Station", "WS002", 41, -190, 150))
                .put()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStationWithEmptyAltitudeResponse() {

        return RestAssured.given()
                .baseUri(baseURL)
                .basePath("/data/3.0/stations")
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .queryParam("appid", apiKey)
                .log().all()
                .body(registerWeatherStationPayload("Downtown Weather Station", "WS003", 37, -122, null))
                .post()
                .then()
                .extract().response();
    }

}
