package com.masiad.l_2_n;

public class Country {

    public String name;
    public String capital;
    public int area;
    public double population;
    public String continent;
    public int flag;

    public Country(){}

    public Country(String n, String c, int a, double p, String co, int f){
        this.name = n;
        this.capital = c;
        this.area = a;
        this.population = p ;
        this.continent = co;
        this.flag = f;
    }
}
