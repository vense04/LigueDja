<header>
	<div class="wrapper">
        <h1><a href="index.jsp" id="brand" title="LigueDjá">LigueDjá</a></h1>
        <nav>
            <ul>
                <li>
                  <a href="Produtos">Categorias</a>
                  <ul class="sub-menu">
                 		 <c:forEach items="${sessionScope.categorias}" var="categoria">
                    		<li><a href="Produtos?categoria=${categoria.codCategoria}">${categoria.nomCategoria}</a></li>
                    	</c:forEach>
                    </ul>
                </li>
                <li><a href="produtos.jsp">Trousers</a></li>
                <li>
                	<a href="produtos.jsp">Dresses</a>
                    <ul class="sub-menu">
                        <li><a href="produtos.jsp">Bridal dress</a></li>
                        <li><a href="produtos.jsp">Cocktail dress</a></li>
                        <li><a href="produtos.jsp">Maxi dress</a></li>
                        <li><a href="produtos.jsp">Shift dress</a></li>
                        <li><a href="produtos.jsp">Warp dress</a></li>
                    </ul>
                </li>
                <li><a href="produtos.jsp">Skirts</a></li>
                <li>
                    <a href="produtos.jsp">Accessories</a>
                    <ul class="sub-menu">
                        <li><a href="produtos.jsp">Hats</a></li>
                        <li><a href="produtos.jsp">Bags</a></li>
                        <li><a href="produtos.jsp">Scarves</a></li>
                        <li><a href="produtos.jsp">Jewellery</a></li>
                        <li><a href="produtos.jsp">Gloves</a></li>
                    </ul>
                </li>
                <li><a href="produtos.jsp">Coats &amp; Jackets </a></li>
                <li><a href="produtos.jsp">Brands</a></li>
          </ul>
        </nav>
    </div>
</header>
<aside id="top">
	<div class="wrapper">
        <ul id="social">
            <li><a href="#" class="facebook" title="like us us on Facebook">like us us on Facebook</a></li>
            <li><a href="#" class="twitter" title="follow us on twitter">follow us on twitter</a></li>
        </ul>
        <form>
        	<input type="text" placeholder="Search LigueDjá..." /><button type="submit">Search</button>
        </form>
        <div id="action-bar">
        	<a href="login.jsp"> Login/Registre-se</a> // 
        	<a href="Carrinho">Meu Carrinho <span id="itensCarrinho">${sessionScope.carrinho.quantidadeProdutos()}</span></a> // 
        	<a href="<c:url value="/j_spring_security_logout" />" title="Fazer logout">Logout</a> // 
			<a href="administrativo/admin.jsp">Administrativo</a> 
		</div>
    </div>
</aside>