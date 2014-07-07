<!-- flight section -->
<div class="bhoechie-tab-content active">
	<center>
		<form class="form-horizontal col-lg-9" action="" method="">
			<h2
				style="text-align: left !important; color: #55518a; margin-bottom: 40px;">Cadastro
				de Produtos</h2>
			<fieldset>
				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Nome Categoria</label>
					<div class="col-md-6">
						<select id="" name="" class="form-control">
							<option value="">Seleciona a Categoria</option>
							<c:forEach items="${sessionScope.categorias}" var="categoria">
								<option value="${categoria.codCategoria}">${categoria.nomCategoria}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Nome Produto</label>
					<div class="col-md-6">
						<input id="" name="" placeholder="digite o nome do produto"
							class="form-control input-md" required="" type="text">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Descrição</label>
					<div class="col-md-6">
						<input id="textinput" name="textinput"
							placeholder="digite a descrição do produto"
							class="form-control input-md" required="" type="text">
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="">Preço R$</label>
					<div class="col-md-6">
						<input id="" name="" placeholder="digite o preço do produto"
							class="form-control input-md" required="" type="text">
					</div>
				</div>

				<!-- File Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="filebutton">Imagem
						do Produto</label>
					<div class="col-md-4">
						<input id="filebutton" name="filebutton" class="input-file"
							type="file">
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-8">
						<button id="" name="" class="btn btn-success" type="submit">Cadastrar</button>
						<button id="" name="" class="btn btn-danger" type="reset">Limpar</button>
					</div>
				</div>

			</fieldset>
		</form>

	</center>
</div>