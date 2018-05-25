package macbeth.weatherapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * The AsyncTask will run "doInBackground" in a seperate thread.
 * The "onProgressUpdate" will run in the ui Task to show a progress bar.
 * The "onPostExecute" will run in the ui Task after doInBackground is done
 *
 * The AsyncTask has 3 template types: <Type1, Type2, Type3>
 *     Type1 - The data type for doInBackground parameter
 *     Type2 - The data type for onProgressUpdate parameter
 *     Type3 - The return type of doInBackground and the input type of
 *             onPostExecute
 *
 *  Void is used if the parameter is not used.
 */
public class WeatherLoaderTask extends AsyncTask<String, Void, String> {

    private WeakReference<Activity> activityRef;

    /**
     * The WeakReference is a reference to the Activity that will
     * not prevent garbage collection from deleting the original
     * Activity object in the possible case that the Activity is deleted
     * while this AsyncTask is still running.
     *
     * @param activity
     */
    public WeatherLoaderTask(Activity activity) {
        activityRef = new WeakReference<Activity>(activity);

    }
    /**
     * Get weather data using the WeatherLoader and the zip code
     *
     * @param strings - zip codes (variable list ... treat like an array)
     * @return weatherData
     */
    @Override
    protected String doInBackground(String... strings) {
        // Start the progress bar ... no inputs to onProgressUpdate
        publishProgress();

        // Get a WeatherData object for the zip code
        WeatherData weatherData = WeatherLoader.loadData(strings[0]);
        if (weatherData == null) {
            return "No Data";
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return weatherData.toString();
    }

    /**
     * Update the UI with progress status.
     * In this task, there is no value supplied for progress.  The
     * UI will just enable the progress bar.
     *
     * @param values - progress information
     */
    @Override
    protected void onProgressUpdate(Void... values) {
        // Start the progress bar
        if (activityRef.get() != null) {
            ProgressBar pb = activityRef.get().findViewById(R.id.progressBar);
            pb.setVisibility(ProgressBar.VISIBLE);
        }
    }

    /**
     * Update the UI after the background task is complete.
     * The weatherData field is populated with the text
     * received from doInBackground().
     *
     * @param result - weather data text
     */
    @Override
    protected void onPostExecute(String result) {
        if (activityRef.get() != null) {
            // Stop the progress bar
            ProgressBar pb = activityRef.get().findViewById(R.id.progressBar);
            pb.setVisibility(ProgressBar.INVISIBLE);

            // Display the weather data
            TextView tv = activityRef.get().findViewById(R.id.weatherData);
            tv.setText(result);
        }
    }
};