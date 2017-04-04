<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Registros</title>
    </head>
    <body>
        <h2>Listagem de Registros</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Descrição</th>
                <th>Status</th>
            </tr>
            <c:forEach var="reclamacao" items="${solicitacao}">
                <tr>
                    <td><a href="edita.html?id=${reclamacao.id}">${reclamacao.id}</a></td>
                    <td>${reclamacao.nome}</td>
                    <td>${reclamacao.email}</td>
                    <td>${reclamacao.descricao}</td>
                    <td>${reclamacao.status}</td>
                    <td><a href="exclui.html?id=${reclamacao.id}">X</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
