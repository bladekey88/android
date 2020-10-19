package com.example.cricketchirp;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    TextView tvResults;
    Button btnSubmit;
    String temperatureMessage;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        tvResults = findViewById(R.id.tvResults);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (!etChirps.getText().toString().isEmpty()) {

                    int numChirps = Integer.parseInt(etChirps.getText().toString().trim());
                    if (numChirps > 0 && numChirps <= 150) {
                        double temperature = (numChirps / 3.0) + 4;
                        temperatureMessage = getString(R.string.approxTemp) + formatter.format(temperature) + getString(R.string.celsius);
                        tvResults.setTextColor(Color.BLACK);
                    } else {
                        temperatureMessage = getString(R.string.chirpGreaterThanZero);
                        tvResults.setTextColor(Color.RED);
                    }

                    tvResults.setText(temperatureMessage);
                    tvResults.setVisibility(View.VISIBLE);

                } else
                {Toast.makeText(MainActivity.this, "Please enter the number of chirps", Toast.LENGTH_SHORT).show();}
            }
        });

    }
}