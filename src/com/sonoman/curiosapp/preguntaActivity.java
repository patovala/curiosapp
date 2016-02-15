package com.sonoman.curiosapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 * Created by janinatatiana on 2/15/16.
 */
public class PreguntaActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta);

        presentarPreguntas();
    }

    public void presentarPreguntas() {
        Bundle extras = getIntent().getExtras();
        List<Pregunta> preguntas = (List<Pregunta>) extras.getSerializable("PREGUNTAS");

        Log.e("Preguntas", "Preguntas en nueva activity > " + preguntas);
    }
}
