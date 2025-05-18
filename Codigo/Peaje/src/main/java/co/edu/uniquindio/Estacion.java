package co.edu.uniquindio;

import java.util.ArrayList;

public class Estacion {
    private String nombre;
    private String departamento;
    private double valorTotalPeaje;
    private ArrayList<Vehiculo> listvehiculos;

    public Estacion(String nombre, String departamento, double valorTotalPeaje,ArrayList<Vehiculo> listvehiculos) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.valorTotalPeaje = valorTotalPeaje;
        this.listvehiculos = listvehiculos;
    }

    // Metodo para calcular el valor del peaje para cada vehiculo
    public double valorPasajeVehiculo() {
        double total = 0.0;

        for (Vehiculo vehiculo : listvehiculos) {
            if (vehiculo instanceof Carro carro) {
                double base = 10000;

                if (carro.getModalidad() == Modalidad.CARRO_ELECTRICO) {
                    base -= base * 0.2;
                }

                if (carro.getModalidad() == Modalidad.SERVICIO_PUBLICO) {
                    base += base * 0.15;
                }

                total += base;

            } else if (vehiculo instanceof Camion camion) {
                double base = 7000 * (camion.getEjes().ordinal() + 4);
                if (camion.getCarga() > 10) {
                    base += base * 0.1;
                }
                total += base;
            } else if (vehiculo instanceof Moto moto) {
                double base = 5000;
                if (moto.getCilindraje() == Cilindraje.MAYOR200){
                    base += 2000;
                }
                total += base;
            }
        }

        return total;
    }

//    Metodo que imprima listado de vehiculos que llegaron al peaje
    public void imprimirDetallePeajes() {
        double totalAcumulado = 0.0;

        System.out.println("=== Listado de vehículos en el peaje de " + nombre + " ===");

        for (Vehiculo vehiculo : listvehiculos) {
            double valorPeaje = 0.0;
            System.out.println("\nPlaca: " + vehiculo.getPlaca());

            if (vehiculo instanceof Carro carro) {
                double base = 10000;
                System.out.println("Tipo: Carro");

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
                System.out.println("Tipo: Camión");
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
                System.out.println("Tipo: Moto");

                if (moto.getCilindraje() == Cilindraje.MAYOR200) {
                    base += 2000;
                    System.out.println("- Recargo por cilindraje > 200cc: +2000");
                }

                valorPeaje = base;
            }

            System.out.println("→ Valor peaje: $" + valorPeaje);
            totalAcumulado += valorPeaje;
        }

        System.out.println("\n=== Total acumulado en el peaje: $" + totalAcumulado + " ===");
    }

//    Metodo para Calcular el valor del peaje de un vehículo X
//    , actualiza el valor total recaudado y guarda el registro del paso del vehículo.
public double procesarPasoVehiculo(Vehiculo vehiculo) {
    double valorPeaje = 0.0;

    if (vehiculo instanceof Carro carro) {
        double base = 10000;

        if (carro.getModalidad() == Modalidad.CARRO_ELECTRICO) {
            base -= base * 0.2;
        }

        if (carro.getModalidad() == Modalidad.SERVICIO_PUBLICO) {
            base += base * 0.15;
        }

        valorPeaje = base;

    } else if (vehiculo instanceof Camion camion) {
        double base = 7000 * (camion.getEjes().ordinal() + 4);

        if (camion.getCarga() > 10) {
            base += base * 0.1;
        }

        valorPeaje = base;

    } else if (vehiculo instanceof Moto moto) {
        double base = 5000;

        if (moto.getCilindraje() == Cilindraje.MAYOR200) {
            base += 2000;
        }

        valorPeaje = base;
    }


    this.valorTotalPeaje += valorPeaje;
    vehiculo.setNumPeajesPagos(vehiculo.getNumPeajesPagos() + 1);
    listvehiculos.add(vehiculo);

    return valorPeaje;
}



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getValorTotalPeaje() {
        return valorTotalPeaje;
    }

    public void setValorTotalPeaje(double valorTotalPeaje) {
        this.valorTotalPeaje = valorTotalPeaje;
    }

    public ArrayList<Vehiculo> getListvehiculos() {
        return listvehiculos;
    }

    public void setListvehiculos(ArrayList<Vehiculo> listvehiculos) {
        this.listvehiculos = listvehiculos;
    }
}
