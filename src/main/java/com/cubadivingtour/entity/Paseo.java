package com.cubadivingtour.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "paseo")
public class Paseo extends PanacheEntity {

    public String nombre;
    public String cuidades;
    public String descripcion;
    public int duracion;
    @OneToMany(mappedBy = "paseo", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Reserva> reservas;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuidades() {
        return cuidades;
    }

    public void setCuidades(String cuidades) {
        this.cuidades = cuidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
