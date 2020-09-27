<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<mt:my_template title="${title}">
	<jsp:attribute name="content">
		<div class="card">
			<div class="card-header">
				<h3>Datos personales</h3>
			</div>
			
			<div class="card-body">
				<div class="col-sm-3">
					<div class="row">
						<span class="label label-default">
							<label for="ndoc">Número de documento: </label>
							<input id="ndoc" type="text" disabled value ="${sessionScope.sessionUser.ndoc}"/>
						</span>
					</div>

					<div class="row">
						<span class="label label-default">
							<label for="name" >Nombre: </label>
							<input id="name" type="text" disabled value="${sessionScope.sessionUser.name}"/>
						</span>
					</div>

					<div class="row">
						<span class="label label-default">
							<label for="last_name">Apellido: </label>
							<input id="last_name" type="text" disabled value="${sessionScope.sessionUser.lastName}"/>
						</span>
					</div>
				</div>
				
				<div class="row">
					<a class="btn btn-primary" href="http://localhost:8080/socialnetwork/actualizar-usuario">Actualizar</a>
					<a class="btn btn-danger" href="http://localhost:8080/socialnetwork/eliminar-usuario">Eliminar cuenta</a>
					<a class="btn btn-success" href="http://localhost:8080/socialnetwork/cambiar-contrasenia">Cambiar Contraseña</a>
				</div>
				
			</div>
			

		
		</div>
			
	</jsp:attribute>
</mt:my_template>