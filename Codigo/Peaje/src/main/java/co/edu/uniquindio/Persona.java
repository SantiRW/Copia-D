package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Persona {
    private String nombre;
    private String nit;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String nit, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nit = nit;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
