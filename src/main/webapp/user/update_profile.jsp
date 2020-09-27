<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<mt:my_template title="Editar usuario">
	<jsp:attribute name="content">
	
		<form method="post" action="http://localhost:8080/socialnetwork/actualizar-usuario">
			
			<div class="row">
				<div class="form-control">
					<span class="label label-default"><label for="ndoc">Numero de documento: </label></span>
					<input id="ndoc" name="ndoc" type="text" value="${sessionScope.sessionUser.ndoc}"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-control">
					<span class="label label-default"><label for="name">Nombre: </label></span>
					<input id="name" name="name" type="text" value="${sessionScope.sessionUser.name}"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-control">
					<span class="label label-default"><label for="lastName">Apellido: </label></span>
					<input id="lastName" name="lastName" type="text" value="${sessionScope.sessionUser.lastName}" />
				</div>
			</div>
			
			<div class="row">
				<div class="dropdown-divider"></div>
				<div class="form-control">
					<button class="btn btn-primary" type="submit">Guardar</button>
					<button class="btn btn-danger" >Cancelar</button>
				</div>
			</div>
			
		</form>
	
	</jsp:attribute>
</mt:my_template>