package api;

public class SmsLog implements ILog {

    public SmsLog() {
        
    }

    @Override
    public void enviarMensaje(String msg) {
        
        System.out.println("Enviando por SMS el mensaje: " + msg);
    }

    
}
