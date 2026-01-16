package tests;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;
import requestBuilder.WSRequestBuilder;

import static org.hamcrest.Matchers.equalTo;
import static requestBuilder.WSRequestBuilder.stationID;

public class APITests {

    @Test
    public void registerWeatherStationTest() {

        WSRequestBuilder.registerWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .body("external_id", equalTo("WS001"))
                .body("name", equalTo("Downtown Weather Station"))
                .body("latitude", equalTo(37))
                .body("longitude", equalTo(-122))
                .body("altitude", equalTo(150));
    }

    @Test(priority = 1)
    public void getWeatherStationInfoTest() {
        WSRequestBuilder.getWeatherStationInfoResponse(String.valueOf(stationID))
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("external_id", equalTo("WS001"))
                .body("name", equalTo("Downtown Weather Station"))
                .body("latitude", equalTo(37))
                .body("longitude", equalTo(-122))
                .body("altitude", equalTo(150));
    }

    @Test(priority = 2)
    public void updateLongitudeAndLatitudeTest() {
        WSRequestBuilder.updateLongitudeAndLatitudeResponse(String.valueOf(stationID))
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("external_id", equalTo("WS002"))
                .body("name", equalTo("Downtown Weather Station"))
                .body("latitude", equalTo(41))
                .body("longitude", equalTo(-106))
                .body("altitude", equalTo(150));
    }

    @Test(priority = 3)
    public void deleteWeatherStationTest() {
        WSRequestBuilder.deleteWeatherStationResponse(String.valueOf(stationID))
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }

    @Test(priority = 4)
    public void registerWeatherStationWithoutStationNameTest() {
        WSRequestBuilder.registerWeatherStationWithoutStationNameResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 5)
    public void registerWeatherStationWithoutExternalIDTest() {
        WSRequestBuilder.registerWeatherStationWithoutExternalIDResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 6)
    public void registerWeatherStationWithoutLatitudeTest() {
        WSRequestBuilder.registerWeatherStationWithoutLatitudeResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 7)
    public void registerWeatherStationWithoutLongitudeTest() {
        WSRequestBuilder.registerWeatherStationWithoutLongitudeResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 8)
    public void registerWeatherStationWithoutAltitudeTest() {
        WSRequestBuilder.registerWeatherStationWithoutAltitudeResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 9)
    public void registerWeatherStation_LatitudeOutOfRangeTest() {
        WSRequestBuilder.registerWeatherStation_LatitudeOutOfRangeResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 10)
    public void registerWeatherStation_LongitudeOutOfRangeTest() {
        WSRequestBuilder.registerWeatherStation_LongitudeOutOfRangeResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 11)
    public void registerWeatherStation_LatitudeAsStringTest() {
        WSRequestBuilder.registerWeatherStation_LatitudeAsStringResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 12)
    public void registerWeatherStation_LongitudeAsStringTest() {
        WSRequestBuilder.registerWeatherStation_LongitudeAsStringResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 13)
    public void registerWeatherStation_AltitudeAsStringTest() {
        WSRequestBuilder.registerWeatherStation_AltitudeAsStringResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 14)
    public void updateWeatherStation_LatitudeOutOfRangeTest() {
        WSRequestBuilder.updateWeatherStation_LatitudeOutOfRangeResponse(String.valueOf(stationID))
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

    @Test(priority = 15)
    public void updateWeatherStation_LongitudeOutOfRangeTest() {
        WSRequestBuilder.updateWeatherStation_LongitudeOutOfRangeResponse(String.valueOf(stationID))
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

}
