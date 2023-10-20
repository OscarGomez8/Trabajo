package com.example.trabajo2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.trabajo2.Models.Personas;
import com.example.trabajo2.configuracion.SQLiteConexion;
import com.example.trabajo2.configuracion.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class ActivityLista extends AppCompatActivity {


    SQLiteConexion conexion;
    ListView listView;
    ArrayList<Personas> listPersonas;
    ArrayList<String> ArregloPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        try{
//establecemos conexion a la base de datos
            conexion = new SQLiteConexion(this, Transacciones.namedb, null,1);
            listView = (ListView) findViewById(R.id.listapersonas);

            GetPersons();
            ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas);
            listView.setAdapter(adp);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String ItemPersonas = listPersonas.get(i).getNombres();
                    Toast.makeText(ActivityLista.this, "Nombre" + ItemPersonas, Toast.LENGTH_LONG).show();
                }
            });



        }catch(Exception ex){
            ex.toString();
        }

    }

    private void GetPersons() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas personas = null;
        listPersonas = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectTablePersonas, null);
        while (cursor.moveToNext()){
            personas = new Personas();
            personas.setId(cursor.getInt(0));
            personas.setNombres(cursor.getString(1));
            personas.setApellidos(cursor.getString(2));
            personas.setEdad(cursor.getInt(3));
            personas.setCorreo(cursor.getString(4));

            listPersonas.add(personas);
        }

        cursor.close();
        FillList();
    }

    private void FillList() {
        ArregloPersonas = new ArrayList<String>();
        for(int i = 0; i < listPersonas.size(); i++){

            ArregloPersonas.add(listPersonas.get(i).getId() + " - " +
                    listPersonas.get(i).getNombres() + " - " +
                    listPersonas.get(i).getApellidos() );


        }
    }


}