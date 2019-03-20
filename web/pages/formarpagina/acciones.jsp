<%-- 
    Document   : acciones
    Created on : 10-ago-2016, 17:11:47
    Author     : DESARROLLO
--%>
<script type="text/javascript">
    
                
            //Para llamar action de botones
            function opcionde(accion){        	
                document.peticion.action = accion;
                document.peticion.submit();
               
            }
            function opcionde3(accion){        	
                document.peticion.action = accion;
                document.peticion.submit();
               
            }
            setTimeout("opcionde3(accion)", 5000);
            
             function guarda(accion){
            	
                document.altaPetiForm.action = accion;
                document.altaPetiForm.submit();
            }
            function pactulizar(){
                //var respuesta=confirm("øEst· seguro de que desea eliminar el registro?");
                
                document.peticion.action = "modificarplantelok.action";
                document.peticion.submit();
                //respuesta=confirm("øEst· seguro de que desea eliminar el registr2o?");
                return true;
            }
            //PARA REGRESAR donde se quedo en el formulario
            window.onload = function() {
            	  var pos = window.name || 0;
            	  window.scrollTo(0, pos);
            	 }
            	 window.onunload = function() {
            	  window.name = self.pageYOffset
            	    || (document.documentElement.scrollTop + document.body.scrollTop);
            	 }
            
            //Para validar letras     
            function validarLet(e) 
            { 
                tecla = (document.all) ? e.keyCode : e.which; // 2
                if (tecla==8)
                {
                    return true;
                } 
                patron =/[A-Za-zÒ—·ÈÌÛ˙¡…Õ”⁄\s\n\t\r]/; // 4
                te = String.fromCharCode(tecla); // 5
                return patron.test(te); // 6
            }
            
            //Para validar numeros
            function validarNum(e)
            {
                tecla = (document.all) ? e.keyCode : e.which;
                if (tecla == 8) 
                return true;
                patron = /\d/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
            
           
            
            //Para validar letrs y numeros
            function validarLn(e) 
            { 
                tecla = (document.all) ? e.keyCode : e.which; // 2
                if (tecla==8)
                {
                    return true;
                }
                patron =/[A-Za-zÒ—·ÈÌÛ˙¡…Õ”⁄0-9.()@_:;,=//<>#$%&+!°ø?*{}'"-\s\n]/; // 4
                te = String.fromCharCode(tecla); // 5
                return patron.test(te); // 6
            }
            
            function validarLn2(e) 
            { 
                tecla = (document.all) ? e.keyCode : e.which; // 2
                if (tecla==8)
                {
                    return true;
                }
                patron =/[A-Za-zÒ—·ÈÌÛ˙¡…Õ”⁄0-9.\s\n]/; // 4
                te = String.fromCharCode(tecla); // 5
                return patron.test(te); // 6
            }
            
            //Para validar email
            function validarEmail(e) 
            { 
                tecla = (document.all) ? e.keyCode : e.which; // 2
                if (tecla==8)
                {
                    return true;
                }
                patron =/[A-Za-zÒ—·ÈÌÛ˙¡…Õ”⁄0-9.@_,.-\s\n]/; // 4
                te = String.fromCharCode(tecla); // 5
                return patron.test(te); // 6
            }
            
            //Para validar letrs y numeros
            function validarNpuntos(e) 
            { 
                tecla = (document.all) ? e.keyCode : e.which; // 2
                if (tecla==8)
                {
                    return true;
                }
                patron =/[0-9.]/; // 4
                te = String.fromCharCode(tecla); // 5
                return patron.test(te); // 6
            }
            
            function funcionboton()
            {
                document.getElementById('enlacebloqueado').style.visibility = 'hidden';
                return true;
            }
            
            
            function funcionbotonavisos()
            {                
                var input = document.getElementById('archi');
                var file = input.files[0];
                if (file.size > 10485760)//2097152
                {
                    alert('No se puden subir archivos de un tamaÒa mayor a 10Mbs. Por favor elije un archivo con un peso menor o igual a 10Mbs. ');
                    return false;
                    
                }       
                else
                {
                    document.getElementById('enlacebloqueado').style.visibility = 'hidden';
                    return true;
                }
            }
            
            function funcionbotonguardar()
            {                
                var input = document.getElementById('archi');
                    var file = input.files[0];
                    if (file.size > 10485760) {//2097152  10485760   5242880
                        alert('No se puden subir archivos de un tamaÒo mayor a 10Mbs. Por favor elije un archivo con un peso menor o igual a 10Mbs. ');
                        return false;
                    } else {
                        var input = document.getElementById('archi2');
                        var file = input.files[0];
                        if (file.size > 10485760) {//2097152  10485760   5242880
                            alert('No se puden subir archivos de un tamaÒo mayor a 10Mbs. Por favor elije un archivo con un peso menor o igual a 10Mbs. ');
                            return false;
                        } else {
                            var input = document.getElementById('archi3');
                            var file = input.files[0];
                            if (file.size > 10485760) {//2097152  10485760   5242880
                                alert('No se puden subir archivos de un tamaÒo mayor a 10Mbs. Por favor elije un archivo con un peso menor o igual a 10Mbs. ');
                                return false;

                            } else {
                                document.getElementById('enlacebloqueado').style.visibility = 'hidden';
                                return true;
                            }
                        }
                    }
                }
            
            
            
            function peliminar()
            {
                var respuesta=confirm("øEst· seguro de que desea eliminar el registro?");
                return respuesta;
            } 
            
            function preguntas(mensajeamostrar)
            {
                var respuesta=confirm(mensajeamostrar);
                return respuesta;
            } 
                 
                 
        </script>
