package com.cubadivingtour.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends PanacheEntity {

    public String nombre;
    public String apellidos;
    public String correo;
    public String movil;
    public String direccion;
    public String pais;
    public String ciudad;
    public String pasaporte;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Reserva> reservas;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String movil, String direccion, String pais, String ciudad, String pasaporte, List<Reserva> reservas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.movil = movil;
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.pasaporte = pasaporte;
        this.reservas = reservas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", movil='" + movil + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pasaporte='" + pasaporte + '\'' +
                ", id=" + id +
                '}';
    }
}
