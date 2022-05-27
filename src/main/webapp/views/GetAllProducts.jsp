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
  <h1>All Product Data</h1>
  <c:forEach items="${Data}" var="b">
  <div style="border:3px solid blue;width:max-content;">
  <p> Product Id: <c:out value="${b.pid}"></c:out> </p>
  <p> Product Price: <c:out value="${b.pprice}"></c:out> </p>
  <p> Product Name: <c:out value="${b.pname}"></c:out> </p>
  <p> Product Review: <c:out value="${b.preview}"></c:out> </p>
  
  <img alt="" src="getimage?pid=${b.pid}" height="70px" width="70px">
  
  </div>
  
  </c:forEach>

</body>
</html>