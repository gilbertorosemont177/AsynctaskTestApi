package com.example.gilbertitoramos.jsonapiweb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String urlapi="https://reqres.in/api/users?page=2&fbclid=IwAR2607N7jZyIkUQkRsMbEewkHmTBT3XnFUZYqrDTuSpUmQGZat9aUWnsgm0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView  = (ListView) findViewById(R.id.listview);

        new Api().execute(urlapi);
    }


    private class Api extends AsyncTask<String,String,DataCnx>{


        @Override
        protected DataCnx doInBackground(String... strings) {

            DataCnx d= new DataCnx(strings[0]);


            return d;
        }


        @Override
        protected void onPostExecute(DataCnx dataCnx) {
            super.onPostExecute(dataCnx);

            // Adapter pour la listView
            listView.setAdapter(new AdapTerJsonResponse(getApplicationContext(), dataCnx.getliste()));
        }
    }




}
