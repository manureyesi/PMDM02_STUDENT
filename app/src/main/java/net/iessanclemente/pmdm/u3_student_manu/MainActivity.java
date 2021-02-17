package net.iessanclemente.pmdm.u3_student_manu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button botonCronometro;
    private Chronometer cronometro;
    private ImageView imagenMonumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCronometro = findViewById(R.id.buttonCronometro);
        botonCronometro.setOnClickListener(this::onClickCronometro);

        cronometro = findViewById(R.id.cronometro);

        imagenMonumento = findViewById(R.id.imageViewMonumento);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        final String TAG = "onConfigurationChanged:";

        //check config
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i(TAG, "Ocultar imagen al modificar orientacion");
            imagenMonumento.setVisibility(View.INVISIBLE);
        } else {
            Log.i(TAG, "Mostrar imagen al modificar orientacion");
            imagenMonumento.setVisibility(View.VISIBLE);
        }

    }

    /**
     * Evento OnClick para el Cronometro
     * @param view
     */
    private void onClickCronometro(View view) {

        this.cronometro.setBase(SystemClock.elapsedRealtime());
        this.cronometro.start();

    }
}