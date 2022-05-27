<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reetu's Product App</title>
</head>
<body>
<h1>Reetu's Product App</h1>
<a href="getAllProducts">GetAllProduct</a> &nbsp; &nbsp; &nbsp;      <%--  <a href="/views/GetProductbyID.jsp">GetProductbyId</a> --%>
<hr> <%--hr tag use for new line --%>
<c:if test="${result=='Success'}">
<h3 style="color: green;">Product Added Successfully!</h3>
</c:if>
<c:if test="${result=='failed'}">
<h3 style="color: red;">Product already exists!!</h3>
</c:if>
<form action="addProduct" method="post" enctype="multipart/form-data">
Product Id: <input type ="number" name = "pid" placeholder="Enter Product Id" required/><br><br>
Product Price: <input type="number" name = "pprice" placeholder = "Enter Product Price" required/><br><br>
Product Name: <input type="text" name = "pname" placeholder = "Enter Product Name" required/><br><br>
Product Review: <input type="text" name = "preview" placeholder = "Enter Product Review" required/><br><br>
Product Image: <input type="file" name="image" /><br><br>
<button>Add Product</button>
</form>
<hr>
<br><br>
<h3>Search Product by Id</h3>
<form action="getProductbyId">
Enter the Product's Id:   <input type="number" name="pid" placeholder="Enter the Id" required/>
<button>Search</button>
</form>
<hr>
<br><br>
<h3>Search ProductLikeName</h3>
<form action="getProductlikename">
Enter the Product's Id:   <input type="text" name="pname" placeholder="Enter the Name" required/>
<button>Search</button>
</form>
<hr>
<br><br>
<c:if test="${key=='success'}">
<h3 style="color: green;">Successfully Deleted!</h3>
</c:if>
<c:if test="${key=='failed'}">
<h3 style="color: red;">No Product found To be Deleted!</h3>
</c:if>
<h3>Delete Product!</h3>
<form action="deleteProduct">
Enter the Product's Id:   <input type="number" name="pid" placeholder="Enter the Id" required/>
                          <button>Delete</button>
                 </form>
<hr>
<br><br>
<a href="updateproductbyId">Update Product By Id Here</a> <hr>
<h3>Update Product's Details Here</h3>                              
<c:if test="${update=='failed'}">
<h3 style="color:red; ">Something Went Wrong!</h3>
</c:if> 
<form action="updateProduct"> &nbsp;&nbsp;&nbsp;  
 Select Product Name Which You Want to Update: 
 <select name="pname1">
<c:forEach items="${pname}" var="a">
<option>${a}</option>
</c:forEach>
</select><br><br>
Product Pid:<input type="number" name="pid" placeholder="Enter the Id" required/><br><br>
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