package com.sonoman.curiosapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        // TODO: Necesitamos ir presentando las preguntas
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
