<%-- 
    Document   : edit
    Created on : 7/05/2020, 04:18:26 PM
    Author     : polanco
--%>

<%@page language = "java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<mt:my_template title="Editar post">
	<jsp:attribute name="content">
		
		 <form method="post" action="http://localhost:8080/socialnetwork/editPost">
        	<div class="form-row">
          		<div class="form-control">
              		<div class="form-text">
                   		<textarea name ="content">${post.content}</textarea>
                   	</div>
             	</div>
          	</div>
                                    
           	<div class="form-row">
            
				<div class="form-control">
              		<button type="submit" class="btn btn-success"><i class="fas fa-save"></i>Guardar</button>   
            	</div>
                                       
         	</div>
                                    
                                    
		</form>
		
	</jsp:attribute>
</mt:my_template>



