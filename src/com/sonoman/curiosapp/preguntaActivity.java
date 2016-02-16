package com.sonoman.curiosapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.io.*;



/**
 * Created by janinatatiana on 2/15/16.
 */
public class PreguntaActivity extends Activity {
    private int preguntaActualIndex = 0;
    private Pregunta preguntaActual;
    private List<Pregunta> preguntas;
    private int totalPreguntas;
    private Set<Respuesta> respuestas = new HashSet<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta);

        //Recuperar el parámetro enviado desde la actividad de inicio
        Bundle extras = getIntent().getExtras();
        preguntas = (List<Pregunta>) extras.getSerializable("PREGUNTAS");
        totalPreguntas = preguntas.size();

        presentarPregunta();
    }

    public void presentarPregunta() {
        preguntaActual = preguntas.get(preguntaActualIndex);
        TextView message = (TextView) findViewById(R.id.pregunta);
        message.setText(preguntaActual.getTexto());

        //Presentar respuesta previa si existe, caso contrario se presenta el campo vacio
        this.fijarRespuestaPrevia();
    }

    public void guardar(View view) {
        this.guardarPregunta();

        if (preguntaActualIndex < totalPreguntas - 1) {
            preguntaActualIndex++;
            presentarPregunta();
        } else {
            //Enviar a guardar todas las respuestas
            guardarRespuestas();
        }

        if(preguntaActualIndex != 0) {
            mostrarOcultarBotonRegresar(1);
        }

        if(preguntaActualIndex == totalPreguntas -1) {
            actualizarBoton("Fizalizar");
        }

    }

    public void mostrarOcultarBotonRegresar(int visibility) {
        Button button = (Button) findViewById(R.id.btn_regresar);
        button.setVisibility(visibility);
    }

    public void actualizarBoton(String texto) {
        Button button = (Button) findViewById(R.id.btn_siguiente);
        button.setText(texto);
    }

    public void regresar(View view) {
        preguntaActualIndex--;
        presentarPregunta();

        if(preguntaActualIndex == 0) {
            mostrarOcultarBotonRegresar(-1);
        }

        if(preguntaActualIndex != totalPreguntas - 1) {
            actualizarBoton("Siguiente");
        }
    }

    public void  guardarPregunta() {
        Pregunta pregunta = preguntas.get(preguntaActualIndex);
        EditText textoRespuesta = (EditText) findViewById(R.id.respuesta);
        Respuesta respuesta = new Respuesta(pregunta.getTexto(), pregunta.getId(), textoRespuesta.getText().toString(), null);

        respuestas.add(respuesta);
    }

    public void fijarRespuestaPrevia() {
        EditText textoRespuesta = (EditText) findViewById(R.id.respuesta);
        String preguntaId = preguntas.get(preguntaActualIndex).getId();
        Respuesta respuesta = null;

        for (Respuesta r: respuestas) {
           if(r.getIdPregunta().equals(preguntaId)) {
               respuesta = r;
           }
        }

        if (respuesta !=null) {
            textoRespuesta.setText(respuesta.getRespuesta());
        } else {
            textoRespuesta.setText("");
        }
    }


    public void guardarRespuestas() {
        Log.e("Respuestas", "Respuestas " + respuestas);
        //TODO: Guardar las respuestas en un archivo

        //Presentar el dialogo despues de guardar las repuestas
        AlertDialog alertDialog = new AlertDialog.Builder(PreguntaActivity.this).create();
        alertDialog.setTitle("Curios App");
        alertDialog.setMessage("Sus preguntas se han guardado con éxito.");

        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Regresa al inicio
                Intent intent = new Intent(PreguntaActivity.this, InicioActivity.class);
                startActivity(intent);
            }
        });

        alertDialog.show();
    }
}
