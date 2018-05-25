package macbeth.weatherapp;

/**
 * Weather data - wind component based on JSON:
 * https://openweathermap.org/current
 */
public class WeatherDataWind {
    private float speed;
    private float deg;

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }
}
