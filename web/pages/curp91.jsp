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
    <body onload="opcionde('buscarcurps9')">
        <s:include value="formarpagina/encabezado.jsp"/>
        <s:form name="peticion" id="peticion" enctype="multipart/form-data" >
        <s:hidden name="MIINICIOC" value="%{MIINICIOC}"> </s:hidden>
        <s:hidden name="TABLAACHECAR" value="%{TABLAACHECAR}"> </s:hidden>
           <s:hidden name="MIUSERNAME" value="%{MIUSERNAME}"> </s:hidden>
           <s:hidden name="MIJDBC" value="%{MIJDBC}"> </s:hidden>
           <s:hidden name="MIPASSWORD" value="%{MIPASSWORD}"> </s:hidden>
        <s:hidden name="CUANTOSR" value="%{CUANTOSR}"> </s:hidden>
        <center>
            <h1 class="encSup">CURP 8</h1>
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
                    <td align="left">ACTUALIZAR CURP's</td>
                </tr>
                <td align="center" colspan="3" class="FOLIO">
                    BUSCANDO CURP's..... <s:property value="MIINICIOC"/> REGISTROS ACTUALIZADOS
                        </td>    
                    </tr>        
                 <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>  
                 
                 <s:if test="milistacurp2.size()>0">
                    <tr>
                        <td colspan="3">
                            <div class="tablaUdai" >
                            <table  width="90%" >
                                <thead>
                                    <tr> 
                                        <!--td width="40">CLAVE</td-->
                                        <td width="200">CURP EN BASE</td>
                                        <td width="200">CURP RENAPO</td> 
                                        <td width="350">NOMBRES</td> 
                                        <td width="70">ACTUALIZADO</td>
                                        
                                    </tr>  
                                </thead>
                                <tbody>	
                                    <s:iterator value="milistacurp2" status="rowstatus">
                                        <tr class="<s:if test="#rowstatus.odd == true "></s:if><s:else>alt</s:else>">
                                            <!--td align="center"><!--s:property value="NUMERO_DESCRIPCION" /></td-->
                                            <td align="center"><s:property value="CURPORIGINAL" /></td>
                                            <td align="center"><s:property value="CURP" /></td>
                                            <td align="center"><s:property value="Nombres" /></td>
                                            <td align="center"><s:property value="ACTUALIZO" /></td>
                                            
                                          
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                            </div> 
                        </td>
                    </tr>          
                </s:if>
         
            
                
        </table>
            <div class="Error" align="center">
                <s:actionerror cssStyle="color:red"/>
                
            </div>


<!--------------------------------------------->
 <s:include value="formarpagina/piepagina.jsp"/>
</s:form>
</body>
</html>







          
     




