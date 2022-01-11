package com.masiad.l_2_n;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.neeloy.lib.data.storage.StorageUtility;

import java.util.ArrayList;
import java.util.List;

// link do rest api wykorzystwanego na zajęciach 
//http://api.nbp.pl


public class MainActivity extends AppCompatActivity implements ItemClick{

    MyRecycleViewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final EditText etName = findViewById(R.id.etPersonName);
//        final EditText etLastName = findViewById(R.id.etPersonLastName);
//        final TextView tvPerson = findViewById(R.id.textView);
//        ListView lvPerson = findViewById(R.id.lvPersonList);

        Button bSave = findViewById(R.id.bSave);
        RecyclerView myRecyclerView = findViewById(R.id.myRecycleView);

        Country country = new Country("Rosja","Moskwa",17130000,147.1,
                "Europa - Azja", R.drawable.flag_of_russia );

        StorageUtility.initLibrary(this);
//        StorageUtility.setObject("country", country);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Country tC = StorageUtility.getObject("country", Country.class);
                Toast.makeText(MainActivity.this, tC.name, Toast.LENGTH_SHORT).show();
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

        ConutryDatabase cDatabase = new ConutryDatabase();
        cDatabase.init(this);


//        cDatabase.addCountry(new Country("Polska","Warszawa",312697,37.95,
//                "Europa", R.drawable.flag_of_poland));
//        cDatabase.addCountry(new Country("Niemcy","Berlin",357578,83.24,
//                "Europa", R.drawable.flag_of_germany ));
//        cDatabase.addCountry(new Country("Tanzania","Dodoma",947300,59.73,
//                "Afryka", R.drawable.flag_of_tanzania ));

        List<Country> countries = cDatabase.getAllCountry();
//        countries.add(new Country("Polska","Warszawa",312697,37.95,
//                "Europa", R.drawable.flag_of_poland));
//        countries.add(new Country("Niemcy","Berlin",357578,83.24,
//                "Europa", R.drawable.flag_of_germany ));
//        countries.add(new Country("Rosja","Moskwa",17130000,147.1,
//                "Europa - Azja", R.drawable.flag_of_russia ));
//        countries.add(new Country("Belize","Belmopan",22966,0.4,
//                "Ameryka Południowa", R.drawable.flag_of_belize));
//        countries.add(new Country("Tanzania","Dodoma",947300,59.73,
//                "Afryka", R.drawable.flag_of_tanzania ));



        myAdapter = new MyRecycleViewAdapter(getApplicationContext(), countries);
        myAdapter.setClickListiner(this);
        // fragment kodu odpowiadającego za generowanie kafelek na ekranie
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            myRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }else{
            myRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }


        // fragment kodu odpowiadającego za generowanie listy na ekranie
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(myAdapter);


        // zadanie
        // napisz metodę która doda osobę do listy i wyświeli ją na ekranie

//        List<String> personList = new ArrayList<>();
//        personList.add("Tomasz Nowak");
//        personList.add("Ewa Nowak");
//        personList.add("Paweł Kowalski");
//
//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
//                android.R.layout.simple_list_item_1, personList);
//        lvPerson.setAdapter(adapter);

    }

    @Override
    public void onItemClickListener(View view, int position) {
        Toast.makeText(getApplicationContext(),
                "Clik " + myAdapter.getItem(position).name,
                Toast.LENGTH_LONG).show();
        Intent nextIntent = new Intent(this, CountryInfoActivity.class);
        nextIntent.putExtra("id", position);
        startActivity(nextIntent);

    }
}