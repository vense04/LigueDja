

<!-- train section -->
<div class="bhoechie-tab-content">
	<center>
		<form class="form-horizontal col-lg-9" action="<%=request.getContextPath()%>/administrativo/EntradaCRUD" name="formCamp" " method="post">
			<fieldset>
				<h2
					style="text-align: left !important; color: #55518a; margin-bottom: 40px;">Cadastro de Entrada</h2>

				<!-- Select Basic -->

				<div class="form-group">
					<label class="col-md-4 control-label" for="">Nome Categoria</label>
					<div class="col-md-6">
						<select id="categorias" name="" class="form-control">
							<c:forEach items="${sessionScope.categorias}" var="categoria">
								<option value="${categoria.codCategoria}">${categoria.nomCategoria}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Nome Produto</label>
					<div class="col-md-6">
						<select id="produtos" name="codProduto" class="form-control">
						</select>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Quantidade</label>
					<div class="col-md-6">
						<input id="" name="quantidade" placeholder="digite a quantidade do produto"
							class="form-control input-md" required="" type="text">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Data</label>
					<div class="col-md-6">
						<input id="" name="data" placeholder="digite a data de entrada" class="form-control input-md data" type="text">
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-8">
						<button id="" name="" class="btn btn-success">Cadastrar</button>
						<button id="" name="" class="btn btn-danger" type="reset">Limpar</button>
					</div>
				</div>

			</fieldset>
		</form>

	</center>
</div>
