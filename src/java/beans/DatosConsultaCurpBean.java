package beans;

import java.io.Serializable;


public class DatosConsultaCurpBean implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;
    private String   direccionIp;
    private int      tipoTransaccion;
    private String   usuario;
    private String   password;
    private String   cveCurp;
    private String   cveEntidadEmisora;
    
    public DatosConsultaCurpBean() {
        super();
    }

    public DatosConsultaCurpBean(String direccionIp, int tipoTransaccion,
            String usuario, String password, String cveCurp) {
        this.direccionIp = direccionIp;
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.password = password;
        this.cveCurp = cveCurp;
    }

    public DatosConsultaCurpBean(String direccionIp, int tipoTransaccion,
            String usuario, String password, String cveCurp,
            String cveEntidadEmisora) {
        this.direccionIp = direccionIp;
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.password = password;
        this.cveCurp = cveCurp;
        this.cveEntidadEmisora = cveEntidadEmisora;
    }

    /**
     * @return the direccionIp
     */
    public String getDireccionIp() {
        return direccionIp;
    }

    /**
     * @param direccionIp the direccionIp to set
     */
    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    /**
     * @return the tipoTransaccion
     */
    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * @param tipoTransaccion the tipoTransaccion to set
     */
    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the cveCurp
     */
    public String getCveCurp() {
        return cveCurp;
    }

    /**
     * @param cveCurp the cveCurp to set
     */
    public void setCveCurp(String cveCurp) {
        this.cveCurp = cveCurp;
    }

    /**
     * @return the cveEntidadEmisora
     */
    public String getCveEntidadEmisora() {
        return cveEntidadEmisora;
    }

    /**
     * @param cveEntidadEmisora the cveEntidadEmisora to set
     */
    public void setCveEntidadEmisora(String cveEntidadEmisora) {
        this.cveEntidadEmisora = cveEntidadEmisora;
    }
       
}
