<header>
	<div class="wrapper">
        <h1><a href="${pageContext.request.contextPath}/Home" id="brand" title="LigueDjá">LigueDjá</a></h1>
        <nav>
            <ul>
                <li>
                  	<ul class="sub-menu">
                 		 <c:forEach items="${sessionScope.categorias}" var="categoria">
                    		<li><a href="Produtos?categoria=${categoria.codCategoria}">${categoria.nomCategoria}</a></li>
                    	</c:forEach>
                    </ul>
                </li>
                
               	 <c:forEach items="${sessionScope.categorias}" var="categoria">
                    		<li><a href="Produtos?categoria=${categoria.codCategoria}">${categoria.nomCategoria}</a></li>
                    	</c:forEach>
               
          </ul>
        </nav>
    </div>
</header>
<aside id="top">
	<div class="wrapper">
        <ul id="social">
            <li><a href="http://www.facebook.com" class="facebook" title="like us us on Facebook">like us us on Facebook</a></li>
            <li><a href="http://www.twitter.com" class="twitter" title="follow us on twitter">follow us on twitter</a></li>
        </ul>
<!--         <form> -->
<!--         	<input type="text" placeholder="Search LigueDjá..." /><button type="submit">Search</button> -->
<!--         </form> -->
        <div id="action-bar">
        	<a href="login.jsp"> Login/Registre-se</a> // 
        	<a href="Carrinho">Meu Carrinho <span id="itensCarrinho">${sessionScope.carrinho.quantidadeProdutos()}</span></a> // 
        	<% 
			 	String login = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName(); 
			 	if (!login.equals("anonymousUser")) { 
			 %> 
        	
        	<a href="<c:url value="/j_spring_security_logout" />" title="Fazer logout"><%=login %> : Sair</a> // 
        	
        	<%} %>
			<a href="administrativo/admin.jsp">Administrativo</a> 
		</div>
    </div>
</aside>