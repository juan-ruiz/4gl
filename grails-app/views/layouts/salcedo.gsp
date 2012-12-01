<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="logo" href="${resource(dir: 'images', file: 'logo.jpg')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'estiloUniversal.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'estiloForm.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
          <header>
          <div id="logo"><a href="/"><img src="${resource(dir: 'images', file: 'logo.jpg')}" alt="Viajando"/></a></div>
          
          
            <div id="menu">
                <div id="search">
                   <form action="/PF_Inmuebles/listb" name="buscar" method="get">
                        <input type="text" class="caja" name="consulta" value="Search" onfocus="if(this.value=='Search')this.value=''"/>
                        <input type="submit" class="lupa" name="btnBuscar" value=""/>
                  </form>
                    
                </div>
                <nav>
                    
                  
                    
                </nav>
            </div>
          </header>
            
      <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
      </g:if>
                

          <g:layoutBody/>
          <g:javascript library="application"/>
	  <r:layoutResources />
          
          
        <footer>
            
        </footer>
	</body>
</html>
