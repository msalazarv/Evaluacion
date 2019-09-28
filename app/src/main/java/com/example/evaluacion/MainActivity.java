package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnNuevo;
    Button btnListado;
    Button btnDatos;
    public static Integer contador=1;
    public static String msjEstudiante="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnListado = findViewById(R.id.btnListado);
        btnDatos = findViewById(R.id.btnDatos);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), EstudianteNuevo.class);
                startActivityForResult(i,0);
            }
        });
        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MuestraLista.class);
                startActivityForResult(i,0);
            }
        });
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MisDatos.class);
                startActivityForResult(i,0);
            }
        });
    }
    public void onActivityResult(int RequestCode, int ResultCode, Intent datos) {
        super.onActivityResult(RequestCode, ResultCode, datos);
        if (ResultCode == RESULT_OK){
            Toast.makeText(this,datos.getStringExtra(msjEstudiante),Toast.LENGTH_SHORT).show();
        }
    }
}
