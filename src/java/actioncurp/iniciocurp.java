/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actioncurp;


import beans.CURPStruct;
import beans.DatosConsultaCurpBean;
import beans.curpBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
//import mx.gob.segob.dgti.ecurp.wserv.services.xsd.ObjectFactory;
//import mx.gob.segob.dgti.ecurp.wserv.services.xsd.DatosConsultaCurp;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.logging.Log;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
  


public class iniciocurp extends ActionSupport{
        public curpBean configwebservice = new curpBean();//OBJETO CON DATOS DE LA CONFIGURACION DEL WEB SEVICE, SOLO LO UTILIZO PARA CONFIGURAR... SE PUDE CAMBIAR POR DATOS ESTATICOS UTILIDADES.CONSTANTES....
        public CURPStruct micurp = new CURPStruct();// OBJETO CURP.

    	public String miinicio(){
            try {
                curpBean configwebservice = new curpBean();
                CURPStruct micurp = new CURPStruct();
	    }catch (Exception e) {
		addActionError("Ocurrio un error: "+e );
		return "ERROR";
            }
            return "SUCCESS";
	}
        
        public String buscardatoscurp(){//CISCAR CURP
            try {
                
                if (validarCURP(configwebservice.getCURP().toUpperCase()))
                {
                    micurp = new CURPStruct();
                    String usuario= configwebservice.getUSUARIO();
                    String password=configwebservice.getPASSWORD();
                    String curp =configwebservice.getCURP();
                    String ip = configwebservice.getMIIP();
                    String entidademisora=obtenerestado(curp);
                    Integer transaccion = configwebservice.getTRANSACCION();
                    System.setProperty ("javax.net.ssl.trustStore",configwebservice.getRUTAKEY()); 
                    System.setProperty("javax.net.ssl.trustStorePassword",configwebservice.getPASSWORDKEY());

                    RPCServiceClient serviceClient = new RPCServiceClient();
                    Options options = serviceClient.getOptions();
                    EndpointReference targetEPR = new EndpointReference(configwebservice.getENDPOINTREFERENCE());
                    options.setTo(targetEPR);
                    DatosConsultaCurpBean datos = new DatosConsultaCurpBean();
                    datos.setTipoTransaccion(transaccion);
                    datos.setUsuario(usuario);
                    datos.setPassword(password);
                    datos.setDireccionIp(ip);
                    datos.setCveCurp(curp.toUpperCase());
                    datos.setCveEntidadEmisora(entidademisora);
                    QName opSetAlta = new QName("http://services.wserv.ecurp.dgti.segob.gob.mx", "consultarPorCurp"); 
                    Object[] altaServiceArgs = new Object[] {datos };
                    Class<?>[] returnTypes = new Class[] { String.class };
                    Object[] response = serviceClient.invokeBlocking(opSetAlta,
	        		altaServiceArgs, returnTypes);
                    String result = (String) response[0];
                        if (result == null) {
                            addActionError("NO HAY RESULTADOS EN WEB SERVICE");
                            utilidades.Constantes.enviaMensajeConsola("NO HAY RESULTADOS EN WEB SERVICE");
                        return "ERROR";
                    }
                    utilidades.Constantes.enviaMensajeConsola(result);
                    addActionError("EL RESULTADO ES: "+result);
                    QName optGetConfirm = new QName("http://services.wserv.ecurp.dgti.segob.gob.mx", "getConfirm");
                    Object[] opGetConfirmArgs = new Object[] {  getSessionID(result), "OK"  };
                    serviceClient.invokeRobust(optGetConfirm, opGetConfirmArgs);
                    String result2 = result.replace('\"', '\'');
                    micurp =(CURPStruct)interpretaCurp(result2); 
                    utilidades.Constantes.enviaMensajeConsola("WEB SERVICE TERMINO OK");   
                    addActionError("WEB SERVICE TERMINO OK. ");
                }else{
                    addFieldError("configwebservice.CURP",getText("CURP no valida"));
                }   
	    }catch (Exception e) {
		addActionError("Ocurrio un error: "+e );
		return "ERROR";
            }
            return "SUCCESS";
	}
     public String obtenerestado (String curp){
      String miestado = curp.substring(11,13);
      miestado = miestado.toUpperCase();
      utilidades.Constantes.enviaMensajeConsola("miestado: "+miestado);
      return miestado;
    }  
        
