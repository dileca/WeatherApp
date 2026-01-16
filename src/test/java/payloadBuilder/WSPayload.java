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
