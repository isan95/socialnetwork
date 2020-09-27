<%@page language = 'java' contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "com.polanco.crud.socialnetwork.web.LoginUserAppServlet" %>

<!DOCTYPE html>
<html lang="es">
    <head>
    <title>Iniciar sesion</title>
    </head>
    <body>
        <h1>Social Network</h1>
        <div style="margin-left:30em; margin-right: 15em; color: blue">
            <form action="http://localhost:8080/socialnetwork/login" method = "POST">
                <h2>Iniciar sesion</h2>
                <div>
                    <input id= "ndoc" name ="ndoc" type="text" style="margin:0 10px 5px 10px; vertical-align:middle;" placeholder="Número de documento" />    
                </div>
                <div>
                    <input id ="pass" name="pass" type="password" style="margin:0 10px 5px 10px; vertical-align:middle;" placeholder="Contraseña" />    
                </div>
                <% if (!LoginUserAppServlet.isResultLogin()){ %>
                	<p style="color: red">Contraseña o usuario incorrecto</p>
                <% } %>
                <div>
					<input value="Entrar" type="submit" style="margin-left: 5em" />
                </div>
			</form>
            <div>
				<a href="http://localhost:8080/socialnetwork/crear-usuario">Crear cuenta</a>
			</div>
        </div>
              
    </body>
</html>
