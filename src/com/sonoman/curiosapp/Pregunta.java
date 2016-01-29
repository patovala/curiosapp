package com.sonoman.curiosapp;

/**
 * Created by janinatatiana on 1/29/16.
 */
public class Pregunta {
    private String id;
    private String categoria;
    private String texto;

    public Pregunta(String id, String texto, String categoria) {
        this.id = id;
        this.categoria = categoria;
        this.texto = texto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
