package com.example.labdmguia03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button Agregar, verLista, misDatos;
    public static String mensaje="vacio";
    public static ArrayList<String> valores = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Agregar = findViewById(R.id.btnAgregar);
        verLista = findViewById(R.id.btnVerLista);
        misDatos = findViewById(R.id.btnMisDatos);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), com.example.labdmguia03.Agregar.class);
                startActivityForResult(i,0);
            }
        });
        verLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), VerListado.class);
                startActivity(i);;
            }
        });
        misDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MisDatos.class );
                startActivity(i);
            }
        });
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent datos) {
        super.onActivityResult(RequestCode, ResultCode, datos);
        if (ResultCode == RESULT_OK){
            valores.add(datos.getStringExtra(mensaje));
            mostrartoast(1);}
    }

    public void mostrartoast(int v){
        if (v==1) {
            Toast.makeText(this, "Nombre guardado correctamente", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Ocurrio un problema", Toast.LENGTH_SHORT).show();
        }
    }
}
