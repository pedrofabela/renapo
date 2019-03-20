<%-- 
    Document   : inicio
    Created on : 10-ago-2016, 11:00:53
    Author     : DESARROLLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>prueba CURP</title>
        <s:include value="formarpagina/archivos_css.jsp"/>       
        <s:include value="formarpagina/acciones.jsp"/>        
    </head>
    <body onload="opcionde('miinicio2')">
         <s:form name="peticion" id="peticion" method="POST" enctype="multipart/form-data">             
           <table width="100%" align="center">
                    <tr>
                        <td width="17%"></td>
                        <td width="18%"></td>
                        <td width="65%"></td>
                    </tr>
                        <td colspan="3">
                        </td>
                    </tr>                
           </table>
        </s:form>    
    </body>
</html>

          
     




