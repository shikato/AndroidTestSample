package org.shikato.androidtestsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TopActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        final EditText num1Edit = (EditText)findViewById(R.id.num1);
        final EditText num2Edit = (EditText)findViewById(R.id.num2);

        Button equalBtn = (Button)findViewById(R.id.equal_button);
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int result = Calc.add(num1Edit.getText().toString(), num2Edit.getText().toString());

                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("result", result);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    // サンプルアプリなので何もしない
                }
            }
        });
    }
}
