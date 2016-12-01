<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Insper</title>
</head>
<body>
    <h2>Bem vindo ao ChatInsper</h2>
    <p>Bem vindo, ${usuarioLogado}</p>
        <a href="criaTarefa">Clique aqui</a> Para entrar no Chat
		<a href="logout">Sair</a>
		<img src="getImage?login=${usuarioLogado}" />
		
</body>

</html>