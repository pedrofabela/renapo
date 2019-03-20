<%-- 
    Document   : fecha
    Created on : 21-abr-2016, 16:56:16
    Author     : Ignacio
--%>

        <script type="text/javascript">     
            $(function() 
            {  
                $('#fecha').datepicker({inline: true  });          
            });   
        </script>
        <font face="Arial,courier" SIZE=1 COLOR="green">
        <strong>

        <table width="100%">
           
            <tr>
                 
                
        <td class="Folio" style="font-size:11px;text-align:right;"  >
            
        
        
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

 
                