    public CURPStruct interpretaCurp(String curp) {
        CURPStruct curpE = null;
        try {
            //DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(curp));
            JAXBContext jaxbContext = JAXBContext.newInstance(CURPStruct.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            curpE = (CURPStruct) jaxbUnmarshaller.unmarshal(is);
            
        } catch (Exception e) {
            //addActionError("Ocurrio un error: "+e );
            e.printStackTrace();
        }
        return curpE;
    }
    public String buscardatoscurp3(){//CISCAR CURP
            try {
                
                if (validarCURP(configwebservice.getCURP().toUpperCase()))
                {
                    String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <CURPStruct statusOper=\"EXITOSO\" message=\"LA OPERACION SE EJECUTO.\" TipoError=\"\" CodigoError=\"\" SessionID=\"ExA13bA5glPEw2mTzIJmW8rm3aEUvVhJ2-yzKjeBXJaKvqavn1Nc!1543613910!1491257372729\"><CURP>EAMI840903HMCSCG03</CURP><apellido1>ESCAMILLA</apellido1><apellido2>MUCIÑO</apellido2><nombres>IGNACIO</nombres><sexo>H</sexo><fechNac>03/09/1984</fechNac><nacionalidad>MEX</nacionalidad><docProbatorio>1</docProbatorio><anioReg>9999</anioReg><foja></foja><tomo></tomo><libro>9999</libro><numActa>99999</numActa><CRIP>150180185000512</CRIP><numEntidadReg>99</numEntidadReg><cveMunicipioReg>999</cveMunicipioReg><NumRegExtranjeros></NumRegExtranjeros><FolioCarta></FolioCarta><cveEntidadNac>MC</cveEntidadNac><cveEntidadEmisora>11003</cveEntidadEmisora><statusCurp>AN</statusCurp></CURPStruct>";
                     //String result2 = result.replace('\"', '\'');
                    micurp =(CURPStruct)interpretaCurp(result); 
                    
                    utilidades.Constantes.enviaMensajeConsola("WEB SERVICE TERMINO OK");   
                    addActionError("WEB SERVICE TERMINO OK. ");
                }else{
                    addFieldError("configwebservice.CURP",getText("CURP no valida"));
                }   
	    }catch (Exception e) {
		addActionError("Ocurrio un error: "+e );
		return "ERROR";
            }
            return "SUCCESS";
	}
        
        
        public boolean validarCURP(String curp) {
        String regex
                = "[A-Z]{1}[A-Z]{1}[A-Z]{2}[0-9]{2}"
                + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
                + "[HM]{1}"
                + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
                + "[A-Z]{3}"
                + "[0-9A-Z]{1}[0-9]{1}$";
        Pattern patron = Pattern.compile(regex);
        if (!patron.matcher(curp).matches()) {
            return false;
        } else {
            return true;
        }
    }



    
    private static String getSessionID(String xml) {
        String sessionID = "";

        try {
            Document doc = DocumentHelper.parseText(xml);
            Attribute attr = doc.getRootElement().attribute("SessionID");
            sessionID = attr.getText();
        } catch (Exception ignoredException) {
        }

        return sessionID;
    }

    /**
     * @return the configwebservice
     */
    public curpBean getConfigwebservice() {
        return configwebservice;
    }

    /**
     * @param configwebservice the configwebservice to set
     */
    public void setConfigwebservice(curpBean configwebservice) {
        this.configwebservice = configwebservice;
    }

    /**
     * @return the micurp
     */
    public CURPStruct getMicurp() {
        return micurp;
    }

    /**
     * @param micurp the micurp to set
     */
    public void setMicurp(CURPStruct micurp) {
        this.micurp = micurp;
    }
    	       
}

