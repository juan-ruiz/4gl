<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viajando</title>
        <link href="css/estiloUniversal.css" type="text/css" rel="stylesheet"/>
        <style type="text/css">
                        #loginHeader {
                          float: right;
                          color: #fff;
                        }
                        #registroHeader {
                          float: right;
                          color: #fff;
                        }
        </style>
    </head>
    <body>
        <header>
            <div id="logo">
                <a href="/PF4GL"><img src="images/logo.jpg" alt="Viajando"/></a>
            </div>
            <div id="menu">
                <div id="search">
                    <form action="/PF_Inmuebles/listb" name="buscar" method="get">
                        <input type="text" class="caja" name="consulta" value="Search" onfocus="if(this.value=='Search')this.value=''"/>
                        <input type="submit" class="lupa" name="btnBuscar" value=""/>
                  </form>
                    
                </div>
                <nav>
                    
                  
                    <div id="loginHeader"> 
                      <g:loginControl />
                    </div>
                </nav>
            </div>
        </header>
        <section>
            <article>
                <h1>Encuentra un sitio para quedarte</h1>
                <p>Descubre, guarda, comparte
                </br>tus lugares favoritos Viajando</p>
            </article>
        </section>
        
        <footer>
            
        </footer>
    </body>
</html>