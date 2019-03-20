package daos;

import daos.DAOFactory;
import daos.OracleDAOFactory;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.InputStream;
import java.sql.DriverManager;

import javax.sql.DataSource;
//import oracle.jdbc.rowset.OracleCachedRowSet;


import mappers.Mapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;


public class miOracleDAOFactory extends OracleDAOFactory implements DAOFactory {
    public List<Object> queryForList(Connection connmultiple, Statement statmultiple,final String sql, final Mapper m) throws Exception {
		List<Object> list = new ArrayList<Object>();
		try{
			//this.createStatement();
                        ////System.outprintln("entre a miquery");
			ResultSet rs = statmultiple.executeQuery(sql);
                        ////System.outprintln("execute a miquery");
			while(rs.next()){
				list.add(m.mapRow(rs));
			}
                        ////System.outprintln("sali a miquery");
			//rs.close();
		}finally{
			//this.closeConnection();
		}
		
		return list;
    }
    
    
    
    
    public Object queryForObject(Connection connmultiple, Statement statmultiple,final String sql, final Mapper m) throws Exception {
		Object retorno = null;
		try {
			//this.createStatement();
            ResultSet rs = statmultiple.executeQuery(sql);
            if ( rs.next()){            
               retorno = m.mapRow(rs);
            }
		} finally {
			//this.closeConnection();
		} 
        return retorno;
    }
	
    public String queryStringUnCampo(Connection connmultiple,Statement statmultiple,String sql) throws Exception {
        String cad="";
        try {
            ResultSet rs = statmultiple.executeQuery(sql);
            if(rs.next()){
            	cad = rs.getString(1);
            }
        } finally {
        	
        }
        return cad;
    }

        public boolean modificar(Connection connmultiple,Statement statmultiple, String sql)throws Exception{
                Integer registroInsertado = 0;
		try {
			registroInsertado=statmultiple.executeUpdate(sql);
		}
		catch(SQLException e){
			//System.outprintln(e);
                        return false;
		} catch (Exception e) {
			//System.outprintln(e);
                        return false;
		}
		finally {

		}
                if (registroInsertado == 1){
                    return true;
                }else{
                    return false;
                }
	}
        
        
        
    
    
}

