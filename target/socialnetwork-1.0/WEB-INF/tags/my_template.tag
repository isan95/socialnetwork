<%@ tag language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ attribute name ="title"  required="true" rtexprvalue="true"%>
<%@ attribute name ="content" fragment="true"%>
<!DOCTYPE html>
<html lang="es">
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
        <div id="colorlib-page">
            <a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
            <aside id="colorlib-aside" role="complementary" class="js-fullheight">
                <nav id="colorlib-main-menu" role="navigation">
                    <ul>
                        <li class="colorlib-active"><a href="http://localhost:8080/socialnetwork/inicio">Inicio</a></li>
                        <li><a href="http://localhost:8080/socialnetwork/myPosts?sessionUser={$sessionScope.sessionUser}">Mis post</a></li>
                    </ul>
                </nav>
				
				<div>
					<nav>
						<ul>
							<li class="nav-item dropdown no-arrow show">

								<a id="userDropdown" class ="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
									<span class="mr-2 d-none d-lg-inline text-gray-600 small"> ${sessionScope.sessionScope.sessionUser.name} ${sessionScope.sessionScope.sessionUser.lastName}</span>
									<img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60" />
								</a>
								<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in show" aria-labelledby="userDropdown">
									<a class="dropdown-item" href="http://localhost:8080/socialnetwork/perfil">
										<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
										Perfil
									</a>

									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="http://localhost:8080/socialnetwork/logout">
										<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
										Cerrar sesion
									</a>
								</div>

							</li>
						</ul>		
                	</nav>


				</div>
				
                <div class="colorlib-footer">								
				
                    <h1 id="colorlib-logo" class="mb-4"><a href="http://localhost:8080/socialnetwork/inicio" style="background-image: url(images/bg_1.jpg);">Social <span>Network</span></a></h1>

                    <p class="pfooter"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
					
                </div><!-- End colorlib-footer -->
				
            </aside>

            <main>
                <div id="colorlib-main">
                    <section class="ftco-section ftco-no-pt ftco-no-pb">
                        <div class="container">
                            <div class="row d-flex">
                                <div class="col-xl-8 py-5 px-md-5">
                                    <div class="row pt-md-4">
                                        <div class="col-md-12">
                                            <jsp:invoke fragment="content"></jsp:invoke>
                                        </div>
                                       
                                    </div>
                                    <!--END row pt-md-4 aqui se encierran los post-->

                                </div>
                                <!--END col-xl-8 py-5 px-md-5-->
                            </div>
                            <!--END row d-flex -->
                        </div>
                        <!--END container-->
                    </section>
                </div>
                <!--END color-lib main-->
            </main>
            
        </div><!--End colorlib-page -->

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
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
		<script src="js/change_pass.js"></script>
        
    </body>      


</html>
       



