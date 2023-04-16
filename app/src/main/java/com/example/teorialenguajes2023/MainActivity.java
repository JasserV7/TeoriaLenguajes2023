package com.example.teorialenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtnombre, txtapellido;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre= (EditText) findViewById(R.id.txtNombre);
        txtapellido= (EditText) findViewById(R.id.txtApellido);

        btnagregar= (Button) findViewById(R.id.btnMostrar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,txtnombre.getText()+" "+ txtapellido.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}