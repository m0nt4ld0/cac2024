package dto;

import java.sql.Date;

public class UsuariosDTO {
    private Long idUsuario;
    private String nombreUsuario;
    private String apeUsuario;
    private String mailUsuario;
    private String pwdUsuario;
    private Date fnacUsuario;
    private String paisUsuario;

    public UsuariosDTO() {
        // Constructor por defecto necesario para Jackson
    }
    
    public UsuariosDTO(Long idUsuario, String nombreUsuario, String apeUsuario, String mailUsuario, String pwdUsuario,
            Date fnacUsuario, String paisUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apeUsuario = apeUsuario;
        this.mailUsuario = mailUsuario;
        this.pwdUsuario = pwdUsuario;
        this.fnacUsuario = fnacUsuario;
        this.paisUsuario = paisUsuario;
    }

    /*
     * SOLAMENTE USO EL CONSTRUCTOR Y LOS GETTERS PORQUE EL DTO ES DATA TRANSFER OBJECT
     * Esto quiere decir que "es un pasamanos" de los objetos
    */
    
    public UsuariosDTO(String nombreUsuario, String apeUsuario, String mailUsuario, String pwdUsuario,
    String paisUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apeUsuario = apeUsuario;
        this.mailUsuario = mailUsuario;
        this.pwdUsuario = pwdUsuario;
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
        return "UsuariosDTO [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apeUsuario=" + apeUsuario
                + ", mailUsuario=" + mailUsuario + ", pwdUsuario=" + pwdUsuario + ", fnacUsuario=" + fnacUsuario
                + ", paisUsuario=" + paisUsuario + "]";
    }

    
}
