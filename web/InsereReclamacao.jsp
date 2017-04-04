<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Reclamações Públicas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>Insira sua Reclamação:</h2>
        <p>Nome: <input type="text" size="30" name="nome"></p> 
        <p>E-mail: <input type="text" size="29" name="email"></p>
        Descrição: <p><textarea rows="10" cols="38" > </textarea></p>
        <p>Status: <select name="Status">
            <option value="0">Aberto</option>
            <option value="1">Confirmado</option>
            <option value="2">Recusado</option>
            <option value="3">Em execução</option>
            <option value="4">Resolvido</option>
        </select></p>
        <input type="submit" value="Registrar" />
        <input type="reset" value="Limpar" />
    </body>
</html>
