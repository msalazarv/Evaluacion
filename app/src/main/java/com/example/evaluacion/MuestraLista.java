package com.example.evaluacion;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.evaluacion.EstudianteNuevo.valores;

public class MuestraLista extends AppCompatActivity {
    private ListView valoresLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_lista);
        valoresLista = findViewById(R.id.listValores);
        this.valoresLista.setAdapter(new AdaptadorLista(this,R.layout.activity_lista_estudiante, valores));
    }
}
