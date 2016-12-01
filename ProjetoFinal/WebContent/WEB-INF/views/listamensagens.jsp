<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ 
taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>
      <tr>
         <th>Nome    			|</th>
         <th>|           Mensagem</th>
      </tr>
      <c:forEach items="${tarefas}" var="tarefa">
         <tr>
  
            <td>${tarefa.usuario}</td>
		
            <td>${tarefa.descricao}</td>

   
         </tr>
      </c:forEach>
   </table>
</body>
</html>