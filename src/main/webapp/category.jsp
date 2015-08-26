<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>kickstarterWEB</title>
</head>
<body>
<h1>Projects from "<c:out value="${categoryName}"/>" category</h1>
<br>
<ol>
    <c:forEach var="project" items="${projects}">
        <li><a href="categoryId=${categoryId}/projectId=${project.id}"><c:out value="${project.name}"/></a>${project.shortDescription}</li>
    </c:forEach>
</ol>
</body>
</html>