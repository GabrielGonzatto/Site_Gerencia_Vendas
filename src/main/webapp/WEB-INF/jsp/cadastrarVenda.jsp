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
                    <h4 class="mb-0">Cadastrar Venda</h4>
                </div>
                <div class="card-body">
                    <form action="/app_bic/venda/cadastrar" method="post">

                        <label for="funcionario">Selecione o funcionário:</label>
                        <select name="funcionario" id="funcionario">
                            <c:forEach items="${funcionarios}" var="funcionario">
                                <option value="${funcionario.codFuncionario}">${funcionario.nome}</option>
                            </c:forEach>
                        </select>

                        <c:if test="${save}">
                            <div>
                                <b>
                                    <p>venda não cadastrada</p>
                                </b>
                            </div>
                        </c:if>


                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Produto</th>
                                <th scope="col">Quantidade</th>
                                <th scope="col">Preço</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${itemProdutos}" var="itemProduto">
                                <tr>
                                    <td>${itemProduto.nomeProduto}</td>
                                    <td>${itemProduto.quantidade}</td>
                                    <td>${itemProduto.total}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <h4>Total venda: ${totalVenda}</h4>

                        <div class="linkBotao">
                            <a class="vermelho" href="/app_bic/venda/limparLista">Limpar lista</a>
                            <a class="azul" href="/app_bic/itemProduto/adicionarProduto">adicionar produto</a>
                        </div>

                        <button class="btn btn-success bot" type="submit">Cadastrar</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>