/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actioncurp;

import beans.CURPStruct;
import beans.DatosConsultaCurpBean;
import beans.curpBean;
import beanspaquete4.CatalogosBean;
import business.registrocurpsBusiness;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edugem.gob.mx.CURPSERVICE;
import edugem.gob.mx.CURPSERVICE_Service;
import edugem.gob.mx.Consultacurp;
import edugem.gob.mx.CurpStruct;
import java.io.File;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.axis2.AxisFault;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class iniciocurp2 extends ActionSupport {

    public curpBean configwebservice = new curpBean();//OBJETO CON DATOS DE LA CONFIGURACION DEL WEB SEVICE, SOLO LO UTILIZO PARA CONFIGURAR... SE PUDE CAMBIAR POR DATOS ESTATICOS UTILIDADES.CONSTANTES....
    public CURPStruct micurp = new CURPStruct();// OBJETO CURP.
    public List<CURPStruct> milistacurp = new ArrayList<CURPStruct>();
    public List<CURPStruct> milistacurp2 = new ArrayList<CURPStruct>();

    public String miinicio() {
        try {
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }
    public Integer MIINICIOC = 0;

    public String miinicio3() {
        try {
            MIINICIOC = 0;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String miinicio33() {
        try {
            MIINICIOC = 0;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public Integer CUANTOSR = 0;

    public String miinicio4() {
        try {
            MIINICIOC = 0;
            CUANTOSR = 10;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String miinicio5() {
        try {
            MIINICIOC = 0;
            CUANTOSR = 25;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String miinicio6() {
        try {
            MIINICIOC = 0;
            CUANTOSR = 25;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String TABLAACHECAR = "";

    public String miinicio8() {
        try {
            MIINICIOC = 0;
            CUANTOSR = 25;
            TABLAACHECAR = utilidades.Constantes.TBL_CURPS;
            MIUSERNAME = utilidades.Constantes.USERNAME;
            MIJDBC = utilidades.Constantes.URL;
            MIPASSWORD = utilidades.Constantes.PASSWORDORA;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String MIUSERNAME = "";
    public String MIJDBC = "";
    public String MIPASSWORD = "";
    ///String miusername,String mijdbc, String mipassword

    public boolean validardatos() {
        boolean mibantemp = true;
        if (TABLAACHECAR == null) {
            addActionError("Debe escribir el nombre de una tabla en el siguiente formato NOMBREDEESCQUEMA.NOMBRETABLA");
            mibantemp = false;
        } else {
            if (TABLAACHECAR.length() == 0) {
                addActionError("Debe escribir el nombre de una tabla en el siguiente formato NOMBREDEESCQUEMA.NOMBRETABLA");
                mibantemp = false;
            }
        }
        if (CUANTOSR == null) {
            addActionError("Debe escribir el numero de registros a actualizar de 1 a 50 recomendable 25");
            mibantemp = false;
        } else {
            if (CUANTOSR == 0) {
                addActionError("Debe escribir el numero de registros a actualizar de 1 a 50 reocomendable 25");
                mibantemp = false;
            }
        }

        if (MIUSERNAME == null) {
            addActionError("Debe escribir el usuario de la BD");
            mibantemp = false;
        } else {
            if (MIUSERNAME.length() == 0) {
                addActionError("Debe escribir el usuario de la BD");
                mibantemp = false;
            }
        }
        if (MIJDBC == null) {
            addActionError("Debe escribir la IP y el SID de la BD formato: jdbc:oracle:thin:@XXX.XXX.XXX.XXX:1521:SID");
            mibantemp = false;
        } else {
            if (MIJDBC.length() == 0) {
                addActionError("Debe escribir la IP y el SID de la BD formato: jdbc:oracle:thin:@XXX.XXX.XXX.XXX:1521:SID");
                mibantemp = false;
            }
        }
        if (MIPASSWORD == null) {
            addActionError("Debe escribir el PASSWORD de la BD");
            mibantemp = false;
        } else {
            if (MIPASSWORD.length() == 0) {
                addActionError("Debe escribir el PASSWORD de la BD");
                mibantemp = false;
            }
        }

        return mibantemp;

    }

    public String buscarcurps8() {//CISCAR CURP
        try {
            if (!validardatos()) {
                return "ERROR1";
            }

            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurpslist(CUANTOSR, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp3(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            ArrayList<CURPStruct> milistacurp3 = new ArrayList<CURPStruct>();
            milistacurp3 = (ArrayList<CURPStruct>) opciones.miupdatecurpslist(milistacurp2, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword

            if (milistacurp3 == null) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }

            if (milistacurp3.size() == 0) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }
            Integer miactualizacion = 0;
            boolean mibt = false;

            for (int i = 0; i < milistacurp3.size(); i++) {
                mibt = milistacurp3.get(i).getACTUALIZO();
                if (mibt) {
                    miactualizacion = miactualizacion + 1;
                }
            }

            milistacurp2 = (ArrayList<CURPStruct>) milistacurp3;

            MIINICIOC = MIINICIOC + miactualizacion;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR1";
        }
        return "SUCCESS";
    }

    public String buscarcurps8asc() {//CISCAR CURP
        try {
            if (!validardatos()) {
                return "ERROR1";
            }

            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurpslist(CUANTOSR, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp2(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            ArrayList<CURPStruct> milistacurp3 = new ArrayList<CURPStruct>();
            milistacurp3 = (ArrayList<CURPStruct>) opciones.miupdatecurpslist(milistacurp2, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword

            if (milistacurp3 == null) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }

            if (milistacurp3.size() == 0) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }
            Integer miactualizacion = 0;
            boolean mibt = false;

            for (int i = 0; i < milistacurp3.size(); i++) {
                mibt = milistacurp3.get(i).getACTUALIZO();
                if (mibt) {
                    miactualizacion = miactualizacion + 1;
                }
            }

            milistacurp2 = (ArrayList<CURPStruct>) milistacurp3;

            MIINICIOC = MIINICIOC + miactualizacion;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR1";
        }
        return "SUCCESS";
    }

    public String buscarcurps9() {//CISCAR CURP
        try {
            if (!validardatos()) {
                return "ERROR1";
            }

            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurpslistd(CUANTOSR, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp3(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            ArrayList<CURPStruct> milistacurp3 = new ArrayList<CURPStruct>();
            milistacurp3 = (ArrayList<CURPStruct>) opciones.miupdatecurpslist(milistacurp2, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword

            if (milistacurp3 == null) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }

            if (milistacurp3.size() == 0) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }
            Integer miactualizacion = 0;
            boolean mibt = false;

            for (int i = 0; i < milistacurp3.size(); i++) {
                mibt = milistacurp3.get(i).getACTUALIZO();
                if (mibt) {
                    miactualizacion = miactualizacion + 1;
                }
            }

            milistacurp2 = (ArrayList<CURPStruct>) milistacurp3;

            MIINICIOC = MIINICIOC + miactualizacion;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR1";
        }
        return "SUCCESS";
    }

    public String buscarcurps9desc() {//CISCAR CURP
        try {
            if (!validardatos()) {
                return "ERROR1";
            }

            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurpslistd(CUANTOSR, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp2(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            ArrayList<CURPStruct> milistacurp3 = new ArrayList<CURPStruct>();
            milistacurp3 = (ArrayList<CURPStruct>) opciones.miupdatecurpslist(milistacurp2, TABLAACHECAR, MIUSERNAME, MIJDBC, MIPASSWORD);//String miusername,String mijdbc, String mipassword

            if (milistacurp3 == null) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }

            if (milistacurp3.size() == 0) {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR2";
            }
            Integer miactualizacion = 0;
            boolean mibt = false;

            for (int i = 0; i < milistacurp3.size(); i++) {
                mibt = milistacurp3.get(i).getACTUALIZO();
                if (mibt) {
                    miactualizacion = miactualizacion + 1;
                }
            }

            milistacurp2 = (ArrayList<CURPStruct>) milistacurp3;

            MIINICIOC = MIINICIOC + miactualizacion;
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR1";
        }
        return "SUCCESS";
    }

    public String buscarcurps() {//CISCAR CURP
        try {
            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurps();
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            if (opciones.miupdatecurps(milistacurp2)) {

            } else {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR";
            }

            MIINICIOC = MIINICIOC + milistacurp.size();
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String buscarcurps2() {//CISCAR CURP
        try {
            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurps2(CUANTOSR);
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            if (opciones.miupdatecurps2(milistacurp2)) {
                //addActionError("Ocurrio un error al guardar CURP's " );
            } else {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR";
            }

            MIINICIOC = MIINICIOC + milistacurp.size();
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String buscarcurps3() {//CISCAR CURP
        try {
            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurps2(CUANTOSR);
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            if (opciones.miupdatecurps(milistacurp2)) {
                //addActionError("Ocurrio un error al guardar CURP's " );
            } else {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR";
            }

            MIINICIOC = MIINICIOC + milistacurp.size();
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String buscarcurps4() {//CISCAR CURP
        try {
            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurps2(CUANTOSR);
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp2(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            if (opciones.miupdatecurps(milistacurp2)) {
                //addActionError("Ocurrio un error al guardar CURP's " );
            } else {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR";
            }

            MIINICIOC = MIINICIOC + milistacurp.size();
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String buscarcurps422() {//CISCAR CURP
        try {
            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurps2(CUANTOSR);
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp2(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            if (opciones.miupdatecurps(milistacurp2)) {
                //addActionError("Ocurrio un error al guardar CURP's " );
            } else {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR";
            }

            MIINICIOC = MIINICIOC + milistacurp.size();
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String buscarcurps33() {//CISCAR CURP
        try {
            registrocurpsBusiness opciones = new registrocurpsBusiness();
            milistacurp = (ArrayList<CURPStruct>) opciones.buscarcurps();//CUANTOSR
            if (milistacurp == null) {
                return "TERMINO";
            } else {
                if (milistacurp.size() == 0) {
                    return "TERMINO";
                }
            }

            milistacurp2 = new ArrayList<CURPStruct>();
            for (int i = 0; i < milistacurp.size(); i++) {
                buscardatoscurp2(milistacurp.get(i).getCURP());
                milistacurp2.add(micurp);
            }
            if (opciones.miupdatecurps2(milistacurp2)) {
                //addActionError("Ocurrio un error al guardar CURP's " );
            } else {
                addActionError("Ocurrio un error al guardar CURP's ");
                return "ERROR";
            }

            MIINICIOC = MIINICIOC + milistacurp.size();
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String subiryobtenerarchivo() {//CISCAR CURP
        try {

            if (validararchivo()) {
                if (leerexcel()) {
                    milistacurp2 = new ArrayList<CURPStruct>();
                    for (int i = 0; i < milistacurp.size(); i++) {
                        //System.out.println();
                        buscardatoscurp(milistacurp.get(i).getCURP());
                        milistacurp2.add(micurp);
                    }
                    if (crearexcel()) {
                        return "xls";
                    } else {
                        addActionError("Ocurrio un error al tratar de crear el archivo excel ");
                        return "ERROR";
                    }
                }
            }
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return "ERROR";
        }
        return "SUCCESS";
    }

    public boolean validararchivo() {
        boolean mibanderavalidatemp = true;
        if (archiFileName != null) {

            if (!(archiFileName.contains(".xls")) && !(archiFileName.contains(".XLS"))) {
                addFieldError("archi", "Solo se admiten archivos con extensión .xls");
                mibanderavalidatemp = false;
            }
        } else {
            addFieldError("archi", "Debe seleccionar un archivo con extensión .xls");
            mibanderavalidatemp = false;
        }

        return mibanderavalidatemp;

    }

    public boolean leerexcel() throws FileNotFoundException, IOException {

        try {
            ////////////////////////////////// ////////////////////////////////

            File f = null;
            f = File.createTempFile("tmp", ".xls");
            String archivoss = f.getAbsolutePath();
            File newarch = new File(archivoss);
            //File newarch = new File(ruta+nombreparaguardar);
            FileUtils.copyFile(archi, newarch);
            f.deleteOnExit();
            ///////////////////////////////////////////////////////////////////

            FileInputStream file = new FileInputStream(new File(archivoss));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            milistacurp = new ArrayList<CURPStruct>();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell celda;
                while (cellIterator.hasNext()) {
                    celda = cellIterator.next();
                    inicializarmicurp(celda.getStringCellValue());
                }
            }
            workbook.close();
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return false;
        }
        return true;
    }

    public void inicializarmicurp(String curp) {
        if (!curp.equals("CURP")) {
            micurp = new CURPStruct();
            micurp.setCURP(curp);
            milistacurp.add((CURPStruct) micurp);
        }

    }

    public File archi;
    public String archiContentType;
    public String archiFileName;

    /**
     * @return the archi
     */
    public File getArchi() {
        return archi;
    }

    /**
     * @param archi the archi to set
     */
    public void setArchi(File archi) {
        this.archi = archi;
    }

    /**
     * @return the archiContentType
     */
    public String getArchiContentType() {
        return archiContentType;
    }

    /**
     * @param archiContentType the archiContentType to set
     */
    public void setArchiContentType(String archiContentType) {
        this.archiContentType = archiContentType;
    }

    /**
     * @return the archiFileName
     */
    public String getArchiFileName() {
        return archiFileName;
    }

    /**
     * @param archiFileName the archiFileName to set
     */
    public void setArchiFileName(String archiFileName) {
        this.archiFileName = archiFileName;
    }

    CURPSERVICE_Service service = null;
    CURPSERVICE port;
    CurpStruct personas;
    public CURPStruct personas3;

    public boolean buscardatoscurp2(String curpvalida) {//CISCAR CURP
        if (curpvalida == null) {
            micurp = new CURPStruct();
            micurp.setCURP("");
            micurp.setCURPORIGINAL(curpvalida);
            micurp.setNombres("La CURP no se encuentra en la base de datos");
            micurp.setApellido1("");
            micurp.setApellido2("");
            micurp.setSexo("");
            micurp.setFechNac("");
            micurp.setNacionalidad("");
            micurp.setCveEntidadNac("");
            micurp.setStatusCurp("");
            return true;
        }
        if (curpvalida.length() == 0) {
            micurp = new CURPStruct();
            micurp.setCURP("");
            micurp.setCURPORIGINAL(curpvalida);
            micurp.setNombres("La CURP no se encuentra en la base de datos");
            micurp.setApellido1("");
            micurp.setApellido2("");
            micurp.setSexo("");
            micurp.setFechNac("");
            micurp.setNacionalidad("");
            micurp.setCveEntidadNac("");
            micurp.setStatusCurp("");
            return true;
        }

        service = new CURPSERVICE_Service();
        port = service.getCURPSERVICEPort();
        personas = port.consultacurp(curpvalida);
        if (personas != null) {
            if (personas.getCURP() != null) {
                if (personas.getNombres().length() == 0) {
                    micurp = new CURPStruct();
                    micurp.setCURP(personas.getCURP());
                    micurp.setCURPORIGINAL(curpvalida);
                    micurp.setNombres(personas.getStatusCurp());
                    micurp.setApellido1("");
                    micurp.setApellido2("");
                    micurp.setSexo("");
                    micurp.setFechNac("");
                    micurp.setNacionalidad("");
                    micurp.setCveEntidadNac("");
                    micurp.setStatusCurp("");
                } else {
                    micurp = new CURPStruct();
                    micurp.setCURP(personas.getCURP());
                    micurp.setCURPORIGINAL(curpvalida);
                    micurp.setNombres(personas.getNombres());
                    micurp.setApellido1(personas.getApellido1());
                    micurp.setApellido2(personas.getApellido2());
                    micurp.setSexo(personas.getSexo());
                    micurp.setFechNac(personas.getFechNac());
                    micurp.setNacionalidad(personas.getNacionalidad());
                    micurp.setCveEntidadNac(personas.getCveEntidadNac());
                    micurp.setStatusCurp(personas.getStatusCurp());
                }

            } else {
                micurp = new CURPStruct();
                micurp.setCURP("");
                micurp.setCURPORIGINAL(curpvalida);
                micurp.setNombres("La CURP no se encuentra en la base de datos");
                micurp.setApellido1("");
                micurp.setApellido2("");
                micurp.setSexo("");
                micurp.setFechNac("");
                micurp.setNacionalidad("");
                micurp.setCveEntidadNac("");
                micurp.setStatusCurp("");
            }
        } else {
            micurp = new CURPStruct();
            micurp.setCURP("");
            micurp.setCURPORIGINAL(curpvalida);
            micurp.setNombres("La CURP no se encuentra en la base de datos");
            micurp.setApellido1("");
            micurp.setApellido2("");
            micurp.setSexo("");
            micurp.setFechNac("");
            micurp.setNacionalidad("");
            micurp.setCveEntidadNac("");
            micurp.setStatusCurp("");
        }
        return true;
    }

    public boolean buscardatoscurp3(String curpvalida) {//CISCAR CURP
        if (curpvalida == null) {
            micurp = new CURPStruct();
            micurp.setCURP("");
            micurp.setCURPORIGINAL(curpvalida);
            micurp.setNombres("La CURP no se encuentra en la base de datos");
            micurp.setApellido1("");
            micurp.setApellido2("");
            micurp.setSexo("");
            micurp.setFechNac("");
            micurp.setNacionalidad("");
            micurp.setCveEntidadNac("");
            micurp.setStatusCurp("");
            return true;
        }
        if (curpvalida.length() == 0) {
            micurp = new CURPStruct();
            micurp.setCURP("");
            micurp.setCURPORIGINAL(curpvalida);
            micurp.setNombres("La CURP no se encuentra en la base de datos");
            micurp.setApellido1("");
            micurp.setApellido2("");
            micurp.setSexo("");
            micurp.setFechNac("");
            micurp.setNacionalidad("");
            micurp.setCveEntidadNac("");
            micurp.setStatusCurp("");
            return true;
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        personas3 = new CURPStruct();
        buscardatoscurp(curpvalida);
        personas3 = micurp;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //service = new CURPSERVICE_Service();
        //port = service.getCURPSERVICEPort();
        //personas3 = port.consultacurp(curpvalida);
        if (personas3 != null) {
            if (personas3.getCURP() != null) {
                if (personas3.getNombres().length() == 0) {
                    micurp = new CURPStruct();
                    micurp.setCURP(personas3.getCURP());
                    micurp.setCURPORIGINAL(curpvalida);
                    micurp.setNombres(personas3.getStatusCurp());
                    micurp.setApellido1("");
                    micurp.setApellido2("");
                    micurp.setSexo("");
                    micurp.setFechNac("");
                    micurp.setNacionalidad("");
                    micurp.setCveEntidadNac("");
                    micurp.setStatusCurp("");
                } else {
                    micurp = new CURPStruct();
                    micurp.setCURP(personas3.getCURP());
                    micurp.setCURPORIGINAL(curpvalida);
                    micurp.setNombres(personas3.getNombres());
                    micurp.setApellido1(personas3.getApellido1());
                    micurp.setApellido2(personas3.getApellido2());
                    micurp.setSexo(personas3.getSexo());
                    micurp.setFechNac(personas3.getFechNac());
                    micurp.setNacionalidad(personas3.getNacionalidad());
                    micurp.setCveEntidadNac(personas3.getCveEntidadNac());
                    micurp.setStatusCurp(personas3.getStatusCurp());
                }

            } else {
                micurp = new CURPStruct();
                micurp.setCURP("");
                micurp.setCURPORIGINAL(curpvalida);
                micurp.setNombres("La CURP no se encuentra en la base de datos");
                micurp.setApellido1("");
                micurp.setApellido2("");
                micurp.setSexo("");
                micurp.setFechNac("");
                micurp.setNacionalidad("");
                micurp.setCveEntidadNac("");
                micurp.setStatusCurp("");
            }
        } else {
            micurp = new CURPStruct();
            micurp.setCURP("");
            micurp.setCURPORIGINAL(curpvalida);
            micurp.setNombres("La CURP no se encuentra en la base de datos");
            micurp.setApellido1("");
            micurp.setApellido2("");
            micurp.setSexo("");
            micurp.setFechNac("");
            micurp.setNacionalidad("");
            micurp.setCveEntidadNac("");
            micurp.setStatusCurp("");
        }
        return true;
    }

    public boolean buscardatoscurp(String curpvalida) {//CISCAR CURP
        try {
            configwebservice = new curpBean();
            configwebservice.setCURP(curpvalida);
            if (validarCURP(configwebservice.getCURP().toUpperCase())) {
                //curpBean configwebservice = new curpBean();
                micurp = new CURPStruct();
                String usuario = configwebservice.getUSUARIO();
                String password = configwebservice.getPASSWORD();
                String curp = configwebservice.getCURP();
                String ip = configwebservice.getMIIP();
                String entidademisora = obtenerestado(curp);
                Integer transaccion = configwebservice.getTRANSACCION();
                System.setProperty("javax.net.ssl.trustStore", configwebservice.getRUTAKEY());
                System.setProperty("javax.net.ssl.trustStorePassword", configwebservice.getPASSWORDKEY());

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
                QName opSetAlta = new QName(" ", "consultarPorCurp");
                Object[] altaServiceArgs = new Object[]{datos};
                Class<?>[] returnTypes = new Class[]{String.class};
                Object[] response = serviceClient.invokeBlocking(opSetAlta,
                        altaServiceArgs, returnTypes);
                String result = (String) response[0];
                if (result == null) {
                    //addActionError("NO HAY RESULTADOS EN WEB SERVICE");
                    utilidades.Constantes.enviaMensajeConsola("NO HAY RESULTADOS EN WEB SERVICE");
                    micurp = new CURPStruct();
                    micurp.setCURP(curpvalida);
                    micurp.setNombres("NO HAY RESULTADOS EN WEB SERVICE");
                    micurp.setApellido1("");
                    micurp.setApellido2("");
                    micurp.setSexo("");
                    micurp.setFechNac("");
                    micurp.setNacionalidad("");
                    micurp.setCveEntidadNac("");
                    micurp.setStatusCurp("");
                    return true;
                }
                utilidades.Constantes.enviaMensajeConsola(result);
                //addActionError("EL RESULTADO ES: "+result);
                QName optGetConfirm = new QName("http://services.wserv.ecurp.dgti.segob.gob.mx", "getConfirm");
                Object[] opGetConfirmArgs = new Object[]{getSessionID(result), "OK"};
                serviceClient.invokeRobust(optGetConfirm, opGetConfirmArgs);
                String result2 = result.replace('\"', '\'');
                micurp = (CURPStruct) interpretaCurp(result2);
                utilidades.Constantes.enviaMensajeConsola("WEB SERVICE TERMINO OK");   
                //addActionError("WEB SERVICE TERMINO OK. ");

                if (micurp != null) {
                    if (micurp.getCURP() != null) {
                        if (micurp.getCURP().length() == 0) {
                            micurp = new CURPStruct();
                            micurp.setCURP(curpvalida);
                            micurp.setNombres("La CURP no se encuentra en la base de datos");
                            micurp.setApellido1("");
                            micurp.setApellido2("");
                            micurp.setSexo("");
                            micurp.setFechNac("");
                            micurp.setNacionalidad("");
                            micurp.setCveEntidadNac("");
                            micurp.setStatusCurp("");
                        }

                    } else {
                        micurp = new CURPStruct();
                        micurp.setCURP(curpvalida);
                        micurp.setNombres("La CURP no se encuentra en la base de datos");
                        micurp.setApellido1("");
                        micurp.setApellido2("");
                        micurp.setSexo("");
                        micurp.setFechNac("");
                        micurp.setNacionalidad("");
                        micurp.setCveEntidadNac("");
                        micurp.setStatusCurp("");
                    }
                } else {
                    micurp = new CURPStruct();
                    micurp.setCURP(curpvalida);
                    micurp.setNombres("La CURP no se encuentra en la base de datos");
                    micurp.setApellido1("");
                    micurp.setApellido2("");
                    micurp.setSexo("");
                    micurp.setFechNac("");
                    micurp.setNacionalidad("");
                    micurp.setCveEntidadNac("");
                    micurp.setStatusCurp("");
                }
            } else {
                micurp = new CURPStruct();
                micurp.setCURP(curpvalida);
                micurp.setNombres("CURP no válida");
                micurp.setApellido1("");
                micurp.setApellido2("");
                micurp.setSexo("");
                micurp.setFechNac("");
                micurp.setNacionalidad("");
                micurp.setCveEntidadNac("");
                micurp.setStatusCurp("");
                //addFieldError("configwebservice.CURP",getText("CURP no valida"));
            }
        } catch (Exception e) {
            //addActionError("Ocurrio un error: "+e );
            micurp = new CURPStruct();
            micurp.setCURP(curpvalida);
            micurp.setNombres("Error al validar curp");//validar corregir solo que no se como lo manejan en la base de datos. ver con Porfirio
            micurp.setApellido1("");
            micurp.setApellido2("");
            micurp.setSexo("");
            micurp.setFechNac("");
            micurp.setNacionalidad("");
            micurp.setCveEntidadNac("");
            micurp.setStatusCurp("");
            return true;
        }
        return true;
    }

    public String obtenerestado(String curp) {
        String miestado = curp.substring(11, 13);
        miestado = miestado.toUpperCase();
        utilidades.Constantes.enviaMensajeConsola("miestado: " + miestado);
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

    public String buscardatoscurp3() {//BUSCAR CURP
        try {

            if (validarCURP(configwebservice.getCURP().toUpperCase())) {
                String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <CURPStruct statusOper=\"EXITOSO\" message=\"LA OPERACION SE EJECUTO.\" TipoError=\"\" CodigoError=\"\" SessionID=\"ExA13bA5glPEw2mTzIJmW8rm3aEUvVhJ2-yzKjeBXJaKvqavn1Nc!1543613910!1491257372729\"><CURP>EAMI840903HMCSCG03</CURP><apellido1>ESCAMILLA</apellido1><apellido2>MUCIÑO</apellido2><nombres>IGNACIO</nombres><sexo>H</sexo><fechNac>03/09/1984</fechNac><nacionalidad>MEX</nacionalidad><docProbatorio>1</docProbatorio><anioReg>9999</anioReg><foja></foja><tomo></tomo><libro>9999</libro><numActa>99999</numActa><CRIP>150180185000512</CRIP><numEntidadReg>99</numEntidadReg><cveMunicipioReg>999</cveMunicipioReg><NumRegExtranjeros></NumRegExtranjeros><FolioCarta></FolioCarta><cveEntidadNac>MC</cveEntidadNac><cveEntidadEmisora>11003</cveEntidadEmisora><statusCurp>AN</statusCurp></CURPStruct>";
                //String result2 = result.replace('\"', '\'');
                micurp = (CURPStruct) interpretaCurp(result);

                utilidades.Constantes.enviaMensajeConsola("WEB SERVICE TERMINO OK");
                addActionError("WEB SERVICE TERMINO OK. ");
            } else {
                addFieldError("configwebservice.CURP", getText("CURP no valida"));
            }
        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
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

    /**
     * @return the milistacurp
     */
    public List<CURPStruct> getMilistacurp() {
        return milistacurp;
    }

    /**
     * @param milistacurp the milistacurp to set
     */
    public void setMilistacurp(List<CURPStruct> milistacurp) {
        this.milistacurp = milistacurp;
    }

    /**
     * @return the milistacurp2
     */
    public List<CURPStruct> getMilistacurp2() {
        return milistacurp2;
    }

    /**
     * @param milistacurp2 the milistacurp2 to set
     */
    public void setMilistacurp2(List<CURPStruct> milistacurp2) {
        this.milistacurp2 = milistacurp2;
    }

    public boolean crearexcel() throws ParseException, Exception {
        return obtenerarchivoexcel();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public List encabezadosok() {
        List<CatalogosBean> listaencabezado = new ArrayList<CatalogosBean>();
        CatalogosBean encabezados = new CatalogosBean();
        encabezados.setVALOR("CURP");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Nombre(s)");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Apellido Paterno");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Apellido Materno");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Sexo");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Fecha Nacimiento");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Nacionalidad");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Clave Entidad de Nacimiento");
        listaencabezado.add((CatalogosBean) encabezados);
        encabezados = new CatalogosBean();
        encabezados.setVALOR("Estatus CURP");
        listaencabezado.add((CatalogosBean) encabezados);

        return listaencabezado;

    }

    public static HSSFWorkbook libro;

    public boolean obtenerarchivoexcel() throws FileNotFoundException, IOException, ParseException, Exception {
        //String pattern = "MM/dd/yyyy";

        try {
            Date mifech = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            //String titulohojaexcel = "CURPS";
            String titulohojaexcel = "REPORTE CURPS";
            String fechahojaexcel = format.format(mifech) + " " + formatoHora.format(mifech);
            ArrayList<CatalogosBean> listanuevosencabezados = (ArrayList<CatalogosBean>) encabezadosok();
            //public List <>  = new ArrayList<CURPStruct>(); 
            ArrayList<CURPStruct> listadatos = (ArrayList<CURPStruct>) milistacurp2;

            libro = new HSSFWorkbook();

            Sheet hoja = libro.createSheet();

            libro.setSheetName(0, titulohojaexcel);

            Row fila2 = hoja.createRow(1);

            Cell celda2 = fila2.createCell(0, HSSFCell.CELL_TYPE_STRING);
            celda2.setCellValue("RESUMEN DE RESULTADOS : " + titulohojaexcel);
            hoja.addMergedRegion(new CellRangeAddress(1, 1, 0, 10));
            CellStyle style = libro.createCellStyle();
            style.setBorderBottom(CellStyle.BORDER_THIN);
            HSSFFont font = (HSSFFont) libro.createFont();
            font.setBold(true);
            font.setFontHeightInPoints((short) 24);
            font.setColor(HSSFColor.GREEN.index);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style.setFont(font);
            celda2.setCellStyle(style);
            fila2 = hoja.createRow(2);
            celda2 = fila2.createCell(0, HSSFCell.CELL_TYPE_STRING);
            celda2.setCellValue(fechahojaexcel);
            hoja.addMergedRegion(new CellRangeAddress(2, 2, 0, 10));
            font.setFontHeightInPoints((short) 20);
            style.setFont(font);
            celda2.setCellStyle(style);
            HSSFFont headerFont = createFont(HSSFColor.WHITE.index, (short) 12, true);
            HSSFFont contentFont = createFont(HSSFColor.BLACK.index, (short) 10, false);
            HSSFCellStyle headerStyle = createStyle(headerFont, HSSFCellStyle.ALIGN_CENTER, HSSFColor.GREEN.index, true, HSSFColor.WHITE.index);
            HSSFCellStyle oddRowStyle = createStyle(contentFont, HSSFCellStyle.ALIGN_LEFT, HSSFColor.WHITE.index, true, HSSFColor.BLACK.index);
            ArrayList<String> tableHeader = new ArrayList<String>();
            for (int ii = 0; ii < listanuevosencabezados.size(); ii++) {
                tableHeader.add(listanuevosencabezados.get(ii).getVALOR());
            }
            for (int f = 0; f < listadatos.size() + 1; f++) {
                ////System.out.println("nueva fila= " +f);
                Row fila = hoja.createRow(f + 5);
                Cell celda = fila.createCell(0);
                if (f == 0) {
                    for (int ii = 0; ii < listanuevosencabezados.size(); ii++) {
                        if (ii > 0) {
                            celda = fila.createCell(ii);
                        }
                        celda.setCellValue(listanuevosencabezados.get(ii).getVALOR());
                        celda.setCellStyle(headerStyle);
                    }
                } else {
                    ///////////////////////////////////////////////////////////////////////
                    ////System.out.println(listadatos.get(f - 1).getSUBSISTEMA());
                    if (listadatos.get(f - 1).getCURP() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getCURP());
                        //celda.setCellStyle(oddRowStyle); 
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println(listadatos.get(f - 1).getMUNICIPIO());
                    celda = fila.createCell(1);
                    if (listadatos.get(f - 1).getNombres() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getNombres());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println(listadatos.get(f - 1).getCCT());
                    celda = fila.createCell(2);
                    if (listadatos.get(f - 1).getApellido1() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getApellido1());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println(listadatos.get(f - 1).getCLAVE());
                    celda = fila.createCell(3);

                    if (listadatos.get(f - 1).getApellido2() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getApellido2());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println(listadatos.get(f - 1).getNOMBRE());
                    celda = fila.createCell(4);
                    if (listadatos.get(f - 1).getSexo() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getSexo());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println(listadatos.get(f - 1).getCALLE());
                    celda = fila.createCell(5);
                    if (listadatos.get(f - 1).getFechNac() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getFechNac());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println((String) listadatos.get(f - 1).getNUMERO());
                    celda = fila.createCell(6);
                    if (listadatos.get(f - 1).getNacionalidad() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getNacionalidad());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println(listadatos.get(f - 1).getCOLONIA());
                    celda = fila.createCell(7);
                    if (listadatos.get(f - 1).getCveEntidadNac() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getCveEntidadNac());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);
                    ////System.out.println(listadatos.get(f - 1).getCP());
                    celda = fila.createCell(8);
                    if (listadatos.get(f - 1).getStatusCurp() != null) {
                        celda.setCellValue((String) listadatos.get(f - 1).getStatusCurp());
                        //celda.setCellStyle(oddRowStyle);
                    }
                    celda.setCellStyle(oddRowStyle);

                }
            }
            ////System.out.println("cinco");
            for (int i = 0; i < tableHeader.size(); i++) {
                hoja.autoSizeColumn(i);
            }
            File f = null;
            f = File.createTempFile("tmp", ".xls");
            String archivoss = f.getAbsolutePath();
            File archivoXLS2 = new File(archivoss);
            FileOutputStream archivo2 = new FileOutputStream(archivoXLS2);
            //out.writeTo(archivoss);
            libro.write(archivo2);
            f.deleteOnExit();
            archivo2.close();
            File file = new File(archivoss);
            this.setPdf(new FileInputStream(file));
            this.setContentLength(file.length());
            this.setContentName("copia.xls");
            ////System.out.println("seis");
            return true;

        } catch (Exception e) {
            addActionError("Ocurrio un error: " + e);
            return false;
        }

    }

    private static HSSFFont createFont(short fontColor, short fontHeight, boolean fontBold) {
        //////System.out.println("uno623");
        HSSFFont font = getLibro().createFont();
        //////System.out.println("uno6123423");
        font.setBold(fontBold);
        //////System.out.println("uno62ggg3");
        font.setColor(fontColor);
        //////System.out.println("uno6hhhh23");
        font.setFontName("Arial");
        //////System.out.println("uno6eeeee23");
        font.setFontHeightInPoints(fontHeight);
        //////System.out.println("uno6aaaaaaaaaaa23");

        return font;
    }

    private static HSSFCellStyle createStyle(HSSFFont font, short cellAlign, short cellColor, boolean cellBorder, short cellBorderColor) {

        HSSFCellStyle style = getLibro().createCellStyle();
        style.setFont(font);
        style.setAlignment(cellAlign);
        style.setFillForegroundColor(cellColor);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        if (cellBorder) {
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);

            style.setTopBorderColor(cellBorderColor);
            style.setLeftBorderColor(cellBorderColor);
            style.setRightBorderColor(cellBorderColor);
            style.setBottomBorderColor(cellBorderColor);
        }

        return style;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    public long contentLength;
    public String contentName;
    public InputStream pdf = null;

    public InputStream getPdf() {
        return this.pdf;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentName() {
        return this.contentName;
    }

    /**
     * @param contentLength the contentLength to set
     */
    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    /**
     * @param contentName the contentName to set
     */
    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    /**
     * @param pdf the pdf to set
     */
    public void setPdf(InputStream pdf) {
        this.pdf = pdf;
    }

    /**
     * @return the libro
     */
    public static HSSFWorkbook getLibro() {
        return libro;
    }

    /**
     * @param aLibro the libro to set
     */
    public static void setLibro(HSSFWorkbook aLibro) {
        libro = aLibro;
    }

    /**
     * @return the MIINICIOC
     */
    public Integer getMIINICIOC() {
        return MIINICIOC;
    }

    /**
     * @param MIINICIOC the MIINICIOC to set
     */
    public void setMIINICIOC(Integer MIINICIOC) {
        this.MIINICIOC = MIINICIOC;
    }

    /**
     * @return the CUANTOSR
     */
    public Integer getCUANTOSR() {
        return CUANTOSR;
    }

    /**
     * @param CUANTOSR the CUANTOSR to set
     */
    public void setCUANTOSR(Integer CUANTOSR) {
        this.CUANTOSR = CUANTOSR;
    }

    /**
     * @return the TABLAACHECAR
     */
    public String getTABLAACHECAR() {
        return TABLAACHECAR;
    }

    /**
     * @param TABLAACHECAR the TABLAACHECAR to set
     */
    public void setTABLAACHECAR(String TABLAACHECAR) {
        this.TABLAACHECAR = TABLAACHECAR;
    }

    /**
     * @return the MIUSERNAME
     */
    public String getMIUSERNAME() {
        return MIUSERNAME;
    }

    /**
     * @param MIUSERNAME the MIUSERNAME to set
     */
    public void setMIUSERNAME(String MIUSERNAME) {
        this.MIUSERNAME = MIUSERNAME;
    }

    /**
     * @return the MIJDBC
     */
    public String getMIJDBC() {
        return MIJDBC;
    }

    /**
     * @param MIJDBC the MIJDBC to set
     */
    public void setMIJDBC(String MIJDBC) {
        this.MIJDBC = MIJDBC;
    }

    /**
     * @return the MIPASSWORD
     */
    public String getMIPASSWORD() {
        return MIPASSWORD;
    }

    /**
     * @param MIPASSWORD the MIPASSWORD to set
     */
    public void setMIPASSWORD(String MIPASSWORD) {
        this.MIPASSWORD = MIPASSWORD;
    }

    /**
     * @return the personas3
     */
    public CURPStruct getPersonas3() {
        return personas3;
    }

    /**
     * @param personas3 the personas3 to set
     */
    public void setPersonas3(CURPStruct personas3) {
        this.personas3 = personas3;
    }

}
