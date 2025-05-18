package co.edu.uniquindio;

public class Carro extends Vehiculo{
    private static Modalidad modalidad;

    public Carro(String placa, int numPeajesPagos, Modalidad modalidad) {
        super(placa, numPeajesPagos);
        this.modalidad = modalidad;
    }


    public static Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    @Override
    public String getDescripcionDetallada() {
        return "";
    }
}
