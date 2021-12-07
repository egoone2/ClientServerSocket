
import com.google.gson.*;
import com.google.gson.reflect.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WeatherApp {

    public static Map<String,Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }

    private String API_KEY = "cfadad3531acf77b0d96b63abb215c40";
    private final static String urlConfig = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final static String idConfig = "&appid=";
    private final static String unitsConfig = "&units=metric";

    public WeatherApp() {}



    public String getWeather(String location) {
        String urlString = urlConfig + location + idConfig + API_KEY + unitsConfig;
        String weather = "";

            try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null){
                result.append(line);
            }
            rd.close();


            Map<String, Object > respMap = jsonToMap (result.toString());
            Map<String, Object > mainMap = jsonToMap (respMap.get("main").toString());
            Map<String, Object > windMap = jsonToMap (respMap.get("wind").toString());

            weather += "Current Temperature: " + mainMap.get("temp") + "\n";
            weather += "Current Humidity: " + mainMap.get("humidity") + "\n";
            weather += "Wind Speed: " + windMap.get("speed")   + "\n";
            weather += "Wind Angle: " + windMap.get("deg") + "\n";

            }
            catch (IOException e) {
                e.printStackTrace();
                return weather;
            }

            return weather;


    }


    public String getAPI_KEY() {
        return API_KEY;
    }

    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }
}
