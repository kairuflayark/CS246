package macbeth.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Prompt Activity
 * The screen will prompt the user for a zip code.
 * The zip code will be sent to the Show Weather Activity
 */
public class PromptActivity extends Activity {

    /**
     * Display the Activity Layout
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);
    }

    /**
     * In response to the user pressing the button, an Intent to transition
     * to the Show Weather Activity is created.
     * @param view
     */
    public void getWeather(View view) {
        // Create Intent and populate with zip
        Intent intent = new Intent(this, ShowWeatherActivity.class);
        EditText editText = (EditText) findViewById(R.id.submittedZip);
        intent.putExtra(ShowWeatherActivity.EXTRA_ZIP, editText.getText().toString());

        // Transition to Show Weather Activity
        startActivity(intent);
    }
}
