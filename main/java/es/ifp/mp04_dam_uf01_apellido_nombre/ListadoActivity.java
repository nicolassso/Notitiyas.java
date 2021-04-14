package es.ifp.mp04_dam_uf01_apellido_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    protected ListView list1;
    private Intent pasarPantalla;
    protected DataBaseSQL db;
    private ArrayList<String> listaNotas = new ArrayList<String>();
    private ArrayAdapter<String> adaptador;
    private String contenidoItem = "";
    private String[] partes;
    private String[] titulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        db = new DataBaseSQL(this);

        list1 = (ListView) findViewById(R.id.listView_listado);

        listaNotas = db.getAllNotas();


        adaptador = new ArrayAdapter<>(ListadoActivity.this, android.R.layout.simple_list_item_1, listaNotas);
        list1.setAdapter(adaptador);


        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contenidoItem = parent.getItemAtPosition(position).toString();
                partes = contenidoItem.split(" - ");

                if (contenidoItem.equals("No hay notas")) {
                    pasarPantalla = new Intent(ListadoActivity.this, CrearNotaActivity.class);
                    finish();
                    startActivity(pasarPantalla);

                } else {
                    pasarPantalla = new Intent(ListadoActivity.this, VerNotasActivity.class);
                    pasarPantalla.putExtra("ID", partes[0]);
                    finish();
                    startActivity(pasarPantalla);
                }

            }
        });

        list1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                contenidoItem = parent.getItemAtPosition(position).toString();
                partes = contenidoItem.split(" - ");

                if (contenidoItem.equals("No hay notas")) {
                    Toast.makeText(ListadoActivity.this, "No existen notas", Toast.LENGTH_SHORT).show();

                } else {
                    pasarPantalla = new Intent(ListadoActivity.this, ActualizarActivity.class);
                    pasarPantalla.putExtra("ID", partes[0]);
                    finish();
                    startActivity(pasarPantalla);
                }

                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_crear_listado:
                pasarPantalla = new Intent(ListadoActivity.this, CrearNotaActivity.class);
                finish();
                startActivity(pasarPantalla);
                break;
            case R.id.item_opciones_listado:
                pasarPantalla = new Intent(ListadoActivity.this, BorrarNotaActivity.class);
                finish();
                startActivity(pasarPantalla);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}