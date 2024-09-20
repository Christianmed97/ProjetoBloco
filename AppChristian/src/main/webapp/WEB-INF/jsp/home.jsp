<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AppLivro</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">AppLivro</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/biblioteca/listagem">Biblioteca</a></li>
				<li class="nav-item"><a class="nav-link" href="/livro/listagem">Livros</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/academico/listagem">Academicos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/literario/listagem">Literarios</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/endereco/listagem">Enderecos</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/openLivros/listagem">OpenLivros</a></li>
					<li class="nav-item"><a class="nav-link"
					href="/api/listagem">Api</a></li>
			</ul>
			
			<form class="d-flex" action="/DetalhesOpenLivros/listagem" method="get">
			<input class="form-control me-2" type="text" placeholder="Pesquise um Livro" name="titulo">
			<button class="btn btn-primary" type="submit">Pesquisar</button>
			</form>
			
		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Bibliotecas:
			${qtdeBiblioteca}</span> <span class="badge rounded-pill bg-secondary">Livros:
			${qtdeLivros}</span> <span class="badge rounded-pill bg-success">Academicos:
			${qtdeAcademicos}</span> <span class="badge rounded-pill bg-danger">Literarios:
			${qtdeLiterarios}</span> <span class="badge rounded-pill bg-warning">Endereços:
			${qtdeEnderecos}</span> <span class="badge rounded-pill bg-warning">OpenLivros:
			${qtdeOpenLivros}</span>

		<c:if test="${not empty listagem}">
			<h2>AppVenda</h2>
			<p>Gestão de vendas de livros:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${titulo}</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
							<td>"${item}"</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<%--<c:if test="${empty listagem}">
			<div class="container mt-5">
		        <div class="card mx-auto" style="width: 18rem;">
		            <img src="https://www.learntek.org/blog/wp-content/uploads/2018/05/java2.jpg" class="card-img-top" alt="Foto do Desenvolvedor">
		            <div class="card-body">
		                <h5 class="card-title">Elberth LC Moraes</h5>
		                <p class="card-text"><strong>Telefone:</strong> (21) 99601-6255</p>
		                <p class="card-text">Atuo como professor universitï¿½rio desde o dia primeiro de abril de dois mil e onze. Neste dia descobri mais uma verdade na minha vida: observar como as pessoas aprendem e ensinam.</p>
		                <a href="https://github.com/Banco-de-Dados-e-Persistencia-em-Java" class="btn btn-primary">GitHub do Projeto</a>
		                <a href="https://www.linkedin.com/in/elberth/" class="btn btn-secondary">LinkedIn</a>
		            </div>
		        </div>
		    </div>
	    </c:if>--%>

	</div>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>