package com.example.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import static com.example.evaluacion.MainActivity.contador;
import static com.example.evaluacion.MainActivity.msjEstudiante;

public class EstudianteNuevo extends AppCompatActivity {

    Button btnGuardar;
    Double Promedio;
    int correlativo;
    EditText txtNombre, txtCodigo, txtMateria, txtParcial1, txtParcial2, txtParcial3;
    public static List<ListaPlantilla> valores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante_nuevo);
        btnGuardar = findViewById(R.id.btnGuardar);
        txtNombre = findViewById(R.id.txtNombre);
        txtCodigo = findViewById(R.id.txtCodigo);
        txtMateria = findViewById(R.id.txtMateria);
        txtParcial1 = findViewById(R.id.txtParcial1);
        txtParcial2 = findViewById(R.id.txtParcial2);
        txtParcial3 = findViewById(R.id.txtParcial3);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNombre.length()>0 && txtCodigo.length()>0 && txtMateria.length()>0 && txtParcial1.length()>0
                        && txtParcial2.length()>0 && txtParcial3.length()>0) {
                    //Codigo
                    if (Double.parseDouble(txtParcial1.getText().toString())<0 || Double.parseDouble(txtParcial1.getText().toString())>10.00
                            || Double.parseDouble(txtParcial2.getText().toString())<0 || Double.parseDouble(txtParcial2.getText().toString())>10.00
                            || Double.parseDouble(txtParcial3.getText().toString())<0 || Double.parseDouble(txtParcial3.getText().toString())>10.00) {
                        ToastValidador2();
                    }else{
                        Procesar();
                    }
                }else{
                    ToastValidador();
                }
            }
        });
    }
    public void Procesar() {
        Double n1,n2,n3;
        n1= Double.parseDouble(txtParcial1.getText().toString()) * 0.30;
        n2= Double.parseDouble(txtParcial2.getText().toString()) * 0.30;
        n3= Double.parseDouble(txtParcial3.getText().toString()) * 0.40;
        Promedio = (n1+n2+n3);
        ListaPlantilla nuevo= new ListaPlantilla();
        nuevo.setNombre(txtNombre.getText().toString());
        nuevo.setCodigo(txtCodigo.getText().toString());
        nuevo.setMateria(txtMateria.getText().toString());
        nuevo.setParcial1(Double.parseDouble(txtParcial1.getText().toString()));
        nuevo.setParcial2(Double.parseDouble(txtParcial2.getText().toString()));
        nuevo.setParcial3(Double.parseDouble(txtParcial3.getText().toString()));
        nuevo.setPromedio(Promedio);
        nuevo.setCorrelativo(contador);
        contador = contador + 1;
        this.valores.add(nuevo);
        Intent enviar = new Intent();
        enviar.putExtra(msjEstudiante,"Estudiante se ingresó con éxito");
        setResult(RESULT_OK, enviar);
        finish();

    }
    public void ToastValidador(){
        Toast.makeText(this,"No se permiten campos vacios",Toast.LENGTH_SHORT).show();
    }
    public void ToastValidador2(){
        Toast.makeText(this,"Las notas deben de estar en el rango de 0 a 10.00",Toast.LENGTH_SHORT).show();
    }
}
