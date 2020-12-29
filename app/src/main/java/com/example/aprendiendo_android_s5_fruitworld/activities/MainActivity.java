package com.example.aprendiendo_android_s5_fruitworld.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aprendiendo_android_s5_fruitworld.R;
import com.example.aprendiendo_android_s5_fruitworld.adapters.FruitAdapter;
import com.example.aprendiendo_android_s5_fruitworld.models.Fruta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewFrutas;
    private GridView gridViewFrutas;

    //Para obtener y hacer desaparecer los íconos
    private MenuItem iconoListView;
    private MenuItem iconoGridView;

    //Para manejo de vistas
    public static int LIST_VIEW = 0;
    public static int GRID_VIEW = 1;
    public int VISTA_ACTUAL = 8;

    private List<Fruta> listaDeFrutas;
    private int contadorDeFrutas;

    private FruitAdapter gridAdapter;
    private FruitAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        VISTA_ACTUAL = LIST_VIEW;

        listViewFrutas=findViewById(R.id.listViewFrutas);
        gridViewFrutas=findViewById(R.id.gridViewFrutas);

        registerForContextMenu(gridViewFrutas);
        registerForContextMenu(listViewFrutas);

        inicializandoFrutas();


    }

    private void inicializandoFrutas() {
        listaDeFrutas = new ArrayList<>();
        listaDeFrutas.add(new Fruta("Plátano", "Chile", R.mipmap.ic_platano));
        listaDeFrutas.add(new Fruta("Frutilla", "Chile", R.mipmap.ic_frutilla));
        listaDeFrutas.add(new Fruta("Naranja", "Chile", R.mipmap.ic_naranja));
        listaDeFrutas.add(new Fruta("Manzana", "Chile", R.mipmap.ic_manzana));
        listaDeFrutas.add(new Fruta("Cereza", "Chile", R.mipmap.ic_cereza));
        listaDeFrutas.add(new Fruta("Pera", "Chile", R.mipmap.ic_pera));
        listaDeFrutas.add(new Fruta("Frambuesa", "Chile", R.mipmap.ic_frambuesa));

        listAdapter = new FruitAdapter(MainActivity.this,R.layout.list_view_item_fruit,listaDeFrutas);
        gridAdapter = new FruitAdapter(MainActivity.this,R.layout.grid_view_item_fruit,listaDeFrutas);

        listViewFrutas.setAdapter(listAdapter);
        gridViewFrutas.setAdapter(gridAdapter);

        contadorDeFrutas = listaDeFrutas.size();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        //Obtenemos los íconos mostrados en el menu
        iconoListView = menu.findItem(R.id.list);
        iconoGridView = menu.findItem(R.id.grid);

        iconoListView.setVisible(false);

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(listaDeFrutas.get(info.position).getNombre());
        inflater.inflate(R.menu.context_menu_frutas,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        //Obtenemos info del que se le hizo click
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId() == R.id.eliminar_fruta){
            listaDeFrutas.remove(info.position);
            refrescarAdapters();
        }
        return super.onContextItemSelected(item);
    }

    private void refrescarAdapters() {
        listAdapter.notifyDataSetChanged();
        gridAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_fruit :{
                Toast.makeText(MainActivity.this, "Fruta añadida correctamente", Toast.LENGTH_SHORT).show();
                addFruta();
                break;
            }
            case R.id.list :{
                Toast.makeText(MainActivity.this, "Vista cambiada a ListView", Toast.LENGTH_SHORT).show();
                gridViewFrutas.setVisibility(View.INVISIBLE);
                listViewFrutas.setVisibility(View.VISIBLE);
                iconoGridView.setVisible(true);
                iconoListView.setVisible(false);
                VISTA_ACTUAL = LIST_VIEW;
                break;
            }
            case R.id.grid :{
                Toast.makeText(MainActivity.this, "Vista cambiada a GridView", Toast.LENGTH_SHORT).show();
                gridViewFrutas.setVisibility(View.VISIBLE);
                listViewFrutas.setVisibility(View.INVISIBLE);
                iconoGridView.setVisible(false);
                iconoListView.setVisible(true);
                VISTA_ACTUAL = GRID_VIEW;
                break;
            }
            default: break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void addFruta() {
        contadorDeFrutas++;
        listaDeFrutas.add(new Fruta("Fruta n°"+contadorDeFrutas,"Desconocido", R.mipmap.ic_launcher));
        refrescarAdapters();

    }
}