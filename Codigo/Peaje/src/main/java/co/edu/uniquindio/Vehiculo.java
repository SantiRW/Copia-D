package co.edu.uniquindio;

public abstract class Vehiculo {
    private String placa;
    private int numPeajesPagos;


    public Vehiculo(String placa, int numPeajesPagos) {
        this.placa = placa;
        this.numPeajesPagos = numPeajesPagos;

    }

    // Metodo abstracto
    public abstract String getDescripcionDetallada();
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumPeajesPagos() {
        return numPeajesPagos;
    }

    public void setNumPeajesPagos(int numPeajesPagos) {
        this.numPeajesPagos = numPeajesPagos;
    }

}
