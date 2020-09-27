<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<mt:my_template title="Cambiar contraseña">
	
	<jsp:attribute name="content">
		
		<div class="card">
			<div class="card-header">
				<h3>Cambiar contraseña</h3>
			</div>
			<div class="card-body">
				<form id="change-pass" action="http://localhost:8080/socialnetwork/cambiar-contrasenia" method="post">
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input type="password" name="old_pass" placeholder="Contraseña actual">
							</div>
							<div>
								<c:if test="${!equalsOldPass}">
									<span>Contraseña incorrecta</span>
								</c:if>
								<span class="help-block" id="error"></span>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input type="password" id="new_pass" name="new_pass" placeholder="Contraseña nueva">
							</div>
							<div>
								<span class="help-block" id="error"></span>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<input type="password" name="cnew_pass" placeholder="Confirmar contraseña nueva">
							</div>
							<div>
								<span class="help-block" id="error"></span>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group">
							<div class="form-control form-control-user">
								<button type="submit" class="btn btn-success">Guardar</button>
								<a href="http://localhost:8080/socialnetwork/perfil" class="btn btn-danger">Cancelar</a>
							</div>
						</div>
					</div>
					
				</form>
			</div>
		</div>
		
		
		
	</jsp:attribute>
	
</mt:my_template>