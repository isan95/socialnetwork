<%-- 
    Document   : post
    Created on : 1/03/2020, 10:36:45 AM
    Author     : polanco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<mt:my_template title="Post">
	<jsp:attribute name="content">
		
		<p>${post.content}</p>
		
		<div class="pt-5 mt-5">
           	<h3 class="mb-5 font-weight-bold">${fn:length(comments)} Commentarios</h3>
           	<ul class="comment-list">
				<c:forEach items="${comments}" var="comment">

					<div class="dropdown">
						<button class="dropdown-toggle" type="button" data-toggle="dropdown">...</button>
						<ul class="dropdown-menu">
							<li><button onclick = "open_modal_update_comment('http://localhost:8080/socialnetwork/actualizar-comentario?idComment=${comment.idCommentApp}')" type="button"> Editar </button></li>
							<li><a href="http://localhost:8080/socialnetwork/delete-comment?idComment=${comment.idCommentApp}"> Eliminar</a></li>

						</ul>
					</div>
					<li class="comment">

						<div class="vcard bio">
							<img src="images/person_1.jpg" alt="Imagen de perfil">
						</div>

						<div class="comment-body">
							<h3>${post.userApp.name} ${post.userApp.lastName}</h3>
							<div class="meta">${comment.commentAppDate}</div>
							<p>${comment.content}</p>
						</div>
					</li>
				</c:forEach>
				   
     			<li class="comment">
                	<div class="vcard bio">
                    	<img src="images/person_1.jpg" alt="Imagen de perfil">
             	    </div>
              		<div class="comment-body">
                    	<h3>${sessionScope.sessionUser.name} ${sessionScope.sessionUser.lastName}</h3>
                  		<form method="POST" action="http://localhost:8080/socialnetwork/comentar">
                                    
							<p><textarea name="contentComment"></textarea></p>
							<input type="hidden" name="idPost" value = ${post.idPostApp}  />
							<p><button type="submit" class="reply"><i class="icon-comment2 mr-2"></i> Comentar</button></p>
                      	
						</form>
                                
                 	</div>
				</li>                   
                         
                        
       		</ul>
      	</div>
			
		<div id="edition" class="modal fade" role="dialog">
		
		</div>

		<script type="text/javascript">
			var $ = jQuery.noConflict();
	
			function open_modal_update_comment(url){
				$('#edition').load(url, function(){
				$(this).modal('show');
				});
			}
		</script>
		
	</jsp:attribute>
</mt:my_template>