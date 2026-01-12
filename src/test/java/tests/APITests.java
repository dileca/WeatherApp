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
                .body("external_ID", equalTo("WS002"))
                .body("name", equalTo("Downtown Weather Station"))
                .body("latitude", equalTo(37.76f))
                .body("longitude", equalTo(-122.43f))
                .body("altitude", equalTo(150));
    }

    @Test(priority = 1)
    public void getWeatherStationInfoTest() {
        WSRequestBuilder.getWeatherStationInfoResponse(String.valueOf(stationID))
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void updateLongitudeAndLatitudeTest() {
        WSRequestBuilder.updateLongitudeAndLatitudeResponse(String.valueOf(stationID), -123.45, 38.76)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
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


}
