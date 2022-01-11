package com.masiad.l_1_n;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
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
        EditText countryPopulation = findViewById((R.id.eTCountryPopulation);
        EditText
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
                String cName = countryName.getText().toString();
                String CCapital = countryCapital.getText().toString();
                int CArea;
                if (countryArea.getTekst().toString().isEmpty()){
                    cArea = 0;}
                else{
                    cArea = Integer.parseInt(countryArea.getText().toString());
                }
                double cPopulation = 0.0;
                if(!countryPopulation.getText().toString().isEmpty()){
                    cPopulation = Double.parseDouble((countryPopulation.getText().toString()));
                }
                String cContinetn = countryCon
                // dowolny warunek jeżeli jest wymagany
                finish();
            }
        });
    }
    private void openGallery(){
        Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentGallery, PICK_CODE);;

    }

    @Override
    protected  void onActivityReult(int requestCode, int resultCode, @Nullable Intent dafa){
        super.onActivityResult(requestCode,resultCode,dafa);
        if (requestCode == RESULT_OK && requestCode == PICK_CODE){
            uriImg = data.GetData();
            Toast.makeText(context this, text: ""+ uriImg.getPatch(), Toast.LENGTH_LONG);
            countryFlag.setImageURI9uriImg);
        }
    }

}