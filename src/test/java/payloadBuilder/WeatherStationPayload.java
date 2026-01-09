package payloadBuilder;

import org.json.simple.JSONObject;

public class WeatherStationPayload {

    public JSONObject registerWeatherStationPayload(String name, String external_id, String latitude, String longitude, String altitude) {
        JSONObject registerWeatherStation = new JSONObject();
        registerWeatherStation.put("external_id", external_id);
        registerWeatherStation.put("name", name);
        registerWeatherStation.put("latitude", latitude);
        registerWeatherStation.put("longitude", longitude);
        registerWeatherStation.put("altitude", altitude);
        return registerWeatherStation;
    }

    public JSONObject registerWeatherStationWithoutStationName(String name, String external_id, String latitude, String longitude, String altitude) {
        JSONObject registerWeatherStationWithoutStationName = new JSONObject();
        registerWeatherStationWithoutStationName.put("external_id", external_id);
        registerWeatherStationWithoutStationName.put("", name);
        registerWeatherStationWithoutStationName.put("latitude", latitude);
        registerWeatherStationWithoutStationName.put("longitude", longitude);
        registerWeatherStationWithoutStationName.put("altitude", altitude);
        return registerWeatherStationWithoutStationName;
    }

    public JSONObject registerWeatherStationWithoutLatitude(String name, String external_id, String latitude, String longitude, String altitude) {
        JSONObject registerWeatherStationWithoutLatitude = new JSONObject();
        registerWeatherStationWithoutLatitude.put("external_id", external_id);
        registerWeatherStationWithoutLatitude.put("name", name);
        registerWeatherStationWithoutLatitude.put("", latitude);
        registerWeatherStationWithoutLatitude.put("longitude", longitude);
        registerWeatherStationWithoutLatitude.put("altitude", altitude);
        return registerWeatherStationWithoutLatitude;
    }

    public JSONObject registerWeatherStationWithoutLongitude(String name, String external_id, String latitude, String longitude, String altitude) {
        JSONObject registerWeatherStationWithoutLongitude = new JSONObject();
        registerWeatherStationWithoutLongitude.put("external_id", external_id);
        registerWeatherStationWithoutLongitude.put("name", name);
        registerWeatherStationWithoutLongitude.put("latitude", latitude);
        registerWeatherStationWithoutLongitude.put("", longitude);
        registerWeatherStationWithoutLongitude.put("altitude", altitude);
        return registerWeatherStationWithoutLongitude;
    }

    public JSONObject registerWeatherStationWithoutAltitude(String name, String external_id, String latitude, String longitude, String altitude) {
        JSONObject registerWeatherStationWithoutAltitude = new JSONObject();
        registerWeatherStationWithoutAltitude.put("external_id", external_id);
        registerWeatherStationWithoutAltitude.put("name", name);
        registerWeatherStationWithoutAltitude.put("latitude", latitude);
        registerWeatherStationWithoutAltitude.put("longitude", longitude);
        registerWeatherStationWithoutAltitude.put("", altitude);
        return registerWeatherStationWithoutAltitude;
    }

    public JSONObject registerWeatherStationWithoutExternalIDPayload(String name, String external_id, String latitude, String longitude, String altitude) {
        JSONObject registerWeatherStationWithoutExternalID = new JSONObject();
        registerWeatherStationWithoutExternalID.put("", external_id);
        registerWeatherStationWithoutExternalID.put("name", name);
        registerWeatherStationWithoutExternalID.put("latitude", latitude);
        registerWeatherStationWithoutExternalID.put("longitude", longitude);
        registerWeatherStationWithoutExternalID.put("altitude", altitude);
        return registerWeatherStationWithoutExternalID;
    }

    public JSONObject getWeatherStationInfoPayload() {
        JSONObject getWeatherStationInfo = new JSONObject();
        return getWeatherStationInfo;
    }

    public JSONObject updateWeatherStationPayload(String name, String external_id, String latitude, String longitude, String altitude) {
        JSONObject updateWeatherStation = new JSONObject();
        updateWeatherStation.put("external_id", external_id);
        updateWeatherStation.put("name", name);
        updateWeatherStation.put("latitude", latitude);
        updateWeatherStation.put("longitude", longitude);
        updateWeatherStation.put("altitude", altitude);
        return updateWeatherStation;
    }

    public JSONObject deleteWeatherStationPayload() {
        JSONObject deleteWeatherStation = new JSONObject();
        return deleteWeatherStation;
    }





}
