package com.example.trabajo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btncrear, btnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btncrear = (Button)findViewById(R.id.btnCrear);
        btnLista = (Button)findViewById(R.id.btnLista);

        /*Creacion de los Listener de los Botones*/

        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcrear = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentcrear);

            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLista = new Intent(getApplicationContext(),ActivityLista.class);
                startActivity(intentLista);
            }
        });
    }
}