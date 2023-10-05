package com.example.trabajo2.configuracion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConexion extends SQLiteOpenHelper
{

    public SQLiteConexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Crear los objetos de bd
        sqLiteDatabase.execSQL(Transacciones.CreateTablePersonas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //modificar o eliminar los objetos de bd
        sqLiteDatabase.execSQL(Transacciones.DropTablePersonas);
        onCreate(sqLiteDatabase);
    }
}
