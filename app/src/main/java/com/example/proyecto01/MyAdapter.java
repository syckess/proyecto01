package com.example.proyecto01;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> etiquetas;
    private int Elemento;


    public MyAdapter(Context context, int layout, List<String> nombres) {
        this.context = context;
        this.layout = layout;
        this.etiquetas = nombres;
        Elemento = R.layout.grid_item;
    }

    @Override
    public int getCount() {
        return this.etiquetas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.etiquetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(Elemento,null);
           

        }else{

        }
        return convertView;

    }

    public void insertarEtiqueta () {
        Elemento = R.layout.grid_item;
        this.notifyDataSetChanged();
    }
    public void insertarImagen () {
        Elemento = R.layout.image_item;
        this.notifyDataSetChanged();
    }


}
