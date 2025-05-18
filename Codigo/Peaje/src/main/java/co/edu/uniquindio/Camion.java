package co.edu.uniquindio;

public class Camion extends Vehiculo{
    private double carga;
    private Ejes ejes;

    public Camion(String placa, int numPeajesPagos, double carga, Ejes ejes) {
        super(placa, numPeajesPagos);
        this.carga = carga;
        this.ejes = ejes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public Ejes getEjes() {
        return ejes;
    }

    public void setEjes(Ejes ejes) {
        this.ejes = ejes;
    }

    @Override
    public String getDescripcionDetallada() {
        return "";
    }
}
