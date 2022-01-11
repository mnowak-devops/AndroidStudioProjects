package com.masiad.l_1_n;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import org.richit.easiestsqllib.Column;
import org.richit.easiestsqllib.Datum;
import org.richit.easiestsqllib.EasiestDB;

import java.util.ArrayList;
import java.util.List;


public class CountryDatabase {

    private EasiestDB countryDB;

    public CountryDatabase(Context context){
        countryDB = EasiestDB.init(context)
                .addTableColumns("Country",
                        new Column("co_name", "text"),
                        new Column("co_capital", "text"),
                        new Column("co_area", "integer"),
                        new Column("co_population", "double"),
                        new Column("co_continent", "text"),
                        new Column("co_flag", "int"))
                .doneAddingTables();
    }

    public boolean addCountry(Country country){
        return countryDB.addDataInTable(0,
                new Datum(1, country.name),
                new Datum(2, country.capital),
                new Datum(3, country.area),
                new Datum(4, country.population),
                new Datum(5, country.continent),
                new Datum(6, country.flagPath));
    }

    public List<Country> getAllCountry(){
        List<Country> tempCountry = new ArrayList<>();
        Cursor cursor = countryDB.getAllDataFrom(0);
        if(cursor != null){
            while(cursor.moveToNext()){
                tempCountry.add(new Country(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getDouble(4),
                        cursor.getString(5),
                        cursor.getInt(6))
                );
            }
        }
        return tempCountry;
    }

    public Country getCountry(int id){
        Country tempCountry = new Country();
        Cursor cursor = countryDB.getOneRowData(0, id+1); // rowNumber starts from 1 but tableIndex starts from 0
        if (cursor != null) {
            cursor.moveToFirst();
            tempCountry.name = cursor.getString(1);
            tempCountry.capital = cursor.getString(2);
            tempCountry.area = cursor.getInt(3);
            tempCountry.population = cursor.getDouble(4);
            tempCountry.continent = cursor.getString(5);
            tempCountry.flagPath = cursor.getString(6);
        }
        return tempCountry;
    }
}
