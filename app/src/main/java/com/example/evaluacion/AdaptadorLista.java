package com.example.evaluacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorLista extends BaseAdapter {

    private List<ListaPlantilla> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;

    public List<ListaPlantilla> GetData(){return this.datasource;}

    public AdaptadorLista(Context context, int IdPlantilla, List<ListaPlantilla> sources){
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
    }

    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public ListaPlantilla getItem(int i) {
        return this.datasource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            TextView labelNombre = convertView.findViewById(R.id.lblNombre);
            TextView labelCodigo = convertView.findViewById(R.id.lblCodigo);
            TextView labelMateria = convertView.findViewById(R.id.lblMateria);
            TextView labelNumero = convertView.findViewById(R.id.lblNumero);
            TextView labelPromedio = convertView.findViewById(R.id.lblPromedio);

            labelNombre.setText(this.datasource.get(i).getNombre());
            labelCodigo.setText(this.datasource.get(i).getCodigo());
            labelMateria.setText(this.datasource.get(i).getMateria());
            labelPromedio.setText(this.datasource.get(i).getPromedio().toString());
            labelNumero.setText(this.datasource.get(i).getCorrelativo().toString());

        }


        return convertView;
    }
}
