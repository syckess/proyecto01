package com.example.proyecto01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class appActivity2 extends AppCompatActivity {
    private GridView gridView;
    private MyAdapter myAdapter;
    private List<String> etiquetas;
    private int Elementos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app2);

        etiquetas = new ArrayList<String>();

        gridView = findViewById(R.id.gridView);
        Elementos = R.layout.grid_item;

        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(appActivity2.this, "click en "+etiquetas.get(position), Toast.LENGTH_LONG).show();
            }
        });*/

        myAdapter = new MyAdapter(this, (Elementos), etiquetas);
        gridView.setAdapter(myAdapter);
        registerForContextMenu(gridView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_item:
                //se agrega nueva etiqueta
                this.etiquetas.add("");
                //notificar nueva etiqueta al adapter
                this.myAdapter.insertarEtiqueta();
                return true;
            case R.id.salir:
                finish();
            case R.id.add_image:
                this.etiquetas.add("");
                this.myAdapter.insertarImagen();
                return true;



            default:
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(this.etiquetas.get(info.position));
        inflater.inflate(R.menu.content_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.delete_item:
                //eliminar etiqueta clickeada
                this.etiquetas.remove(info.position);
                //notificar al adapter del cambio
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }


}