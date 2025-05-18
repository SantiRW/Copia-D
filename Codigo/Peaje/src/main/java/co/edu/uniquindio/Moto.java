package co.edu.uniquindio;

public class Moto extends Vehiculo{
    private Cilindraje cilindraje;

    public Moto(String placa, int numPeajesPagos, Cilindraje cilindraje) {
        super(placa, numPeajesPagos);
        this.cilindraje = cilindraje;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(Cilindraje cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public String getDescripcionDetallada() {
        return "";
    }
}
