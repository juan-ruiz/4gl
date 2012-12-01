
<%@ page import="pf4gl.PF_Inmuebles" %>
<!DOCTYPE html>
<html>
	<head>
          <style type="text/css">
          #container{position: absolute;
top: 97px;
left: 17%;
width: 920px;}
          .titulo{
            
            border:none;
          }
          #loginHeader{
            float: right;
          }
          
          </style>
		<meta name="layout" content="salcedo" />
                <title>Viajando</title>
                 <link href="/css/estiloUniversal.css" type="text/css" rel="stylesheet"/>
                  <link href="/css/estiloSearch.css" type="text/css" rel="stylesheet"/>
                
		</head>
        <body style="background-image: url('/images/bg4.jpg');">
	
          <div id="container">  
                <div id="tituloSearch">
                  <h1 class="titulo">Búsqueda</h1>
                                
                </div>
                <div id="panel">
                    <!-- en donde aparece el # en el <a href> se pone el link del inmueble -->
                    <ul>
                      <g:each in="${inmueblefoto}" var="item">
                          <li>
                            <a href="/PF_Inmuebles/show/${item.key?.id}">
                            <img style="height: 186px;width: 186px;" src="/images/inmuebles/${item.key?.usuario.id}${item.value?.url}${item.key?.id}.jpg"/></a></li>
                           </g:each>
                    </ul>
                </div>
                
                
            </div>
          
	</body>
</html>
