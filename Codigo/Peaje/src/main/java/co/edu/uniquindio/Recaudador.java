package co.edu.uniquindio;

import java.time.LocalDate;

public class Recaudador extends  Persona{
    private Double sueldoMensual;

    public Recaudador(String nombre, String nit, LocalDate fechaNacimiento, Double sueldoMensual) {
        super(nombre, nit, fechaNacimiento);
        this.sueldoMensual = sueldoMensual;
    }

    public Double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }
    // Metodo para buscar un Recaudador
    public boolean buscarRecaudadorPorNombreCompleto(String nombreCompleto) {
        String nombreActual = this.getNombre().trim().replaceAll("\\s+", " ").toLowerCase();
        String nombreBuscado = nombreCompleto.trim().replaceAll("\\s+", " ").toLowerCase();
        return nombreActual.equals(nombreBuscado);
    }
}
