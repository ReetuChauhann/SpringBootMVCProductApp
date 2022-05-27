<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <c:if test="${result==null}">
<h3 style="color: red;">Product with this id is not found!</h3>
</c:if>
<c:if test="${result!=null}">
<div style="border:3px solid blue;width:max-content;">
  <p> Product Id: <c:out value="${result.pid}"></c:out> </p><br><br>
  <p> Product Price: <c:out value="${result.pprice}"></c:out> </p><br><br>
  <p> Product Name: <c:out value="${result.pname}"></c:out> </p><br><br>
  <p> Product Review: <c:out value="${result.preview}"></c:out> </p><br><br>
</div>
</c:if>
</body>
</html>