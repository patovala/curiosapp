package com.sonoman.curiosapp;

/**
 * Created by on 2/16/16.
 */
public class Respuesta {
    private String idPregunta;
    private String pregunta;
    private String respuesta;
    private String usuario;

    public Respuesta() {
        
    }

    public Respuesta(String pregunta, String idPregunta, String respuesta, String usuario) {
        this.pregunta = pregunta;
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
        this.usuario = usuario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Respuesta respuesta = (Respuesta) o;

        return idPregunta != null ? idPregunta.equals(respuesta.idPregunta) : respuesta.idPregunta == null;

    }

    @Override
    public int hashCode() {
        return idPregunta != null ? idPregunta.hashCode() : 0;
    }
}
