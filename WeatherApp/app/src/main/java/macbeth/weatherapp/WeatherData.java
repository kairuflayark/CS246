package macbeth.weatherapp;

import java.util.Date;

/**
 * Weather data based on JSON:
 * https://openweathermap.org/current
 */
public class WeatherData {
    private String name;
    private WeatherDataMain main;
    private WeatherDataWind wind;
    private Long dt;

    public String getName() {
        return name;
    }

    public WeatherDataMain getMain() {
        return main;
    }

    public WeatherDataWind getWind() {
        return wind;
    }

    public Long getDt() {
        return dt;
    }

    /**
     * Format the Weather Data into a single string.
     *
     * @return
     */
    public String toString() {
        String text = "Location: " + name + "\n";
        text += "Observation: " + new Date(dt*1000).toString() + "\n";
        text += "Temp: " + main.getTemp() + " Deg F\n";
        text += "Humidity: " + main.getHumidity() + "%\n";
        text += "Pressure: " + main.getPressure() + " hPa\n";
        text += "Wind: " + wind.getSpeed() + " mph (" + wind.getDeg() + " deg)\n";
        return text;
    }
}
