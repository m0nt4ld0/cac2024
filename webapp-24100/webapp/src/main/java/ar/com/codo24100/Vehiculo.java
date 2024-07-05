package ar.com.codo24100;

public class Vehiculo {
    // Atributos
    private String marca;
    private String modelo;
    private Integer anio;
    private String chasis;
    private boolean encendido;
    private Integer velocidad;
    private Integer velMax;

    // Constructor
    public Vehiculo (String marca, String modelo, Integer anio, String chasis, Integer vm) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.chasis = chasis;
        // Cuando los autos nacen, por defecto nacen encendido=false y velocidad=0
        this.velocidad = 0;
        this.encendido = false;
        this.velMax = vm;
    }
    // Métodos
    public void encender() {
        // Aca va la lógica del método
        if(!this.encendido)
            this.encendido = true;
        else
            System.out.println("El auto ya está encendido.");
    }

    public void apagar() {
        if(this.encendido)
            this.encendido = false;
        else
            System.out.println("El auto ya está apagado.");
    }

    public void acelerar() {
        if(this.encendido && this.velocidad<this.velMax)
            this.velocidad++;
    }

    public void frenar() {
        if(this.encendido && this.velocidad>0) {
            this.velocidad--;
        }
    }

    public Integer obtenerVelocidad() {
        return this.velocidad;
    }

    public Integer obtenerVelMax() {
        return this.velMax;
    }

    public void detener2() {
        while(this.velocidad>0) {
                this.velocidad--;
                System.out.println(this.velocidad);
        }
    }

    public void detener() {
        if(this.encendido) {
            System.out.println(this.velocidad);
            for(int i=this.velocidad; i>0; i--) {
                this.velocidad--;
                System.out.println(this.velocidad);
            }
        }
    }
    
}
