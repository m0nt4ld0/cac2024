package oop;


public class Libro extends Articulo {

    /*atributos */
    private String isbn;


    /*contructor */
    public Libro( String t, String a , String i, Float d) {
        super(t, a, d, i); // Llamada al constructor del padre
    }

    /*metodos: get/sets */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + "Libro [isbn=" + isbn + "]";
    }      
    
}
