package es.ifp.mp04_dam_uf01_apellido_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ActualizarActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected TextView label3;
    protected TextView label4;
    protected TextView label5;
    protected EditText box1;
    protected EditText box2;
    protected EditText box3;
    protected EditText box4;
    protected EditText box5;
    protected Button button1;
    protected Button button2;

    private DataBaseSQL db;
    private Intent pasarPantalla;
    private String contenidoBox1;
    private String contenidoBox2;
    private String contenidoBox3;
    private String contenidoBox4;
    private String contenidoBox5;

    private Bundle extras;
    private String paquete1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_actualizar);
        label2 = (TextView) findViewById(R.id.label2_actualizar);
        label3 = (TextView) findViewById(R.id.label3_actualizar);
        label4 = (TextView) findViewById(R.id.label4_actualizar);
        label5 = (TextView) findViewById(R.id.label5_actualizar);
        box1 = (EditText) findViewById(R.id.box1_actualizar);
        box2 = (EditText) findViewById(R.id.box2_actualizar);
        box3 = (EditText) findViewById(R.id.box3_actualizar);
        box4 = (EditText) findViewById(R.id.box4_actualizar);
        box5 = (EditText) findViewById(R.id.box5_actualizar);
        button1 = (Button) findViewById(R.id.button1_actualizar);
        button2 = (Button) findViewById(R.id.button2_actualizar);

        //rellenar boxes con los datos de la db

        extras = getIntent().getExtras();
        if (extras != null) {

            paquete1 = extras.getString("ID");
            Note n = db.getOneNota(Integer.parseInt(paquete1));
            box1.append(n.getTitulo());
            box2.append(n.getTelefono());
            box3.append(n.getLugar());
            box4.append(n.getCliente());
            box5.append(n.getURL());

        }

        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasarPantalla = new Intent(ActualizarActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contenidoBox1 = box1.getText().toString();
                contenidoBox2 = box2.getText().toString();
                contenidoBox3 = box3.getText().toString();
                contenidoBox4 = box4.getText().toString();
                contenidoBox5 = box5.getText().toString();

                if (contenidoBox1.equals("")) {
                    Toast.makeText(ActualizarActivity.this, "Título obligatorio", Toast.LENGTH_SHORT).show();
                } else {

                    if(numeric(contenidoBox2)||contenidoBox2.equals("")) {
                        //datos a la bbdd

                        db.updateNota(Integer.parseInt(paquete1), contenidoBox1, contenidoBox2, contenidoBox3, contenidoBox4, contenidoBox5);

                        box1.setText("Guardando...");
                        box2.setText("Guardando...");
                        box3.setText("Guardando...");
                        box4.setText("Guardando...");
                        box5.setText("Guardando...");

                        Toast.makeText(ActualizarActivity.this, "Nota actualizada correctamente", Toast.LENGTH_SHORT).show();

                        TimerTask myTimerTask = new TimerTask() {

                            @Override
                            public void run() {

                                Intent pasarPantalla = new Intent(ActualizarActivity.this, ListadoActivity.class);
                                finish();
                                startActivity(pasarPantalla);
                            }

                        };
                        Timer timer = new Timer();
                        timer.schedule(myTimerTask, 1000);
                    }else{
                        Toast.makeText(ActualizarActivity.this, "El teléfono debe ser numérico", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });*/

    }

    public Boolean numeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actualizar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1_actualizar:
                pasarPantalla = new Intent(ActualizarActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
                break;
            case R.id.item2_actualizar:
                contenidoBox1 = box1.getText().toString();
                contenidoBox2 = box2.getText().toString();
                contenidoBox3 = box3.getText().toString();
                contenidoBox4 = box4.getText().toString();
                contenidoBox5 = box5.getText().toString();

                if (contenidoBox1.equals("")) {
                    Toast.makeText(ActualizarActivity.this, "Título obligatorio", Toast.LENGTH_SHORT).show();
                } else {

                    if(numeric(contenidoBox2)||contenidoBox2.equals("")) {
                        //datos a la bbdd

                        db.updateNota(Integer.parseInt(paquete1), contenidoBox1, contenidoBox2, contenidoBox3, contenidoBox4, contenidoBox5);

                        box1.setText("Guardando...");
                        box2.setText("Guardando...");
                        box3.setText("Guardando...");
                        box4.setText("Guardando...");
                        box5.setText("Guardando...");

                        Toast.makeText(ActualizarActivity.this, "Nota actualizada correctamente", Toast.LENGTH_SHORT).show();

                        TimerTask myTimerTask = new TimerTask() {

                            @Override
                            public void run() {

                                Intent pasarPantalla = new Intent(ActualizarActivity.this, ListadoActivity.class);
                                finish();
                                startActivity(pasarPantalla);
                            }

                        };
                        Timer timer = new Timer();
                        timer.schedule(myTimerTask, 1000);
                    }else{
                        Toast.makeText(ActualizarActivity.this, "El teléfono debe ser numérico", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}