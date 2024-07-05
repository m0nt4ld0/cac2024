package oop;

public class MainBuscador {

    public static void main(String[] args) {
        
        String claveQueEnviaElUsuarioPorForm = "iron man";
        
        //instancio mi buscador
        Buscador buscador = new Buscador();

        buscador.setClaveDeBusqueda(claveQueEnviaElUsuarioPorForm);

        buscador.buscar();
        buscador.mostrarResultados();
    }
}