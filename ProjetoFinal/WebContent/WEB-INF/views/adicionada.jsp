<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ 
taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head> <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script></head>
<body>
    <h3>ChatInsper</h3>
    <form action="adicionaTarefa" method="post">
    	Escreva sua mensagem: <br />
    	<textarea name="descricao" rows="6" cols="80"></textarea><br />
    	<form:errors path="tarefa.descricao" cssStyle="color:red"/><br/>
    	<input type="submit" value="Adicionar">
    </form>
       <table>
      <tr>
         <th>Nome    			|</th>
         <th>|           Mensagem</th>
      </tr>
      <c:forEach items="${tarefas}" var="tarefa">
         <tr>
  
            <td>${usuarioLogado}</td>
		
            <td>${tarefa.descricao}</td>

				
            <td>
               <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
            </td>
   
         </tr>
      </c:forEach>
   </table>
</body>
</html>