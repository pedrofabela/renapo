package utilidades;
//listareporteadmin
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Constantes {

    public static final boolean esDesarrollo = true;
    public static final String rutaEstilos = "http://aplicaciones.edugem.gob.mx/estilosUDAI/";
    public static final String RUTAIMAGES  = "";
    public static final String USUARIO="WS657050188";//"wsgestion";
    public static final String PASSWORD="Rx99Q7a3"; //"wsgestion2011";
    public static final String MIIP="";
    public static final String RUTAKEY="/opt/certificados/autenCert.keystore";
    public static final String PASSWORDKEY="assembly";
    public static final Integer TRANSACCION = 5;
    public static final String ENDPOINTREFERENCE ="https://webs.curp.gob.mx/WebServiceConsultaRenapo/services/ConsultaDatosRenapo?wsdl"; //"https://websdes.curp.gob.mx/WebServiceConsultaRenapo/services/ConsultaDatosRenapo?wsdl";
    
    
   public static final String TBL_CURPS = "U_SIGEDSPD.SGD_RENAPO"; //U_SIGEDSPD.SGD_RENAPO
   
  
    
    public static final boolean CONPOOL =  false;
         public static final String NOMBREPOOL = "jdbc/CURPS_ES";  //jdbc/CURPS_ES en produccion   jdbc/CURPSS_ES2 en localchost
         public static final String USERNAME = "U_VALIDACURP";	//
         public static final String URL = "jdbc:oracle:thin:@10.33.220.209:1521:oraudai";//"jdbc:oracle:thin:@10.33.220.209:1521:oraudai";// "jdbc:oracle:thin:@10.33.220.169:1521:oraudai"; //10.33.220.169:1521:oraudai en produccion   172.20.2.160:1521:xe localhost  	jdbc:oracle:thin:@172.20.2.47:1521:xe
         public static final String PASSWORDORA = "VALIDA#17";
         
         public static final Integer DATOSCAPTURADOS = 1; // 0 conexion configurada 1 datos que se ingresan
   
   
//            public static final boolean CONPOOL =  false;
//         public static final String NOMBREPOOL = "jdbc/APOYOS_ES";  //jdbc/APOYOS_ES en produccion   jdbc/APOYOS_ES2 en localchost
//         public static final String USERNAME = "U_APOYOELEC";	
//         public static final String URL = "jdbc:oracle:thin:@172.20.2.47:1521:xe";//"jdbc:oracle:thin:@172.20.2.47:1521:xe";// "jdbc:oracle:thin:@10.33.220.169:1521:oraudai"; //10.33.220.169:1521:oraudai en produccion   172.20.2.160:1521:xe localhost  	jdbc:oracle:thin:@172.20.2.47:1521:xe
//         public static final String PASSWORDORA = "pr1v$pan";


    //DECLARACIONES EXCLUSIVAS DE webcurp
    public static final String nombreSistema = "webcurp";
         
	       public static void enviaMensajeConsola(String cadena){
	   		if(esDesarrollo){
	   			System.out.println("MENSAJE_DESARROLLO("+nombreSistema+"): "+cadena);
	   			//log.info("MENSAJE_DESARROLLO("+nombreSistema+"): "+cadena);
	   		}
	   	}

} 
