package macbeth.weatherapp;

/**
 * Weather data - main component based on JSON:
 * https://openweathermap.org/current
 */
public class WeatherDataMain  {
    private float temp;
    private float humidity;
    private float pressure;

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
