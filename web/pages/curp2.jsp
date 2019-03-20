<%-- 
    Document   : inicio
    Created on : 10-ago-2016, 11:00:53
    Author     : DESARROLLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CURP 2</title>
        <s:include value="formarpagina/archivos_css.jsp"/>       
        <s:include value="formarpagina/acciones.jsp"/>   
        <script type="text/javascript">
            function guardarTabla(accion, apoyo){
                document.peticion.IDREGISTRO.value = apoyo;
                document.peticion.action = accion;
                document.peticion.submit();
            }
        </script>        
    </head>
    <body>
        <s:include value="formarpagina/encabezado.jsp"/>
        <s:form name="peticion" id="peticion" enctype="multipart/form-data" >
        
        <center>
            <h1 class="encSup">CURP</h1>
        </center>
        <s:include value="formarpagina/fechasola.jsp"/>
        <table width="100%" class="FormS" align="center">
                     
            
            <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>  

                <tr>
                    <td align="center" colspan="10" class="subtituloG">DATOS
                        
                    </td>
                </tr>
                <tr></tr><tr></tr><tr></tr><tr></tr>
                <tr>
                    <td align="left" width="316px"/></td>
                    <td align="left" width="316px"></td>
                    <td align="left" width="316px"></td>
                </tr>
                <tr></tr><tr></tr><tr></tr><tr></tr> 
                <tr>
                    <td align="left">SUBIR ARCHIVO CON CURPS (FORMATO .xls)</td>
                </tr>
                    <tr align="left">
                        <td align="center" colspan="2">
                            <div class="form-group <s:if test='hasFieldErrors().containsKey(archi)'>has-error</s:if>">                 
                        <s:file style="width:98%" name="archi" id="archi" accept="application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel">ARCHIVO: </s:file>
                                <s:fielderror fieldName="archi" cssClass="help-block" cssStyle="color:red"/>                       
                            </div>   
                        </td>
                        <td align="left">
                            <a href="Javascript:opcionde('subiryobtenerarchivo')">
                                <img name="BUSCAR" alt="BUSCAR" src="<s:property value="@utilidades.Constantes@rutaEstilos"/>images/botonBuscar.png"/>  
                            </a>
                        </td>    
                    </tr>        
                          
                
                 <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>  
         
            
                
        </table>
            <div class="Error" align="center">
                <s:actionerror cssStyle="color:red"/>
                
            </div>


<!--------------------------------------------->
 <s:include value="formarpagina/piepagina.jsp"/>
</s:form>
</body>
</html>







          
     




