package com.masiad.l_2_n;

import android.content.Context;
import android.database.Cursor;
import org.richit.easiestsqllib.Column;
import org.richit.easiestsqllib.Datum;
import org.richit.easiestsqllib.EasiestDB;

import java.util.ArrayList;
import java.util.List;

public class ConutryDatabase {

    private EasiestDB countryDatabase;

    public void init(Context context){
        countryDatabase = EasiestDB.init(context)
                .addTableColumns("Country",
                        new Column("country_name", "text"),
                        new Column("country_capital", "text"),
                        new Column("country_area", "integer"),
                        new Column("country_population", "double"),
                        new Column("country_continent", "text"),
                        new Column("country_flag", "integer"))
                .doneAddingTables();
    }

    public boolean addCountry(Country country){
        return countryDatabase.addDataInTable(0,
                new Datum(1, country.name),
                new Datum(2, country.capital),
                new Datum(3,country.area),
                new Datum(4, country.population),
                new Datum(5, country.continent),
                new Datum(6, country.flag));
    }

    public List<Country> getAllCountry(){
        List<Country> tempCountry = new ArrayList<>();
        Cursor cursor = countryDatabase.getAllDataFrom("Country");
        if(cursor != null){
            while (cursor.moveToNext()){
                tempCountry.add(new Country(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getDouble(4),
                        cursor.getString(5),
                        cursor.getInt(6)
                ));
            }
        }
        return tempCountry;
    }

    public Country getCountry(int id){
        Country tempCountry = new Country();
        Cursor cursor = countryDatabase.getOneRowData(0, id+1); // rowNumber starts from 1 but tableIndex starts from 0
        if (cursor != null) {
            cursor.moveToFirst();
            tempCountry.name = cursor.getString(1);
            tempCountry.capital = cursor.getString(2);
            tempCountry.area = cursor.getInt(3);
            tempCountry.population = cursor.getDouble(4);
            tempCountry.continent = cursor.getString(5);
            tempCountry.flag = cursor.getInt(6);
        }
        return tempCountry;
    }

}
