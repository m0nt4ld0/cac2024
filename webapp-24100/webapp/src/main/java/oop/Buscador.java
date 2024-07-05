package oop;

import java.util.ArrayList;

public class Buscador {
    private String claveDeBusqueda;
    private ArrayList<Articulo> resultados;

    public Buscador() {
        this.resultados = new ArrayList<Articulo>();
    }

    public void buscar() {
        Libro l = new Libro(claveDeBusqueda, "SIN AUTOR", "https://dummyimage.com/100x100.png/ff4444/ffffff", (float) 123);
        Pelicula p = new Pelicula(claveDeBusqueda, "Stanley Kubrick", "https://dummyimage.com/100x100.png/ff4444/ffffff", 567.8f);
        resultados.add(p);
        resultados.add(l);
        //System.out.println("Hemos encontrado " + getCantidad() + " resultados para" + this.claveDeBusqueda);
    }

    public void mostrarResultados() {
        System.out.println("Hemos encontrado " + getCantidad() + " resultados para " + this.claveDeBusqueda);
        for(Articulo art: resultados) 
        {
            // if(art instanceof Libro) {}
            System.out.println(art.toString());
        }
    }

    public Integer getCantidad() {
        return this.resultados.size();
    }

    public void setClaveDeBusqueda(String claveQueEnviaElUsuarioPorForm) {
        
        this.claveDeBusqueda = claveQueEnviaElUsuarioPorForm;
    }
    
}
