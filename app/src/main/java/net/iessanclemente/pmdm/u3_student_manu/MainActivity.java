package net.iessanclemente.pmdm.u3_student_manu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button botonCronometro;
    private Chronometer cronometro;
    private ImageView imagenMonumento;
    private Spinner listaProvincias;

    public Boolean esPrimerInicioApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.esPrimerInicioApp = Boolean.TRUE;

        botonCronometro = findViewById(R.id.buttonCronometro);
        botonCronometro.setOnClickListener(this::onClickCronometro);

        cronometro = findViewById(R.id.cronometro);

        imagenMonumento = findViewById(R.id.imageViewMonumento);

        listaProvincias = findViewById(R.id.spinnerProvincias);

        // Añadir listener para lista
        listaProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String TAG = "onItemSelected:";
                String provincia = listaProvincias.getSelectedItem().toString();
                // Comprobamos si la provincia es de galicia
                if (Arrays.asList(getResources().getStringArray(R.array.provincias_gallegas_array)).contains(provincia)) {
                    Log.i(TAG, "La provincia seleccionada es Gallega");
                    Toast.makeText(MainActivity.this,R.string.text_toast_gal,Toast.LENGTH_LONG).show();
                } else {
                    Log.i(TAG, "La provincia seleccionada NO es Gallega");
                    Toast.makeText(MainActivity.this,R.string.text_toast_no_gal,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                final String TAG = "onNothingSelected:";
                Log.i(TAG, "No se seleciona ninguna provincia");
            }
        });
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
     * Evento OnClick para el boton de añadir borrar texto
     * @param view
     */
    private void onClickTexto (View view) {

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