package com.sonoman.curiosapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InicioActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void inicio(View view) {
        List<Pregunta> preguntas = getPreguntas();
        Log.e("Preguntas", "Preguntas " + preguntas);

        Intent intent = new Intent(this, PreguntaActivity.class);
        //Pasar las preguntas a la siguiente actividad
        Bundle bundle = new Bundle();
        bundle.putSerializable("PREGUNTAS", (Serializable) preguntas);
        intent.putExtras(bundle);

        //Iniciar la actividad
        startActivity(intent);
    }

    public List<Pregunta> getPreguntas(){
        List<Pregunta> preguntas = new ArrayList<>();
        try {
            InputStreamReader is = new InputStreamReader(getAssets()
                .open("preguntas.csv"));

            BufferedReader reader = new BufferedReader(is);

            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String [] lineArray = line.split(",");
                if (lineArray.length >= 3) {
                    Pregunta pregunta = new Pregunta(lineArray[0], lineArray[1], lineArray[2]);
                    preguntas.add(pregunta);
                }
            }
        } catch (Exception e ) {
            Log.e("Error", "Error" + e);
        }


        return preguntas;
    }
}
