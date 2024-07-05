package api;

public class EmailLog implements ILog {
    
    public EmailLog() {
    }

    @Override
    public void enviarMensaje(String msg) {
        
        System.out.println("Enviando por e-mail el mensaje: " + msg);
    }

    
}
