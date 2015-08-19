<%--
  Created by IntelliJ IDEA.
  User: Viktor
  Date: 18.08.2015
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog of categories</title>
</head>
<body>
<h2><c:out value="${quote}"/></h2>
<h3>Now, you can choose one of categories, you prefer:</h3>
<ol>
<h4><c:forEach var="category" items="&{category}">
    <li><a href="projects?categoryId=${category.id}"><c:out value="${category.name}"/></a></li>
</c:forEach> </h4>
</ol>
</body>
</html>
