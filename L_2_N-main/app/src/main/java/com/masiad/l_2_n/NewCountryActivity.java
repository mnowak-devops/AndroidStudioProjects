package com.masiad.l_2_n;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class NewCountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_country);

        EditText countryName = findViewById(R.id.eTCountryName);
        EditText countryCapital = findViewById(R.id.eTCountryCapital);
        EditText countryArea = findViewById(R.id.eTCountryArea);

        String name = countryName.getText().toString();
        int area;
        if (countryArea.getText().toString().isEmpty()){
            area = 0;
        }else{
            area = Integer.parseInt(countryArea.getText().toString());
        }


        Button saveCountry = findViewById(R.id.bSaveCountry);

        saveCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dowolny warunek jeżeli jest wymagany
                finish();
            }
        });

    }
}