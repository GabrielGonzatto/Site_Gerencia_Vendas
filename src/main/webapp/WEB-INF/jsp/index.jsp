<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>mercado zé</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">

</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card">
                <div class="card-header">
                    <h4 class="mb-0">Login</h4>
                </div>
                <div class="card-body">
                    <c:url var="login_usuario_url" value="/usuario/login" />
                    <form:form action="${login_usuario_url}" method="post" modelAttribute="usuario">
                        <div class="form-group">
                            <form:label path="login" class="form-label">Login:</form:label>
                            <form:input type="text" path="login" class="form-control" />
                        </div>
                        <div class="form-group">
                            <form:label path="senha" class="form-label">Senha:</form:label>
                            <form:input type="password" path="senha" class="form-control" />
                        </div>
                        <br>
                        <div class="d-grid gap-2">
                            <button class="btn btn-lg" type="submit">Entrar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>