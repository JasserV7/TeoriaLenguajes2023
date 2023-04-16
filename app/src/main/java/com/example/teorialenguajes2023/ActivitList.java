package com.example.teorialenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.teorialenguajes2023.configuracion.SQLiteConexion;
import com.example.teorialenguajes2023.configuracion.Transacciones;
import com.example.teorialenguajes2023.tablas.Personas;

import java.util.ArrayList;

public class ActivitList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listapersona;
    ArrayList<Personas> Lista;
    ArrayList<String> ArregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activit_list);

        conexion= new SQLiteConexion(this,Transacciones.NameDatabase,null, 1);
        listapersona= (ListView) findViewById(R.id.Listapersonas);
        ObtenerListaPersonas();


        ArrayAdapter adp= new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas);
        listapersona.setAdapter(adp);


        listapersona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), Lista.get(i).getCorreo().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void ObtenerListaPersonas() {
        SQLiteDatabase db= conexion.getReadableDatabase();
        Personas person= null;
        Lista = new ArrayList<Personas>();


        Cursor cursor= db.rawQuery("SELECT * FROM "+ Transacciones.tablapersona, null);

        while(cursor.moveToNext())
        {
            person= new Personas();
            person.setId(cursor.getInt( 0 ));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));


            Lista.add(person);
        }

        cursor.close();
        
        
        Filllist();

    }

    private void Filllist()
    {
        ArregloPersonas= new ArrayList<String>();

        for(int i =0; i< Lista.size(); i++)
        {
            ArregloPersonas.add(Lista.get(i).getId() + " / " +
                                 Lista.get(i).getNombres()+ " / " +
                                 Lista.get(i).getApellidos() + " /" );

        }


    }
}