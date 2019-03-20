
package daos;


import beans.CURPStruct;
import daos.OracleDAOFactory;
import daos.curpDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mappers.CurpsMapper;
;

import utilidades.Constantes;
import utilidades.ObjPrepareStatement;


public class curpDAOImpl extends OracleDAOFactory implements curpDAO {

		OracleDAOFactory oraDaoFac = new OracleDAOFactory();
                miOracleDAOFactory oraDaoFac2 = new miOracleDAOFactory();
    	
    
    public List buscarcurps() throws Exception{
    	 //String query = "SELECT UNO.IDAPOYO,UNO.SECCION,UNO.DISTRITO,DOS.NOMBRE AS REGION, UNO.CCT,UNO.CANTIDAD,UNO.IMPORTE,UNO.NOBENEFICIARIOS,UNO.FECHAPROGENTREGA,UNO.ENTREGADOS,UNO.ULTIMAFECHADEENTREGA,UNO.PENDIENTESPORENTREGAR,UNO.CONCEPTO,CUATRO.DESCRIPCION AS MUNICIPIO FROM "+Constantes.TBL_APOYOS+" UNO LEFT JOIN "+Constantes.TBL_REGION+" DOS ON UNO.REGION=DOS.NOREGION LEFT JOIN "+Constantes.TBL_ESCUELAS+" TRES ON TRES.CCT = UNO.CCT LEFT JOIN "+Constantes.TBL_MUNICIPIOS+" CUATRO ON CUATRO.CVEMUNICIPIO=TRES.MUNICIPIO WHERE UNO.CONCEPTO = '"+plan+"' order by UNO.IDAPOYO";
    	 String query = "SELECT UNO.CURP FROM "+Constantes.TBL_CURPS+" UNO WHERE UNO.NOMBRES is null and rownum > 0 AND rownum <= 50";
         
         Constantes.enviaMensajeConsola("QueryConsultabuscarcurps---> " + query);
		 List list = null;
		 list = oraDaoFac.queryForList(query, new CurpsMapper());
		 return list;
    }
    
    public List buscarcurps2(Integer cuantos) throws Exception{
    	 //String query = "SELECT UNO.IDAPOYO,UNO.SECCION,UNO.DISTRITO,DOS.NOMBRE AS REGION, UNO.CCT,UNO.CANTIDAD,UNO.IMPORTE,UNO.NOBENEFICIARIOS,UNO.FECHAPROGENTREGA,UNO.ENTREGADOS,UNO.ULTIMAFECHADEENTREGA,UNO.PENDIENTESPORENTREGAR,UNO.CONCEPTO,CUATRO.DESCRIPCION AS MUNICIPIO FROM "+Constantes.TBL_APOYOS+" UNO LEFT JOIN "+Constantes.TBL_REGION+" DOS ON UNO.REGION=DOS.NOREGION LEFT JOIN "+Constantes.TBL_ESCUELAS+" TRES ON TRES.CCT = UNO.CCT LEFT JOIN "+Constantes.TBL_MUNICIPIOS+" CUATRO ON CUATRO.CVEMUNICIPIO=TRES.MUNICIPIO WHERE UNO.CONCEPTO = '"+plan+"' order by UNO.IDAPOYO";
    	 //String query = "SELECT UNO.CURP FROM "+Constantes.TBL_CURPS+" UNO WHERE UNO.NOMBRES is null and rownum > 0 AND rownum <= "+cuantos +" order by UNO.CURP desc";
          
                  
         String query = "SELECT UNO.CURP FROM (SELECT DOS.CURP FROM "+Constantes.TBL_CURPS+" DOS WHERE DOS.NOMBRES is null ORDER BY DOS.CURP DESC) UNO WHERE rownum > 0 AND rownum <= "+cuantos;
                
                  
         Constantes.enviaMensajeConsola("QueryConsultabuscarcurps---> " + query);
		 List list = null;
		 list = oraDaoFac.queryForList(query, new CurpsMapper());
		 return list;
    }
    
