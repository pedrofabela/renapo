package mappers;

import beans.CURPStruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import mappers.Mapper;



public class CurpsMapper implements Mapper {
	
	public Object mapRow(ResultSet rs) throws SQLException {
		CURPStruct catalogo = new CURPStruct();
                if (rs.getString("CURP")!=null)
                {
                  if (rs.getString("CURP").length()==0)
                  {  
                      catalogo.setCURP(rs.getString(""));
                  }else{
                      catalogo.setCURP(rs.getString("CURP").trim());
                  }   
                }else{
                    catalogo.setCURP(rs.getString(""));
                }    
		
		catalogo.setApellido1("");
                catalogo.setApellido2("");
                catalogo.setSexo("");
                catalogo.setFechNac("");
                catalogo.setNacionalidad("");
                catalogo.setCveEntidadNac("");
                catalogo.setStatusCurp("");
		return catalogo;
	}	

}


