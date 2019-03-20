/**
 *
 * @author Esteban
 */

package daos;


import beans.CURPStruct;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public interface curpDAO {
    public Connection crearConexion() throws Exception;
    public Statement crearStatement(Connection cone) throws Exception ;
    public List buscarcurps() throws Exception;
    public List buscarcurps2(Integer cuantos) throws Exception;
    public List buscarcurps2(Integer cuantos,String tabla) throws Exception;
    
    public List buscarcurpslist(Integer cuantos,String tabla,String miusername,String mijdbc, String mipassword) throws Exception;
    public List buscarcurpslistd(Integer cuantos,String tabla,String miusername,String mijdbc, String mipassword) throws Exception;
    public boolean updatecurps (Connection conn, PreparedStatement stat,CURPStruct miobjetocurp )throws Exception;
    public boolean miupdatecurps(List <CURPStruct> milistaaguardar) throws Exception;
    public List miupdatecurpslist(List <CURPStruct> milistaaguardar,String tabla,String miusername,String mijdbc, String mipassword) throws Exception;
    //public List miupdatecurpslistd(List <CURPStruct> milistaaguardar,String tabla,String miusername,String mijdbc, String mipassword) throws Exception;
    public boolean miupdatecurps2(List <CURPStruct> milistaaguardar) throws Exception;
    public boolean updatecurpsnew (CURPStruct miobjetocurp )throws Exception;
    
}