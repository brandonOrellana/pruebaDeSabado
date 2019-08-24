package ar.com.eduit.curso.java.clase08;

import java.util.Objects;

public class Auto implements Comparable<Auto>{
    private String marca;
    private String modelo;
    private String color;

    public Auto(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + '}';
    }
    public String compare(){ return color+","+marca+","+modelo; }
    @Override public int compareTo(Auto a){
        return this.compare().compareTo(a.compare());
    }
    
    @Override public int hashCode() { return toString().hashCode(); }
    @Override public boolean equals(Object obj) { return this.hashCode()==obj.hashCode();}
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
