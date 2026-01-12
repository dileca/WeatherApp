package payloadBuilder;

import org.json.simple.JSONObject;

public class WSPayload {

    public static JSONObject registerWeatherStationPayload(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStation = new JSONObject();
        registerWeatherStation.put("external_id", external_id);
        registerWeatherStation.put("name", name);
        registerWeatherStation.put("latitude", latitude);
        registerWeatherStation.put("longitude", longitude);
        registerWeatherStation.put("altitude", altitude);
        return registerWeatherStation;
    }

    public static JSONObject registerWeatherStationWithoutStationName(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStationWithoutStationName = new JSONObject();
        registerWeatherStationWithoutStationName.put("external_id", external_id);
        registerWeatherStationWithoutStationName.put("", name);
        registerWeatherStationWithoutStationName.put("latitude", latitude);
        registerWeatherStationWithoutStationName.put("longitude", longitude);
        registerWeatherStationWithoutStationName.put("altitude", altitude);
        return registerWeatherStationWithoutStationName;
    }

    public static JSONObject registerWeatherStationWithoutLatitude(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStationWithoutLatitude = new JSONObject();
        registerWeatherStationWithoutLatitude.put("external_id", external_id);
        registerWeatherStationWithoutLatitude.put("name", name);
        registerWeatherStationWithoutLatitude.put("", latitude);
        registerWeatherStationWithoutLatitude.put("longitude", longitude);
        registerWeatherStationWithoutLatitude.put("altitude", altitude);
        return registerWeatherStationWithoutLatitude;
    }

    public static JSONObject registerWeatherStationWithoutLongitude(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStationWithoutLongitude = new JSONObject();
        registerWeatherStationWithoutLongitude.put("external_id", external_id);
        registerWeatherStationWithoutLongitude.put("name", name);
        registerWeatherStationWithoutLongitude.put("latitude", latitude);
        registerWeatherStationWithoutLongitude.put("", longitude);
        registerWeatherStationWithoutLongitude.put("altitude", altitude);
        return registerWeatherStationWithoutLongitude;
    }

    public static JSONObject registerWeatherStationWithoutAltitude(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStationWithoutAltitude = new JSONObject();
        registerWeatherStationWithoutAltitude.put("external_id", external_id);
        registerWeatherStationWithoutAltitude.put("name", name);
        registerWeatherStationWithoutAltitude.put("latitude", latitude);
        registerWeatherStationWithoutAltitude.put("longitude", longitude);
        registerWeatherStationWithoutAltitude.put("", altitude);
        return registerWeatherStationWithoutAltitude;
    }

    public static JSONObject registerWeatherStationWithoutExternalIDPayload(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStationWithoutExternalID = new JSONObject();
        registerWeatherStationWithoutExternalID.put("", external_id);
        registerWeatherStationWithoutExternalID.put("name", name);
        registerWeatherStationWithoutExternalID.put("latitude", latitude);
        registerWeatherStationWithoutExternalID.put("longitude", longitude);
        registerWeatherStationWithoutExternalID.put("altitude", altitude);
        return registerWeatherStationWithoutExternalID;
    }

    public static JSONObject updateWeatherStationPayload(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject updateWeatherStation = new JSONObject();
        updateWeatherStation.put("external_id", external_id);
        updateWeatherStation.put("name", name);
        updateWeatherStation.put("latitude", latitude);
        updateWeatherStation.put("longitude", longitude);
        updateWeatherStation.put("altitude", altitude);
        return updateWeatherStation;
    }
}
