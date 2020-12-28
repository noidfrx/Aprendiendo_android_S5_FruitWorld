package com.example.aprendiendo_android_s5_fruitworld.models;

public class Fruta {
    private String nombre, origen;
    private int icono;

    public Fruta(String nombre, String origen, int icono) {
        this.nombre = nombre;
        this.origen = origen;
        this.icono = icono;
    }

    public Fruta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
