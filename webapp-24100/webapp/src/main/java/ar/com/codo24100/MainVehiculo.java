package ar.com.codo24100;

public class MainVehiculo {
    public static void main(String[] args) {
        
        // Crear el vehiculo
        Vehiculo v = new Vehiculo("Renault", "Clio", 2018, "abcd", 2);

        // Ejecutar métodos del vehículo clio
        v.encender();
        v.acelerar();
        System.out.println(v.obtenerVelocidad());
        v.acelerar();
        System.out.println(v.obtenerVelocidad());
        v.detener();
    }
}
