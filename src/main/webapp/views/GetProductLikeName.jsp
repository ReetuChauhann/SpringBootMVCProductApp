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
<%--  <c:if test="${result==null}">
<c:out value="Not Found!"></c:out>
</c:if> --%>
<c:if test="${result!=null}">
 
<c:forEach items="${result}" var="x">

<div style="border:1px solid blue;width:max-content;">
  <p> Product Id: <c:out value="${x.pid}"></c:out> </p><br>
  <p> Product Price: <c:out value="${x.pprice}"></c:out> </p><br>
  <p> Product Name: <c:out value="${x.pname}"></c:out> </p><br>
  <p> Product Review: <c:out value="${x.preview}"></c:out> </p><br>
</div>
</c:forEach>
</c:if>
 

</body>
</html>