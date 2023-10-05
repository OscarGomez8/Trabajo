package com.example.trabajo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajo2.configuracion.SQLiteConexion;
import com.example.trabajo2.configuracion.Transacciones;

public class MainActivity extends AppCompatActivity
{
    EditText nombres, apellidos, edad, correo;
    Button btnprocesar, btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = findViewById(R.id.txtNombre);
        apellidos = findViewById(R.id.txtApellido);
        edad = findViewById(R.id.txtEdad);
        correo = findViewById(R.id.txtCorreo);

        btnprocesar = (Button) findViewById(R.id.btnProcesar);
        btnregresar = (Button) findViewById(R.id.btnRegresar);

        btnprocesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPerson();
            }
        });

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentregresar = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intentregresar);
            }
        });

    }

    private void AddPerson() {
        try{
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.namedb, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());

        Long Result = db.insert(Transacciones.Tabla, Transacciones.id, valores);
        Toast.makeText(this, getString(R.string.Respuesta), Toast.LENGTH_SHORT).show();

        db.close();
        }catch (Exception exception){
            Toast.makeText(this, getString(R.string.ErrorRespuesta), Toast.LENGTH_SHORT).show();
        }
    }


}