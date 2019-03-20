package beans;

import java.io.Serializable;


public class curpBean implements Serializable {
    private static long serialVersionUID = -3358884679090829992L;

    private String CURP ;
    private String USUARIO;
    private String PASSWORD;
    private String MIIP;
    private String RUTAKEY;
    private String PASSWORDKEY;
    private Integer TRANSACCION;
    private String ENDPOINTREFERENCE;
        

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    public curpBean(){
        this.USUARIO=utilidades.Constantes.USUARIO;
        this.PASSWORD=utilidades.Constantes.PASSWORD;
        this.MIIP=utilidades.Constantes.MIIP;
        this.RUTAKEY=utilidades.Constantes.RUTAKEY;
        this.PASSWORDKEY=utilidades.Constantes.PASSWORDKEY;
        this.TRANSACCION = utilidades.Constantes.TRANSACCION;
        this.ENDPOINTREFERENCE = utilidades.Constantes.ENDPOINTREFERENCE;   
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the CURP
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * @param CURP the CURP to set
     */
    public void setCURP(String CURP) {
        this.CURP = CURP.trim();
    }

    /**
     * @return the USUARIO
     */
    public String getUSUARIO() {
        return USUARIO;
    }

    /**
     * @param USUARIO the USUARIO to set
     */
    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param PASSWORD the PASSWORD to set
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    /**
     * @return the MIIP
     */
    public String getMIIP() {
        return MIIP;
    }

    /**
     * @param MIIP the MIIP to set
     */
    public void setMIIP(String MIIP) {
        this.MIIP = MIIP;
    }

    /**
     * @return the RUTAKEY
     */
    public String getRUTAKEY() {
        return RUTAKEY;
    }

    /**
     * @param RUTAKEY the RUTAKEY to set
     */
    public void setRUTAKEY(String RUTAKEY) {
        this.RUTAKEY = RUTAKEY;
    }

    /**
     * @return the PASSWORDKEY
     */
    public String getPASSWORDKEY() {
        return PASSWORDKEY;
    }

    /**
     * @param PASSWORDKEY the PASSWORDKEY to set
     */
    public void setPASSWORDKEY(String PASSWORDKEY) {
        this.PASSWORDKEY = PASSWORDKEY;
    }

    /**
     * @return the TRANSACCION
     */
    public Integer getTRANSACCION() {
        return TRANSACCION;
    }

    /**
     * @param TRANSACCION the TRANSACCION to set
     */
    public void setTRANSACCION(Integer TRANSACCION) {
        this.TRANSACCION = TRANSACCION;
    }

    /**
     * @return the ENDPOINTREFERENCE
     */
    public String getENDPOINTREFERENCE() {
        return ENDPOINTREFERENCE;
    }

    /**
     * @param ENDPOINTREFERENCE the ENDPOINTREFERENCE to set
     */
    public void setENDPOINTREFERENCE(String ENDPOINTREFERENCE) {
        this.ENDPOINTREFERENCE = ENDPOINTREFERENCE;
    }
}
