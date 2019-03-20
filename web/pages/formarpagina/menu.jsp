<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
<title></title>

  <link href="<s:property value="@utilidades.Constantes@rutaEstilos"/>css/estiloUDAIV.css" rel="stylesheet" type="text/css" />
  <link href="<s:property value="@utilidades.Constantes@rutaEstilos"/>css/tablaV.css" rel="stylesheet" type="text/css" />
  <link href="<s:property value="@utilidades.Constantes@rutaEstilos"/>css/menu.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
            function SeleccionMenu(accion){
                 if (accion == "accesoManual"){
                     document.formularioPrincipal.target="_blank";
                     document.formularioPrincipal.action = accion;
                     document.formularioPrincipal.submit();
                 }else {
                    document.formularioPrincipal.target="_self";
                    document.formularioPrincipal.action = accion;
                    document.formularioPrincipal.submit();
                 }
            }

        </script>   
</head>   

<body>

        <s:form name="formularioPrincipal" method="post" id="formularioPrincipal">
        <div id="menu">
            <center>
                <ul class="menuTemplate1 decor1_1" >
                    <li><s:a action="miinicio">Inicio</s:a></li>
                    <li class="separator"></li>
                    <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                        <s:if test='CVE_MODPADRE=="S"'>
                            <li>
                                <a href="#Horizontal-Menus" class="arrow">
                                    <s:property value="DESC_MOD"/>
                                </a>
                                <div class="drop decor1_2" style="width: 485px;"> <%--380--%>
                                    <div class='left'>
                                        <div>
                                            <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">
                                                <s:if test='CVE_MODULO==MODPADRE'>
                                                    <a href="Javascript:SeleccionMenu('<s:property value="ACCION"/>')">
                                                        <s:property value="MOD"/>
                                                        <s:set var="myVar">
                                                            <s:property value="MOD.length()" />
                                                        </s:set>
                                                        <s:if test='MOD.length()<40'>
                                                            <c:forEach begin="${myVar}" end="40" varStatus="lp">
                                                                &nbsp;
                                                            </c:forEach>
                                                        </s:if>                                                        
                                                    </a>
                                                    <br/>
                                                </s:if>
                                            </s:iterator>
                                        </div>
                                    </div>
                                    <div class='left' style="text-align:right; width: 180px;"> <%--200--%>
                                        <s:url value="%{IMAGEN}" var="urlTag"/>
                                        <img align="middle" src="<s:property value="#urlTag"/>"/>
                                    </div>
                                    <div style='clear: both;'></div>
                                </div>
                            </li>
                        </s:if>
                        
                    </s:iterator>
                    <li><s:a action="cerrarSesion">Cerrar Sesión</s:a></li>	
                    <li class="separator"></li>
                </ul>                    
            </center>
        </div>       
        </s:form>
     <br/><br/><br/>
    </body>
         
       
</html>