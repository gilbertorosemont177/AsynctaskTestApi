package com.example.gilbertitoramos.jsonapiweb;

public class DataTableau {

    public int id;
    public String first_name;
    public String last_name;
    public String avatar;

    // objt vide afin davoir acces aux attributs
    DataTableau(){}



    @Override
    public String toString() {
        return "id="+id+" firstname="+first_name+" last_name"+last_name+" avatar="+avatar;
    }
}
