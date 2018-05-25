package macbeth.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Show Weather Activity
 * Display the current weather for the zip code provided.
 */
public class ShowWeatherActivity extends Activity {

    public static final String EXTRA_ZIP = "macbeth.weatherapp.extra_zip";
    private WeatherLoader weatherLoader;

    /**
     * Display Activity Layout
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weather);

        // Get the zip code from the Intent
        Intent intent = getIntent();
        String zip = intent.getStringExtra(EXTRA_ZIP);
        ((TextView) findViewById(R.id.requestedZip)).setText("Weather for " + zip);

        // Get weather data in the background
        //weatherLoaderTask(zip);
        WeatherLoaderTask task = new WeatherLoaderTask(this);
        task.execute(zip);
    }

    private void weatherLoaderTask(String zip) {
        // Start the progress bar
        ProgressBar pb = findViewById(R.id.progressBar);
        pb.setVisibility(ProgressBar.INVISIBLE);

        // Get a WeatherData object for the zip code
        WeatherData weatherData = WeatherLoader.loadData(zip);

        // Stop the progress bar
        pb.setVisibility(ProgressBar.INVISIBLE);

        // Display the weather data
        TextView tv = findViewById(R.id.weatherData);
        if (weatherData == null) {
            tv.setText("No Data");
        }
        else {
            tv.setText(weatherData.toString());
        }

    }



}
