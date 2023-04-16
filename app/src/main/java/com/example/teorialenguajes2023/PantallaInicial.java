package com.example.teorialenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaInicial extends AppCompatActivity {

    Button btnadd, btnlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);


        btnadd= (Button) findViewById(R.id.btnadd);
        btnlist= (Button) findViewById(R.id.btnlist);

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pagina = new Intent(getApplicationContext(), ActivitList.class);
                startActivity(pagina);

            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pagina2= new Intent(getApplicationContext(), ActivityIngresar.class);
                startActivity(pagina2);

            }
        });
    }
}