package com.example.gilbertitoramos.jsonapiweb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class AdapTerJsonResponse extends ArrayAdapter {

    Context context;
    List<DataTableau> list;
    TextView firstname,Lastname;
    ImageView imgurl;


    public AdapTerJsonResponse(Context context, List<DataTableau> liste) {

        super(context,0, liste);

        this.context = context;
        list=liste;

    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view =  inflater.inflate(R.layout.rowdata ,parent,false);


        firstname = (TextView) view.findViewById(R.id.firstname);
        Lastname= (TextView) view.findViewById(R.id.last_name);
        imgurl =(ImageView)view.findViewById(R.id.imgurl);
        firstname.setText(list.get(position).first_name);
        Lastname.setText (list.get(position).last_name);
        //Add image avec Picasso --> il faut ajouter depencies picasso --file/projectstructure
        Picasso.get().load(list.get(position).avatar).into(imgurl);
       return view;
    }
}
