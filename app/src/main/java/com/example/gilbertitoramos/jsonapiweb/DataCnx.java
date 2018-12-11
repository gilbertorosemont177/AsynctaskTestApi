package com.example.gilbertitoramos.jsonapiweb;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataCnx {
    URL url;
    HttpURLConnection ccnx;
    String jsonStringResult;

    List<DataTableau> tableau;

    //data quon va obtenir apartir de notre objet json
    int id;
    String first_name,last_name,avatar;

    public DataCnx(String url){
    tableau= new ArrayList<DataTableau>();

        try {
            this.url = new URL(url);
            ccnx=(HttpURLConnection) this.url.openConnection();
            ccnx.connect();
            if(ccnx.getResponseCode()== HttpURLConnection.HTTP_OK){

                InputStream is= ccnx.getInputStream();
                BufferedReader bre= new BufferedReader(new InputStreamReader(is));
                String ligne="";

                while((jsonStringResult=bre.readLine())!=null){


                        ligne+=jsonStringResult;
                }

                JSONObject TransformerStringtojsonObject= new JSONObject(ligne);

                JSONArray responseJsonObjetArray=TransformerStringtojsonObject.getJSONArray("data");

                bre.close();

                for( int i=0; i<responseJsonObjetArray.length();i++){

                   // on va soustraire chaque objet qui se trouve dans l'arrayObjetJson
                   JSONObject jsonobjet= (JSONObject) responseJsonObjetArray.get(i);
                   // on cree un objet datatableau quon va ajouter a une liste tableau
                   DataTableau data=new DataTableau();
                   // attributs de lobjet tableau data
                   data.id=jsonobjet.getInt("id");
                   data.first_name=jsonobjet.getString("first_name");
                   data.last_name=jsonobjet.getString("last_name");
                   data.avatar=jsonobjet.getString("avatar");

                   // ajouter a la liste
                   tableau.add(data);
               }


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("++++++++++ DISCONNECT +++++++");
            ccnx.disconnect();


        }
    }

    public List<DataTableau> getliste(){
        return tableau;
    }

}
