package oop;


public class Pelicula extends Articulo {

    /*atributos */
    private String genero;


    /*contructor */
    public Pelicula( String t, String a , String i, Float d) {
        super(t, a, d, i); // Llamada al constructor del padre
    }

    /*metodos: get/sets */
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString() + "Pelicula [genero=" + genero + "]";
    }      

}
