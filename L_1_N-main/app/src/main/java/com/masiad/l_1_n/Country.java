package com.masiad.l_1_n;

import android.net.Uri;

public class Country {

    public String name;
    public String capital;
    public int area;
    public double population;
    public String continent;
    public String flagPath;

    public Country(){}

    public Country(String name, String capital, int area, double population, String continent, int flag) {
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.population = population;
        this.continent = continent;
        this.flagPath = flagPath;
    }
}
