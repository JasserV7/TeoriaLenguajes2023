package com.example.teorialenguajes2023.configuracion;

public class Transacciones {

    //nombre de la base de datos

    public static final String NameDatabase= "TLENG";

    //Creaciòn de tabla y objetos

    public static final String tablapersona="personas";

    //campos de la tabla personas

    public static String id= "id";
    public static String nombres= "nombres";
    public static String apellidos= "apellidos";
    public static String edad= "edad";
    public static String correo= "correo";


    //Consultas de SQL para la manipulacion  de objetos

    public static String CreateTBPersonas= "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT)";


    public static  String DropTBPersonas= "DROP TABLE IF EXISTS personas";
}