     public List buscarcurps2(Integer cuantos,String tabla) throws Exception{
    	 //String query = "SELECT UNO.IDAPOYO,UNO.SECCION,UNO.DISTRITO,DOS.NOMBRE AS REGION, UNO.CCT,UNO.CANTIDAD,UNO.IMPORTE,UNO.NOBENEFICIARIOS,UNO.FECHAPROGENTREGA,UNO.ENTREGADOS,UNO.ULTIMAFECHADEENTREGA,UNO.PENDIENTESPORENTREGAR,UNO.CONCEPTO,CUATRO.DESCRIPCION AS MUNICIPIO FROM "+Constantes.TBL_APOYOS+" UNO LEFT JOIN "+Constantes.TBL_REGION+" DOS ON UNO.REGION=DOS.NOREGION LEFT JOIN "+Constantes.TBL_ESCUELAS+" TRES ON TRES.CCT = UNO.CCT LEFT JOIN "+Constantes.TBL_MUNICIPIOS+" CUATRO ON CUATRO.CVEMUNICIPIO=TRES.MUNICIPIO WHERE UNO.CONCEPTO = '"+plan+"' order by UNO.IDAPOYO";
    	 //String query = "SELECT UNO.CURP FROM "+Constantes.TBL_CURPS+" UNO WHERE UNO.NOMBRES is null and rownum > 0 AND rownum <= "+cuantos +" order by UNO.CURP desc";
          
                  
         String query = "SELECT UNO.CURP FROM (SELECT DOS.CURP FROM "+utilidades.Constantes.TBL_CURPS+" DOS WHERE DOS.NOMBRES is null ORDER BY DOS.CURP DESC) UNO WHERE rownum > 0 AND rownum <= "+cuantos;
                
                  
         Constantes.enviaMensajeConsola("QueryConsultabuscarcurps---> " + query);
		 List list = null;
		 list = oraDaoFac.queryForList(query, new CurpsMapper());
		 return list;
    }
     
      public List buscarcurpslist(Integer cuantos,String tabla,String miusername,String mijdbc, String mipassword) throws Exception{
    	 //String query = "SELECT UNO.IDAPOYO,UNO.SECCION,UNO.DISTRITO,DOS.NOMBRE AS REGION, UNO.CCT,UNO.CANTIDAD,UNO.IMPORTE,UNO.NOBENEFICIARIOS,UNO.FECHAPROGENTREGA,UNO.ENTREGADOS,UNO.ULTIMAFECHADEENTREGA,UNO.PENDIENTESPORENTREGAR,UNO.CONCEPTO,CUATRO.DESCRIPCION AS MUNICIPIO FROM "+Constantes.TBL_APOYOS+" UNO LEFT JOIN "+Constantes.TBL_REGION+" DOS ON UNO.REGION=DOS.NOREGION LEFT JOIN "+Constantes.TBL_ESCUELAS+" TRES ON TRES.CCT = UNO.CCT LEFT JOIN "+Constantes.TBL_MUNICIPIOS+" CUATRO ON CUATRO.CVEMUNICIPIO=TRES.MUNICIPIO WHERE UNO.CONCEPTO = '"+plan+"' order by UNO.IDAPOYO";
    	 //String query = "SELECT UNO.CURP FROM "+Constantes.TBL_CURPS+" UNO WHERE UNO.NOMBRES is null and rownum > 0 AND rownum <= "+cuantos +" order by UNO.CURP desc";
          
                  
         String query = "SELECT UNO.CURP FROM (SELECT DOS.CURP FROM "+tabla+" DOS WHERE DOS.NOMBRES is null ORDER BY DOS.CURP ASC) UNO WHERE rownum > 0 AND rownum <= "+cuantos;
                
                  
         Constantes.enviaMensajeConsola("QueryConsultabuscarcurps---> " + query);
		 List list = null;
		 list = oraDaoFac.queryForList(query, new CurpsMapper(),miusername,mijdbc,mipassword);
		 return list;
    }
      
      
       public List buscarcurpslistd(Integer cuantos,String tabla,String miusername,String mijdbc, String mipassword) throws Exception{
    	 //String query = "SELECT UNO.IDAPOYO,UNO.SECCION,UNO.DISTRITO,DOS.NOMBRE AS REGION, UNO.CCT,UNO.CANTIDAD,UNO.IMPORTE,UNO.NOBENEFICIARIOS,UNO.FECHAPROGENTREGA,UNO.ENTREGADOS,UNO.ULTIMAFECHADEENTREGA,UNO.PENDIENTESPORENTREGAR,UNO.CONCEPTO,CUATRO.DESCRIPCION AS MUNICIPIO FROM "+Constantes.TBL_APOYOS+" UNO LEFT JOIN "+Constantes.TBL_REGION+" DOS ON UNO.REGION=DOS.NOREGION LEFT JOIN "+Constantes.TBL_ESCUELAS+" TRES ON TRES.CCT = UNO.CCT LEFT JOIN "+Constantes.TBL_MUNICIPIOS+" CUATRO ON CUATRO.CVEMUNICIPIO=TRES.MUNICIPIO WHERE UNO.CONCEPTO = '"+plan+"' order by UNO.IDAPOYO";
    	 //String query = "SELECT UNO.CURP FROM "+Constantes.TBL_CURPS+" UNO WHERE UNO.NOMBRES is null and rownum > 0 AND rownum <= "+cuantos +" order by UNO.CURP desc";
          
                  
         String query = "SELECT UNO.CURP FROM (SELECT DOS.CURP FROM "+tabla+" DOS WHERE DOS.NOMBRES is null ORDER BY DOS.CURP DESC) UNO WHERE rownum > 0 AND rownum <= "+cuantos;
                
                  
         Constantes.enviaMensajeConsola("QueryConsultabuscarcurps---> " + query);
		 List list = null;
		 list = oraDaoFac.queryForList(query, new CurpsMapper(),miusername,mijdbc,mipassword);
		 return list;
    }
    
    
    public boolean miupdatecurps(List <CURPStruct> milistaaguardar) throws Exception{
        
        abreConexion();
        
        
        for (int i=0;i<milistaaguardar.size();i++){
            updatecurps (conecta, objPreConexion,milistaaguardar.get(i) );  
            //System.out.println("i="+i+" milistacurp: ");
        }
        cierraConexiones();
        
        return true;
    }
    
    
    public List miupdatecurpslist(List <CURPStruct> milistaaguardar,String tabla,String miusername,String mijdbc, String mipassword) throws Exception{
        
        abreConexionlist(miusername,mijdbc,mipassword);
        
        boolean seactualizo = false;
        for (int i=0;i<milistaaguardar.size();i++){
            seactualizo = updatecurpslist (conecta, objPreConexion,milistaaguardar.get(i),tabla );  
            milistaaguardar.get(i).setACTUALIZO(seactualizo);
            //System.out.println("i="+i+" milistacurp: ");
        }
        cierraConexiones();
        
        return milistaaguardar;
    }
    
    
    
    
    
    
    
