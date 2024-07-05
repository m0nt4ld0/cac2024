package api;

public class LogService {
    private ILog logger;

    public LogService(int logHabilitado) {
        
        switch (logHabilitado) {
            case 1:
                this.logger = new SmsLog();        
                break;
            case 2:
                this.logger = new EmailLog();        
                break;
            default:
                this.logger = new DefaultLog();        
                break;
        }
    }

    public void enviarMensaje(String msg) {
        this.logger.enviarMensaje(msg);
    }
}
