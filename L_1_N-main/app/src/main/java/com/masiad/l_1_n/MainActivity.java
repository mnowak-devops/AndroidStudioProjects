package com.masiad.l_1_n;

import android.content.Intent;
import android.content.res.Configuration;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// link do rest api wykorzystwanego na zajęciach 
//http://api.nbp.pl

public class MainActivity extends AppCompatActivity implements OnClickListener {

    MyRecycleViewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bSave = findViewById(R.id.bSave);
        RecyclerView myRecycleView = findViewById(R.id.myRecycleView);
        CountryDatabase countryDatabase = new CountryDatabase(this);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newCountry = new Intent(getApplicationContext(), NewCountryActivity.class);
                startActivity(newCountry);
//                String name = etName.getText().toString();
//                String lastName = etLastName.getText().toString();
//                tvPerson.setText(name + " " + lastName);
//                Toast.makeText(MainActivity.this, "Dodano nowy rekord", Toast.LENGTH_SHORT).show();
//                View parentView = findViewById(android.R.id.content);

                // doanie Snackbar do
                // aby dodać ten element należy w pliku app/grundle.build dodać rekord
                // implementation 'com.google.android.material:material:1.3.0-alpha01'

//                Snackbar snackbar = Snackbar.make(parentView, "tekst", Snackbar.LENGTH_SHORT);
//                snackbar.show();
            }
        });

        // zadanie
        // napisz metodę która doda osobę do listy i wyświeli ją na ekranie
//
//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
//                android.R.layout.simple_list_item_1, personList);
//        lvPerson.setAdapter(adapter);
       // CountryDatabase countryDatabase = new CountryDatabase(this);

//        countryDatabase.addCountry(new Country("Francja","Paryż",632734,67.39,
//                "Europa", R.drawable.flag_of_france));
//        countryDatabase.addCountry(new Country( "Niemcy","Berlin",357578,83.24,
//                "Europa", R.drawable.flag_of_germany));

        List<Country> countries = countryDatabase.getAllCountry();

        Executor extcutor = Executors.newFixedThreadPool(10);

        myAdapter = new MyRecycleViewAdapter(this, countries);
        myAdapter.setOnClick(this);
        myRecycleView.setLayoutManager(new GridLayoutManager(this, 2));
        myRecycleView.setAdapter(myAdapter);

        // fragment kodu dzięki któremu można stworzyć listę w widoku
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        // fragment kodu dzięki któremu można stworzyć kafelki w widoku
//        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
//            myRecycleView.setLayoutManager(new GridLayoutManager(this, 2));
//            myRecycleView.setAdapter(myAdapter);
//        }else{
//            myRecycleView.setLayoutManager(new GridLayoutManager(this, 3));
//            myRecycleView.setAdapter(myAdapter);
//        }
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getApplicationContext(),
                "Click " + myAdapter.getItem(position).name,
                Toast.LENGTH_LONG).show();
        Intent infoCountry = new Intent(this, CountryInfoActivity.class);
        infoCountry.getIntExtra("id", position);
        startActivity(infoCountry);
    }

    private Runnable myTask = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i<= 100; i++){


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

}