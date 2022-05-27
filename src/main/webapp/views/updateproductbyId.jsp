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
<h3>Update Product's Details Here</h3>
<c:if test="${update=='failed'}">
<h3 style="color:red; ">Something Went Wrong!</h3>
</c:if> 
<form action="updateProductbyId" method="post">
 Select Product Name Which You Want to Update: 
 <select name="pid">
<c:forEach items="${Pid}" var="a">
<option>${a}</option>
</c:forEach>
</select><br><br>
Product Price: <input type="number" name = "pprice" placeholder = "Enter Product Price" required/><br><br>
Product Name: <input type="text" name = "pname" placeholder = "Enter Product Name" required/><br><br>
Product Review: <input type="text" name = "preview" placeholder = "Enter Product Review" required/><br><br>
<button>Update Product</button>
<c:if test="${update=='success'}">
<h3 style="color:green; ">Successfully Updated!</h3>
</c:if>
</form>

</body>
</html>