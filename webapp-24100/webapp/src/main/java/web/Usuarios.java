package web;

import java.sql.Date;

public class Usuarios {
    private Long idUsuario;
    private String nombreUsuario;
    private String apeUsuario;
    private String mailUsuario;
    private String pwdUsuario;
    private Date fnacUsuario;
    private String paisUsuario;

    public Usuarios(Long idUsuario, String nombreUsuario, String apeUsuario, String mailUsuario, String pwdUsuario,
            Date fnacUsuario, String paisUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apeUsuario = apeUsuario;
        this.mailUsuario = mailUsuario;
        this.pwdUsuario = pwdUsuario;
        this.fnacUsuario = fnacUsuario;
        this.paisUsuario = paisUsuario;
    }
    
    public Usuarios(String nombreUsuario, String apeUsuario, String mailUsuario, String pwdUsuario, String paisUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apeUsuario = apeUsuario;
        this.mailUsuario = mailUsuario;
        this.pwdUsuario = pwdUsuario;
        this.paisUsuario = paisUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }



    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }



    public void setApeUsuario(String apeUsuario) {
        this.apeUsuario = apeUsuario;
    }



    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }



    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }



    public void setFnacUsuario(Date fnacUsuario) {
        this.fnacUsuario = fnacUsuario;
    }



    public void setPaisUsuario(String paisUsuario) {
        this.paisUsuario = paisUsuario;
    }



    public Long getIdUsuario() {
        return idUsuario;
    }



    public String getNombreUsuario() {
        return nombreUsuario;
    }



    public String getApeUsuario() {
        return apeUsuario;
    }



    public String getMailUsuario() {
        return mailUsuario;
    }



    public String getPwdUsuario() {
        return pwdUsuario;
    }



    public Date getFnacUsuario() {
        return fnacUsuario;
    }



    public String getPaisUsuario() {
        return paisUsuario;
    }



    @Override
    public String toString() {
        return "Usuarios [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apeUsuario=" + apeUsuario
                + ", mailUsuario=" + mailUsuario + ", pwdUsuario=" + pwdUsuario + ", fnacUsuario=" + fnacUsuario
                + ", paisUsuario=" + paisUsuario + "]";
    }

}
