package com.masiad.l_1_n;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CountryInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);

        int id = getIntent().getIntExtra("id", -1);

        ImageView countryFlag = findViewById(R.id.country_flag);
        TextView countryName = findViewById(R.id.country_name);
        TextView countryCapital = findViewById(R.id.country_capital);
        TextView countryArea = findViewById(R.id.country_area);
        TextView countryPopulation = findViewById(R.id.country_population);
        TextView countryContinent = findViewById(R.id.country_continent);
        Button prevButton = findViewById(R.id.prevButton);


        Country country = MainActivity.countryDatabase.getCountry(id);

        countryFlag.setImageURI(Uri.parse(country.flagPath));
        countryName.setText(getResources().getString(R.string.c_name) + country.name);
        countryCapital.setText(getString(R.string.c_capital) + country.capital);


        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}