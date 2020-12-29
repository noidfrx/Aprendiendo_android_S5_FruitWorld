package com.example.aprendiendo_android_s5_fruitworld.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aprendiendo_android_s5_fruitworld.R;
import com.example.aprendiendo_android_s5_fruitworld.models.Fruta;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private int layout; //Para obtener el layout desde la instancia hecha
    private List<Fruta> listaDeFrutas;


    public FruitAdapter(Context context, int layout, List<Fruta> listaDeFrutas) {
        this.context = context;
        this.layout = layout;
        this.listaDeFrutas = listaDeFrutas;
    }

    @Override
    public int getCount() {
        return listaDeFrutas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDeFrutas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder = null;

        //Si el convertView está nulo se infla vista
        if(convertView == null){

            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();

            holder.tvNombreFruta = convertView.findViewById(R.id.nombreFruta);
            holder.tvOrigenFruta = convertView.findViewById(R.id.origenFruta);
            holder.ivImagenFruta = convertView.findViewById(R.id.iconoFruta);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }



        //Se obtienen datos de nuesta lista de frutas
        String nombreFrutaActual = listaDeFrutas.get(position).getNombre();
        String origenFrutaActual = listaDeFrutas.get(position).getOrigen();
        int imagenFrutaActual = listaDeFrutas.get(position).getIcono();

        //Se rellenan los campos asociados a los datos
        holder.tvNombreFruta.setText(nombreFrutaActual);
        holder.tvOrigenFruta.setText(origenFrutaActual);
        holder.ivImagenFruta.setImageResource(imagenFrutaActual);

        //Se retorna la vista inflada
        return convertView;
    }

    static class ViewHolder{
        private TextView tvNombreFruta, tvOrigenFruta;
        private ImageView ivImagenFruta;

    }


}
