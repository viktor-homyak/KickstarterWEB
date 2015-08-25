<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
</head>
<body>
<h1>Project from "<c:out value="${category}"/>" category</h1>
<br>
<p><c:out value="${project.name}"/></p>
</body>
</html>