package com.example.trabajo2.configuracion;

public class Transacciones {

    //Nombre de la base de datos

    public static final String namedb = "PMO12023";

    //Tablas de la base de datos
    public static final String Tabla = "personas";

    //Campos de la tabla

    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";


    //Consultas de Base de Datos
    //ddl
    public static final String CreateTablePersonas = "CREATE TABLE personas "+
     "( id INTEGER PRIMARY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edad INTEGER, " +
     "correo TEXT)";

    public static final String DropTablePersonas = "DROP TABLE IF EXISTS personas";


    //dml
    public static final String SelectTablePersonas = "SELECT * FROM " + Transacciones.Tabla;

}
