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
    <link href="${pageContext.request.contextPath}/css/listar.css" rel="stylesheet" type="text/css">

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
    <div class="centro">
        <h1>Produtos</h1>
    </div>
    <div class="row justify-content-center">
        <table class="table">
            <thead>
            <tr>
                <th class="table-dark">Nome</th>
                <th class="table-dark">Descrição</th>
                <th class="table-dark">Preço</th>
                <th class="table-dark"></th>
                <th class="table-dark"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${produtos}" var="produto">
                <tr class="table-active">
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.preco}</td>
                    <td>
                        <form action="/app_bic/produto/editar" method="post">
                            <input type="hidden" name="codProduto" value="${produto.codProduto}">
                            <button type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <form action="/app_bic/produto/excluir" method="post">
                            <input type="hidden" name="codProduto" value="${produto.codProduto}">
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

</body>

</html>