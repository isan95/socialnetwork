<%-- 
    Document   : registerUser
    Created on : 15/02/2020, 01:47:57 PM
    Author     : polanco
--%>

<%@page language = 'java' contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
				
        <title>${title}</title>
    </head>
	
    <body>
        <div class="card">
			
			<div class="card-header">
				<h3>Registrar nuevo usuario</h3>
			</div><!--end card-header-->
			
			<div class="card-body">
				<form id="register-form" action="http://localhost:8080/socialnetwork/crear-usuario" method="post">
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input type="text" name="ndoc" placeholder="Número de documento" />
								<div>
									<span class="help-block" id="error"></span>
								</div>
							</div>	
						</div>					
					</div>
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input type="text" name="name" placeholder="Nombre" />
								<div>
									<span class="help-block" id="error"></span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input type="text" name="lname" placeholder="Apellido" />
								<div>
									<span class="help-block" id="error"></span>
								</div>
							</div>
						</div>					
					</div>
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input id="pass" type="password" name="pass" placeholder="Contraseña"/>
								<div>
									<span class="help-block" id="error"></span>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input type="password" name="cpass" placeholder="Confirmar contraseña"/>
								<div>
									<span class="help-block" id="error"></span>
								</div>
							</div>						
						</div>
					</div>
					
					<div class="row">
						<div class="form-control form-control-user">
							<button type="submit" class="btn btn-primary">Crear usuario</button>
						</div>
					</div>
				</form>
				<a href="http://localhost:8080/socialnetwork/login" class="btn btn-primary">Iniciar sesión</a>
			</div><!--end card-body-->
		</div><!--end card-->
		
		
		<script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/scrollax.min.js"></script>
        <!--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
		-->
		<script src="js/main.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
		<script src="js/register.js"></script>

    </body>
</html>
