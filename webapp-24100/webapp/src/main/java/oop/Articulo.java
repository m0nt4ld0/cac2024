package oop;

public class Articulo {
    // Atributos
    private String titulo;
    private String articulo;
    private Float precio;
    private String imagen;
    
    // Constructor
    public Articulo() {
        super();
    }

    public Articulo(String titulo, String articulo, Float precio, String imagen) {
        this.titulo = titulo;
        this.articulo = articulo;
        this.precio = precio;
        this.imagen = imagen;
    }

    // Metodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Articulo [titulo=" + titulo + ", articulo=" + articulo + ", precio=" + precio + ", imagen=" + imagen
                + "]";
    }

    

}
