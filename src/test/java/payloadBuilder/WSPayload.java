package payloadBuilder;

import org.json.simple.JSONObject;

public class WSPayload {

    public static JSONObject registerWeatherStationPayload(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStation = new JSONObject();
        registerWeatherStation.put("external_id", external_id);
        registerWeatherStation.put("name", name);
        if (latitude != null) {
            registerWeatherStation.put("latitude", latitude);
        }
        if (longitude != null) {
            registerWeatherStation.put("longitude", longitude);
        }
        if (altitude != null) {
            registerWeatherStation.put("altitude", altitude);
        }
        return registerWeatherStation;
    }

    public static JSONObject updateWeatherStationPayload(String name, String external_id, Integer latitude, Integer longitude, Integer altitude) {
        JSONObject updateWeatherStation = new JSONObject();
        updateWeatherStation.put("external_id", external_id);
        updateWeatherStation.put("name", name);
        if (latitude != null) {
            updateWeatherStation.put("latitude", latitude);
        }
        if (longitude != null) {
            updateWeatherStation.put("longitude", longitude);
        }
        if (altitude != null) {
            updateWeatherStation.put("altitude", altitude);
        }
        return updateWeatherStation;
    }

    public static JSONObject registerWeatherStationPayloadWithStringLatitude(String name, String external_id, String latitude, Integer longitude, Integer altitude) {
        JSONObject registerWeatherStation = new JSONObject();
        registerWeatherStation.put("external_id", external_id);
        registerWeatherStation.put("name", name);
        if (latitude != null && !latitude.isEmpty()) {
            registerWeatherStation.put("latitude", latitude);
        } else if (latitude != null) {
            // Include the field with empty string value to test bad request
            registerWeatherStation.put("latitude", latitude);
        }
        if (longitude != null) {
            registerWeatherStation.put("longitude", longitude);
        }
        if (altitude != null) {
            registerWeatherStation.put("altitude", altitude);
        }
        return registerWeatherStation;
    }

}
