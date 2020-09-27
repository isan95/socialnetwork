<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal-dialog modal-lg" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<h3 class="modal-title">Edicion de comentario</h3>
			<button class="close"  type="button" data-dismiss= "modal" aria-label= "Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		
		<form method="post" action="http://localhost:8080/socialnetwork/actualizar-comentario">
			<div class="modal-body">
				<div class="form-control">
					<input type="hidden" value = "${comment.idCommentApp}" name="idComment" />
					<textarea name="content"> ${comment.content} </textarea>
				</div>
				<div class="modal-footer">
					<div class="form-control">
						<button type="button" class="btn btn-danger"  data-dismiss="modal" >Cancelar </button>
						<button type="submit" class="btn btn-primary">Guardar</button>
					</div>
				</div>
				
			</div>
		</form>
		
	
	
	</div>
</div>