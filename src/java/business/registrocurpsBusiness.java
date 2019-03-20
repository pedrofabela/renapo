

package business;



import beans.CURPStruct;
import daos.curpDAO;
import daos.curpDAOImpl;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;




public class registrocurpsBusiness {
    
    private  curpDAO accUsrDAO;

    public registrocurpsBusiness() throws Exception{
        this.accUsrDAO = new curpDAOImpl();
    }
	
  
    public List buscarcurps() throws Exception{
        List lista = this.accUsrDAO.buscarcurps();
        return lista;
    }
    
    public List buscarcurps2(Integer cuantos) throws Exception{
        List lista = this.accUsrDAO.buscarcurps2(cuantos);
        return lista;
    }
    
    public List buscarcurps3(Integer cuantos) throws Exception{
        List lista = this.accUsrDAO.buscarcurps2(cuantos);
        return lista;
    }
    
    public List buscarcurpslist(Integer cuantos,String tabla,String miusername,String mijdbc, String mipassword) throws Exception{
        List lista = this.accUsrDAO.buscarcurpslist(cuantos,tabla, miusername, mijdbc, mipassword);
        return lista;
    }
    
    public List buscarcurpslistd(Integer cuantos,String tabla,String miusername,String mijdbc, String mipassword) throws Exception{
        List lista = this.accUsrDAO.buscarcurpslistd(cuantos,tabla, miusername, mijdbc, mipassword);
        return lista;
    }
    
    public boolean miupdatecurps(List <CURPStruct> milistaaguardar) throws Exception{
        return this.accUsrDAO.miupdatecurps(milistaaguardar);
    }
    
    public List miupdatecurpslist(List <CURPStruct> milistaaguardar,String tabla,String miusername,String mijdbc, String mipassword) throws Exception{
        return this.accUsrDAO.miupdatecurpslist(milistaaguardar,tabla,miusername,mijdbc, mipassword);
    }
    
   
    
    public boolean miupdatecurps2(List <CURPStruct> milistaaguardar) throws Exception{
        return this.accUsrDAO.miupdatecurps2(milistaaguardar);
    }
    
   
}