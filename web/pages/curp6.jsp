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
        <title>CURP 2 con update junto</title>
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
        <s:hidden name="MIINICIOC" value="%{MIINICIOC}"> </s:hidden>
        <center>
            <h1 class="encSup">CURP4</h1>
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
                    <td align="left">EMPEZAR A BUSCAR CURP's</td>
                </tr>
                <td align="right" colspan="2">
                            <s:textfield maxlength="2" style="width:30%;" id="CUANTOSR" name="CUANTOSR" onpaste="return true;" autocomplete="off" onkeypress="return validarNum(event)">Núm. Registros a validar(*) </s:textfield>
                    </td>        
                
                <td align="center" colspan="1">
                            <a href="Javascript:opcionde('buscarcurps4')">
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







          
     




