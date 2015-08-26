<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
</head>
<body>
<h1>Project from "<c:out value="${categoryName}"/>" category</h1>
<br>
<p><h4><c:out value="${project.name}${project.shortDescription}"/></h4></p>
<p><h6><c:out value="Sum to raise=${project.sumToRaise}"/></h6></p>
<p><h6><c:out value="Current sum=${project.currentSum}"/></h6></p>
</body>
</html>