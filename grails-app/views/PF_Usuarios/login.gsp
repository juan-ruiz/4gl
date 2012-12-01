<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="salcedo" />
    <title>Login</title>      
    
            <style type="text/css">

                        #loginHeader {
                          float: right;
                          color: #fff;
                        }
                        #registroHeader {
                          float: right;
                          color: #fff;
                        }
                        #btnEntrar{
                          width: 115px;
height: 36px;
background-color: #6AA74F;
border: 1px ridge #3B6E22;
cursor: pointer;
font-family: "ParadoxVirtual","Paradox",Helvetica,Arial;
font-size: 20px;
margin-top: 20px;
padding-bottom: 10px;
text-decoration: none;
margin-left: 100px;
color: white;


                        }
                        
                        #create{
                          width: 115px;
height: 36px;
background-color: rgb(214,73,55);
border: 1px ridge rgb(180 ,55, 37);
cursor: pointer;
font-family: "ParadoxVirtual","Paradox",Helvetica,Arial;
font-size: 20px;
margin-top: 5px;
padding-bottom: 10px;
text-decoration: none;
margin-left: 143px;
color: white;


                        }
                         #registroF{
        
        border: none;
        
        
    }
    
    .inputRegistro{
      position: absolute;
      left: 30%
      
    }
        </style>
    
  </head>
  <body>
    
    
    <!--<div class="body">-->
      
    <div id="container">
      
    <div style="position: absolute;
    top: 17%;
    left: 15%;"id="entrar">
      <div>
      <h1 class ="titulo">Login</h1>


      <g:form action="authenticate" method="post" >
        <div class="dialog">
          <table>
            <tbody>            
              <tr class="prop">
                <td class="name">
                  <label for="login">Login:</label>
                </td>
                <td>
                  <input type="text" id="login" name="login"/>
                </td>
              </tr> 
          
              <tr class="prop">
                <td class="name">
                  <label for="password">Password:</label>
                </td>
                <td>
                  <input type="password" id="password" name="password"/>
                </td>
              </tr> 
            </tbody>
          </table>
        </div>
        <div class="buttons">
          <span class="button">
            <input  class="save" id="btnEntrar" type="submit" value="Login" />
          </span>
        </div>
        
      </g:form>
      
      
      <div id="separador">
      
        <div id="registrate" style="margin-left: 20px;">
        
          <h1 class="titulo">Registrate</h1>
          
          
          
          
          <g:form action="save" method="post" >
            <fieldset id="registroF" class="form">
					<g:render template="form"/>
				</fieldset>
            <fieldset style="border:none;" class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
        
      </g:form>
          
          
          
        
        </div>
      
      
      
      
      
      </div>
      
      
      
      
      
      
      
</div>
    </div>
      
      <div id="separador"> </div>
      
   </div>
   <!--</div>-->
  </body>
</html>