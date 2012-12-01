
<%@ page import="pf4gl.PF_Inmuebles" %>
<!DOCTYPE html>
<html>
	<head>
          <link href="/css/estiloUniversal.css" type="text/css" rel="stylesheet"/>
          <link href="/css/estiloPerfil.css" type="text/css" rel="stylesheet"/>
          <style type="text/css">
           
                        
            
          </style>
		<g:set var="entityName" value="${message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	
                
                
               <!--MAPA--> 
                <script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=false"></script>
        <script type="text/javascript">
          function initialize(address) {
                var geoCoder = new google.maps.Geocoder(address)
                var request = {address:address};
                geoCoder.geocode(request, function(result, status){
                        var latlng = new google.maps.LatLng(result[0].geometry.location.lat(), result[0].geometry.location.lng());
                        var myOptions = {
                          zoom: 15,
                          center: latlng,
                          mapTypeId: google.maps.MapTypeId.ROADMAP
                        };
                var map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);
                        var marker = new google.maps.Marker({position:latlng,map:map,title:'title'});
                })
          }

            $(document).ready(function(){
                var direccion = document.getElementById("infoDireccion").innerHTML;
                var ciudad = document.getElementById("infoCiudad").innerHTML;
                initialize(direccion+' '+ciudad);
            })
        </script>
        <style type="text/css">

          #map_canvas {
              width:357px; 
              height:263px;
              border:1px solid #ccc;
          }
        </style>
                </head>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	<body>
          <header style="z-index: 4;">
            <div id="logo">
                <a href="/"><img src="/images/logo.jpg" alt="Viajando"/></a>
            </div>
            <div id="menu">
                <div id="search">
                    <form action="/PF_Inmuebles/listb" name="buscar" method="get">
                        <input type="text" class="caja" name="consulta" value="Search" onfocus="if(this.value=='Search')this.value=''"/>
                        <input type="submit" class="lupa" name="btnBuscar" value=""/>
                  </form>
                    
                </div>
                <nav>
                   
                  
                  <div id="loginHeader" style="float: right;"> 
                      <g:loginControl />
                    </div>
                </nav>
            </div>
        </header>
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
		<a href="#show-PF_Inmuebles" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		
	
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        
        
                <div id="container" style="position: absolute;
top: 97px; left:14%;width: 920px;text-align: left;
text-decoration: none;height: 137px;">  
                <div id="tituloPerfil">
                    <table>
                            <tr>
                                <td><h1 class="titulo"><label id="nombreInmueble">${PF_InmueblesInstance?.tipoInmueble} - ${PF_InmueblesInstance?.titulo}</label></h1></td>
                                <td class="alinear"><p id="estiloPrecio">Desde $<label id="precio">${PF_Preciomenor?.montoPrecio}</label></p></td>
                            </tr>
                    </table>
                </div>
                <div id="panel1">
                    <div id="imagen">
                        <img src="/images/inmuebles/${PF_InmueblesInstance?.usuario.id}${PF_MultimediaInstance?.url}${PF_InmueblesInstance?.id}.jpg"/>
                    </div>
                    <div id="datos">
                        <table>
                                <tr>
                                    <td class="alinear"><label id="tipoHabitacion">Tipo de habitación:</label></td>
                                    <td class="alinear2"><label id="infotipoHabitacion">${PF_InmueblesInstance?.tipoHabitacion}</label></td>
                                </tr>
                                <tr>
                                    <td class="alinear"><label id="tipoInmueble">Tipo de inmueble:</label></td>
                                    <td class="alinear2"><label id="infoTipoInmueble">${PF_InmueblesInstance?.tipoInmueble}</label></td>
                                </tr>
                                <tr>
                                    <td class="alinear"><label id="capacidad">Capacidad:</label></td>
                                    <td class="alinear2"><label id="infoCapacidad">${PF_InmueblesInstance?.capacidad}</label></td>
                                </tr>
                                <tr>
                                    <td class="alinear"><label id="pais">País:</label></td>
                                    <td class="alinear2"><label id="infoPais">${PF_InmueblesInstance?.ciudad?.pais?.nomre}</label></td>
                                </tr>
                                <tr>
                                    <td class="alinear"><label id="ciudad">Ciudad:</label></td>
                                    
<!-- es importante que no se le cambie el id a este label (infoCiudad), porque con JS yo saco la direccion y la ciudad para
hacer la busqueda en el mapa -->
                                    <td class="alinear2"><label id="infoCiudad">${PF_InmueblesInstance?.ciudad?.nombre}</label></td>
                                </tr>
                                <tr>
                                    <td class="alinear"><label id="direccion">Dirección:</label></td>
<!-- *******  OJO!! es importante que el label donde se pone la direccion tenga el id=infoDireccion, porque con JS yo saco 
la cadena que aparece dentro de ese label que seria en este caso C/ Calàbria, 115 y la busco en el mapa******************-->                                    
                                    <td class="alinear2"><label id="infoDireccion">${PF_InmueblesInstance?.direccion}</label></td>
                                </tr>
                            </table>
                    </div>
                </div>
                <div id="tituloDescripcion">
                    <h1 class="titulo">Descripción</h1>
                </div>
                <div id="panel2">
                    <div id="descripcion">
                      <label id="infoDescripcion" style="position:relative;top:25px">
                            ${PF_InmueblesInstance?.descripcion}
                        </label>
                    </div>
                  <div id="mapa" style="position:relative;top:30px">
<!-- *******  OJO!! Aqui se pone solo esta capa sin nada adentro, y por nada del mundo se le puede cambiar el id porque con javascript yo ahi pongo el mapa******************-->
                        <div id="map_canvas"></div>
<!-- Hasta aqui va el componente del mapa -->                        
                    </div>
                </div>
            </div>
        
        
        
        
         <footer>
            
        </footer>
        
        </body>
</html>
