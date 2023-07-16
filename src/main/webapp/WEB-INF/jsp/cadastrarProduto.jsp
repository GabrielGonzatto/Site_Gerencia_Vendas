<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mercado zé</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/cadastrar.css" rel="stylesheet" type="text/css">

</head>

<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/app_bic/venda/cadastrar">Mercado zé</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/app_bic/venda/listar">Vendas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/app_bic/funcionario/cadastrar">Cadastrar funcionário</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/app_bic/funcionario/listar">Funcionários</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/app_bic/produto/cadastrar">Cadastrar produto</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/app_bic/produto/listar">Produtos</a>
                </li>
            </ul>
        </div>

        <a class="nav-link" href="/app_bic/usuario/">Sair</a>
    </div>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card">
                <div class="card-header">
                    <h4 class="mb-0">Cadastrar Produto</h4>
                </div>
                <div class="card-body">

                    <c:if test="${cadastro}">
                        <p><b>Cadastro não realizado</b></p>
                    </c:if>

                    <c:url var="cadastrar_produto_url" value="/produto/cadastrar" />
                    <form:form action="${cadastrar_produto_url}" method="post" modelAttribute="produto">
                        <div class="form-group">
                            <form:label path="nome">Nome:</form:label>
                            <form:input type="text" path="nome" />
                        </div>
                        <div class="form-group">
                            <form:label path="descricao">Descriçao:</form:label>
                            <form:input type="text" path="descricao" />
                        </div>
                        <div>
                            <form:label path="preco">Preço:</form:label>
                            <form:input type="number" path="preco" />
                        </div>

                        <div class="d-grid gap-2">
                            <button class="btn btn-success btn-lg" type="submit">Cadastrar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>

</html>