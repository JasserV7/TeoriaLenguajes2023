package com.example.teorialenguajes2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teorialenguajes2023.configuracion.SQLiteConexion;
import com.example.teorialenguajes2023.configuracion.Transacciones;

public class ActivityIngresar extends AppCompatActivity {
    EditText codigo, nombres, apellidos, edad, correo;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        try{

            codigo= (EditText) findViewById(R.id.txtCodigo);
            nombres= (EditText) findViewById(R.id.txtnombres);
            apellidos= (EditText) findViewById(R.id.txtapellidos);
            edad= (EditText) findViewById(R.id.txtedad);
            correo= (EditText) findViewById(R.id.txtcorreo);
            btnAgregar= (Button) findViewById(R.id.btnIngre);

            btnAgregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AgregarPersonas();
                }
            });

        }catch (Exception ex){
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();

        }


    }

    private void AgregarPersonas() {

       try{
           SQLiteConexion conexion= new SQLiteConexion(this, Transacciones.NameDatabase,null,1);

           SQLiteDatabase db= conexion.getWritableDatabase();

           ContentValues valores = new ContentValues();
           valores.put(Transacciones.nombres, nombres.getText().toString());
           valores.put(Transacciones.apellidos, apellidos.getText().toString());
           valores.put(Transacciones.edad, edad.getText().toString());
           valores.put(Transacciones.correo, correo.getText().toString());

           Long resultado= db.insert(Transacciones.tablapersona, Transacciones.id, valores);

           Toast.makeText(this, "Registro ingresado con exito", Toast.LENGTH_SHORT).show();

           CleanPantalla();
       }catch (Exception ex)
       {
           ex.toString();
       }
    }

    private void CleanPantalla() {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
    }
}