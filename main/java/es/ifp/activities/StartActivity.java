package es.ifp.mp04_dam_uf01_apellido_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    protected ImageView image1;
    protected TextView label1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

//        image1 = (ImageView) findViewById(R.id.img_start);
//        label1 = (TextView) findViewById(R.id.label1_start);

        TimerTask myTimerTask = new TimerTask() {

            @Override
            public void run() {

                Intent pasarPantalla = new Intent(StartActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }

        };
        Timer timer = new Timer();
        timer.schedule(myTimerTask, 2000);



    }
}