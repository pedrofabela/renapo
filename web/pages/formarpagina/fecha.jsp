<%-- 
    Document   : fecha
    Created on : 21-abr-2016, 16:56:16
    Author     : Ignacio
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>  

        <script type="text/javascript">     
            $(function() 
            {  
                $('#fecha').datepicker({inline: true  });          
            });   
        </script>
        <font face="Arial,courier" SIZE=1 COLOR="green">
                        <strong>
                            
        <table width="100%">
            <tr >
             
                <td class="Folio" width="30%" style="font-size:11px;text-align:left">
                    Usuario: <s:label value="%{session.get('NAMEUSUARIO')}"/>
                </td>
                 <td class="Folio" width="40%" style="font-size:11px;text-align: center;">
                     Perfil: <s:label value="%{session.get('NAMEPERFIL')}"/>
                </td> 
                
        <td class="Folio" style="font-size:11px;text-align:right;" width="30%">
            
        
        
        <script>
            var meses = new Array("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
            var dia = new Array("Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado");        
            var fecha=new Date();
            document.write(dia[fecha.getDay()] +" - " +fecha.getDate()+" de "+meses[fecha.getMonth()] + " de " + fecha.getFullYear());
        </script>
        
        </td>
               
           </tr>
        </table>
                
        </strong>
  </font>

        
                