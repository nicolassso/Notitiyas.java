package es.ifp.mp04_dam_uf01_apellido_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class BorrarNotaActivity extends AppCompatActivity {

    protected Button button1;
    protected Button button2;
    protected DataBaseSQL db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_nota);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        db = new DataBaseSQL(this);

        button1 = (Button) findViewById(R.id.button1_borrar);
        button2 = (Button) findViewById(R.id.button2_borrar);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.deleteAllNotas();

                button1.setText("Borrando...");
                Toast.makeText(BorrarNotaActivity.this, "Se han borrado todas las notas correctamente", Toast.LENGTH_SHORT).show();
                TimerTask myTimerTask = new TimerTask() {

                    @Override
                    public void run() {

                        Intent pasarPantalla = new Intent(BorrarNotaActivity.this, ListadoActivity.class);
                        finish();
                        startActivity(pasarPantalla);
                    }

                };
                Timer timer = new Timer();
                timer.schedule(myTimerTask, 1000);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pasarPantalla = new Intent(BorrarNotaActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);

            }
        });

    }
}