package org.shikato.androidtestsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int result = intent.getIntExtra("result", -1);

        TextView resultView = (TextView)findViewById(R.id.result);
        resultView.setText(Integer.toString(result));
    }
}
