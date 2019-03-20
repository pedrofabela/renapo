package beanspaquete4;

import java.io.Serializable;


public class CatalogosBean implements Serializable {
	private static long serialVersionUID = -3358884679090829992L;

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

	private String ID_CATALOGO;
	private String VALOR;
        private String SUBSISTEMA;

    /**
     * @return the IDCATALOGO
     */
    public String getID_CATALOGO() {
        return ID_CATALOGO;
    }

    /**
     * @param ID_CATALOGO the IDCATALOGO to set
     */
    public void setID_CATALOGO(String ID_CATALOGO) {
        this.ID_CATALOGO = ID_CATALOGO;
    }

    /**
     * @return the VALOR
     */
    public String getVALOR() {
        return VALOR;
    }

    /**
     * @param VALOR the VALOR to set
     */
    public void setVALOR(String VALOR) {
        this.VALOR = VALOR;
    }
    
    
    /**
     * @return the SUBSISTEMA
     */
    public String getSUBSISTEMA() {
        return SUBSISTEMA;
    }

    /**
     * @param VALOR the VALOR to set
     */
    public void setSUBSISTEMA(String SUBSISTEMA) {
        this.SUBSISTEMA = SUBSISTEMA;
    }
	
	
}