    public boolean miupdatecurps2(List <CURPStruct> milistaaguardar) throws Exception{
        
        //abreConexion();
        
        
        for (int i=0;i<milistaaguardar.size();i++){
            updatecurpsnew (milistaaguardar.get(i) );
            for(int q=0;q<1000000000;q++); 
        }
        //cierraConexiones();
        
        return true;
    }
    
    public boolean updatecurpslist (Connection conn, PreparedStatement stat,CURPStruct miobjetocurp,String tabla)throws Exception{
         ArrayList<ObjPrepareStatement> arregloCampos =  new ArrayList<ObjPrepareStatement>();
         ObjPrepareStatement temporal;
         //System.out.println("cur:"+miobjetocurp.getCURP());
      	 //Constantes.enviaMensajeConsola("Entre al DAO GUARDAcurp......");
        temporal = new ObjPrepareStatement("NOMBRES", "STRING", miobjetocurp.getNombres());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDO_PATERNO", "STRING", miobjetocurp.getApellido1());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDO_MATERNO", "STRING", miobjetocurp.getApellido2());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SEXO", "STRING", miobjetocurp.getSexo());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_NACIMIENTO", "STRING", miobjetocurp.getFechNac());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NACIONALIDAD", "STRING", miobjetocurp.getNacionalidad());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CLAVE", "STRING", miobjetocurp.getCveEntidadNac());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUSCURP", "STRING", miobjetocurp.getStatusCurp());
        arregloCampos.add(temporal);
        String id="";
        if (miobjetocurp.getCURP()==null){
            id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
        }else{
             if (miobjetocurp.getCURP().length()==0){
                id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
            }else{
                 if (miobjetocurp.getCURP().equals(miobjetocurp.getCURPORIGINAL())){
                     id = " where CURP='"+miobjetocurp.getCURP()+"'";
                 }else{
                     temporal = new ObjPrepareStatement("CURP_RENAPO", "STRING", miobjetocurp.getCURP());
                     arregloCampos.add(temporal);
                     id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
                 }
                 
            }
        }
        return oraDaoFac.queryUpdateTransaccion(conn,stat,tabla, arregloCampos, id);
    }
    
    
    
    
    
    
    
    
    public boolean updatecurps (Connection conn, PreparedStatement stat,CURPStruct miobjetocurp )throws Exception{
         ArrayList<ObjPrepareStatement> arregloCampos =  new ArrayList<ObjPrepareStatement>();
         ObjPrepareStatement temporal;
         //System.out.println("cur:"+miobjetocurp.getCURP());
      	 //Constantes.enviaMensajeConsola("Entre al DAO GUARDAcurp......");
        temporal = new ObjPrepareStatement("NOMBRES", "STRING", miobjetocurp.getNombres());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDO_PATERNO", "STRING", miobjetocurp.getApellido1());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDO_MATERNO", "STRING", miobjetocurp.getApellido2());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SEXO", "STRING", miobjetocurp.getSexo());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_NACIMIENTO", "STRING", miobjetocurp.getFechNac());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NACIONALIDAD", "STRING", miobjetocurp.getNacionalidad());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CLAVE", "STRING", miobjetocurp.getCveEntidadNac());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUSCURP", "STRING", miobjetocurp.getStatusCurp());
        arregloCampos.add(temporal);
        String id="";
        if (miobjetocurp.getCURP()==null){
            id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
        }else{
             if (miobjetocurp.getCURP().length()==0){
                id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
            }else{
                 if (miobjetocurp.getCURP().equals(miobjetocurp.getCURPORIGINAL())){
                     id = " where CURP='"+miobjetocurp.getCURP()+"'";
                 }else{
                     temporal = new ObjPrepareStatement("CURP_RENAPO", "STRING", miobjetocurp.getCURP());
                     arregloCampos.add(temporal);
                     id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
                 }
                 
            }
        }
        return oraDaoFac.queryUpdateTransaccion(conn,stat,Constantes.TBL_CURPS, arregloCampos, id);
    }
    
    
    public boolean updatecurpsnew (CURPStruct miobjetocurp )throws Exception{
         ArrayList<ObjPrepareStatement> arregloCampos =  new ArrayList<ObjPrepareStatement>();
         ObjPrepareStatement temporal;
      	 //Constantes.enviaMensajeConsola("Entre al DAO GUARDAcurp......");
        temporal = new ObjPrepareStatement("NOMBRES", "STRING", miobjetocurp.getNombres());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDO_PATERNO", "STRING", miobjetocurp.getApellido1());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("APELLIDO_MATERNO", "STRING", miobjetocurp.getApellido2());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SEXO", "STRING", miobjetocurp.getSexo());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_NACIMIENTO", "STRING", miobjetocurp.getFechNac());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NACIONALIDAD", "STRING", miobjetocurp.getNacionalidad());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CLAVE", "STRING", miobjetocurp.getCveEntidadNac());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUSCURP", "STRING", miobjetocurp.getStatusCurp());
        arregloCampos.add(temporal);
        String id="";
        if (miobjetocurp.getCURP()==null){
            id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
        }else{
             if (miobjetocurp.getCURP().length()==0){
                id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
            }else{
                 if (miobjetocurp.getCURP().equals(miobjetocurp.getCURPORIGINAL())){
                     id = " where CURP='"+miobjetocurp.getCURP()+"'";
                 }else{
                     temporal = new ObjPrepareStatement("CURP_RENAPO", "STRING", miobjetocurp.getCURP());
                     arregloCampos.add(temporal);
                     id = " where CURP='"+miobjetocurp.getCURPORIGINAL()+"'";
                 }
                 
            }
        }

        //String id = " where CURP='"+miobjetocurp.getCURP()+"'";
        return oraDaoFac.queryUpdate(Constantes.TBL_CURPS, arregloCampos, id);
    }
    
    
    
    Statement objConexion;
    PreparedStatement objPreConexion;
    Connection conecta;
    
    
    //******************** ABRE CONEXION PARA LSITAS
    private void abreConexion() {
        try {
            conecta = crearConexion();
            objConexion= crearStatement(conecta);
        }
        catch (Exception e) {
            e.printStackTrace();
            //addActionError("Ocurrio un error al abrin conexiones: "+e );
        }
    }
    
    
    //******************** CREA CONEXION PARA LSITAS
    public Connection crearConexion() throws Exception {
        Connection conne;
        conne = createConnection();
        Constantes.enviaMensajeConsola("conexion abierta.........");
        return conne;
    }
    
    
    //******************** creando statement
    public Statement crearStatement(Connection cone) throws Exception {
        Statement stei; 
        stei = createStatement2(cone);
        return stei;
    }  
    
    
     //******************** ABRE CONEXION PARA LSITAS
    private void abreConexionlist(String miusername,String mijdbc, String mipassword) {
        try {
            conecta = crearConexionlist(miusername,mijdbc,mipassword);
            objConexion= crearStatement(conecta);
        }
        catch (Exception e) {
            e.printStackTrace();
            //addActionError("Ocurrio un error al abrin conexiones: "+e );
        }
    }
    
    
    //******************** CREA CONEXION PARA LSITAS
    public Connection crearConexionlist(String miusername,String mijdbc, String mipassword) throws Exception {
        Connection conne;
        conne = createConnectionlist(miusername,mijdbc,mipassword);
        Constantes.enviaMensajeConsola("conexion abierta.........");
        return conne;
    }
    
    
   
    //******************** CIERRA CONEXION PARA LSITAS
    private void cierraConexiones() {
        try {
            conecta.close();
            objConexion.close();            
            //objPreConexion.close();
            //Constantes.enviaMensajeConsola("------CIERRA LA CONNNN---------------");
        }
        catch (Exception e) {
            e.printStackTrace();
            //addActionError("Ocurrio un error al cerrar conexiones: "+e );
        }
    }
    
    
    
}