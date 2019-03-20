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
        <title>PRUEBA CURP</title>
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
                    <td align="left" >
                        <div class="form-group <s:if test='hasFieldErrors().containsKey(configwebservice.CURP)'>has-error</s:if>">                 
                            <s:fielderror fieldName="configwebservice.CURP" cssClass="help-block" cssStyle="color:red"/>                      
                        </div> 
                    </td>
                </tr>
                <tr>
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.CURP" id="configwebservice.CURP" style="width:100%;" maxlength="18" onkeypress = "return validarLn2(event)">CURP: </s:textfield>
                    </td>
                </tr> 
                <tr>
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.USUARIO" id="configwebservice.USUARIO" style="width:100%;" maxlength="100" onkeypress = "return validarLn2(event)">DATO U: </s:textfield>
                    </td>
                </tr> 
                <tr>
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.PASSWORD" id="configwebservice.PASSWORD" style="width:100%;" maxlength="100" onkeypress = "return validarLn2(event)">DATO P: </s:textfield>
                    </td>
                </tr>  
                <tr style="display: none;">
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.TRANSACCION" id="configwebservice.TRANSACCION" style="width:100%;" maxlength="100" onkeypress = "return validarLn2(event)">TRANSACCION: </s:textfield>
                    </td>
                </tr>    
                <tr style="display: none;">
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.RUTAKEY" id="configwebservice.RUTAKEY" style="width:100%;" maxlength="100" onkeypress = "return validarLn(event)">RUTA .CER: </s:textfield>
                    </td>
                </tr>
                <tr style="display: none;">
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.PASSWORDKEY" id="configwebservice.PASSWORDKEY" style="width:100%;" maxlength="100" onkeypress = "return validarLn(event)">CADENA .CER: </s:textfield>
                    </td>
                </tr>   
                <tr>
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.ENDPOINTREFERENCE" id="configwebservice.ENDPOINTREFERENCE" style="width:100%;" maxlength="100" onkeypress = "return validarLn(event)">ENDPOINTREFERENCE: </s:textfield>
                    </td>
                </tr> 
                <tr>
                    <td align="left" colspan="3">
                        <s:textfield cssClass="estTF" name="configwebservice.MIIP" id="configwebservice.MIIP" style="width:100%;" maxlength="18" onkeypress = "return validarLn2(event)">IP: </s:textfield>
                    </td>
                </tr>    
                <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>  
               
                <tr></tr><tr></tr><tr></tr><tr></tr>
               
                <tr>    
                    <td colspan="3">
                        <a href="Javascript:opcionde('buscardatoscurp')">
                            <img name="BUSCAR" alt="BUSCAR" src="<s:property value="@utilidades.Constantes@rutaEstilos"/>images/botonBuscar.png"/>  
                        </a>
                    </td>
                </tr>
                        
                <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr> 
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">CURP:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.CURP" /></u>
                    </td>
                </tr>  
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">NOMBRE:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.nombres" /></u>
                    </td>
                </tr>   
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">APELLIDO PATERNO:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.apellido1" /></u>
                    </td>
                </tr> 
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">APELLIDO MATERNO:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.apellido2" /></u>
                    </td>
                </tr>  
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">SEXO:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.sexo" /></u>
                    </td>
                </tr> 
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">FECHA DE NACIMIENTO:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.fechNac" /></u>
                    </td>
                </tr> 
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">NACIONALIDAD:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.nacionalidad" /></u>
                    </td>
                </tr>
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">CLAVE ENTIDAD DE NACIMIENTO:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.cveEntidadNac" /></u>
                    </td>
                </tr>  
                <tr>  
                    <td colspan="1" style="font-size:12px;text-align:right;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <font color="#000000">ESTATUS CURP:</font>
                    </td>
                    <td colspan="2" style="font-size:12px;text-align:left;font-weight:bold;color:#257435;margin-bottom:10px;">
                        <u><s:property value="micurp.statusCurp" /></u>
                    </td>
                </tr>     
                <tr></tr><tr></tr><tr></tr><tr></tr>        
                         
                       
                               
                
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







          
     




