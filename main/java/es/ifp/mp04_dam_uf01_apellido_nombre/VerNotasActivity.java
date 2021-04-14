package es.ifp.mp04_dam_uf01_apellido_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class VerNotasActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected TextView label3;
    protected TextView label4;
    protected TextView label5;
    protected Button button1;
    protected Button button2;

    private Intent pasarPantalla;
    private DataBaseSQL db;
    private int identificador=0;

    private Bundle extras;
    private String paquete1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notas);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        db = new DataBaseSQL(this);

        label1 = (TextView) findViewById(R.id.label1_ver);
        label2 = (TextView) findViewById(R.id.label2_ver);
        label3 = (TextView) findViewById(R.id.label3_ver);
        label4 = (TextView) findViewById(R.id.label4_ver);
        label5 = (TextView) findViewById(R.id.label5_ver);
        button1 = (Button) findViewById(R.id.button1_ver);
        button2 = (Button) findViewById(R.id.button2_ver);

        //mostrar info de las notas en los textview
        extras = getIntent().getExtras();
        if (extras != null) {

            paquete1 = extras.getString("ID");
            Note n = db.getOneNota(Integer.parseInt(paquete1));
            label1.append(n.getTitulo());
            label2.append(n.getTelefono());
            label3.append(n.getLugar());
            label4.append(n.getCliente());
            label5.append(n.getURL());

        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent pasarPantalla = new Intent(VerNotasActivity.this, ListadoActivity.class);
               finish();
               startActivity(pasarPantalla);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //eliminar nota
                identificador = Integer.parseInt(paquete1);
                db.deleteNota(identificador);


                label1.setText("Eliminado...");
                label2.setText("Eliminado...");
                label3.setText("Eliminado...");
                label4.setText("Eliminado...");
                label5.setText("Eliminado...");

                Toast.makeText(VerNotasActivity.this, "Nota eliminada correctamente", Toast.LENGTH_SHORT).show();

                TimerTask myTimerTask = new TimerTask() {

                    @Override
                    public void run() {

                        Intent pasarPantalla = new Intent(VerNotasActivity.this, ListadoActivity.class);
                        finish();
                        startActivity(pasarPantalla);
                    }

                };
                Timer timer = new Timer();
                timer.schedule(myTimerTask, 1000);

            }
        });

    }
}