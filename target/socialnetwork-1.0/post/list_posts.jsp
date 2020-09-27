<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<mt:my_template title="${title}">
	<jsp:attribute name="content">
		<div class="create-post">
        	<div class="card">
            	<div class="card-header">
                	<h5>Nuevo post</h5>
                </div>
                <div class="card-body">
                	<form method="post" action="http://localhost:8080/socialnetwork/crear-post">
                    	<div class="form-row">
                        	<textarea name="contentPost"></textarea>                                                        
                        </div>

                        <div class ="form-row">
                        	<div clas="form-control">
                            	<input type="submit" value="Publicar" class="btn py-3 px-4 btn-primary"/>
                            </div>
                        </div>
	               </form>
     			</div>
    		</div>

		</div>
        <c:forEach items="${posts}" var="post">
			
			<div class="blog-entry ftco-animate d-md-flex">
            	<a href="http://localhost:8080/socialnetwork/post?idPost=${post.idPostApp}" class="img img-2" style="background-image: url(images/image_1.jpg);"></a>
            	
				<div class="text text-2 pl-md-4">
            	
					<h3 class="mb-2"><a href="http://localhost:8080/socialnetwork/post?idPost=${post.idPostApp}"> <p>${post.userApp.name} ${post.userApp.lastName}</p> </a></h3>
                	
					<c:if test="${post.userApp.idUserApp == sessionScope.sessionUser.idUserApp}">
						<div class="dropdown">
                        	<button class="dropdown-toggle" type="button" data-toggle="dropdown">...</button>
                            <ul class="dropdown-menu">
                            	<li><a href="http://localhost:8080/socialnetwork/editPost?idPost=${post.idPostApp}"> Editar</a></li>
                                <li><a href="http://localhost:8080/socialnetwork/delete?idPost=${post.idPostApp}"> Eliminar</a></li>
                                                
                            </ul>
                        </div>
					</c:if>
				
                    <p class="mb-4"> ${post.content} </p>
                    	<div class="meta-wrap">
                        	<p class="meta">
                            	<span><i class="icon-calendar mr-2"></i>${post.postAppDate}</span>
                             	<span><i class="icon-comment2 mr-2"></i>${post.quantityComments}</span>
                                                                                                        
                          	</p>
                   	    </div>
                </div>
			</div>
		</c:forEach>
		
	</jsp:attribute>
</mt:my_template>

							
								     