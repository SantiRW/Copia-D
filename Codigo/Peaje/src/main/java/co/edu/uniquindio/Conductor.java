package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Conductor extends Persona{
    private ArrayList<Vehiculo> listVehiculosAsignados;

    public Conductor(String nombre, String nit, LocalDate fechaNacimiento, ArrayList<Vehiculo> listVehiculosAsignados) {
        super(nombre, nit, fechaNacimiento);
        this.listVehiculosAsignados = listVehiculosAsignados;
    }

// Metodo para asignar un vehiculo
    public void asignarVehiculo(Vehiculo vehiculo) {
    if (vehiculo != null && !listVehiculosAsignados.contains(vehiculo)) {
        listVehiculosAsignados.add(vehiculo);
    }
}


    public ArrayList<Vehiculo> getListVehiculosAsignados() {
        return listVehiculosAsignados;
    }

    public void setListVehiculosAsignados(ArrayList<Vehiculo> listVehiculosAsignados) {
        this.listVehiculosAsignados = listVehiculosAsignados;
    }
//    Metodo para consultar el total de dinero pagado en peajes por cada vehículo que una persona tiene asignado
    public void imprimirPeajesPagadosPorVehiculo() {
        double totalGeneral = 0.0;

        System.out.println("=== Reporte de peajes pagados por " + getNombre() + " ===");

        for (Vehiculo vehiculo : listVehiculosAsignados) {
            double valorPeaje = 0.0;
            System.out.println("\n" + vehiculo.getDescripcionDetallada());

            if (vehiculo instanceof Carro carro) {
                double base = 10000;

                if (carro.getModalidad() == Modalidad.CARRO_ELECTRICO) {
                    double descuento = base * 0.2;
                    base -= descuento;
                    System.out.println("- Descuento por eléctrico: -" + descuento);
                }

                if (carro.getModalidad() == Modalidad.SERVICIO_PUBLICO) {
                    double recargo = base * 0.15;
                    base += recargo;
                    System.out.println("- Recargo por servicio público: +" + recargo);
                }

                valorPeaje = base;

            } else if (vehiculo instanceof Camion camion) {
                int ejes = camion.getEjes().ordinal() + 4;
                double base = 7000 * ejes;
                System.out.println("- Ejes: " + ejes);
                System.out.println("- Valor base por ejes: " + base);

                if (camion.getCarga() > 10) {
                    double recargo = base * 0.1;
                    base += recargo;
                    System.out.println("- Recargo por carga > 10t: +" + recargo);
                }

                valorPeaje = base;

            } else if (vehiculo instanceof Moto moto) {
                double base = 5000;

                if (moto.getCilindraje() == Cilindraje.MAYOR200) {
                    base += 2000;
                    System.out.println("- Recargo por cilindraje > 200cc: +2000");
                }

                valorPeaje = base;
            }


            double totalVehiculo = valorPeaje * vehiculo.getNumPeajesPagos();
            System.out.println("→ Peajes pagados: " + vehiculo.getNumPeajesPagos());
            System.out.println("→ Total pagado por este vehículo: $" + totalVehiculo);

            totalGeneral += totalVehiculo;
        }

        System.out.println("\n=== Total general pagado por el conductor: $" + totalGeneral + " ===");
    }
// Metodo par devolver una lista de vehículos de un conductor que coincidan con un tipo específico
    public ArrayList<Vehiculo> obtenerVehiculosPorTipo(String tipoVehiculo) {
        ArrayList<Vehiculo> vehiculosFiltrados = new ArrayList<>();

        for (Vehiculo vehiculo : listVehiculosAsignados) {
            switch (tipoVehiculo.toLowerCase()) {
                case "carro":
                    if (vehiculo instanceof Carro) {
                        vehiculosFiltrados.add(vehiculo);
                    }
                    break;
                case "moto":
                    if (vehiculo instanceof Moto) {
                        vehiculosFiltrados.add(vehiculo);
                    }
                    break;
                case "camion":
                    if (vehiculo instanceof Camion) {
                        vehiculosFiltrados.add(vehiculo);
                    }
                    break;
                default:
                    System.out.println("Tipo de vehículo no reconocido: " + tipoVehiculo);
                    return new ArrayList<>();
            }
        }

        return vehiculosFiltrados;
    }
    // Metodo para obtener conductores con camiones mayores a 10 ton
    public static List<Conductor> obtenerConductoresConCamionesPesados(List<Conductor> conductores) {
        List<Conductor> conductoresConCamionesPesados = new ArrayList<>();

        for (Conductor conductor : conductores) {
            for (Vehiculo vehiculo : conductor.getListVehiculosAsignados()) {
                if (vehiculo instanceof Camion camion && camion.getCarga() > 10) {
                    conductoresConCamionesPesados.add(conductor);
                    break;
                }
            }
        }

        return conductoresConCamionesPesados;
    }

}
