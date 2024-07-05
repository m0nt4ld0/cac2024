package api;

public class MainLog {
    public static void main(String[] args) {
        String msg = "Hola Mundo";    
        
        int log = 2; // La idea es que esto venga de la DB y el Main solo va a ser un pasamanos
        LogService ls = new LogService(log);
        ls.enviarMensaje(msg);
        
        // Interface nombre = new ClaseQueImplementaLaInterface();
        //ILog ilog = new SmsLog();
        //ilog.enviarMensaje(msg);
    }
}
