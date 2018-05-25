package macbeth.weatherapp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class will create a WeatherData object using JSON data received from openweathermap.org
 *
 */
public class WeatherLoader {

    public static WeatherData loadData(String zip) {
        WeatherData weatherData;
        try {
            // Create a stream to the URL
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zip + ",us&appid=3cdb5f940155747817fa162765ae2a6b&units=imperial");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Read all data from the website into a single string
            String line = "";
            String allLines = "";
           do {
                line = reader.readLine();
                if (line != null) {
                    allLines += line;
                }
            }
            while (line != null);

            // Create the WeatherData object from the JSON data
            Gson gson = new Gson();
            weatherData = gson.fromJson(allLines, WeatherData.class);

            Thread.sleep(2000); // Added to demonstrate the AsyncTask better
                                      // Normally this is pointless thing to do.

            return weatherData;
        }
        catch (MalformedURLException murle) {
            System.out.println(murle.getMessage());
            return null;
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return null;
        }
        catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
            return null;
        }
    }


}
