<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ 
taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

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
         <th>Id</th>
         <th>Descrição</th>
         <th>Finalizado</th>
         <th>Data de finalização</th>
      </tr>
      <c:forEach items="${tarefas}" var="tarefa">
         <tr>
  
            <td>${tarefa.id}</td>
		
            <td>${tarefa.descricao}</td>
				
            <c:if test="${tarefa.finalizado eq false}">
               <td>Não finalizada</td>
            </c:if>
            <c:if test="${tarefa.finalizado eq true}">
               <td>Finalizado</td>
            </c:if>
				
            <td>
               <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
            </td>
   
         </tr>
      </c:forEach>
   </table>
</body>
</html>
