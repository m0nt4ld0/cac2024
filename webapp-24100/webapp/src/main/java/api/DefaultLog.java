package api;

public class DefaultLog implements ILog {

    public DefaultLog() {
        
    }

    @Override
    public void enviarMensaje(String msg) {
        
        System.out.println("Enviando por defecto el mensaje: " + msg);
    }

    
}
