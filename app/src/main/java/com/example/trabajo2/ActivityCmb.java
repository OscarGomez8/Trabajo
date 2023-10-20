package com.example.trabajo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.trabajo2.configuracion.SQLiteConexion;
import com.example.trabajo2.configuracion.Transacciones;

public class ActivityCmb extends AppCompatActivity {

    SQLiteConexion conexion;
    Spinner combopersonas;

    EditText nombres, apellidos, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmb);

        conexion = new SQLiteConexion(this, Transacciones.namedb, null, 1);
        combopersonas = (Spinner) findViewById(R.id.spinner);
        nombres = (EditText) findViewById(R.id.cbNombre);
        apellidos = (EditText) findViewById(R.id.cbApellido);
        correo =  (EditText) findViewById(R.id.cbCorreo);

       // GetPersoas();
    }



}