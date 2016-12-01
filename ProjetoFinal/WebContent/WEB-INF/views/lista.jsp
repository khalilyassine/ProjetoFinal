<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ 
taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<html>
<body>

   <table>
      <tr>
         <th>Nome</th>
         <th>Descrição</th>
         <th>Finalizado</th>
         <th>Data de finalização</th>
      </tr>
      <c:forEach items="${tarefas}" var="tarefa">
         <tr>
  
            <td>${usuarioLogado} :   </td>
		
            <td>${tarefa.mensagem}</td>
				
 
				
            <td>
               <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
            </td>
   
         </tr>
      </c:forEach>
   </table>
</body>
</html>